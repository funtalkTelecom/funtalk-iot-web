/**
 * PaymentBank_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.funtalk.outerface.neusoft.paymentBank;

public interface PaymentBank_Service extends javax.xml.rpc.Service {
    public String getPaymentBankSOAPAddress();

    public PaymentBank_PortType getPaymentBankSOAP() throws javax.xml.rpc.ServiceException;

    public PaymentBank_PortType getPaymentBankSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
