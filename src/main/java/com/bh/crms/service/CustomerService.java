package com.bh.crms.service;

import com.bh.crms.dao.CustomerDao;
import com.bh.crms.domain.Customer;
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
    public void deleteCustomer(String cid) {
        customerDao.deleteCustomer(cid);
    }
}
