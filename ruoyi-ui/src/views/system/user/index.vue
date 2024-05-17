
<template>
  <div class="scroll-container">
    <div class="content" :style="{ width: contentWidth + 'px' }">

      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px"
               label-position="left">
        <el-row type="flex" justify="center" align="middle" gutter="15">
          <el-form-item label="内部编号" prop="field105">
            <el-select v-model="formData.field105" placeholder="请输入内部编号" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field105Options" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="产品名称" prop="field104">
            <el-select v-model="formData.field104" placeholder="请输入产品名称" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field104Options" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="品类" prop="field103">
            <el-select v-model="formData.field103" placeholder="请输入品类" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field103Options" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center" align="middle" gutter="15">
          <el-form-item label="发货编号" prop="field116">
            <el-select v-model="formData.field116" placeholder="请输入发货编号" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field116Options" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="规格" prop="field117">
            <el-select v-model="formData.field117" placeholder="请输入规格" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field117Options" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="品牌方" prop="field118">
            <el-select v-model="formData.field118" placeholder="请输入品牌方" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field118Options" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center" align="middle" gutter="15">
          <el-form-item label="产品状态" prop="field135">
            <el-input v-model="formData.field135" placeholder="请输入产品状态" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
          <el-form-item label="状态" prop="field130">
            <el-input v-model="formData.field130" placeholder="请输入状态" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
          <el-form-item label="生产日期" prop="field134">
            <el-date-picker type="daterange" v-model="formData.field134" format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期" end-placeholder="结束日期"
                            range-separator="至" clearable></el-date-picker>
          </el-form-item>
          <el-form-item label="录入时间" prop="field132">
            <el-date-picker type="daterange" v-model="formData.field132" format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期" end-placeholder="结束日期"
                            range-separator="至" clearable></el-date-picker>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="start" align="top" gutter="15">
          <el-col :span="12">
            <el-form-item  prop="field144">
              <el-button type="primary" icon="el-icon-search" size="medium"> 录入时间 </el-button>
            </el-form-item>
          </el-col>
          <el-form-item  prop="field143">
            <el-button type="primary" icon="el-icon-search" size="medium"> 产品名称 </el-button>
          </el-form-item>
          <el-form-item  prop="field142">
            <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
          </el-form-item>
          <el-form-item  prop="field141">
            <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
          </el-form-item>
          <el-form-item  prop="field140">
            <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
          </el-form-item>
          <el-form-item  prop="field139">
            <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center" align="middle" gutter="15">
          <el-col :span="12">
            <el-form-item  prop="field159">
              <el-select v-model="formData.field159" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field159Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item  prop="field160">
              <el-select v-model="formData.field160" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field160Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field158">
              <el-select v-model="formData.field158" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field158Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field156">
              <el-select v-model="formData.field156" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field156Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field160">
              <el-select v-model="formData.field160" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field160Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field158">
              <el-select v-model="formData.field158" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field158Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field156">
              <el-select v-model="formData.field156" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field156Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field160">
              <el-select v-model="formData.field160" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field160Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field158">
              <el-select v-model="formData.field158" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field158Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field156">
              <el-select v-model="formData.field156" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field156Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field160">
              <el-select v-model="formData.field160" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field160Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field158">
              <el-select v-model="formData.field158" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field158Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item  prop="field156">
              <el-select v-model="formData.field156" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in field156Options" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item size="large">
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>

  </div>
    <div class="scrollbar" ref="scrollbar"></div>
  </div>
</template>



<style>
/*.scroll-container {*/
/*  width: 100%; !* 设置容器的宽度 *!*/
/*  white-space: nowrap; !* 防止内容换行 *!*/
/*  overflow-x: auto; !* 启用水平滚动条 *!*/
/*  overflow-y: auto; !* 启用水平滚动条 *!*/
/*    bottom: 0;*/
/*    left: 0;*/
/*}*/

/* 自定义滚动条样式 */
.scroll-container::-webkit-scrollbar {
  width: 12px; /* 设置滚动条的宽度 */
}

.scroll-container::-webkit-scrollbar-thumb {
  background-color: #888; /* 设置滚动条拖动条的颜色 */
}

.scroll-container::-webkit-scrollbar-track {
  background-color: #f1f1f1; /* 设置滚动条轨道的颜色 */
}

.scroll-container {
  /*position: fixed;*/
  bottom: 0;
  left: 0;
  width: 100%;
  /*height: 80%; !* 滚动容器的高度 *!*/
  overflow: scroll;
  /*background-color: #f1f1f1; !* 背景颜色 *!*/
}

.content {
  white-space: nowrap; /* 防止内容换行 */
  /*padding: 10px; !* 可选的内边距 *!*/
}
</style>







<script>
import { listUser, getUser, delUser, addUser, updateUser, resetUserPwd, changeUserStatus, deptTreeSelect } from "@/api/system/user";
import { getToken } from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  components: {},
  props: [],
  mounted() {
    // 计算内容宽度
    this.contentWidth = this.$refs.scrollbar.scrollWidth;

    // 监听窗口大小变化，以便重新计算内容宽度
    window.addEventListener('resize', this.handleResize);
  },
  beforeDestroy() {
    // 在组件销毁之前移除 resize 事件监听
    window.removeEventListener('resize', this.handleResize);
  },
  data() {
    return {

      contentWidth: 0,

      formData: {
        field105: undefined,
        field104: undefined,
        field103: undefined,
        field116: undefined,
        field117: undefined,
        field118: undefined,
        field135: undefined,
        field130: undefined,
        field134: null,
        field132: null,
        field144: undefined,
        field143: undefined,
        field142: undefined,
        field141: undefined,
        field140: undefined,
        field139: undefined,
        field159: undefined,
        field161: undefined,
        field160: undefined,
        field158: undefined,
        field156: undefined,
        field157: undefined,
        field154: undefined,
        field155: undefined,
        field153: undefined,
        field150: undefined,
        field151: undefined,
        field152: undefined,
      },
      rules: {
        field105: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field104: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field103: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field116: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field117: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field118: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field135: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field130: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field134: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
        field132: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
        field159: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }],
        field161: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field160: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }],
        field158: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }],
        field156: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }],
        field157: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }],
        field154: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field155: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field153: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field150: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field151: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
        field152: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'change'
        }],
      },
      field105Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field104Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field103Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field116Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field117Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field118Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field159Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field160Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field158Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field156Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field157Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field150Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field151Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      field152Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    handleResize() {
      // 当窗口大小变化时重新计算内容宽度
      this.contentWidth = this.$refs.scrollbar.scrollWidth;
    }
  }
}

</script>
<style>
</style>
