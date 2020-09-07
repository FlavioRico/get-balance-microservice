package mx.com.multiva.sipare.util.generator.impl;

import mx.com.multiva.sipare.model.entity.SipareBalance;
import mx.com.multiva.sipare.model.response.Balance;
import mx.com.multiva.sipare.model.response.Comparison;
import mx.com.multiva.sipare.model.response.Summary;
import mx.com.multiva.sipare.model.util.AccountBalanceT24;
import mx.com.multiva.sipare.repository.SipareBalanceRepository;
import mx.com.multiva.sipare.util.client.AccountBalanceT24Client;
import mx.com.multiva.sipare.util.generator.BalanceGenerator;
import mx.com.multiva.sipare.util.BalanceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ProcesarBalanceGenerator implements BalanceGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcesarBalanceGenerator.class);

    @Autowired
    private SipareBalanceRepository sipareBalanceRepository;
    @Autowired
    private AccountBalanceT24Client accountBalanceT24Client;
    @Autowired
    private ProcesarBalanceBuilder procesarBalanceBuilder;

    @Override
    public Balance generateCurrentBalance() {

        LOGGER.info("Generating current PROCESAR Balance");

        /** Retrieving balance from Database **/
        SipareBalance sipareBalance = sipareBalanceRepository.findByDispatchDateAndType(
                LocalDate.now().toString(), BalanceType.PROCESAR);

        Balance balance = new Balance();

        if(sipareBalance != null) {

            /**
             * In the case of the PROCESAR balance, if it is persisted,
             * it implies that it is balanced and therefore has been approved,
             * it is not necessary to call the service again.
             **/

            Summary summary = procesarBalanceBuilder.buildSummary(
                    sipareBalance.getTotalRcv(),
                    sipareBalance.getTotalVicAcvImss(),
                    sipareBalance.getTotal()
            );

            Comparison comparison = new Comparison();
            comparison.setRcvEquality(true);
            comparison.setViviendaAcvImssEquality(true);
            comparison.setTotalEquality(true);

            balance.setId(sipareBalance.getId());
            balance.setDispatchDate(sipareBalance.getDispatchDate());
            balance.setType(sipareBalance.getType());
            balance.setFileAmounts(summary);
            balance.setT24Amounts(summary);
            balance.setComparisons(comparison);
            balance.setBalanced(true);
            balance.setStatus(sipareBalance.getStatus());
            balance.setHttpStatus(HttpStatus.OK);

        }else {

            try {

                /** Retrieving balance from Yaxché and T24 Services **/
                AccountBalanceT24 accountBalanceT24 =
                        accountBalanceT24Client.getAccAccountBalanceT24();

                /** 24 as a reference of T24 input **/
                balance.setId(24);
                balance.setDispatchDate(accountBalanceT24.getDate());
                balance.setType(BalanceType.PROCESAR);
                balance.setFileAmounts(procesarBalanceBuilder.buildSummary(
                        accountBalanceT24.getCollectionImssRcv(),
                        accountBalanceT24.getCollectionAcvViv(),
                        accountBalanceT24.getCollectionImssRcv()
                                .add(accountBalanceT24.getCollectionAcvViv())
                ));
                balance.setT24Amounts(procesarBalanceBuilder.buildSummary(
                        BigDecimal.valueOf(accountBalanceT24.getBalanceT24RCV()),
                        BigDecimal.valueOf(accountBalanceT24.getBalanceT24Imss()),
                        BigDecimal.valueOf(accountBalanceT24.getBalanceT24RCV()
                                + accountBalanceT24.getBalanceT24Imss())
                ));
                balance.setComparisons(procesarBalanceBuilder.buildComparison(
                        balance.getFileAmounts(), balance.getT24Amounts()
                ));
                balance.setBalanced(procesarBalanceBuilder.isBalanced(
                        balance.getComparisons()));
                balance.setStatus(200);
                balance.setHttpStatus(HttpStatus.OK);

            }catch (Exception exception) {

                balance.setHttpStatus(HttpStatus.FAILED_DEPENDENCY);
            }

        }

        return balance;
    }
}
