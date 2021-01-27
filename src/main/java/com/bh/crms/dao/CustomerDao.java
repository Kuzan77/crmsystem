package com.bh.crms.dao;

import com.bh.crms.domain.Customer;
import com.bh.crms.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
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

        String sql = "insert into tb_customer values (?,?,?,?,?,?,?)";
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
        String sql = "select * from tb_customer";
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
     */
//    public void deleteCustomer(String cid) {
//        String sql = "delete from tb_customer where cid = ?";
//    }
}
