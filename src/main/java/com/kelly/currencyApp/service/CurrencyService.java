package com.kelly.currencyApp.service;


import com.kelly.currencyApp.model.Currencies;
import com.kelly.currencyApp.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;


    public void addCurrency(Currencies currency) {
        Assert.isTrue(currency.getCurrency().length() >= 2, "Currency name must contain 3 letters");
        Assert.isTrue(currency.getCurrency().length() <= 4, "Currency name must contain 3 letters");

        currencyRepository.addCurrency(currency);
    }

    public void editCurrency(Currencies currency) {
        Assert.isTrue(currency.getCurrency().length() >= 2, "Currency name must contain 3 letters");
        Assert.isTrue(currency.getCurrency().length() <= 4, "Currency name must contain 3 letters");

        currencyRepository.editCurrency(currency);
    }
}
