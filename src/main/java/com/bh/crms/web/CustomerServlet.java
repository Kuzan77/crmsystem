package com.bh.crms.web;

import com.bh.crms.domain.Customer;
import com.bh.crms.service.CustomerService;
import com.bh.crms.utils.DateUtil;
import com.bh.crms.utils.UUIDUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 10:33
 */
@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.封装对象
         * 2.添加cid--UUID
         * 3.调用service方法
         * 4.把成功信息保存到request域
         * 5.跳转至msg.jsp页面
         */
        try {
            String cid = UUIDUtil.getContinuouslyUUID();
            String cname = req.getParameter("cname");
            String gender = req.getParameter("gender");
            String birthday = req.getParameter("birthday");
            Date newbirthday = DateUtil.stringToDate(birthday, "yyyy-MM-dd");
            String cellphone = req.getParameter("cellphone");
            String email = req.getParameter("email");
            String description = req.getParameter("description");
            Customer customer = new Customer(cid, cname, gender, newbirthday, cellphone, email, description);

            req.setAttribute("msg", "添加用户成功");
            customerService.addCustomer(customer);
            RequestDispatcher dispather=req.getRequestDispatcher("msg.jsp");
            dispather.forward(req, resp);


        } catch (ParseException e) {
            System.out.println("转换日期格式失败!!!");
        }


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
