package com.xingchen.content.api;


import com.xingchen.content.service.TeachplanService;
import com.xingchen.domain.dto.SaveTeachplanDto;
import com.xingchen.domain.dto.TeachplanDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 35238
 * 功能: 课程计划接口
 * 时间: 2024-04-07 20:55
 */
@Api(value = "课程计划接口",tags = "课程计划接口")
@RestController
public class TeachplanController {

    @Autowired
    TeachplanService teachplanService;

    @ApiOperation("课程计划查询")
    @ApiImplicitParam(value = "courseId", name = "课程Id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId){
        List<TeachplanDto> teachplanTree = teachplanService.findTeachplanTree(courseId);
        return teachplanTree;
    }

    @ApiOperation("课程计划的创建|修改")
    @PostMapping("/teachplan")
    public void saveTeachplan( @RequestBody SaveTeachplanDto teachplan){
        teachplanService.saveTeachplan(teachplan);
    }

    @ApiOperation("课程计划删除")
    @DeleteMapping("/teachplan/{teachplanId}")
    public void deleteTeachplan(@PathVariable Long teachplanId){
        teachplanService.deleteTeachplan(teachplanId);
    }


    @ApiOperation("课程计划层级下移")
    @PostMapping("/teachplan/movedown/{teachplanId}")
    public void movedownTeachplan( @PathVariable Long teachplanId){
        teachplanService.movedownTeachplan(teachplanId);
    }

    @ApiOperation("课程计划层级上移")
    @PostMapping("/teachplan/moveup/{teachplanId}")
    public void moveupTeachplan( @PathVariable Long teachplanId){
        teachplanService.moveupTeachplan(teachplanId);
    }


}