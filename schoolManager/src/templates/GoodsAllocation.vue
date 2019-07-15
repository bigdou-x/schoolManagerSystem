<template>
    <el-container>
        <el-aside width="20%" style="background-color:#f2f6fc;">
            <Tree :treeData="areaTreeData" :treeNodeClickFunc="treeNodeClickFunc"></Tree>
        </el-aside>
        <el-container>
            <el-main></el-main>
        </el-container>
    </el-container>
</template>
<script>
    import BaseLayout from "../components/BaseContainerLayout"
    import Tree from "../components/Tree"

    export default {
        name:"GoodsAllocation",
        data(){
            return {
                areaTreeData:[{
                    label:"组织区域",
                    children:[
                        {
                            label:"天津市",
                            children:[
                                {
                                    label:"西青区",
                                    children:[]
                                },
                                {
                                    label:"南开区",
                                    children:[]
                                }
                            ]
                        }
                    ]
                }],
                treeNodeClickFunc (node) {
                    console.info("node===",node);
                }
            }
        },
        methods:{

        },
        components:{
            BaseLayout,
            Tree
        }
    }
</script>
<style>
    
</style>