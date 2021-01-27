package com.bh.crms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/27 9:32
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
