<template>
    <el-container :style="containerStyle">
        <el-header v-if="isShowHeader" :style="headerStyle">
            <slot name="headerSlot"></slot>
        </el-header>
        <el-main :style="mainStyle">
            <slot name="mainSlot"></slot>
        </el-main>
        <el-footer v-if="isShowFooter" :style="footerStyle">
            <slot name="footerSlot"></slot>
        </el-footer>
    </el-container>
</template>
<script>
    export default{
        name:"BaseContainerLayout",
        data(){
            return {

            }
        },
        methods:{
            
        },
        props:{
            isShowHeader: {
                type:Boolean,
                required:false,
                default:() => {
                    return false;
                }
            },
            isShowFooter: {
                type:Boolean,
                required:false,
                default:() => {
                    return false;
                }
            },
            containerStyle: {
                type:String,
                required:false,
                default:() => {
                    return "height:100%;width:100%";
                }
            },
            headerStyle: {
                type:String,
                required:false,
                default:() => {
                    return "height:5%;width:100%";
                }
            },
            mainStyle: {
                type:String,
                required:false,
                default:() => {
                    return "height:90%;width:100%";
                }
            },
            footerStyle: {
                type:String,
                required:false,
                default:() => {
                    return "height:5%;width:100%";
                }
            }
        }
    }
</script>
<style>
    
</style>