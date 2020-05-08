/**
 * PaymentBankResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.funtalk.outerface.neusoft.paymentBank;

public class PaymentBankResponse  implements java.io.Serializable {
    private String responseId;

    private String resultCode;

    private String resultInfo;

    private String payDate;

    private String flowNumber;

    private String writeoffDate;

    public PaymentBankResponse() {
    }

    public PaymentBankResponse(
           String responseId,
           String resultCode,
           String resultInfo,
           String payDate,
           String flowNumber,
           String writeoffDate) {
           this.responseId = responseId;
           this.resultCode = resultCode;
           this.resultInfo = resultInfo;
           this.payDate = payDate;
           this.flowNumber = flowNumber;
           this.writeoffDate = writeoffDate;
    }


    /**
     * Gets the responseId value for this PaymentBankResponse.
     *
     * @return responseId
     */
    public String getResponseId() {
        return responseId;
    }


    /**
     * Sets the responseId value for this PaymentBankResponse.
     *
     * @param responseId
     */
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }


    /**
     * Gets the resultCode value for this PaymentBankResponse.
     *
     * @return resultCode
     */
    public String getResultCode() {
        return resultCode;
    }


    /**
     * Sets the resultCode value for this PaymentBankResponse.
     *
     * @param resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }


    /**
     * Gets the resultInfo value for this PaymentBankResponse.
     *
     * @return resultInfo
     */
    public String getResultInfo() {
        return resultInfo;
    }


    /**
     * Sets the resultInfo value for this PaymentBankResponse.
     *
     * @param resultInfo
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }


    /**
     * Gets the payDate value for this PaymentBankResponse.
     *
     * @return payDate
     */
    public String getPayDate() {
        return payDate;
    }


    /**
     * Sets the payDate value for this PaymentBankResponse.
     *
     * @param payDate
     */
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }


    /**
     * Gets the flowNumber value for this PaymentBankResponse.
     *
     * @return flowNumber
     */
    public String getFlowNumber() {
        return flowNumber;
    }


    /**
     * Sets the flowNumber value for this PaymentBankResponse.
     *
     * @param flowNumber
     */
    public void setFlowNumber(String flowNumber) {
        this.flowNumber = flowNumber;
    }


    /**
     * Gets the writeoffDate value for this PaymentBankResponse.
     *
     * @return writeoffDate
     */
    public String getWriteoffDate() {
        return writeoffDate;
    }


    /**
     * Sets the writeoffDate value for this PaymentBankResponse.
     *
     * @param writeoffDate
     */
    public void setWriteoffDate(String writeoffDate) {
        this.writeoffDate = writeoffDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PaymentBankResponse)) return false;
        PaymentBankResponse other = (PaymentBankResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.responseId==null && other.getResponseId()==null) ||
             (this.responseId!=null &&
              this.responseId.equals(other.getResponseId()))) &&
            ((this.resultCode==null && other.getResultCode()==null) ||
             (this.resultCode!=null &&
              this.resultCode.equals(other.getResultCode()))) &&
            ((this.resultInfo==null && other.getResultInfo()==null) ||
             (this.resultInfo!=null &&
              this.resultInfo.equals(other.getResultInfo()))) &&
            ((this.payDate==null && other.getPayDate()==null) ||
             (this.payDate!=null &&
              this.payDate.equals(other.getPayDate()))) &&
            ((this.flowNumber==null && other.getFlowNumber()==null) ||
             (this.flowNumber!=null &&
              this.flowNumber.equals(other.getFlowNumber()))) &&
            ((this.writeoffDate==null && other.getWriteoffDate()==null) ||
             (this.writeoffDate!=null &&
              this.writeoffDate.equals(other.getWriteoffDate())));
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
        if (getResponseId() != null) {
            _hashCode += getResponseId().hashCode();
        }
        if (getResultCode() != null) {
            _hashCode += getResultCode().hashCode();
        }
        if (getResultInfo() != null) {
            _hashCode += getResultInfo().hashCode();
        }
        if (getPayDate() != null) {
            _hashCode += getPayDate().hashCode();
        }
        if (getFlowNumber() != null) {
            _hashCode += getFlowNumber().hashCode();
        }
        if (getWriteoffDate() != null) {
            _hashCode += getWriteoffDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentBankResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/PaymentBank/", ">PaymentBankResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ResponseId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ResultCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ResultInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PayDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flowNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FlowNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("writeoffDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WriteoffDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
