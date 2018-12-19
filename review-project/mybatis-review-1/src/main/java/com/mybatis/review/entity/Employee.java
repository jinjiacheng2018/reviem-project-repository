package com.mybatis.review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *<p> Description: 雇员实体类 </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = -8808546155385651919L;

    private Integer empId; //雇员编号

    private String empName; //雇员姓名

    private Integer empAge; //雇员年龄

    private String empAddress; //雇员地址

}
