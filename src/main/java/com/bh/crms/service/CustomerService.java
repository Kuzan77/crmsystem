package com.bh.crms.service;

import com.bh.crms.dao.CustomerDao;
import com.bh.crms.domain.Customer;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 11:28
 */
public class CustomerService {

    private CustomerDao customerDao = new CustomerDao();

    /**
     * 添加客户
     * @param c
     */
    public void addCustomer(Customer c) {
        customerDao.addCustomer(c);
    }

    /**
     * 查询所有
     */
    public List findAll() {
        return customerDao.findAll();
    }

    /**
     * 删除客户(根据cid)
     */
    public int deleteCustomer(String cid) {
        return customerDao.deleteCustomer(cid);
    }

    /**
     * 根据ID查询客户信息(修改之前)
     */
    public Customer findCustomerById(String id) {
        return customerDao.findCustomerById(id);
    }

    /**
     * 编辑客户信息
     */
    public int editCustomer(Customer c) {
        return customerDao.editCustomer(c);
    }

    /**
     * 高级搜索
     */
    public List advancedQuery(Customer c) {
        return customerDao.advancedQuery(c);
    }
}
