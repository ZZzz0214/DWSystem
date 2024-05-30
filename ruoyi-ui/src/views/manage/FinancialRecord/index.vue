<template>
  <div class="app-container" >

    <el-row :gutter="20" >
      <!--财务数据-->
      <el-col >
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="80px">
          <el-form-item label="结算日期" prop="settlementDate">
            <el-input
              v-model="queryParams.settlementDate"
              placeholder="请输入结算日期"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="订单号" prop="orderNumber">
            <el-input
              v-model="queryParams.orderNumber"
              placeholder="请输入订单号"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="是否完成" prop="isCompleted">
            <el-select
              v-model="queryParams.isCompleted"
              placeholder="是否完成"
              clearable
              style="width: 240px"
            >
              <el-option
                v-for="dict in dict.type.completed"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              />
            </el-select>
          </el-form-item>
          <el-form-item label="品牌方" prop="brand">
            <el-input
              v-model="queryParams.brand"
              placeholder="请输入品牌方"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="出货方" prop="supplier">
            <el-input
              v-model="queryParams.supplier"
              placeholder="请输入出货方"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="支出/收入" prop="incomeExpense">
            <el-input
              v-model="queryParams.incomeExpense"
              placeholder="请输入支出/收入"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            >
            </el-input>
          </el-form-item>
          <el-form-item label="付款项目" prop="paymentItem">
            <el-input
              v-model="queryParams.paymentItem"
              placeholder="请输入付款项目"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="处理人" prop="handler">
            <el-input
              v-model="queryParams.handler"
              placeholder="请输入处理人"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="日期">
            <el-date-picker
              v-model="dateRange"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="筛选属性" prop="filterAttribute">
            <el-select v-model="queryParams.filterAttribute" clearable placeholder="选择属性"   style="width: 240px">
              <el-option v-for="column in columns" :key="column.key" :label="column.label" :value="column.key"></el-option>
            </el-select>
          </el-form-item>
          <!-- 筛选条件选择框 -->
          <el-form-item label="筛选条件" prop="filterCondition">
            <el-select v-model="queryParams.filterCondition"  clearable placeholder="选择条件"  style="width: 240px">
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
              style="width: 240px"
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

        <el-table v-loading="loading" :data="financialRecordList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="编号" align="center" key="bianHao" prop="bianHao" v-if="columns[12].visible" />
          <el-table-column label="结算日期" align="center" key="settlementDate" prop="settlementDate" v-if="columns[0].visible" />
          <el-table-column label="日期" align="center" prop="date" v-if="columns[1].visible"  width="180">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.date) }}</span> <!-- 格式化后的数据 -->
            </template>
          </el-table-column>
          <el-table-column label="订单号" align="center" key="orderNumber" prop="orderNumber" v-if="columns[2].visible" :show-overflow-tooltip="true" />
          <el-table-column label="产品名称_详细信息" align="center" key="productNameDetails" prop="productNameDetails" v-if="columns[3].visible" :show-overflow-tooltip="true" />
          <el-table-column label="账款" align="center" key="amount" prop="amount" v-if="columns[4].visible" :show-overflow-tooltip="true" />
          <el-table-column label="是否完成" align="center" key="isCompleted" prop="isCompleted" v-if="columns[5].visible" :show-overflow-tooltip="true" >
            <template slot-scope="scope">
            {{ dict.type.completed[scope.row.isCompleted] ? dict.type.completed[scope.row.isCompleted]["label"] : '空' }}
          </template>
          </el-table-column>
          <el-table-column label="支出收入" align="center" key="incomeExpense" prop="incomeExpense" v-if="columns[6].visible" :show-overflow-tooltip="true" />
          <el-table-column label="付款项目" align="center" key="paymentItem" prop="paymentItem" v-if="columns[7].visible" :show-overflow-tooltip="true" />
          <el-table-column label="备注" align="center" key="remarks" prop="remarks" v-if="columns[8].visible" :show-overflow-tooltip="true" />
          <el-table-column label="品牌方" align="center" key="brand" prop="brand" v-if="columns[9].visible" :show-overflow-tooltip="true" />
          <el-table-column label="出货方" align="center" key="supplier" prop="supplier" v-if="columns[10].visible" :show-overflow-tooltip="true" />
          <el-table-column label="处理人" align="center" key="handler" prop="handler" v-if="columns[11].visible" :show-overflow-tooltip="true" />


          // 功能按钮  数据最后一列的操作
          <el-table-column label="操作" align="center" width="160" class-name="small-padding fixed-width">
            <template slot-scope="scope" v-if="scope.row.id !== 1">
              <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:user:edit']">修改</el-button>
              <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['system:user:remove']">删除</el-button>
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
              <el-input v-model="form.settlementDate" placeholder="请输入结算日期" maxlength="30" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="日期" prop="date">
              <el-date-picker
                v-model="form.date"
                style="width: 240px"
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
              <el-input v-model="form.orderNumber" placeholder="请输入订单号" maxlength="30" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="产品名称_详细信息" prop="productName">
              <el-input v-model="form.productNameDetails" placeholder="请输入产品名称_详细信息" maxlength="30" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="账款" prop="amount">
              <el-input v-model="form.amount" placeholder="请输入账款" maxlength="30" />
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
              <el-input v-model="form.remarks" placeholder="请输入备注" maxlength="30" />
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
              <el-input v-model="form.supplier" placeholder="请输入出货方" maxlength="30" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="处理人" prop="handler">
              <el-input v-model="form.handler" placeholder="请输入处理人" maxlength="30" />
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
import { listFinancialRecords,getFinancialRecords,addFinancialRecords,updateFinancialRecords,delFinancialRecords } from "@/api/manage/financialRecord";
import { getToken } from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";


