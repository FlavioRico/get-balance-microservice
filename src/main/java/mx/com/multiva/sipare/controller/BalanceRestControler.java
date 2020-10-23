package mx.com.multiva.sipare.controller;

import mx.com.multiva.sipare.model.response.Balance;
import mx.com.multiva.sipare.model.response.Message;
import mx.com.multiva.sipare.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@CrossOrigin
@RestController
public class BalanceRestControler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceRestControler.class);

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/balances/findByTypeAndDate")
    public ResponseEntity<Object> getBalanceByTypeAndDate(
            @RequestParam(required = false) String date, @RequestParam String type) {

        Balance balance = balanceService.retrieveBalanceByTypeAndDate(date, type);

        if (balance.getHttpStatus() != HttpStatus.OK) {

            Message message = new Message();

            message.setStatus(balance.getHttpStatus().value());
            message.setError(balance.getHttpStatus().getReasonPhrase());

            switch (message.getStatus()) {

                case 204:
                    message.setDescription("No balance available");
                    break;
                case 400:
                    message.setDescription("Wrong balance type or date");
                    break;
                case 424:
                    message.setDescription("T24 Services are not responding");
                    break;
                default:
                    LOGGER.warn("Unspecified code");
                    break;
            }

            message.setTimestamp(
                    new Timestamp(System.currentTimeMillis()));

            return  ResponseEntity.status(message.getStatus())
                    .body(message);
        }

        return ResponseEntity.ok().body(balance);
    }

}
