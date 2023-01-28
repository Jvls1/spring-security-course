package com.jojo.controller;

import com.jojo.model.AccountTransactions;
import com.jojo.model.Customer;
import com.jojo.repository.AccountTransactionsRepository;
import com.jojo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            return accountTransactionsRepository.
                    findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
        }
        return null;
    }
}