export default {
  name: "FinancialRecord",
  dicts: ['sys_normal_disable', 'sys_user_sex','completed','expense_income','brand_owner','payment_item','expense_income'],
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
        headers: { Authorization: "Bearer " + getToken() },
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
        filterAttribute:undefined,
        filterCondition:undefined,
        filterValue:undefined,
        bianHao:undefined

      },

      // 列信息
      columns: [
        { key: 'settlementDate', label: '结算日期', visible: true },
        { key: 'date', label: '日期', visible: true },
        { key: 'orderNumber', label: '订单号', visible: true },
        { key: 'productNameDetail', label: '产品名称_详细信息', visible: true },
        { key: 'amount', label: '账款', visible: true },
        { key: 'isCompleted', label: '是否完成', visible: true },
        { key: 'incomeExpense', label: '支出收入', visible: true },
        { key: 'paymentItem', label: '付款项目', visible: true },
        { key: 'remark', label: '备注', visible: true },
        { key: 'brand', label: '品牌方', visible: true },
        { key: 'supplier', label: '出货方', visible: true },
        { key: 'handler', label: '处理人', visible: true },
        { key: 'bianHao', label: '编号', visible: true }
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
          { required: true, message: "价格不能为空", trigger: "blur" },
          { pattern: /^\d+(\.\d+)?$/, message: "价格必须是数字", trigger: "blur" }
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
      listFinancialRecords(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
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
      // getFinancialRecords().then(response => {
        this.open = true;
        this.title = "添加财务记录";
      // });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const idd = row.id || this.ids;
      getFinancialRecords(idd).then(response => {
        this.form = response.data;
        console.log(response.data)
        this.open = true;
        this.title = "修改财务记录";
      });
    },

    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateFinancialRecords(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFinancialRecords(this.form).then(response => {
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
      const FinancialRecordIds = row.id || this.ids;
      this.$modal.confirm('是否确认删除财务编号为"' + FinancialRecordIds + '"的数据项？').then(function() {
        return delFinancialRecords(FinancialRecordIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
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
  },

};
</script>
<style scoped>

.el-table__body-wrapper {
  max-height: calc(100vh - 500px); /* 设置表格体的最大高度，留出搜索条件和底部pagination的空间 */
  overflow-y: auto; /* 当内容超出容器高度时显示垂直滚动条 */
}

</style>
