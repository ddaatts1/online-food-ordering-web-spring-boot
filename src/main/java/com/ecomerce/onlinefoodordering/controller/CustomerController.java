package com.ecomerce.onlinefoodordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @GetMapping("")
    public String gethomepage(){
        return "/customer/customer-homepage";
    }

}
