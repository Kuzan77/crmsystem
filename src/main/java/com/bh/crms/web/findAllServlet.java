package com.bh.crms.web;

import com.bh.crms.domain.Customer;
import com.bh.crms.service.CustomerService;
import com.bh.crms.utils.PageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 15:55
 */
@WebServlet(name = "findAllServlet", urlPatterns = "/findAll")
public class findAllServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 原始查询
         */
//        List<Customer> customerList = customerService.findAll();
//        req.setAttribute("crmsList", customerList);
//        RequestDispatcher dispather = req.getRequestDispatcher("list.jsp");
//        dispather.forward(req, resp);

        /**
         * 分页查询
         */
        // 获取分页参数
        int start = 0;
        int count = 5;

        try {
            start = Integer.parseInt(req.getParameter("start"));
        } catch (Exception e) {

        }

        int total = customerService.findtotal(start, count);
        PageUtil page = new PageUtil(start, count, total);
        List<Customer> clist = customerService.findAllPage(page.getStart(), page.getCount());
        req.setAttribute("page", page);
        req.setAttribute("crmsList", clist);
        RequestDispatcher dispather = req.getRequestDispatcher("list.jsp");
        dispather.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
