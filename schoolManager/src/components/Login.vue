<template>
    <el-container style='height: 100%;'>
        <el-header>Demo</el-header>
        <el-main>
            <template>
                <el-row>
                    <el-col :span='6' :offset='9' style="margin-top:15%;">
                        <el-form label-position="left" label-width="60px" :model='loginData'>
                            <el-form-item label='用户名'>
                                <el-input v-model='loginData.userName' placeholder='用户名'></el-input>
                            </el-form-item>
                            <el-form-item label='密码'>
                                <el-input v-model='loginData.password' placeholder='密码' type='password'></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type='primary' @click='onSubmit'>登录</el-button>
                            </el-form-item>
                        </el-form>
                    </el-col>
                </el-row>
                
            </template>
        </el-main>
        <el-footer>xxxx</el-footer>
    </el-container>
</template>

<script>
    export default{
        name: 'Login',
        data () {
            return {
                loginData: {
                    userName: '',
                    password: ''
                }
            }
        },
        methods: {
            onSubmit () {
                console.info(this.$axios)
                this.$axios.get("/user/login",{
                    params: this.loginData
                }).then(response => {
                    console.info(response)
                    console.info("router ",this.$router)
                })
                .catch(error => (console.info("error ",error)));
            }
        }
    }
</script>

<style scoped='scoped'>
    .el-header, .el-footer {
        color: #333;
        text-align: center;
    }
    /* .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
      }
      
      .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
      }
      
      .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
      }
      
      body > .el-container {
        margin-bottom: 40px;
      }
      
      .el-container:nth-child(5) .el-aside,
      .el-container:nth-child(6) .el-aside {
        line-height: 260px;
      }
      
      .el-container:nth-child(7) .el-aside {
        line-height: 320px;
      } */
</style>
