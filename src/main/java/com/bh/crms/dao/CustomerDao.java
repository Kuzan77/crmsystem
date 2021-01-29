package com.bh.crms.dao;

import com.bh.crms.domain.Customer;
import com.bh.crms.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 10:54
 */
public class CustomerDao {
    DataSource ds = JdbcUtils.getDataSource();
    private QueryRunner qr = new QueryRunner(ds);
    /**
     * 添加客户
     * @param c
     */
    public void addCustomer(Customer c) {

        String sql = "insert into tb_customer(cid, cname, gender, birthday, cellphone, email, description) values (?,?,?,?,?,?,?)";
        Object[] objects = {c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription()};
        try {
            qr.update(sql, objects);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有
     */
    public List findAll() {
        String sql = "select * from tb_customer where enable = 0";
        List<Customer> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Customer.class));
        } catch (SQLException e) {
            System.out.println("查询失败!!!");
        }
        return list;
    }

    /**
     * 删除客户(根据cid)
     * 修改enable字段为1
     */
    public int deleteCustomer(String cid) {
        String sql = "UPDATE tb_customer SET enable = ?  where cid = ?";
        int n = 0;
        // 实际参数
         Object[] parms = {1, cid};
        try {
            n = qr.update(sql, parms);
        } catch (SQLException e) {
            System.out.println("删除失败!!!");
        }
        return n;
    }

    /**
     * 根据ID查询客户信息(修改之前)
     */
    public Customer findCustomerById(String id) {
        String sql = "SELECT * FROM tb_customer where cid = ?";
        Customer customer = null;
        try {
            customer = qr.query(sql,  new BeanHandler<Customer>(Customer.class),id);
        } catch (SQLException e) {
            System.out.println("执行失败!!!");
        }
        return customer;
    }

    /**
     * 编辑客户信息
     */
    public int editCustomer(Customer c) {
        String sql = "UPDATE tb_customer SET cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? WHERE cid=?";
        Object[] params = {c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription(), c.getCid()};;
        int result = 0;
        try {
            result = qr.update(sql, params);
        } catch (SQLException se) {
            System.out.println("执行sql语句失败!!!");
        }
        return result;
    }

    /**
     * 高级搜索(多条件组合查询)
     */
    public List advancedQuery(Customer c) {
        /**
         * 1.拼接sql语句
         * 2.准备参数
         * 3.执行sql语句
         * 4.返回执行结果
         */

        //定义一个容器存储实际参数
        List<String> list = new ArrayList<String>();

        String sql = "select * from tb_customer where 1 = 1";

        // 获取并判断条件是否存在
        if (!c.getCname().equals("")) {
            sql += " and cname like ?";
            list.add("%"+c.getCname().trim()+"%");
        }
        if (!c.getGender().equals("")) {
            sql += " and gender = ?";
            list.add(c.getGender().trim());
        }
        if (!c.getCellphone().equals("")) {
            sql += " and cellphone = ?";
            list.add(c.getCellphone().trim());
        }
        if (!c.getEmail().equals("")) {
            sql += " and email = ?";
            list.add(c.getEmail().trim());
        }
        sql += " and enable = 0";
        // 存储查询结果
        List<Customer> customerList = null;
        try {
            customerList = qr.query(sql, new BeanListHandler<Customer>(Customer.class), list.toArray());
        } catch (SQLException se) {
            System.out.println("执行sql语句失败!!!");
        }
        return customerList;
    }
}
