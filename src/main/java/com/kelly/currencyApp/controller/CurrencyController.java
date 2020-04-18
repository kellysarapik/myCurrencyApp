package com.kelly.currencyApp.controller;

import com.kelly.currencyApp.model.Currencies;
import com.kelly.currencyApp.repository.CurrencyRepository;
import com.kelly.currencyApp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/currency")

public class CurrencyController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/all")
    public List<Currencies> getCurrencies() {
        return currencyRepository.fetchAllCurrencies();
    }

    @DeleteMapping("/{currencyId}")
    public void deleteSingleCurrency(@PathVariable int currencyId) {
        currencyRepository.removeSingleCurrency(currencyId);
    }
@PostMapping("/new")
    public void addCurrency(@RequestBody Currencies currency) {
        currencyService.addCurrency(currency);
    }
@PostMapping("/edit")
    public void editCurrency(@RequestBody Currencies currency) {
        currencyService.editCurrency(currency);
    }
}

