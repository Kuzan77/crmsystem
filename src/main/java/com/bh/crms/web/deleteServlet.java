package com.bh.crms.web;

import com.bh.crms.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 16:43
 */
@WebServlet(name = "deleteServlet", urlPatterns = "/delete")
public class deleteServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        customerService.deleteCustomer(cid);

        req.setAttribute("msg", "删除用户成功");
        RequestDispatcher dispather=req.getRequestDispatcher("msg.jsp");
        dispather.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
