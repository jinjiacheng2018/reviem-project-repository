package com.mybatis.review;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.review.dao.EmployeeDao;
import com.mybatis.review.entity.Employee;

/**
 *<p> Description: 测试类 </p>
 *<p> Copyright: Copyright(c) 2018/12/19 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/19 16:06
 */
public class MyBatisAppTest
{
    /**
     * MyBatis的配置文件路径
     */
    private final String resource = "mybatis-config.xml";
    
    /**
     * 获取SqlSessionFactory对象
     * @return SqlSessionFactory
     * @throws IOException IO异常
     */
    private SqlSessionFactory getSqlSessionFactory() throws IOException
    {
        // 1.读取配置文件,获取SqlSessionFactory工厂对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    
    /**
     * 查询一条结果
     * @throws IOException IO异常
     */
    @Test
    public void test_01() throws IOException
    {
        // 1.获取SqlSessionFactory工厂对象并开启一个会话
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        
        // 2.通过SqlSession指定sql的id执行查询
        Employee employee = sqlSession.selectOne("com.mybatis.review.dao.EmployeeDao.queryEmpById", 1);
        System.out.println(employee);
        
        // 3.关闭会话
        sqlSession.close();
    }
    
    /**
     * 查询列表结果
     * @throws IOException IO异常
     */
    @Test
    public void test_02() throws IOException
    {
        // 1.获取SqlSessionFactory工厂对象并开启一个会话
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        
        // 2.通过SqlSession执行查询
        List<Employee> allEmps = sqlSession.selectList("com.mybatis.review.dao.EmployeeDao.queryAllEmps");
        allEmps.forEach(employee -> System.out.println(employee));
        
        // 3.关闭会话
        sqlSession.close();
    }
    
    /**
     * 接口式编程
     * @throws IOException IO异常
     */
    @Test
    public void test_03() throws IOException
    {
        // 开启会话
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        
        // 获取接口对象
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.queryAllEmps();
        employees.forEach(employee -> System.out.println(employee));
        
        // 关闭会话
        sqlSession.close();
    }

    /**
     * 动态SQL语句
     * @throws IOException IO异常
     */
    @Test
    public void test_04() throws IOException
    {
        // 开启会话
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        // 获取接口对象
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee emp = employeeDao.queryEmpByParam(new Employee(null,"Tom",25,null));
        System.out.println(emp);

        // 关闭会话
        sqlSession.close();
    }
}
