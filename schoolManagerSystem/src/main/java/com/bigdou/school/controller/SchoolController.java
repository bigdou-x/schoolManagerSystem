package com.bigdou.school.controller;

import com.bigdou.school.entity.School;
import com.bigdou.school.service.SchoolService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <P>文件描述：学校Controller</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-8-18 17:15:16
 */
@RestController
@RequestMapping(value = "/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @ApiOperation(value = "添加学校", notes = "根据School对象创建学校")
    @ApiImplicitParam(name = "school", value = "学校信息实体类", required = true, dataType = "School")
    @PostMapping
    public Object addSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @ApiOperation(value = "修改学校信息", notes = "根据School对象修改学校")
    @ApiImplicitParam(name = "school", value = "学校信息实体类", required = true, dataType = "School")
    @PutMapping
    public Object modifySchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @ApiOperation(value = "获取学校信息", notes = "根据id查询学校，id为空查全部")
    @ApiImplicitParam(name = "schoolId", value = "学校Id", dataType = "String", paramType = "query")
    @GetMapping
    public Object getSchools(@RequestParam(name = "schoolId") String schoolId) {
        return schoolService.getSchools(schoolId);
    }

    @ApiOperation(value = "删除学校", notes = "根据School对象删除学校")
    @ApiImplicitParam(name = "school", value = "学校信息实体类", required = true, dataType = "School")
    @DeleteMapping
    public Object deleteSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

}
