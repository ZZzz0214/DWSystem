<template>
  <div class="app-container" >

    <el-row :gutter="20" >
      <!--产品信息-->
      <el-col >
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="80px">
          <el-form-item label="内部编号" prop="internalProductCode">
            <el-input
              v-model="queryParams.internalProductCode"
              placeholder="请输入内部编号"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="产品名称" prop="productName">
            <el-input
              v-model="queryParams.productName"
              placeholder="请输入产品名称"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="发货编码" prop="shipmentCode">
            <el-input
              v-model="queryParams.shipmentCode"
              placeholder="请输入发货编码"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="产品状态" prop="productStatus">
            <el-select v-model="queryParams.productStatus" placeholder="请选择产品状态">
              <el-option
                v-for="dict in dict.type.product_status"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>


          <el-form-item label="品类" prop="category">
            <el-select v-model="queryParams.category" placeholder="请选择品类">
              <el-option
                v-for="dict in dict.type.category"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="规格" prop="specifications">
            <el-input
              v-model="queryParams.specifications"
              placeholder="请输入规格"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="品牌方" prop="brandOwner">
            <el-select v-model="queryParams.brandOwner" placeholder="请选择品牌方">
              <el-option
                v-for="dict in dict.type.brand_owner"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>

          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-select v-model="queryParams.status" placeholder="请选择状态">
              <el-option
                v-for="dict in dict.type.status"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>



          <el-form-item label="生产日期">
            <el-date-picker
              v-model="dateRange1"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="录入时间">
            <el-date-picker
              v-model="dateRange2"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery" >搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
              v-hasPermi="['system:user:add']"
            >新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="el-icon-edit"
              size="mini"
              :disabled="single"
              @click="handleUpdate"
              v-hasPermi="['system:user:edit']"
            >修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="el-icon-delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
              v-hasPermi="['system:user:remove']"
            >删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="info"
              plain
              icon="el-icon-upload2"
              size="mini"
              @click="handleImport"
              v-hasPermi="['system:user:import']"
            >导入</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExport"
              v-hasPermi="['system:user:export']"
            >导出</el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="userList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="left" inline class="demo-table-expand">
                <el-form-item v-for="(column, index) in columns" :key="index" v-if="column.visible" :label="column.label">
                  <span>{{ props.row[column.key] }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>

          <el-table-column label="录入时间" align="center" prop="entryTime" v-if="columns[0].visible"  width="180">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.entryTime) }}</span> <!-- 格式化后的数据 -->
            </template>
          </el-table-column>
          <el-table-column label="产品名称" align="center" key="productName" prop="productName" v-if="columns[1].visible" :show-overflow-tooltip="true" />
          <el-table-column label="内部商品编号" align="center" key="internalProductCode" prop="internalProductCode" v-if="columns[2].visible" :show-overflow-tooltip="true" />
          <el-table-column label="发货编码" align="center" key="shipmentCode" prop="shipmentCode" v-if="columns[3].visible" :show-overflow-tooltip="true" />
          <el-table-column label="规格" align="center" key="specifications" prop="specifications" v-if="columns[4].visible" :show-overflow-tooltip="true" />
          <el-table-column label="生产日期" align="center" key="productionDate" prop="productionDate" v-if="columns[5].visible" :show-overflow-tooltip="true" />
          <el-table-column label="产品卖点" align="center" key="productSellingPoints" prop="productSellingPoints" v-if="columns[6].visible" :show-overflow-tooltip="true" />
          <el-table-column label="现货库存" align="center" key="currentStock" prop="currentStock" v-if="columns[7].visible" :show-overflow-tooltip="true" />
          <el-table-column label="实际返单时效" align="center" key="actualOrderTime" prop="actualOrderTime" v-if="columns[8].visible" :show-overflow-tooltip="true" />
          <el-table-column label="退货地址" align="center" key="returnAddress" prop="returnAddress" v-if="columns[9].visible" :show-overflow-tooltip="true" />
          <el-table-column label="快递明细" align="center" key="shippingDetails" prop="shippingDetails" v-if="columns[10].visible" :show-overflow-tooltip="true" />
          <el-table-column label="链接" align="center" key="link" prop="link" v-if="columns[11].visible" :show-overflow-tooltip="true" />
          <el-table-column label="状态" align="center" key="status" prop="status" v-if="columns[12].visible" :show-overflow-tooltip="true" >
            <template slot-scope="scope">
              {{ dict.type.status[scope.row.status] ? dict.type.status[scope.row.status]["label"] : '空' }}
            </template>
          </el-table-column>
          <el-table-column label="品牌" align="center" key="brand" prop="brand" v-if="columns[13].visible" :show-overflow-tooltip="true" >
            <template slot-scope="scope">
              {{ dict.type.brand[scope.row.brand] ? dict.type.brand[scope.row.brand]["label"] : '空' }}
            </template>
          </el-table-column>
          <el-table-column label="筛选" align="center" key="filter" prop="filter" v-if="columns[14].visible" :show-overflow-tooltip="true" >
            <template slot-scope="scope">
              {{ dict.type.filter[scope.row.filter] ? dict.type.filter[scope.row.filter]["label"] : '空' }}
            </template>

          </el-table-column>
          <el-table-column label="品类" align="center" key="category" prop="category" v-if="columns[15].visible" :show-overflow-tooltip="true">
            <template slot-scope="scope">
              {{ dict.type.category[scope.row.category] ? dict.type.category[scope.row.category]["label"] : '空' }}
            </template>

          </el-table-column>
          <el-table-column label="剩余库存" align="center" key="remainingStock" prop="remainingStock" v-if="columns[16].visible" :show-overflow-tooltip="true" />
          <el-table-column label="售后数量" align="center" key="afterSalesQuantity" prop="afterSalesQuantity" v-if="columns[17].visible" :show-overflow-tooltip="true" />
          <el-table-column label="品牌方" align="center" key="brandOwner" prop="brandOwner" v-if="columns[18].visible" :show-overflow-tooltip="true" >
            <template slot-scope="scope">
              {{ dict.type.brand_owner[scope.row.brandOwner] ? dict.type.brand_owner[scope.row.brandOwner]["label"] : '空' }}
            </template>

          </el-table-column>
          <el-table-column label="产品状态" align="center" key="productStatus" prop="productStatus" v-if="columns[19].visible" :show-overflow-tooltip="true" >
            <template slot-scope="scope">
              {{ dict.type.product_status[scope.row.productStatus] ? dict.type.product_status[scope.row.productStatus]["label"] : '空' }}
            </template>

          </el-table-column>
          <el-table-column label="采购价" align="center" key="purchasePrice" prop="purchasePrice" v-if="columns[20].visible" :show-overflow-tooltip="true" />
          <el-table-column label="运费" align="center" key="shippingCost" prop="shippingCost" v-if="columns[21].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货价_链" align="center" key="shippingPriceChain" prop="shippingPriceChain" v-if="columns[22].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货价_代发" align="center" key="shippingPriceDropship" prop="shippingPriceDropship" v-if="columns[23].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货价_详细代发" align="center" key="shippingPriceDetailedDropship" prop="shippingPriceDetailedDropship" v-if="columns[24].visible" :show-overflow-tooltip="true" />
          <el-table-column label="采购_注意事项" align="center" key="purchaseNotes" prop="purchaseNotes" v-if="columns[25].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货_注意事项" align="center" key="shippingNotes" prop="shippingNotes" v-if="columns[26].visible" :show-overflow-tooltip="true" />
          <el-table-column label="公域挂价_天猫_淘宝_京东" align="center" key="publicListingPriceTmallTaobaoJd" prop="publicListingPriceTmallTaobaoJd" v-if="columns[27].visible" :show-overflow-tooltip="true" />
          <el-table-column label="拼多多挂价" align="center" key="pinduoduoListingPrice" prop="pinduoduoListingPrice" v-if="columns[28].visible" :show-overflow-tooltip="true" />
          <el-table-column label="私域_团购_快团等" align="center" key="privateGroupBuyPrice" prop="privateGroupBuyPrice" v-if="columns[29].visible" :show-overflow-tooltip="true" />
          <el-table-column label="直播挂价_专属价_日常改原价" align="center" key="liveStreamPrice" prop="liveStreamPrice" v-if="columns[30].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货价_1档" align="center" key="shippingPriceTier1" prop="shippingPriceTier1" v-if="columns[31].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货价_2档" align="center" key="shippingPriceTier2" prop="shippingPriceTier2" v-if="columns[32].visible" :show-overflow-tooltip="true" />
          <el-table-column label="代发出货价" align="center" key="dropshipShippingPrice" prop="dropshipShippingPrice" v-if="columns[33].visible" :show-overflow-tooltip="true" />
          <el-table-column label="阿里挂价" align="center" key="alibabaListingPrice" prop="alibabaListingPrice" v-if="columns[34].visible" :show-overflow-tooltip="true" />

          <el-table-column
            label="操作"
            align="center"
            width="160"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope" v-if="scope.row.userId !== 1">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:user:edit']"
              >修改</el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
              >删除</el-button>
              <!--                v-hasPermi="['system:user:remove']"-->

              <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)" v-hasPermi="['system:user:resetPwd', 'system:user:edit']">
                <el-button size="mini" type="text" icon="el-icon-d-arrow-right">更多</el-button>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="handleResetPwd" icon="el-icon-key"
                                    v-hasPermi="['system:user:resetPwd']">重置密码</el-dropdown-item>
                  <el-dropdown-item command="handleAuthRole" icon="el-icon-circle-check"
                                    v-hasPermi="['system:user:edit']">分配角色</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </template>
          </el-table-column>
        </el-table>

      </el-col>
    </el-row>

    <div class="pagination-container">
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />
    </div>

    <!-- 添加或修改用户配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="发货编码" prop="shipmentCode">
              <el-input v-model="form.shipmentCode" placeholder="请输入发货编码" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="产品名称" prop="productName">
              <el-input v-model="form.productName" placeholder="请输入产品名称"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="生产日期" prop="productionDate">
              <el-date-picker
                v-model="form.productionDate"
                type="date"
                placeholder="选择生产日期"
                format="yyyy-MM-dd"
                value-format="yyyy-MM-dd"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="规格" prop="specifications">
              <el-input v-model="form.specifications" placeholder="请输入规格"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="产品卖点" prop="productSellingPoints">
              <el-input v-model="form.productSellingPoints" placeholder="请输入产品卖点" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="现货库存" prop="currentStock">
              <el-input v-model="form.currentStock" placeholder="请输入现货库存"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="退货地址" prop="returnAddress">
              <el-input v-model="form.returnAddress" placeholder="请输入退货地址" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="实际返单时效" prop="actualOrderTime">
              <el-input v-model="form.actualOrderTime" placeholder="请输入实际返单时效"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="公域挂价_天猫_淘宝_京东" prop="publicListingPriceTmallTaobaoJd">
              <el-input v-model="form.publicListingPriceTmallTaobaoJd" placeholder="请输入公域挂价_天猫_淘宝_京东" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="快递明细" prop="shippingDetails">
              <el-input v-model="form.shippingDetails" placeholder="请输入快递明细"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="私域_团购_快团等" prop="privateGroupBuyPrice">
              <el-input v-model="form.privateGroupBuyPrice" placeholder="请输入私域_团购_快团等" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="拼多多挂价" prop="pinduoduoListingPrice">
              <el-input v-model="form.pinduoduoListingPrice" placeholder="请输入拼多多挂价"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="品类" prop="category">
              <el-select v-model="form.category" placeholder="请选择品类">
                <el-option
                  v-for="dict in dict.type.category"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="直播挂价_专属价_日常改原价" prop="liveStreamPrice">
              <el-input v-model="form.liveStreamPrice" placeholder="请输入直播挂价_专属价_日常改原价"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-select v-model="form.status" placeholder="请选择状态">
                <el-option
                  v-for="dict in dict.type.status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="品牌" prop="brand">
              <el-select v-model="form.brand" placeholder="请选择品牌">
                <el-option
                  v-for="dict in dict.type.brand"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="筛选" prop="filter">
              <el-select v-model="form.filter" placeholder="请选择筛选">
                <el-option
                  v-for="dict in dict.type.filter"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="产品状态" prop="productStatus">
              <el-select v-model="form.productStatus" placeholder="请选择产品状态">
                <el-option
                  v-for="dict in dict.type.product_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="剩余库存" prop="remainingStock">
              <el-input v-model="form.remainingStock" placeholder="请输入剩余库存" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="链接" prop="link">
              <el-input v-model="form.link" placeholder="请输入链接"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="采购价" prop="purchasePrice">
              <el-input v-model="form.purchasePrice" placeholder="请输入采购价" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="售后数量" prop="afterSalesQuantity">
              <el-input v-model="form.afterSalesQuantity" placeholder="请输入售后数量"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="运费" prop="shippingCost">
              <el-input v-model="form.shippingCost" placeholder="请输入运费" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="品牌方" prop="brandOwner">
              <el-select v-model="form.brandOwner" placeholder="请选择品牌方">
                <el-option
                  v-for="dict in dict.type.brand_owner"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="采购_注意事项" prop="purchaseNotes">
              <el-input v-model="form.purchaseNotes" placeholder="请输入采购_注意事项" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="代发出货价" prop="dropshipShippingPrice">
              <el-input v-model="form.dropshipShippingPrice" placeholder="请输入代发出货价"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="出货价_链" prop="shippingPriceChain">
              <el-input v-model="form.shippingPriceChain" placeholder="请输入出货价_链" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="出货价_1档" prop="shippingPriceTier1">
              <el-input v-model="form.shippingPriceTier1" placeholder="请输入出货价_1档"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="出货价_代发" prop="shippingPriceDropship">
              <el-input v-model="form.shippingPriceDropship" placeholder="请输入出货价_代发" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="出货价_2档" prop="shippingPriceTier2">
              <el-input v-model="form.shippingPriceTier2" placeholder="请输入出货价_2档"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="出货价_详细代发" prop="shippingPriceDetailedDropship">
              <el-input v-model="form.shippingPriceDetailedDropship" placeholder="请输入出货价_详细代发" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  label="阿里挂价" prop="alibabaListingPrice">
              <el-input v-model="form.alibabaListingPrice" placeholder="请输入阿里挂价"  maxlength="20" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="出货_注意事项" prop="shippingNotes">
              <el-input v-model="form.shippingNotes" placeholder="请输入出货_注意事项" maxlength="30" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="录入时间" prop="entryTime">
              <el-date-picker
                v-model="form.entryTime"
                type="datetime"
                placeholder="选择录入时间"
                format="yyyy-MM-dd HH:mm:ss"
                value-format="yyyy-MM-dd HH:mm:ss"
              ></el-date-picker>
            </el-form-item>


          </el-col>
        </el-row>

        <el-card>
          <div v-for="(column, index) in columns" :key="index" v-if="column.visible">
            {{ column.label }}: {{ form[column.key] }}
          </div>
        </el-card>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 财务数据导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的财务数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>


