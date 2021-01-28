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
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/28 11:54
 */
@WebServlet(name = "AdvancedQueryServlet", urlPatterns = "/query")
public class AdvancedQueryServlet extends HttpServlet {

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        Customer customer = new Customer(cname, gender, cellphone, email);
        List<Customer> customerList = customerService.advancedQuery(customer);

        req.setAttribute("crmsList", customerList);

        RequestDispatcher dispather = req.getRequestDispatcher("list.jsp");
        dispather.forward(req, resp);
    }
}
