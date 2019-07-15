<template>
  <el-container direction="vertical">
    <el-header :style="headerLayout">
      <el-row>
        <el-col :span="10">
          <label>Demo</label>
        </el-col>
        <el-col :span="8" :offset="4">
          <NavMenu :menu-json="menuJson" :style="headerLayout"></NavMenu>
        </el-col>
        <el-col :span="2">
          <el-dropdown v-on:command="clickDropDownMenu">
            <span class="el-dropdown-link">
              用户: admin<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="modifyPassword">修改密码</el-dropdown-item>
              <el-dropdown-item command="logout">注销</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
      </el-row>
    </el-header>
    <el-main :style="mainLayout">
      <router-view></router-view>
    </el-main>
    <el-footer :style="headerLayout">这是呆毛</el-footer>
  </el-container>
</template>
<script>
    import NavMenu from "./NavMenu"

    export default {
      name:"HomePage",
      data(){
        return {
          menuJson:[
            {
              label:"首页",
              routerPath:"/Home",
              childMenu:[],
              clickFunc:() => {
                console.info("点击首页");
              }
            },
            {
              label:"库存信息",
              routerPath:"/StockInfo",
              childMenu:[],
              clickFunc:() => {
                console.info("点击库存信息");
              }
            },
            {
              label:"库存管理",
              routerPath:"/test1",
              childMenu:[
                {
                  label:"物品配置",
                  routerPath:"/test2",
                  childMenu:[
                    {
                      label:"物品配置1",
                      routerPath:"/GoodsAllocation",
                      childMenu:[],
                      clickFunc:() => {
                        console.info("点击物品配置1");
                      }
                    },
                    {
                      label:"物品配置2",
                      routerPath:"/test4",
                      childMenu:[],
                      clickFunc:() => {
                        console.info("点击物品配置2");
                      }
                    }
                  ]
                },
                {
                  label:"操作员",
                  childMenu:[],
                  routerPath:"/test5",
                  clickFunc:() => {
                    console.info("点击操作员");
                  }
                }
              ]
            }
          ],
          headerHeight:0,
          footerHeight:0
        }
      },
      methods:{
        clickDropDownMenu: function(currentMenu){
          this.$message("你点嘛呢? "+currentMenu);
        }
      },
      computed:{
        mainLayout(){
          // this.headerHeight = window.innerHeight * 0.02;
          // this.footerHeight = window.innerHeight * 0.02;
          return "height:" + (window.innerHeight * 0.84) + "px";
        },
        headerLayout(){
          return "height:" + (window.innerHeight * 0.07) + "px";
        }
      },
      components:{
        NavMenu
      }

    }
</script>
<style>
    .el-header, .el-footer {
      background-color: #545c64;
      color: #fff;
      text-align: center;
      line-height: 60px;
    }
    
    .el-main {
      background-color: #E9EEF3;
      color: #333;
      text-align: center;
    }
    
    .el-dropdown-link {
      cursor: pointer;
      color: #409EFF;
    }
    .el-icon-arrow-down {
      font-size: 12px;
    }
    .demonstration {
      display: block;
      color: #8492a6;
      font-size: 14px;
      margin-bottom: 20px;
    }
    .el-container {
      height: 100%;
      width: 100%;
    }
    .el-main {
      background-color: #ffffff;
    }
</style>