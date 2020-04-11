package com.kelly.currencyApp.controller;

import com.kelly.currencyApp.model.Rates;
import com.kelly.currencyApp.repository.CurrencyRepository;
import com.kelly.currencyApp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@CrossOrigin("*")
public class CurrencyController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/all")
    public List<Rates> getCurrencies() {
        return currencyRepository.fetchAllCurrencies();
    }

}
