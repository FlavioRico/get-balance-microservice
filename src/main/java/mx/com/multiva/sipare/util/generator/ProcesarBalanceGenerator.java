package mx.com.multiva.sipare.util.generator;

import mx.com.multiva.sipare.model.entity.SipareBalance;
import mx.com.multiva.sipare.model.response.Balance;
import mx.com.multiva.sipare.model.response.Comparison;
import mx.com.multiva.sipare.model.response.Summary;
import mx.com.multiva.sipare.model.request.AccountBalanceT24;
import mx.com.multiva.sipare.repository.SipareBalanceRepository;
import mx.com.multiva.sipare.repository.SipareContentFileT24Repository;
import mx.com.multiva.sipare.util.DateOperations;
import mx.com.multiva.sipare.util.client.AccountBalanceT24Client;
import mx.com.multiva.sipare.util.BalanceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class ProcesarBalanceGenerator {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ProcesarBalanceGenerator.class);

    @Autowired
    private SipareBalanceRepository sipareBalanceRepository;
    @Autowired
    private SipareContentFileT24Repository sipareContentFileT24Repository;
    @Autowired
    private AccountBalanceT24Client accountBalanceT24Client;
    @Autowired
    private ProcesarBalanceBuilder procesarBalanceBuilder;
    @Autowired
    private DateOperations dateOperations;

    public Balance generateBalanceByDate(String date) {

        LOGGER.info("Getting balance with date : " + date);

        Balance balance = new Balance();
        balance.setHttpStatus(HttpStatus.OK);

        return balance;
    }

    public Balance generateCurrentBalance() {

        LOGGER.info("Getting current balance");

        Balance balance = new Balance();

        SipareBalance sipareBalance = sipareBalanceRepository
                .findByDispatchDateAndType(
                        //"2020-09-29",
                        LocalDate.now().toString(),
                        BalanceType.PROCESAR
                );

        if(sipareBalance != null) {

            LOGGER.info("Retrieving saved balance");

            Summary summary = procesarBalanceBuilder
                    .buildSummary(
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
            balance.setPaymentDate(sipareBalance.getPaymentDate());
            balance.setType(sipareBalance.getType());
            balance.setFileAmounts(summary);
            balance.setT24Amounts(summary);
            balance.setComparisons(comparison);
            balance.setBalanced(true);
            balance.setStatus(sipareBalance.getStatus());
            balance.setHttpStatus(HttpStatus.OK);
            balance.setApprovedBy(sipareBalance.getApprovedBy());
            balance.setTimestamp(sipareBalance.getTimestamp());

        }else {

            /**
             * If PROCESAR balance is saved it implies that is
             * balanced and has been approved otherwise
             * it is necessary to call T24 services.
             **/

            try {

                LOGGER.info("Retrieving balance from T24 Services");

                /** Retrieving balance from Yaxché and T24 Services **/
                AccountBalanceT24 accountBalanceT24 =
                        accountBalanceT24Client.getAccAccountBalanceT24();

                /** To generate payment date **/
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();

                /** To generate timestamp **/
                SimpleDateFormat timestampFormat =
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Timestamp timestamp =
                        new Timestamp(System.currentTimeMillis());

                balance.setDispatchDate(simpleDateFormat.format(currentDate));
                balance.setPaymentDate(simpleDateFormat.format(
                        dateOperations.subtractBusinessDays(
                                currentDate,
                                1
                        )
                ));
                balance.setType(BalanceType.PROCESAR);

                /** Retrieving RCV and ACV totals from database with T+1 date **/
                BigDecimal totalAcv =
                        sipareContentFileT24Repository.getTotalAcv(
                                //"2020-09-29"
                                simpleDateFormat.format(currentDate)
                        );
                BigDecimal totalRcv =
                        sipareContentFileT24Repository.getTotalRcv(
                                //"2020-09-29"
                                simpleDateFormat.format(currentDate)
                        );

                balance.setFileAmounts(procesarBalanceBuilder.buildSummary(
                        totalRcv, totalAcv, totalRcv.add(totalAcv)));
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
                balance.setApprovedBy("unapproved");
                balance.setTimestamp(timestampFormat.format(timestamp));

            }catch (Exception exception) {

                balance.setHttpStatus(HttpStatus.FAILED_DEPENDENCY);
            }

        }

        return balance;
    }

    public Balance generateCurrentMockedBalance() {

        SipareBalance sipareBalance = sipareBalanceRepository
                .findByDispatchDateAndType(
                        LocalDate.now().toString(),
                        BalanceType.PROCESAR);

        Balance balance = new Balance();

        if (sipareBalance != null) {

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
            balance.setPaymentDate(sipareBalance.getPaymentDate());
            balance.setType(sipareBalance.getType());
            balance.setFileAmounts(summary);
            balance.setT24Amounts(summary);
            balance.setComparisons(comparison);
            balance.setBalanced(true);
            balance.setStatus(sipareBalance.getStatus());
            balance.setHttpStatus(HttpStatus.OK);
            balance.setApprovedBy(sipareBalance.getApprovedBy());
            balance.setTimestamp(sipareBalance.getTimestamp());

        } else {

            /** To generate currend and payment date **/
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();

            /** To generate timestamp **/
            SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            /** Mockup retrieved values **/
            BigDecimal zeroConstant = BigDecimal.valueOf(0);
            Summary summary = procesarBalanceBuilder.buildSummary(
                    zeroConstant, zeroConstant, zeroConstant
            );

            /** Building mockup balance **/
            balance.setDispatchDate(LocalDate.now().toString());
            balance.setPaymentDate(simpleDateFormat.format(
                    dateOperations.subtractBusinessDays(currentDate, 3)
            ));
            balance.setType(BalanceType.PROCESAR);
            balance.setFileAmounts(summary);
            balance.setT24Amounts(summary);
            balance.setComparisons(procesarBalanceBuilder.buildComparison(
                    balance.getFileAmounts(), balance.getT24Amounts()
            ));
            balance.setBalanced(procesarBalanceBuilder.isBalanced(
                    balance.getComparisons()));
            balance.setStatus(200);
            balance.setHttpStatus(HttpStatus.OK);
            balance.setApprovedBy("unapproved");
            balance.setTimestamp(timestampFormat.format(timestamp));
        }

        return balance;
    }

}
