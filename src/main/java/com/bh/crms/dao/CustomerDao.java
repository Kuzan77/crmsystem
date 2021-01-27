package com.bh.crms.dao;

import com.bh.crms.domain.Customer;
import com.bh.crms.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

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

        String sql = "insert into tb_customer values (?,?,?,?,?,?,?)";
        Object[] objects = {c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription()};
        try {
            qr.update(sql, objects);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectCustomer() {
        String sql = "select * from tb_customer";

    }
}
