package mx.com.multiva.sipare.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Summary {

    private BigDecimal rcv;
    @JsonProperty("vivienda_acv_imss")
    private BigDecimal viviendaAcvImss;
    private BigDecimal total;

    public BigDecimal getRcv() {
        return rcv;
    }

    public void setRcv(BigDecimal rcv) {
        this.rcv = rcv;
    }

    public BigDecimal getViviendaAcvImss() {
        return viviendaAcvImss;
    }

    public void setViviendaAcvImss(BigDecimal viviendaAcvImss) {
        this.viviendaAcvImss = viviendaAcvImss;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
