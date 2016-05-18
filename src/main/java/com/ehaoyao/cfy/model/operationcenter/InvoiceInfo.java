package com.ehaoyao.cfy.model.operationcenter;

public class InvoiceInfo {
	
	/**
	 * 普通发票
	 */
	public static final String INVOICE_INFO_INVOICE_TYPE_PLAIN = "PLAIN";
	
	/**
	 * 电子发票
	 */
	public static final String INVOICE_INFO_INVOICE_TYPE_ELECTRONIC = "ELECTRONIC";
	
	/**
	 * 增值税发票
	 */
	public static final String INVOICE_INFO_INVOICE_TYPE_VAT = "VAT";
	
    private Long invoiceId;

    private String orderNumber;

    private String orderFlag;

    private String kfAccount;

    private String invoiceStatus;

    /**
     * 发票类型  PLAIN：普通发票 ELECTRONIC：电子发票 VAT：增值税发票
     */
    private String invoiceType;

    private String invoiceTitle;

    private String invoiceContent;

    private String remark;

    private String createTime;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag == null ? null : orderFlag.trim();
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount == null ? null : kfAccount.trim();
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus == null ? null : invoiceStatus.trim();
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getInvoiceContent() {
        return invoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent == null ? null : invoiceContent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    
    /**
     * 获取发票类型描述
     * 发票类型  PLAIN：普通发票 ELECTRONIC：电子发票 VAT：增值税发票
     * @param invoiceType
     * @return
     */
    public static String getInvoiceTypeDesc(String invoiceType){
    	String invoiceTypeDesc = null;
    	if(invoiceType!=null && invoiceType.length()>0){
    		if(INVOICE_INFO_INVOICE_TYPE_PLAIN.equals(invoiceType)){
    			invoiceTypeDesc = "普通发票";
    		}
    		if(INVOICE_INFO_INVOICE_TYPE_ELECTRONIC.equals(invoiceType)){
    			invoiceTypeDesc = "电子发票";
    		}
    		if(INVOICE_INFO_INVOICE_TYPE_VAT.equals(invoiceType)){
    			invoiceTypeDesc = "增值税发票";
    		}
    	}
    	return invoiceTypeDesc;
    }
}