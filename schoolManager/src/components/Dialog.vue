<template>
    <el-dialog title="商品信息"  :visible.sync="isDialogVisible" :before-close="handleClose" width="400px">
        <el-form label-width="80px">
            <el-row>
                <el-col :span="20">
                    <el-form-item label="名称">
                        <el-input type="text" v-model="stockInfo.caption"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="20">
                    <el-form-item label="数量">
                        <el-input-number type="number" v-model="stockInfo.num"></el-input-number>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="20">
                    <el-form-item label="所在区域">
                        <el-input type="text" v-model="stockInfo.area"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="20">
                    <el-form-item label="负责人">
                        <el-input type="text" v-model="stockInfo.chargePerson"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="20">
                    <el-form-item label="描述">
                        <el-input type="textarea" v-model="stockInfo.description"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-button type="primary" v-on:click="btnConfirm">确定</el-button>
            </el-row>
        </el-form>
    </el-dialog>
</template>
<script>
    export default{
        name:"Dialog",
        data(){
            return {
                isDialogVisible:false,
                stockInfo:{
                    caption:"",
                    num:0,
                    area:"",
                    chargePerson:"",
                    description:""
                }
            }
        },
        methods:{
            seeDialogVisibelStatus:function(){
                console.info("this.isDialogVisible===",this.isDialogVisible);
            },
            show:function(){
                console.info("显示Dialog");
                this.isDialogVisible = true;
            },
            hide:function(){
                console.info("隐藏Dialog");
                this.isDialogVisible = false;
            },
            handleClose:function(){
                this.isDialogVisible = false;
                console.info("handleClose");
            },
            btnConfirm(){
                this.$emit("submit-event",this.stockInfo);
            },
            refreshData(data){
                console.info("====refreshData===",data);
                this.stockInfo.caption = data.caption;
                this.stockInfo.num = data.num;
                this.stockInfo.area = data.area;
                this.stockInfo.chargePerson = data.chargePerson;
                this.stockInfo.description = data.description;
            }
        },
        props:["dialogVisible"]
    }
</script>
<style>
    
</style>