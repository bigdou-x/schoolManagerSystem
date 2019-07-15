<template>
  <el-table v-bind:data="tableData" :style="tableStyle" v-loading="isLoadingDisplay">
    <template v-for="col in columns">
      <el-table-column v-bind:label="col.label" v-bind:type="col.type" v-if="!col.operation" v-bind:prop="col.prop">
      </el-table-column>

      <el-table-column v-else v-bind:label="col.label" v-bind:prop="col.prop">
        <template slot-scope="scope">
          <el-button v-for="(oper, index) in col.operation" v-bind:key="index" v-on:click="oper.func(scope)" type="text">{{ oper.label }}</el-button>
        </template>
      </el-table-column>
    </template>
  </el-table>
</template>
<script>
  export default{
    name:"Grid",
    data(){
      return {
        message : "xuxiao is boy",
        isLoadingDisplay:false
      }
    },
    methods:{
      showLoading() {
        this.isLoadingDisplay = true;
      },
      hideLoading() {
        this.isLoadingDisplay = false;
      }
    },
    computed:{

    },
    props:["columns","tableData","tableStyle","gridFunc"],
    beforeCreate() {
     console.group('beforeCreate 创建前状态===============》');
     console.log("%c%s", "color:red" , "el     : " + this.$el); //undefined
     console.log("%c%s", "color:red","data   : " + this.$data); //undefined 
     console.log("%c%s", "color:red","message: " + this.message)  
    },
    created() {
      console.group('created 创建完毕状态===============》');
      console.log("%c%s", "color:red","el     : " + this.$el); //undefined
      console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化 
      console.log("%c%s", "color:red","message: " + this.message); //已被初始化
    },
    beforeMount() {
      console.group('beforeMount 挂载前状态===============》');
      console.log("%c%s", "color:red","el     : " + (this.$el)); //已被初始化
      console.log(this.$el);
      console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化  
      console.log("%c%s", "color:red","message: " + this.message); //已被初始化  
    },
    mounted() {
      console.group('mounted 挂载结束状态===============》');
      console.log("%c%s", "color:red","el     : " + this.$el); //已被初始化
      console.log(this.$el);    
      console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化
      console.log("%c%s", "color:red","message: " + this.message); //已被初始化 
    },
    beforeUpdate() {
      console.group('beforeUpdate 更新前状态===============》');
      console.log("%c%s", "color:red","el     : " + this.$el);
      console.log(this.$el);   
      console.log("%c%s", "color:red","data   : " + this.$data); 
      console.log("%c%s", "color:red","message: " + this.message); 
    },
    updated() {
      console.group('updated 更新完成状态===============》');
      console.log("%c%s", "color:red","el     : " + this.$el);
      console.log(this.$el); 
      console.log("%c%s", "color:red","data   : " + this.$data); 
      console.log("%c%s", "color:red","message: " + this.message); 
    },
    beforeDestroy() {
      console.group('beforeDestroy 销毁前状态===============》');
      console.log("%c%s", "color:red","el     : " + this.$el);
      console.log(this.$el);    
      console.log("%c%s", "color:red","data   : " + this.$data); 
      console.log("%c%s", "color:red","message: " + this.message); 
    },
    destroyed() {
      console.group('destroyed 销毁完成状态===============》');
      console.log("%c%s", "color:red","el     : " + this.$el);
      console.log(this.$el);  
      console.log("%c%s", "color:red","data   : " + this.$data); 
      console.log("%c%s", "color:red","message: " + this.message)
    }
  }    
</script>
<style>

</style>