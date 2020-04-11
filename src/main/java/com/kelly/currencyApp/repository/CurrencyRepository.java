package com.kelly.currencyApp.repository;

import com.kelly.currencyApp.model.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rates> fetchAllCurrencies() {
        return jdbcTemplate.query("select * from currency_converter",
                (dbRow, sequenceNumber) -> {
                    return new Rates(dbRow.getInt("id"),
                                 dbRow.getString("currency"),
                                 dbRow.getDouble("eur_rate"));
                }
        );
    }

}
