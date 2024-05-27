/**
* @program: DWSystem
* @author: Wasaige0828
**/
<template>
  <div class="app-container home">

    <el-row :gutter="20">
        <h1 :style="{ color: '#1890ff',textAlign:'center'} " class="title">帝王团购管理系统</h1>
    </el-row>

    <el-row :gutter="20">
      <el-col>
        <el-card class="update-log">
          <div class="update-item">
            <div class="update-title">1. 产品信息管理：</div>
            <div class="update-content">管理员可添加、编辑和删除产品信息，包括名称、描述、价格、库存等。员工可以查看产品信息，了解团购商品的详情和库存情况。</div>

            <div class="update-title">2. 代发记录：</div>
            <div class="update-content">记录代发订单的详细信息，包括下单时间、客户信息、产品信息等。提供代发订单跟踪和管理功能，确保订单顺利完成。</div>

            <div class="update-title">3. 批发记录：</div>
            <div class="update-content">记录批发订单的信息，包括购买数量、价格、客户信息等。支持批发订单的管理和跟踪，确保批发业务顺利进行。</div>

            <div class="update-title">4. 售后服务：</div>
            <div class="update-content">提供售后服务功能，包括退换货申请、售后反馈处理等。员工可以处理售后申请，确保客户的满意度和信任度。</div>

            <div class="update-title">5. 出货单查询：</div>
            <div class="update-content">员工可以查询出货单的信息，包括出货时间、产品信息、收货地址等。确保出货流程的透明和及时性。</div>

            <div class="update-title">6. 入库查询记录：</div>
            <div class="update-content">记录产品入库的信息，包括入库时间、入库数量、供应商信息等。管理员可以随时查询产品的入库情况，确保库存管理的准确性。</div>

            <div class="update-title">7. 财务信息：</div>
            <div class="update-content">提供财务管理功能，包括销售额统计、支出记录、利润分析等。管理员可以根据系统提供的财务数据进行决策和规划，确保财务运作的稳健性。</div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-divider />


    <el-tag type="danger" :style="{fontSize: '20px' }" >当前版本:<span>v{{ version }}</span></el-tag>


  </div>
</template>

<script>

import {color} from "echarts";

export default {
  name: "Index",
  computed: {
    color() {
      return color
    }
  },
  data() {
    return {
      // 版本号
      version: "3.8.7"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  font-size: 26px;
  color: #676a6c;
  overflow-x: hidden;

  .update-item {
    margin-bottom: 15px;
  }

  .update-title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 8px;
    font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  }

  .update-content {
    font-size: 16px;
    margin-bottom: 8px;
  }
}
.title {
  font-family: "楷体", "KaiTi", KaiTi, STKaiti, serif;
  margin-top: 10px;
  font-size: 50px;
  font-weight: 800;
}
</style>

