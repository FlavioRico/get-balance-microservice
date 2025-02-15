package mx.com.multiva.sipare.util.generator;

import mx.com.multiva.sipare.model.response.Comparison;
import mx.com.multiva.sipare.model.response.Summary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProcesarBalanceBuilder {

    public Summary buildSummary(
            BigDecimal rcv, BigDecimal viviendaAcvImss, BigDecimal total) {

        Summary summary = new Summary();

        summary.setRcv(rcv);
        summary.setViviendaAcvImss(viviendaAcvImss);
        summary.setTotal(total);

        return summary;
    }

    public Comparison buildComparison(Summary fileAmounts, Summary t24Amounts) {

        Comparison comparison = new Comparison();

        comparison.setRcvEquality(
                fileAmounts.getRcv().compareTo(t24Amounts.getRcv()) == 0
        );
        comparison.setViviendaAcvImssEquality(
                fileAmounts.getViviendaAcvImss()
                        .compareTo(t24Amounts.getViviendaAcvImss()) == 0
        );
        comparison.setTotalEquality(
                fileAmounts.getTotal().compareTo(t24Amounts.getTotal()) == 0
        );

        return  comparison;
    }

    public boolean isBalanced(Comparison comparison) {

        boolean balanced;

        balanced =
                comparison.isRcvEquality()
                        && comparison.isViviendaAcvImssEquality()
                        && comparison.isTotalEquality();

        return balanced;
    }

}
