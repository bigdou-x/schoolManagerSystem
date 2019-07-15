<template>
  <div>
    <Grid v-bind:columns="gridCol" ref="gridInfo" v-bind:tableData="gridData" v-bind:tableStyle="tableStyle"></Grid>
    <Dialog v-bind:dialogVisible="dialogVisible" ref="dialogInfo" @submit-event="modifyData"></Dialog>
    <gridInfo></gridInfo>
  </div>
</template>
<script>
  import Grid from "./Grid";
  import Dialog from "./Dialog";

  export default {
    name:"StockInfo",
    data(){
      var that = this;
      return {
        dialogVisible:true,
        tableColIndex:0,
        tableStyle:"width:100%;height:100%;",
        gridCol:[
          {
            label:"选择",
            type:"selection"
          },
          {
            label:"序号",
            type:"index"
          },
          {
            label:"名称",
            prop:"caption"
          },
          {
            label:"数量",
            prop:"num"
          },
          {
            label:"所在区域",
            prop:"area"
          },
          {
            label:"负责人",
            prop:"chargePerson"
          },
          {
            label:"描述",
            prop:"description"
          },
          {
            label:"操作",
            operation:[
              {
                label:"编辑",
                //箭头函数 简单定义方法
                func:(colData) => {
                  //调用子组件内方法
                  this.tableColIndex = colData.$index;
                  console.info("this.tableColIndex===",this.tableColIndex);
                  this.$refs.dialogInfo.refreshData(colData.row);
                  this.$refs.dialogInfo.show();
                }
              },{
                label:"删除",
                func:(colData) => {
                  this.$confirm("确认要删除吗?","提示",{
                    confirmButtonText:"确定",
                    cancelButtonText:"取消",
                    type:"warning"
                  }).then(() => {
                    this.$refs.gridInfo.showLoading();
                    this.gridData.splice(colData.$index,1);
                    console.info("gridData===",this.gridData);
                    this.$message({
                      type:"success",
                      message:"删除成功"
                    });
                    setTimeout(() => {
                      this.$refs.gridInfo.hideLoading();
                    },1000);
                    
                  }).catch(() => {
                    this.$message({
                      type:"info",
                      message:"已取消删除"
                    });
                  });
                }
              }
            ]
          }
        ],
        gridData:[
          {
            caption:"旺仔牛奶",
            num:100,
            area:"大中国",
            chargePerson:"王小丽",
            description:"???"
          },
          {
            caption:"烤串",
            num:0,
            area:"东北",
            chargePerson:"老铁",
            description:"三毛撸"
          },
          {
            caption:"煎饼果子",
            num:60,
            area:"天津",
            chargePerson:"张三",
            description:"xxx"
          }
        ]
      }
    },
    methods:{
      modifyData(data){
        console.info("子组件传递给父组件的数据==",this.$refs);
        
        this.$refs.dialogInfo.hide();
        // this.gridData[this.tableColIndex] = {};
        // this.gridData[this.tableColIndex] = data;
        this.$set(this.gridData[this.tableColIndex],"caption", data.caption);
        this.$message({
          type:"success",
          message:"修改成功"
        });
      }
    },
    components:{Grid,   Dialog},
    created() {
    }
  }    
</script>
<style>

</style>