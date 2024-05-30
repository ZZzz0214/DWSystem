<template>
  <div class="app-container">

    <el-row :gutter="24">
      <!--财务数据-->
      <el-col>
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
                 label-width="100px">
          <el-form-item label="订单编号" prop="orderNumber">
            <el-input
              v-model="queryParams.orderNumber"
              placeholder="请输入订单编号"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="物流公司" prop="logisticsCompany">
            <el-input
              v-model="queryParams.logisticsCompany"
              placeholder="请输入物流公司"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="收货人" prop="recipientName">
            <el-select
              v-model="queryParams.recipientName"
              placeholder="请输入收货人"
              clearable
              style="width: 200px"
            >
            </el-select>
          </el-form-item>
          <el-form-item label="商品名称" prop="productName">
            <el-input
              v-model="queryParams.productName"
              placeholder="请输入商品名称"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="商品编码" prop="productCode">
            <el-input
              v-model="queryParams.productCode"
              placeholder="请输入商品编码"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="订单号" prop="orderId">
            <el-input
              v-model="queryParams.orderId"
              placeholder="请输入订单号"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="物流单号" prop="trackingNumber">
            <el-input
              v-model="queryParams.trackingNumber"
              placeholder="请输入物流单号"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="联系电话" prop="recipientPhone">
            <el-input
              v-model="queryParams.recipientPhone"
              placeholder="请输入联系电话"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="规格" prop="specifications">
            <el-input
              v-model="queryParams.specifications"
              placeholder="请输入规格"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="团长" prop="leader">
            <el-input
              v-model="queryParams.leader"
              placeholder="请输入团长"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="内部商品编号" prop="internalProductCode">
            <el-input
              v-model="queryParams.internalProductCode"
              placeholder="请输入内部商品编号"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="筛选" prop="filter">
            <el-input
              v-model="queryParams.filter"
              placeholder="请输入筛选条件"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="产品名称" prop="productNameDetails">
            <el-input
              v-model="queryParams.productNameDetails"
              placeholder="请输入产品名称"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="品牌方" prop="brand">
            <el-input
              v-model="queryParams.brand"
              placeholder="请输入品牌方"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="日期">
            <el-date-picker
              v-model="dateRange"
              style="width: 200px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="筛选属性" prop="filterAttribute">
            <el-select v-model="queryParams.filterAttribute" clearable placeholder="选择属性" style="width: 200px">
              <el-option v-for="column in columns" :key="column.key" :label="column.label"
                         :value="column.key"></el-option>
            </el-select>
          </el-form-item>
          <!-- 筛选条件选择框 -->
          <el-form-item label="筛选条件" prop="filterCondition">
            <el-select v-model="queryParams.filterCondition" clearable placeholder="选择条件" style="width: 200px">
              <el-option label="包含" value="contains"></el-option>
              <el-option label="等于" value="equals"></el-option>
              <el-option label="开头是" value="startsWith"></el-option>
              <el-option label="结尾是" value="endsWith"></el-option>
              <el-option label="为空" value="isEmpty"></el-option>
              <el-option label="不为空" value="isNotEmpty"></el-option>
            </el-select>
          </el-form-item>
          <!-- 筛选值输入框 -->
          <el-form-item label="筛选值" prop="filterValue">
            <el-input
              v-model="queryParams.filterValue"
              placeholder="请输入筛选值"
              clearable
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
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
              v-hasPermi="['manage:FinancialRecord:add']"
            >新增
            </el-button>
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
            >修改
            </el-button>
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
            >删除
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="info"
              plain
              icon="el-icon-upload2"
              size="mini"
              @click="handleImport"
              v-hasPermi="['system:user:import']"
            >导入
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExport"
              v-hasPermi="['system:user:export']"
            >导出
            </el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="financialRecordList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>
