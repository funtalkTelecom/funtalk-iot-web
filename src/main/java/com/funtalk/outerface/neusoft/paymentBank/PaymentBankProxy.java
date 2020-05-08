package com.funtalk.outerface.neusoft.paymentBank;

public class PaymentBankProxy implements PaymentBank_PortType {
  private String _endpoint = null;
  private PaymentBank_PortType paymentBank_PortType = null;
  
  public PaymentBankProxy() {
    _initPaymentBankProxy();
  }
  
  public PaymentBankProxy(String endpoint) {
    _endpoint = endpoint;
    _initPaymentBankProxy();
  }
  
  private void _initPaymentBankProxy() {
    try {
      paymentBank_PortType = (new com.funtalk.outerface.neusoft.paymentBank.PaymentBank_ServiceLocator()).getPaymentBankSOAP();
      if (paymentBank_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)paymentBank_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)paymentBank_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (paymentBank_PortType != null)
      ((javax.xml.rpc.Stub)paymentBank_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public PaymentBank_PortType getPaymentBank_PortType() {
    if (paymentBank_PortType == null)
      _initPaymentBankProxy();
    return paymentBank_PortType;
  }
  
  public PaymentBankResponse execute(PaymentBankRequest paymentBankRequest) throws java.rmi.RemoteException{
    if (paymentBank_PortType == null)
      _initPaymentBankProxy();
    return paymentBank_PortType.execute(paymentBankRequest);
  }
  
  
}