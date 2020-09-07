package mx.com.multiva.sipare.util.generator;

import mx.com.multiva.sipare.model.response.Balance;
import mx.com.multiva.sipare.util.BalanceType;
import mx.com.multiva.sipare.util.generator.impl.ProcesarBalanceGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceSelector {

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceSelector.class);

    @Autowired
    ProcesarBalanceGenerator procesarBalanceGenerator;

    public Balance selectCurrentBalance(String type) {

        Balance balance = null;

        switch (type) {

            case BalanceType.PROCESAR:
                balance = procesarBalanceGenerator.generateCurrentBalance();
                break;

            case BalanceType.CONSAR:
                break;

            default:
                LOGGER.error("Invalid balance type");
                break;
        }

        return balance;
    }

}
