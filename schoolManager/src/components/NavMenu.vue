<template>
    <el-menu 
        class="el-menu-demo"
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        :router="true"
        :default-active="this.$route.path">
        <template v-for="(firstMenu, firstIndex) in menuJson">
            <el-menu-item  :index="String(firstMenu.routerPath)" v-if="firstMenu.childMenu.length < 1" v-on:click="firstMenu.clickFunc">
                {{ firstMenu.label }}
            </el-menu-item>
            <el-submenu v-else :index="String(firstMenu.routerPath)">
                <template slot="title">{{ firstMenu.label }}</template>
                <template v-for="(secondMenu, secondIndex) in firstMenu.childMenu">
                    <el-menu-item  :index="String(secondMenu.routerPath)" v-if="secondMenu.childMenu.length < 1" v-on:click="secondMenu.clickFunc">
                        {{ secondMenu.label }}
                    </el-menu-item>
                    <el-submenu :index="String(secondMenu.routerPath)" v-else>
                        <template slot="title">{{ secondMenu.label }}</template>
                        <template v-for="(thirdMenu, thirdIndex) in secondMenu.childMenu">
                            <el-menu-item :index="String(thirdMenu.routerPath)" v-on:click="thirdMenu.clickFunc">
                                {{ thirdMenu.label }}
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
            </el-submenu>
        </template>
    </el-menu>
</template>
<script>
    export default{
        name:"NavMenu",
        data(){
            return {

            }
        },
        methods:{

        },
        props:{
            menuJson:{
                type:Array,
                // required:true
                default:() => {
                    return [];
                }
            }
        }
    }
</script>
<style>
    
</style>