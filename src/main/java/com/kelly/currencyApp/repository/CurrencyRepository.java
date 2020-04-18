package com.kelly.currencyApp.repository;

import com.kelly.currencyApp.model.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Currencies> fetchAllCurrencies() {
        return jdbcTemplate.query("select * from currency_converter",
                (dbRow, sequenceNumber) -> {
                    return new Currencies(dbRow.getInt("id"),
                            dbRow.getString("currency"),
                            dbRow.getDouble("eur_rate"));
                }
        );
    }

    public void removeSingleCurrency(int currencyId) {
        jdbcTemplate.update("delete from currency_converter where id = ?", currencyId);

    }


    public void addCurrency(Currencies currency) {
        jdbcTemplate.update("insert into currency_converter (`currency`, `eur_rate`) values (?,?)",
                currency.getCurrency(), currency.getEurRate());
    }

    public void editCurrency(Currencies currency) {
        jdbcTemplate.update("update currency_converter set `currency` = ?, `eur_rate` = ? where `id` = ?",
                currency.getCurrency(), currency.getEurRate(), currency.getId());
    }
}

