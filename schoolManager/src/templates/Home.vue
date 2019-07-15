<template>
    <div class="block">
        <span class="demonstration">默认Hover指示器触发</span>
        <el-carousel height="150px">
            <el-carousel-item v-for="item in 4" :key="item">
                <h3>{{ item }}</h3>
            </el-carousel-item>
        </el-carousel>
        <el-button @click="btnAdd">添加</el-button>
        <el-form ref="form" :model="info">
            <el-form-item
                label="年龄"
                prop="age"
                :rules="[
                  { required: true, message: '年龄不能为空'},
                  { type: 'number', message: '年龄必须为数字值'}
                ]"
              >
               <el-input type="age" v-model.number="info.age" autocomplete="off"></el-input>
              </el-form-item>
                   <el-form-item
                        v-for="(item, index) in info.subInfo"
                        :label="'域名' + index"
                        :key="index"
                        :prop="'subInfo.' + index + '.age'"
                        :rules="{
                          required: true, message: '域名不能为空', trigger: 'blur'
                        }"
                      >
                   <el-input v-model="item.age" autocomplete="off"></el-input>
                  </el-form-item>
              <el-form-item>
                  <el-button type="primary" @click="submitForm('infos')">提交</el-button>
              </el-form-item>
        </el-form>
    </div>
</template>
<script>
    export default {
        name:"Home",
        data(){
            return {
                info:{
                    age:"0",
                    subInfo:[]
                }
            }
        },
        methods:{
            btnAdd() {
                var subInfo = {
                    age:"0"
                }
                this.info.subInfo.push(subInfo);
            },
            submitForm(formName) {
                //  this.$refs[formName].validate((valid) => {
                //   if (valid) {
                //     alert('submit!');
                //   } else {
                //     console.log('error submit!!');
                //     return false;
                //   }
                // });
            }
        }
    }
</script>
<style>
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 150px;
        margin: 0;
    }
    .el-carousel__item:nth-child(2n){
        background-color: #99a9bf;
    }
    .el-carousel__item:nth-child(2n+1){
        background-color: #d3dce6;
    }
</style>