<!--          <el-table-column label="编号" align="center" key="bianHao" prop="bianHao" v-if="columns[12].visible"/>-->
          <el-table-column label="订单编号" align="center" key="orderNumber" prop="orderNumber" v-if="columns[0].visible"/>
          <el-table-column label="订单号" align="center" key="orderId" prop="orderId" v-if="columns[1].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="物流公司" align="center" key="logisticsCompany" prop="logisticsCompany" v-if="columns[2].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="物流单号" align="center" key="trackingNumber" prop="trackingNumber" v-if="columns[3].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="收货人" align="center" key="recipientName" prop="recipientName" v-if="columns[4].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="联系电话" align="center" key="recipientPhone" prop="recipientPhone" v-if="columns[5].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="详细地址" align="center" key="address" prop="address" v-if="columns[6].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="商品名称" align="center" key="productName" prop="productName" v-if="columns[7].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="规格" align="center" key="specifications" prop="specifications" v-if="columns[8].visible":show-overflow-tooltip="true"/>
          <el-table-column label="数量" align="center" key="quantity" prop="quantity" v-if="columns[9].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="商品编码" align="center" key="productCode" prop="productCode" v-if="columns[10].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="团员备注" align="center" key="memberRemarks" prop="memberRemarks" v-if="columns[11].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="团长" align="center" key="leader" prop="leader" v-if="columns[12].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="筛选" align="center" key="filter" prop="filter" v-if="columns[13].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="日期" align="center" key="date" prop="date" v-if="columns[14].visible" :show-overflow-tooltip="true">
                      <template slot-scope="scope">
                        <span>{{ parseTime(scope.row.date) }}</span> <!-- 格式化后的数据 -->
                      </template>
                    </el-table-column>
          <el-table-column label="产品名称" align="center" key="productNameDetails" prop="productNameDetails" v-if="columns[15].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="倍数" align="center" key="multiplier" prop="multiplier" v-if="columns[16].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="备注" align="center" key="remarks" prop="remarks" v-if="columns[17].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="内部商品编号" align="center" key="internalProductCode" prop="internalProductCode" v-if="columns[18].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="货数" align="center" key="stockQuantity" prop="stockQuantity" v-if="columns[19].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="品牌方" align="center" key="brand" prop="brand" v-if="columns[20].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购价" align="center" key="purchasePrice" prop="purchasePrice" v-if="columns[21].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购_运费" align="center" key="purchaseShippingFee" prop="purchaseShippingFee" v-if="columns[22].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购_其他费" align="center" key="purchaseOtherFee" prop="purchaseOtherFee" v-if="columns[23].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购_总额" align="center" key="purchaseTotalAmount" prop="purchaseTotalAmount" v-if="columns[24].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购_检查" align="center" key="purchaseInspection" prop="purchaseInspection" v-if="columns[25].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购_状况" align="center" key="purchaseStatus" prop="purchaseStatus" v-if="columns[26].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="采购_备注" align="center" key="purchaseRemarks" prop="purchaseRemarks" v-if="columns[27].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货价" align="center" key="sellingPrice" prop="sellingPrice" v-if="columns[28].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货_运费" align="center" key="sellingShippingFee" prop="sellingShippingFee" v-if="columns[29].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货_其他费" align="center" key="sellingOtherFee" prop="sellingOtherFee" v-if="columns[30].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货_总额" align="center" key="sellingTotalAmount" prop="sellingTotalAmount" v-if="columns[31].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货_检查" align="center" key="sellingInspection" prop="sellingInspection" v-if="columns[32].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货_状况" align="center" key="sellingStatus" prop="sellingStatus" v-if="columns[33].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="出货_备注" align="center" key="sellingRemarks" prop="sellingRemarks" v-if="columns[34].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="利润" align="center" key="profit" prop="profit" v-if="columns[35].visible" :show-overflow-tooltip="true"/>


          // 功能按钮 数据最后一列的操作
          <el-table-column label="操作" align="center" width="160" class-name="small-padding fixed-width">
            <template slot-scope="scope" v-if="scope.row.id !== 1">
              <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                         v-hasPermi="['system:user:edit']">修改
              </el-button>
              <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                         v-hasPermi="['system:user:remove']">删除
              </el-button>
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
    <el-dialog :title="title" :visible.sync="open" width="1400px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="结算日期" prop="settlementDate">
              <el-input v-model="form.settlementDate" placeholder="请输入结算日期" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="日期" prop="date">
              <el-date-picker
                v-model="form.date"
                style="width: 200px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="请输入日期"
              ></el-date-picker>
              <!--              <el-input v-model="form.date" placeholder="请输入日期" maxlength="30" />-->
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="订单号" prop="orderNumber">
              <el-input v-model="form.orderNumber" placeholder="请输入订单号" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="产品名称_详细信息" prop="productName">
              <el-input v-model="form.productNameDetails" placeholder="请输入产品名称_详细信息" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="账款" prop="amount">
              <el-input v-model="form.amount" placeholder="请输入账款" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="是否完成" prop="isCompleted">
              <el-select v-model="form.isCompleted" placeholder="请选择是否完成">
                <el-option
                  v-for="dict in dict.type.completed"
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
            <el-form-item label="支出收入" prop="incomeExpense">
              <el-select v-model="form.incomeExpense" placeholder="请输入支出收入">
                <el-option
                  v-for="dict in dict.type.expense_income"
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
            <el-form-item label="付款项目" prop="paymentItem">
              <el-select v-model="form.paymentItem" placeholder="请输入付款项目">
                <el-option
                  v-for="dict in dict.type.payment_item"
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
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remarks" placeholder="请输入备注" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="品牌方" prop="brand">
              <el-select v-model="form.brand" placeholder="请输入付款项目">
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
            <el-form-item label="出货方" prop="supplier">
              <el-input v-model="form.supplier" placeholder="请输入出货方" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="处理人" prop="handler">
              <el-input v-model="form.handler" placeholder="请输入处理人" maxlength="30"/>
            </el-form-item>
          </el-col>
        </el-row>
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
            <el-checkbox v-model="upload.updateSupport"/>
            是否更新已经存在的财务数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
                   @click="importTemplate">下载模板
          </el-link>
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
import {addDropshipRecord, delDropshipRecord, getDropshipRecord, listDropshipRecord, updateDropshipRecord} from "@/api/manage/dropshipRecord";
import {getToken} from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";


