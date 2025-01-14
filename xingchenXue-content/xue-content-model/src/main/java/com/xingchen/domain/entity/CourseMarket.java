package com.xingchen.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.xingchen.base.config.EnumConverter;
import com.xingchen.base.enums.CourseEnum;
import com.xingchen.domain.dto.AddCourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 课程营销信息(CourseMarket)表实体类
 *
 * @author makejava
 * @since 2024-03-27 22:07:50
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course_market")
public class CourseMarket  {
    //主键，课程id@TableId
    private Long id;

    //收费规则，对应数据字典
    private CourseEnum charge;
    //现价
    private Float price;
    //原价
    private Float originalPrice;
    //咨询qq
    private String qq;
    //微信
    private String wechat;
    //电话
    private String phone;
    //有效期天数
    private Integer validDays;

    //由于charge字段，前端传过来的charge不是枚举值(例如FEE_NO)，而是code，我们要往数据库存code，而不是存枚举值
    public CourseMarket(AddCourseDto courseDto) {
        this.charge = new EnumConverter().convert(courseDto.getCharge());
    }
}