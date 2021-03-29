package com.tts.springbootbasicshw.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/")
    public String index(Customer customer)
    {
        return "customer/index";
    }

    @PostMapping(value = "/")
    public String addNewCustomer(Customer customer, Model model)
    {
        customerRepository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail()));
        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());
        model.addAttribute("email", customer.getEmail());
        return "customer/result";
    }
}
