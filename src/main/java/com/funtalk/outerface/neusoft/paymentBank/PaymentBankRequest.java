/**
 * PaymentBankRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.funtalk.outerface.neusoft.paymentBank;

public class PaymentBankRequest  implements java.io.Serializable {
    private String requestId;

    private String systemId;

    private String serviceId;

    private int serviceKind;

    private long payFee;

    private String bankFlowNumber;

    private String notifyDate;

    private String bankId;

    private boolean ifContinue;

    public PaymentBankRequest() {
    }

    public PaymentBankRequest(
           String requestId,
           String systemId,
           String serviceId,
           int serviceKind,
           long payFee,
           String bankFlowNumber,
           String notifyDate,
           String bankId,
           boolean ifContinue) {
           this.requestId = requestId;
           this.systemId = systemId;
           this.serviceId = serviceId;
           this.serviceKind = serviceKind;
           this.payFee = payFee;
           this.bankFlowNumber = bankFlowNumber;
           this.notifyDate = notifyDate;
           this.bankId = bankId;
           this.ifContinue = ifContinue;
    }


    /**
     * Gets the requestId value for this PaymentBankRequest.
     *
     * @return requestId
     */
    public String getRequestId() {
        return requestId;
    }


    /**
     * Sets the requestId value for this PaymentBankRequest.
     *
     * @param requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    /**
     * Gets the systemId value for this PaymentBankRequest.
     *
     * @return systemId
     */
    public String getSystemId() {
        return systemId;
    }


    /**
     * Sets the systemId value for this PaymentBankRequest.
     *
     * @param systemId
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }


    /**
     * Gets the serviceId value for this PaymentBankRequest.
     *
     * @return serviceId
     */
    public String getServiceId() {
        return serviceId;
    }


    /**
     * Sets the serviceId value for this PaymentBankRequest.
     *
     * @param serviceId
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }


    /**
     * Gets the serviceKind value for this PaymentBankRequest.
     *
     * @return serviceKind
     */
    public int getServiceKind() {
        return serviceKind;
    }


    /**
     * Sets the serviceKind value for this PaymentBankRequest.
     *
     * @param serviceKind
     */
    public void setServiceKind(int serviceKind) {
        this.serviceKind = serviceKind;
    }


    /**
     * Gets the payFee value for this PaymentBankRequest.
     *
     * @return payFee
     */
    public long getPayFee() {
        return payFee;
    }


    /**
     * Sets the payFee value for this PaymentBankRequest.
     *
     * @param payFee
     */
    public void setPayFee(long payFee) {
        this.payFee = payFee;
    }


    /**
     * Gets the bankFlowNumber value for this PaymentBankRequest.
     *
     * @return bankFlowNumber
     */
    public String getBankFlowNumber() {
        return bankFlowNumber;
    }


    /**
     * Sets the bankFlowNumber value for this PaymentBankRequest.
     *
     * @param bankFlowNumber
     */
    public void setBankFlowNumber(String bankFlowNumber) {
        this.bankFlowNumber = bankFlowNumber;
    }


    /**
     * Gets the notifyDate value for this PaymentBankRequest.
     *
     * @return notifyDate
     */
    public String getNotifyDate() {
        return notifyDate;
    }


    /**
     * Sets the notifyDate value for this PaymentBankRequest.
     *
     * @param notifyDate
     */
    public void setNotifyDate(String notifyDate) {
        this.notifyDate = notifyDate;
    }


    /**
     * Gets the bankId value for this PaymentBankRequest.
     *
     * @return bankId
     */
    public String getBankId() {
        return bankId;
    }


    /**
     * Sets the bankId value for this PaymentBankRequest.
     *
     * @param bankId
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }


    /**
     * Gets the ifContinue value for this PaymentBankRequest.
     *
     * @return ifContinue
     */
    public boolean isIfContinue() {
        return ifContinue;
    }


    /**
     * Sets the ifContinue value for this PaymentBankRequest.
     *
     * @param ifContinue
     */
    public void setIfContinue(boolean ifContinue) {
        this.ifContinue = ifContinue;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PaymentBankRequest)) return false;
        PaymentBankRequest other = (PaymentBankRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.requestId==null && other.getRequestId()==null) ||
             (this.requestId!=null &&
              this.requestId.equals(other.getRequestId()))) &&
            ((this.systemId==null && other.getSystemId()==null) ||
             (this.systemId!=null &&
              this.systemId.equals(other.getSystemId()))) &&
            ((this.serviceId==null && other.getServiceId()==null) ||
             (this.serviceId!=null &&
              this.serviceId.equals(other.getServiceId()))) &&
            this.serviceKind == other.getServiceKind() &&
            this.payFee == other.getPayFee() &&
            ((this.bankFlowNumber==null && other.getBankFlowNumber()==null) ||
             (this.bankFlowNumber!=null &&
              this.bankFlowNumber.equals(other.getBankFlowNumber()))) &&
            ((this.notifyDate==null && other.getNotifyDate()==null) ||
             (this.notifyDate!=null &&
              this.notifyDate.equals(other.getNotifyDate()))) &&
            ((this.bankId==null && other.getBankId()==null) ||
             (this.bankId!=null &&
              this.bankId.equals(other.getBankId()))) &&
            this.ifContinue == other.isIfContinue();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRequestId() != null) {
            _hashCode += getRequestId().hashCode();
        }
        if (getSystemId() != null) {
            _hashCode += getSystemId().hashCode();
        }
        if (getServiceId() != null) {
            _hashCode += getServiceId().hashCode();
        }
        _hashCode += getServiceKind();
        _hashCode += new Long(getPayFee()).hashCode();
        if (getBankFlowNumber() != null) {
            _hashCode += getBankFlowNumber().hashCode();
        }
        if (getNotifyDate() != null) {
            _hashCode += getNotifyDate().hashCode();
        }
        if (getBankId() != null) {
            _hashCode += getBankId().hashCode();
        }
        _hashCode += (isIfContinue() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentBankRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/PaymentBank/", ">PaymentBankRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RequestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SystemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ServiceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ServiceKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PayFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankFlowNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BankFlowNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notifyDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NotifyDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BankId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ifContinue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IfContinue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
