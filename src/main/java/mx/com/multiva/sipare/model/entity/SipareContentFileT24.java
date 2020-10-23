package mx.com.multiva.sipare.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_sipare_content_file_t24")
public class SipareContentFileT24 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_content")
	private int idContent;
    private String typeRegister;
    private String recipientEntityType;
	private String recipientEntityKey;
	private String shippingType;
	private String captureLine;
	private String certificate;
	private String paymentDate;
	@Column(name = "dateIMSSACV")
	private String dateImssAcv;
	@Column(name = "dateRCV")
	private String dateRcv;
	@Column(name = "importIMSS")
	private BigDecimal importImss;
	@Column(name = "importRCV")
	private BigDecimal importRcv;
	private BigDecimal importVivienda;
	@Column(name = "importACV")
	private BigDecimal importAcv;
	private BigDecimal importTotal;
	private String originCaptureLine;
    private String paymentMethod;
	private String placeOffice;
	@Column(name = "id_file")
	private int fileId;
	@Column(name = "patronal_registry")
	private String patronalRegistry;
	@Column(name = "bussines_name")
	private String bussinesName;
	@Column(name = "user_name")
    private String userName;
    private String telephone;
    private String email;
	@Column(name = "user_or_client")
    private String userOrClient;
	@Column(name = "name_contact")
    private String contactName;
	@Column(name = "account_number")
    private String accountNumber;
	@Column(name = "format_payment")
    private String paymentFormat;
    private String dateRegistry;
	@Column(name = "date_valid_procesar")
    private String validProcesarDate;
	@Column(name = "id_code")
    private int codeId;
	@Column(name = "file_resp_procesar")
    private int fileRespProcesar;

	public int getIdContent() {
		return idContent;
	}

	public void setIdContent(int idContent) {
		this.idContent = idContent;
	}

	public String getTypeRegister() {
		return typeRegister;
	}

	public void setTypeRegister(String typeRegister) {
		this.typeRegister = typeRegister;
	}

	public String getRecipientEntityType() {
		return recipientEntityType;
	}

	public void setRecipientEntityType(String recipientEntityType) {
		this.recipientEntityType = recipientEntityType;
	}

	public String getRecipientEntityKey() {
		return recipientEntityKey;
	}

	public void setRecipientEntityKey(String recipientEntityKey) {
		this.recipientEntityKey = recipientEntityKey;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public String getCaptureLine() {
		return captureLine;
	}

	public void setCaptureLine(String captureLine) {
		this.captureLine = captureLine;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getDateImssAcv() {
		return dateImssAcv;
	}

	public void setDateImssAcv(String dateImssAcv) {
		this.dateImssAcv = dateImssAcv;
	}

	public String getDateRcv() {
		return dateRcv;
	}

	public void setDateRcv(String dateRcv) {
		this.dateRcv = dateRcv;
	}

	public BigDecimal getImportImss() {
		return importImss;
	}

	public void setImportImss(BigDecimal importImss) {
		this.importImss = importImss;
	}

	public BigDecimal getImportRcv() {
		return importRcv;
	}

	public void setImportRcv(BigDecimal importRcv) {
		this.importRcv = importRcv;
	}

	public BigDecimal getImportVivienda() {
		return importVivienda;
	}

	public void setImportVivienda(BigDecimal importVivienda) {
		this.importVivienda = importVivienda;
	}

	public BigDecimal getImportAcv() {
		return importAcv;
	}

	public void setImportAcv(BigDecimal importAcv) {
		this.importAcv = importAcv;
	}

	public BigDecimal getImportTotal() {
		return importTotal;
	}

	public void setImportTotal(BigDecimal importTotal) {
		this.importTotal = importTotal;
	}

	public String getOriginCaptureLine() {
		return originCaptureLine;
	}

	public void setOriginCaptureLine(String originCaptureLine) {
		this.originCaptureLine = originCaptureLine;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPlaceOffice() {
		return placeOffice;
	}

	public void setPlaceOffice(String placeOffice) {
		this.placeOffice = placeOffice;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getPatronalRegistry() {
		return patronalRegistry;
	}

	public void setPatronalRegistry(String patronalRegistry) {
		this.patronalRegistry = patronalRegistry;
	}

	public String getBussinesName() {
		return bussinesName;
	}

	public void setBussinesName(String bussinesName) {
		this.bussinesName = bussinesName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserOrClient() {
		return userOrClient;
	}

	public void setUserOrClient(String userOrClient) {
		this.userOrClient = userOrClient;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPaymentFormat() {
		return paymentFormat;
	}

	public void setPaymentFormat(String paymentFormat) {
		this.paymentFormat = paymentFormat;
	}

	public String getDateRegistry() {
		return dateRegistry;
	}

	public void setDateRegistry(String dateRegistry) {
		this.dateRegistry = dateRegistry;
	}

	public String getValidProcesarDate() {
		return validProcesarDate;
	}

	public void setValidProcesarDate(String validProcesarDate) {
		this.validProcesarDate = validProcesarDate;
	}

	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public int getFileRespProcesar() {
		return fileRespProcesar;
	}

	public void setFileRespProcesar(int fileRespProcesar) {
		this.fileRespProcesar = fileRespProcesar;
	}

}
