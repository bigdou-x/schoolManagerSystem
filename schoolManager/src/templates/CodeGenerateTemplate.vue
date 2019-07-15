<template>
  <el-container>
    <el-aside style="width:28%;margin: 1%;">
      <div class="widget-panel"></div>
    </div>
    </el-aside>
    <el-main style="width:70%">
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name:"CodeGenerateTemplate",
    data () {
      return {

      }
    },
    methods:{

    }
  }
</script>

<style scoped="scoped">
  .widget-panel{
    height:99%;
    width: 99%;
    box-shadow: rgba(0, 0, 0, 0.12) 0px 2px 4px, rgba(0, 0, 0, 0.04) 0px 0px 6px;
    border-radius: 4px;
    border: 1px solid #BEE5EB;
  }
</style>
