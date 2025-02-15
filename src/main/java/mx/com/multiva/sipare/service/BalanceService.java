package mx.com.multiva.sipare.service;

import mx.com.multiva.sipare.model.response.Balance;
import mx.com.multiva.sipare.util.generator.BalanceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    private BalanceSelector balanceSelector;

    public Balance retrieveBalanceByTypeAndDate(String date, String type) {

        return balanceSelector.selectBalance(date, type);
    }

}
