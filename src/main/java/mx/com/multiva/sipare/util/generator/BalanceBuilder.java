package mx.com.multiva.sipare.util.generator;

import mx.com.multiva.sipare.model.response.Comparison;
import mx.com.multiva.sipare.model.response.Summary;

import java.math.BigDecimal;

public interface BalanceBuilder {

    public Summary buildSummary(BigDecimal rcv, BigDecimal viviendaAcvImss, BigDecimal total);
    public Comparison buildComparison(Summary fileAmounts, Summary t24Amounts);
    public boolean isBalanced(Comparison comparison);

}
