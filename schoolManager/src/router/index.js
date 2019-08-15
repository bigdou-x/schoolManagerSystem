import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import CodeGenerateTemplate from "../templates/CodeGenerateTemplate"
import GenerateButton from '../components/GenerateButton'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // }
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: "/CodeGenerateTemplate",
      name: "CodeGenerateTemplate",
      component: CodeGenerateTemplate
    },
    {
      path: "/GenerateButton",
      name: "GenerateButton",
      component: GenerateButton
    }
  ]
})
