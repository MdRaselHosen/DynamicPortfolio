package com.rasel.portfolio.controller;

import com.rasel.portfolio.model.Customer;
import com.rasel.portfolio.service.customerService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;

@Controller
public class PortfolioController {

    private final customerService customerSeriv;
    public PortfolioController(customerService customerSeriv){
        this.customerSeriv = customerSeriv;
    }
    @GetMapping("index")
    public String index(){
        return "index";
    }
    @GetMapping("main")
    public String main(){
        return "main";
    }

    @GetMapping("contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("projects")
    public String projects(){
        return "projects";
    }

    @PostMapping("contactInfo")
    public String contactInfo(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String message,
                              Model model){

        //System.out.println(name + " "+ email + " " + message);

        Customer customer = new Customer(name,email,message);
        customerSeriv.save(customer);
        //List<Customer> customerList = customerSeriv.getAll();
        //System.out.println(customerList);

        //model.addAttribute("customerList",customerSeriv.getAll());

        //model.addAttribute(customerList);
        //model.addAttribute("customerList",customerSeriv.getAll());


        //model.addAttribute(customerSeriv.getAll());
        //List<Customer> customerList = customerSeriv.getAll();
        //System.out.println(customerList);
        //List<Customer> customerList = customerSeriv.getAll();



        return "contact";
    }

    @GetMapping("admin")
    public String admin(Model model){

        List<Customer> allCustomer =customerSeriv.getAll();
        model.addAttribute("customerList", allCustomer);
        return "admin";
    }
}
