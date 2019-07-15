<template>
    <el-tree :data="treeData" :props="treeProps" v-on:node-click="treeNodeClickFunc" :highlight-current="true"></el-tree>
</template>
<script>
    export default{
        name:"Tree",
        data() {
            return {
            }
        },
        methods:{

        },
        props:{
            treeData:{
                type:Array,
                required:true,
                default:() => {
                    return [];
                }
            },
            treeProps:{
                type:Object,
                required:false,
                default:() => {
                    return {label:"label",children:"children"};
                }
            },
            treeNodeClickFunc:{
                type:Function,
                default:() => {
                    
                }
            }
        }
    }
</script>
<style>
    .el-tree {
        background: #f2f6fc;
    }
    .el-tree--highlight-current .el-tree-node.is-current>.el-tree-node__content {
        background-color: #9dcbff;
    }
</style>