package com.bh.crms.web;

import com.bh.crms.domain.Customer;
import com.bh.crms.service.CustomerService;
import com.bh.crms.utils.DateUtil;

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
 * @date ：Created in 2021/1/28 9:30
 */
@WebServlet(name = "editServlet", urlPatterns = "/edit")
public class editServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.封装对象
         * 2.调用方法完成修改后的数据添加
         * 3.保存信息到request域
         * 4.转发至msg.jsp页面
         */
        try {
            String cid = req.getParameter("cid");
            String cname = req.getParameter("cname");
            String gender = req.getParameter("gender");
            String birthday = req.getParameter("birthday");
            Date newbirthday = DateUtil.stringToDate(birthday, "yyyy-MM-dd");
            String cellphone = req.getParameter("cellphone");
            String email = req.getParameter("email");
            String description = req.getParameter("description");
            Customer customer = new Customer(cid, cname, gender, newbirthday, cellphone, email, description);

            int n = customerService.editCustomer(customer);
            if (n > 0) {
                req.setAttribute("msg", "修改用户成功");
            }else {
                req.setAttribute("msg", "修改用户失败!");
            }
            RequestDispatcher dispather=req.getRequestDispatcher("msg.jsp");
            dispather.forward(req, resp);

        } catch (ParseException e) {
            System.out.println("日期解析失败!!!");
        }

    }
}