export default {
  name: "DropshipRecord",
  dicts: ['sys_normal_disable', 'sys_user_sex', 'completed', 'expense_income', 'brand_owner', 'payment_item', 'expense_income'],
  components: {Treeselect},
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
      financialRecordList: null,
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
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {},
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
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/user/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        settlementDate: undefined,
        date: undefined,
        orderNumber: undefined,
        productNameDetails: undefined,
        amount: undefined,
        isCompleted: undefined,
        incomeExpense: undefined,
        paymentItem: undefined,
        remarks: undefined,
        brand: undefined,
        supplier: undefined,
        handler: undefined,
        filterAttribute: undefined,
        filterCondition: undefined,
        filterValue: undefined,
        bianHao: undefined

      },

      // 列信息
      columns: [
        {key: 'orderNumber', label: '订单编号', visible: true}, // 修改 key 和 label
        {key: 'orderId', label: '订单号', visible: true}, // 修改 key 和 label
        {key: 'logisticsCompany', label: '物流公司', visible: true}, // 修改 key 和 label
        {key: 'trackingNumber', label: '物流单号', visible: true}, // 修改 key 和 label
        {key: 'recipientName', label: '收货人', visible: true}, // 修改 key 和 label
        {key: 'recipientPhone', label: '联系电话', visible: true}, // 修改 key 和 label
        {key: 'address', label: '详细地址', visible: true}, // 修改 key 和 label
        {key: 'productName', label: '商品名称', visible: true}, // 修改 key 和 label
        {key: 'specifications', label: '规格', visible: true}, // 修改 key 和 label
        {key: 'quantity', label: '数量', visible: true}, // 修改 key 和 label
        {key: 'productCode', label: '商品编码', visible: true}, // 修改 key 和 label
        {key: 'memberRemarks', label: '团员备注', visible: true}, // 修改 key 和 label
        {key: 'leader', label: '团长', visible: true}, // 修改 key 和 label
        {key: 'filter', label: '筛选', visible: true}, // 修改 key 和 label
        {key: 'date', label: '日期', visible: true}, // 修改 key 和 label
        {key: 'productNameDetails', label: '产品名称', visible: true}, // 修改 key 和 label
        {key: 'multiplier', label: '倍数', visible: true}, // 修改 key 和 label
        {key: 'remarks', label: '备注', visible: true}, // 修改 key 和 label
        {key: 'internalProductCode', label: '内部商品编号', visible: true}, // 修改 key 和 label
        {key: 'stockQuantity', label: '货数', visible: true}, // 修改 key 和 label
        {key: 'brand', label: '品牌方', visible: true}, // 修改 key 和 label
        {key: 'purchasePrice', label: '采购价', visible: true}, // 修改 key 和 label
        {key: 'purchaseShippingFee', label: '采购_运费', visible: true}, // 修改 key 和 label
        {key: 'purchaseOtherFee', label: '采购_其他费', visible: true}, // 修改 key 和 label
        {key: 'purchaseTotalAmount', label: '采购_总额', visible: true}, // 修改 key 和 label
        {key: 'purchaseInspection', label: '采购_检查', visible: true}, // 修改 key 和 label
        {key: 'purchaseStatus', label: '采购_状况', visible: true}, // 修改 key 和 label
        {key: 'purchaseRemarks', label: '采购_备注', visible: true}, // 修改 key 和 label
        {key: 'sellingPrice', label: '出货价', visible: true}, // 修改 key 和 label
        {key: 'sellingShippingFee', label: '出货_运费', visible: true}, // 修改 key 和 label
        {key: 'sellingOtherFee', label: '出货_其他费', visible: true}, // 修改 key 和 label
        {key: 'sellingTotalAmount', label: '出货_总额', visible: true}, // 修改 key 和 label
        {key: 'sellingInspection', label: '出货_检查', visible: true}, // 修改 key 和 label
        {key: 'sellingStatus', label: '出货_状况', visible: true}, // 修改 key 和 label
        {key: 'sellingRemarks', label: '出货_备注', visible: true}, // 修改 key 和 label
        {key: 'profit', label: '利润', visible: true}// 修改 key 和 label
      ],
      // 表单校验
      rules: {
        // userName: [
        //   { required: true, message: "用户名称不能为空", trigger: "blur" },
        //   { min: 2, max: 20, message: '用户名称长度必须介于 2 和 20 之间', trigger: 'blur' }
        // ],
        // nickName: [
        //   { required: true, message: "用户昵称不能为空", trigger: "blur" }
        // ],
        // password: [
        //   { required: true, message: "用户密码不能为空", trigger: "blur" },
        //   { min: 5, max: 20, message: '用户密码长度必须介于 5 和 20 之间', trigger: 'blur' },
        //   { pattern: /^[^<>"'|\\]+$/, message: "不能包含非法字符：< > \" ' \\\ |", trigger: "blur" }
        // ]
        amount: [
          {required: true, message: "价格不能为空", trigger: "blur"},
          {pattern: /^\d+(\.\d+)?$/, message: "价格必须是数字", trigger: "blur"}
        ]

      }
    };
  },
  created() {
    this.getList();
    this.getConfigKey("sys.user.initPassword").then(response => {
      this.initPassword = response.msg;
    });
  },

  beforeDestroy() {
    window.removeEventListener('scroll', this.handleScroll);
  },
  // mounted() {
  //   this.initializeForm();
  // },
  methods: {
    // initializeForm() {
    //   const currentDate = format(new Date(), 'yyyy-MM-dd');
    //   console.log(currentDate)
    //   this.form.date = currentDate;
    // },
    // // formatIsCompleted(row, column, cellValue) {
    // //   const completedDict = this.dicts.completed || {}; // 获取completed字典
    // //   const label = Object.keys(completedDict).find(key => completedDict[key] === cellValue); // 找到对应值的键
    // //   return label || cellValue; // 如果找到了对应的键，返回键值，否则返回原值回字典中对应的值，如果没有匹配项则返回原值
    // // },
    /** 查询用户列表 */
    getList() {
      this.loading = true;

      // 获取数据
      listDropshipRecord(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.financialRecordList = response.rows;
        this.total = response.total;
        this.loading = false;

        // 在数据获取成功后进行过滤
        this.applyFilter();
      }).catch(() => {
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
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id);
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
      // getDropshipRecord().then(response => {
      this.open = true;
      this.title = "添加财务记录";
      // });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const idd = row.id || this.ids;
      getDropshipRecord(idd).then(response => {
        this.form = response.data;
        console.log(response.data)
        this.open = true;
        this.title = "修改财务记录";
      });
    },

    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateDropshipRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDropshipRecord(this.form).then(response => {
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
      const DropshipRecordIds = row.id || this.ids;
      this.$modal.confirm('是否确认删除财务编号为"' + DropshipRecordIds + '"的数据项？').then(function () {
        return delDropshipRecord(DropshipRecordIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('/manage/FinancialRecord/export', {
        ...this.queryParams
      }, `财务记录_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/user/importTemplate', {}, `user_template_${new Date().getTime()}.xlsx`)
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
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", {dangerouslyUseHTMLString: true});
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  },

};
</script>
<style scoped>

.el-table__body-wrapper {
  max-height: calc(100vh - 400px); /* 设置表格体的最大高度，留出搜索条件和底部pagination的空间 */
  overflow-y: auto; /* 当内容超出容器高度时显示垂直滚动条 */
}

</style>
