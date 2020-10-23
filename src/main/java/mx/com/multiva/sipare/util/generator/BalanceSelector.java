package mx.com.multiva.sipare.util.generator;

import mx.com.multiva.sipare.model.response.Balance;
import mx.com.multiva.sipare.util.BalanceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BalanceSelector {

    @Autowired
    ProcesarBalanceGenerator procesarBalanceGenerator;

    public Balance selectBalance(String date, String type) {

        Balance balance = new Balance();

        if (type.equals(BalanceType.PROCESAR)) {

            if(date == null) {

                balance =
                        procesarBalanceGenerator.generateCurrentBalance();

            }else {

                balance =
                        procesarBalanceGenerator.generateBalanceByDate(date);
            }

        }else {

            balance.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return balance;
    }

}
