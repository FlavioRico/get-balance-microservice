package mx.com.multiva.sipare.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comparison {

    @JsonProperty("rcv_equality")
    private boolean rcvEquality;
    @JsonProperty("vivienda_acv_imss_equality")
    private boolean viviendaAcvImssEquality;
    @JsonProperty("total_equality")
    private boolean totalEquality;

    public boolean isRcvEquality() {
        return rcvEquality;
    }

    public void setRcvEquality(boolean rcvEquality) {
        this.rcvEquality = rcvEquality;
    }

    public boolean isViviendaAcvImssEquality() {
        return viviendaAcvImssEquality;
    }

    public void setViviendaAcvImssEquality(boolean viviendaAcvImssEquality) {
        this.viviendaAcvImssEquality = viviendaAcvImssEquality;
    }

    public boolean isTotalEquality() {
        return totalEquality;
    }

    public void setTotalEquality(boolean totalEquality) {
        this.totalEquality = totalEquality;
    }

}
