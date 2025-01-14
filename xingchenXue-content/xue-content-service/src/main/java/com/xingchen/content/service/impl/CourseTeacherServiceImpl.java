package com.xingchen.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingchen.base.exception.SystemException;
import com.xingchen.content.mapper.CourseTeacherMapper;
import com.xingchen.content.service.CourseTeacherService;
import com.xingchen.domain.entity.CourseTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程-教师关系表(CourseTeacher)表服务实现类
 *
 * @author makejava
 * @since 2024-04-12 20:55:31
 */
@Service
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherMapper, CourseTeacher> implements CourseTeacherService {

    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    /**
     * 课程教师查询接口实现方法
     * @param courseId 课程id
     * @return 教师列表
     */
    @Override
    public List<CourseTeacher> findAllcourseTeacher(Long courseId) {
        //构造条件
        LambdaQueryWrapper<CourseTeacher> courseTeacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
        courseTeacherLambdaQueryWrapper.eq(CourseTeacher::getCourseId,courseId);
        List<CourseTeacher> teacherList = courseTeacherMapper.selectList(courseTeacherLambdaQueryWrapper);
        return teacherList;
    }

    /**
     * 课程教师添加、修改接口
     * @param courseTeacher 教师基本信息
     * @return 教师基本信息
     */
    @Override
    @Transactional
    public CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher) {
        //判断是修改还是添加
        Long id = courseTeacher.getId();
        if (id !=null){
            int i = courseTeacherMapper.updateById(courseTeacher);
            if (i<=0){
                SystemException.cast("修改教师失败，请重试");
            }
        }else {
            int insert = courseTeacherMapper.insert(courseTeacher);
            if (insert <=0){
                SystemException.cast("新增教师失败，请重试");
            }
        }
        return courseTeacher;
    }

    /**
     * 课程教师删除接口
     * @param courseId   课程id
     * @param courseTeacherId 教师id
     * @return
     */
    @Override
    @Transactional
    public void deleteCourseTeacher(Long courseId, Long courseTeacherId) {
        LambdaQueryWrapper<CourseTeacher> teachplanLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teachplanLambdaQueryWrapper.eq(CourseTeacher::getCourseId,courseId).eq(CourseTeacher::getId,courseTeacherId);
        int delete = courseTeacherMapper.delete(teachplanLambdaQueryWrapper);
        if (delete <=0) {
            SystemException.cast("删除失败,请重试");
        }

    }
}