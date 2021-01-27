package com.bh.crms.service;

import com.bh.crms.dao.CustomerDao;
import com.bh.crms.domain.Customer;

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
}
