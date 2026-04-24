package com.et.expense_tracker_springboot.controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.et.expense_tracker_springboot.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class WebController {

    private final TransactionService service;

    @Autowired
    public WebController(TransactionService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String showDashboard(Model model) {
        model.addAttribute("balance",service.calculateBalance());
        model.addAttribute("transactions",service.getAllTransactions());
        return"dashboard";
    }

    @PostMapping("/add")
    public String addTransaction(@RequestParam String type, @RequestParam BigDecimal amount, @RequestParam LocalDate date, @RequestParam String category, @RequestParam String description) {
        service.addTransaction(type,amount,date,category,description);
        return "redirect:/";
    }
}
