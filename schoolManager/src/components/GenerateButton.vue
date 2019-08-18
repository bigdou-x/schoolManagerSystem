<template>
    <el-row >
        <el-col :span='24' class="widgetLayoutStyle">
            <el-button>按钮</el-button>
            <i class="el-icon-circle-plus-outline" @click="add"></i>
            <i class="el-icon-remove-outline" @click="remove"></i>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name:"GenerateButton",
        data() {
            return {

            }
        },
        methods:{
            add() {
                console.info("点击添加");
            },
            remove() {
                console.info("点击删除");
            }
        }
        // props: ["widgetData"]
    }
</script>

<style>
    .widgetLayoutStyle {
        margin: 5px;
    }
</style>