<script>
// import { listUser, getUser, delUser, addUser, updateUser, resetUserPwd, changeUserStatus } from "@/api/system/user";
import { listProduct,getProduct,addProduct,updateProduct,delProduct } from "@/api/manage/product";
import { getToken } from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";


export default {
  name: "User",
  dicts: ['sys_normal_disable', 'sys_user_sex','category','status','brand','filter','product_status','brand_owner'],
  components: { Treeselect },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户表格数据
      userList: null,
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      // 是否显示弹出层
      open: false,
      // 默认密码
      initPassword: undefined,
      // 日期范围
      dateRange: [],
      dateRange1: [], // 生产日期范围
      dateRange2: [],// 录入时间范围
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {
      },
      entryTime: this.getCurrentDateTime,
      intervalId: null, // 定时器ID
      defaultProps: {
        children: "children",
        label: "label"
      },
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/user/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        // userName: undefined,
        // status: undefined,
        // deptId: undefined
        internalProductCode: undefined, // 内部编号
        productName: undefined, // 产品名称
        shipmentCode: undefined, // 发货编码
        productStatus: undefined, // 产品状态
        category: undefined, // 品类
        specifications: undefined, // 规格
        brandOwner: undefined, // 品牌方
        status: undefined, // 状态
        productionStartDate: undefined,
        productionEndDate: undefined,
        entryStartDate: undefined,
        entryEndDate: undefined
      },
      // 列信息
      columns: [
        { key: 'entryTime', label: '录入时间', visible: true },
        { key: 'productName', label: '产品名称', visible: true },
        { key: 'internalProductCode', label: '内部商品编号', visible: true },
        { key: 'shipmentCode', label: '发货编码', visible: true },
        { key: 'specifications', label: '规格', visible: true },
        { key: 'productionDate', label: '生产日期', visible: true },
        { key: 'productSellingPoints', label: '产品卖点', visible: true },
        { key: 'currentStock', label: '现货库存', visible: true },
        { key: 'actualOrderTime', label: '实际返单时效', visible: true },
        { key: 'returnAddress', label: '退货地址', visible: true },
        { key: 'shippingDetails', label: '快递明细', visible: true },
        { key: 'link', label: '链接', visible: true },
        { key: 'status', label: '状态', visible: true },
        { key: 'brand', label: '品牌', visible: true },
        { key: 'filter', label: '筛选', visible: true },
        { key: 'category', label: '品类', visible: true },
        { key: 'remainingStock', label: '剩余库存', visible: true },
        { key: 'afterSalesQuantity', label: '售后数量', visible: true },
        { key: 'brandOwner', label: '品牌方', visible: true },
        { key: 'productStatus', label: '产品状态', visible: true },
        { key: 'purchasePrice', label: '采购价', visible: true },
        { key: 'shippingCost', label: '运费', visible: true },
        { key: 'shippingPriceChain', label: '出货价_链', visible: true },
        { key: 'shippingPriceDropship', label: '出货价_代发', visible: true },
        { key: 'shippingPriceDetailedDropship', label: '出货价_详细代发', visible: true },
        { key: 'purchaseNotes', label: '采购_注意事项', visible: true },
        { key: 'shippingNotes', label: '出货_注意事项', visible: true },
        { key: 'publicListingPriceTmallTaobaoJd', label: '公域挂价_天猫_淘宝_京东', visible: true },
        { key: 'pinduoduoListingPrice', label: '拼多多挂价', visible: true },
        { key: 'privateGroupBuyPrice', label: '私域_团购_快团等', visible: true },
        { key: 'liveStreamPrice', label: '直播挂价_专属价_日常改原价', visible: true },
        { key: 'shippingPriceTier1', label: '出货价_1档', visible: true },
        { key: 'shippingPriceTier2', label: '出货价_2档', visible: true },
        { key: 'dropshipShippingPrice', label: '代发出货价', visible: true },
        { key: 'alibabaListingPrice', label: '阿里挂价', visible: true },
      ],
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名称不能为空", trigger: "blur" },
          { min: 2, max: 20, message: '用户名称长度必须介于 2 和 20 之间', trigger: 'blur' }
        ],
        nickName: [
          { required: true, message: "用户昵称不能为空", trigger: "blur" }
        ],
        password: [
          { required: true, message: "用户密码不能为空", trigger: "blur" },
          { min: 5, max: 20, message: '用户密码长度必须介于 5 和 20 之间', trigger: 'blur' },
          { pattern: /^[^<>"'|\\]+$/, message: "不能包含非法字符：< > \" ' \\\ |", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getConfigKey("sys.user.initPassword").then(response => {
      this.initPassword = response.msg;
    });
    // 启动定时器，每秒更新一次时间
    this.intervalId = setInterval(() => {
      // this.form.entryTime = this.getCurrentDateTime();
      this.$set(this.form, "entryTime", this.getCurrentDateTime());
    }, 1000);
  },

  beforeDestroy() {
    // 在组件销毁前清除定时器
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
    window.removeEventListener('scroll', this.handleScroll);
  }
  ,
  methods: {

    getCurrentDateTime() {
      const now = new Date();
      const year = now.getFullYear();
      const month = String(now.getMonth() + 1).padStart(2, '0');
      const day = String(now.getDate()).padStart(2, '0');
      const hours = String(now.getHours()).padStart(2, '0');
      const minutes = String(now.getMinutes()).padStart(2, '0');
      const seconds = String(now.getSeconds()).padStart(2, '0');
      return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    }
  ,
    /** 查询用户列表 */
    getList() {

      // 确保 dateRange1 和 dateRange2 是数组
      if (Array.isArray(this.dateRange1) && this.dateRange1.length) {
        this.queryParams.productionStartDate = this.dateRange1[0];
        this.queryParams.productionEndDate = this.dateRange1[1];
      } else {
        this.queryParams.productionStartDate = undefined;
        this.queryParams.productionEndDate = undefined;
      }

      if (Array.isArray(this.dateRange2) && this.dateRange2.length) {
        this.queryParams.entryStartDate = this.dateRange2[0];
        this.queryParams.entryEndDate = this.dateRange2[1];
      } else {
        this.queryParams.entryStartDate = undefined;
        this.queryParams.entryEndDate = undefined;
      }

      this.loading = true;
      // listProduct(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
      listProduct(this.queryParams).then(response => {
          this.userList = response.rows;
          this.total = response.total;
          this.loading = false;
        // 在数据获取成功后进行过滤
        this.applyFilter();
        }
      ).catch(() => {
        this.loading = false;
      });

    },
    applyFilter() {
      if (!this.queryParams.filterAttribute || !this.queryParams.filterCondition || !this.queryParams.filterValue) {
        return;
      }

      console.log(this.queryParams.financialRecordList);
      const filterAttr = this.columns.find(col => col.key === this.queryParams.filterAttribute)?.key;

      if (!filterAttr) return;

      this.financialRecordList = this.financialRecordList.filter(item => {
        const value = item[filterAttr];
        if (value === undefined || value === null) return false;  // 处理值不存在的情况
        switch (this.queryParams.filterCondition) {
          case 'contains':
            return value.includes(this.queryParams.filterValue);
          case 'equals':
            return value === this.queryParams.filterValue;
          case 'startsWith':
            return value.startsWith(this.queryParams.filterValue);
          case 'endsWith':
            return value.endsWith(this.queryParams.filterValue);
          case 'isEmpty':
            return value === '';
          case 'isNotEmpty':
            return value !== '';
          default:
            return true;
        }
      });


    },


    // 用户状态修改
    handleStatusChange(row) {
      let text = row.status === "0" ? "启用" : "停用";
      this.$modal.confirm('确认要"' + text + '""' + row.userName + '"用户吗？').then(function() {
        return changeUserStatus(row.userId, row.status);
      }).then(() => {
        this.$modal.msgSuccess(text + "成功");
      }).catch(function() {
        row.status = row.status === "0" ? "1" : "0";
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        userId: undefined,
        deptId: undefined,
        userName: undefined,
        nickName: undefined,
        password: undefined,
        sex: undefined,
        status: "0",
        remark: undefined,
        postIds: [],
        roleIds: []
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.dateRange1=[];
      this.dateRange2=[];
      this.resetForm("queryForm");
      // this.queryParams.deptId = undefined;
      // this.$refs.tree.setCurrentKey(null);
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.productId);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    // 更多操作触发
    handleCommand(command, row) {
      switch (command) {
        case "handleResetPwd":
          this.handleResetPwd(row);
          break;
        case "handleAuthRole":
          this.handleAuthRole(row);
          break;
        default:
          break;
      }
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();

        this.open = true;
        this.title = "添加产品信息";

    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.productId || this.ids;
      getProduct(userId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改产品信息";
      });
    },

    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.productId != undefined) {
            updateProduct(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProduct(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const userIds = row.productId || this.ids;
      this.$modal.confirm('是否确认删除用户编号为"' + userIds + '"的数据项？').then(function() {
        return delProduct(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      // this.download('manage/Product/export', {
      //   ...this.queryParams
      // }, `user_${new Date().getTime()}.xlsx`)

      // 获取隐藏的列
      const hiddenColumns = this.columns.filter(column => !column.visible).map(column => column.key);

      // 构建请求参数
      const params = {
        ...this.queryParams,
        hiddenColumns
      };
      console.log(typeof params)

      // 调用下载方法
      this.download('manage/Product/export', params, `产品信息数据_${new Date().getTime()}.xlsx`);
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/user/importTemplate', {
      }, `user_template_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
<style scoped>

.el-table__body-wrapper {
  max-height: calc(100vh - 350px); /* 设置表格体的最大高度，留出搜索条件和底部pagination的空间 */
  overflow-y: auto; /* 当内容超出容器高度时显示垂直滚动条 */
}
.demo-table-expand {
  font-size: 0;
  column-count: 3;
}
.demo-table-expand label {
  width: 90px;
  color: #2278d9;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}

</style>
