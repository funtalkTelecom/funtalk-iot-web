/**
 * PaymentBank_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.funtalk.outerface.neusoft.paymentBank;

public class PaymentBank_ServiceLocator extends org.apache.axis.client.Service implements PaymentBank_Service {

    public PaymentBank_ServiceLocator() {
    }


    public PaymentBank_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PaymentBank_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PaymentBankSOAP
    //正式地址
//    private java.lang.String PaymentBankSOAP_address = "http://124.202.134.14:8280/services/MSC_PaymentBankSOAP";
//    private java.lang.String PaymentBankSOAP_address = "http://172.31.100.14:8280/services/MSC_PaymentBankSOAP";
//    private java.lang.String PaymentBankSOAP_address = "http://172.31.100.25:8080/billingWS/services/PaymentBankSOAP";

    private String PaymentBankSOAP_address = "http://172.31.2.113:8080/billingWS/services/PaymentBankSOAP";

    //测试地址
    // private String PaymentBankSOAP_address = "http://172.31.2.197:8080/billingWS/services/PaymentBankSOAP";


    public String getPaymentBankSOAPAddress() {
        return PaymentBankSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private String PaymentBankSOAPWSDDServiceName = "PaymentBankSOAP";

    public String getPaymentBankSOAPWSDDServiceName() {
        return PaymentBankSOAPWSDDServiceName;
    }

    public void setPaymentBankSOAPWSDDServiceName(String name) {
        PaymentBankSOAPWSDDServiceName = name;
    }

    public PaymentBank_PortType getPaymentBankSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PaymentBankSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPaymentBankSOAP(endpoint);
    }

    public PaymentBank_PortType getPaymentBankSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            PaymentBankSOAPSoapBindingStub _stub = new PaymentBankSOAPSoapBindingStub(portAddress, this);
            _stub.setPortName(getPaymentBankSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPaymentBankSOAPEndpointAddress(String address) {
        PaymentBankSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (PaymentBank_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                PaymentBankSOAPSoapBindingStub _stub = new PaymentBankSOAPSoapBindingStub(new java.net.URL(PaymentBankSOAP_address), this);
                _stub.setPortName(getPaymentBankSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("PaymentBankSOAP".equals(inputPortName)) {
            return getPaymentBankSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/PaymentBank/", "PaymentBank");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/PaymentBank/", "PaymentBankSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("PaymentBankSOAP".equals(portName)) {
            setPaymentBankSOAPEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
