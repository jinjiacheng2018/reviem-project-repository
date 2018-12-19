package com.mybatis.review.dao;

import com.mybatis.review.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *<p> Description: 雇员数据访问层 </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 17:11
 */
public interface EmployeeDao {

    /**
     * 获取所有的雇员信息对象
     * @return
     */
    List<Employee> queryAllEmps();

    /**
     * 通过雇员编号获取雇员对象
     * @param empId
     * @return
     */
    Employee queryEmpById(Integer empId);
}
