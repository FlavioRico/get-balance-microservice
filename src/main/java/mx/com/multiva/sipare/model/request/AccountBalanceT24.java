package mx.com.multiva.sipare.model.request;

import java.math.BigDecimal;

public class AccountBalanceT24 {

    private String resultCode;
    private String resultDescription;
    private String resultTimestamp;
    private String date;
    private Double balanceT24Imss;
    private Double balanceT24RCV;
    private BigDecimal collectionImssRcv;
    private long balanceT24Viv;
    private BigDecimal collectionAcvViv;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public String getResultTimestamp() {
        return resultTimestamp;
    }

    public void setResultTimestamp(String resultTimestamp) {
        this.resultTimestamp = resultTimestamp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getBalanceT24Imss() {
        return balanceT24Imss;
    }

    public void setBalanceT24Imss(Double balanceT24Imss) {
        this.balanceT24Imss = balanceT24Imss;
    }

    public Double getBalanceT24RCV() {
        return balanceT24RCV;
    }

    public void setBalanceT24RCV(Double balanceT24RCV) {
        this.balanceT24RCV = balanceT24RCV;
    }

    public BigDecimal getCollectionImssRcv() {
        return collectionImssRcv;
    }

    public void setCollectionImssRcv(BigDecimal collectionImssRcv) {
        this.collectionImssRcv = collectionImssRcv;
    }

    public long getBalanceT24Viv() {
        return balanceT24Viv;
    }

    public void setBalanceT24Viv(long balanceT24Viv) {
        this.balanceT24Viv = balanceT24Viv;
    }

    public BigDecimal getCollectionAcvViv() {
        return collectionAcvViv;
    }

    public void setCollectionAcvViv(BigDecimal collectionAcvViv) {
        this.collectionAcvViv = collectionAcvViv;
    }

}
