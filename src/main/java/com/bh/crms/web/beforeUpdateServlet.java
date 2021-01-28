package com.bh.crms.web;

import com.bh.crms.domain.Customer;
import com.bh.crms.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编辑之前根据ID查询客户信息进行回显
 * @author ：mmzs
 * @date ：Created in 2021/1/27 20:45
 */
@WebServlet(name = "beforeUpdateServlet", urlPatterns = "/beforeUpdate")
public class beforeUpdateServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1.获取cid
         * 2.根据cid查询数据
         * 3.调用service方法
         * 4.把成功信息保存到request域
         * 5.跳转至edit.jsp页面
         */
        String cid = req.getParameter("cid");
        Customer customer = customerService.findCustomerById(cid);

        req.setAttribute("customer", customer);

        RequestDispatcher dispather=req.getRequestDispatcher("edit.jsp");
        dispather.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
