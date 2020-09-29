package com.soap.ws.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handleMessage");
		boolean result = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (result == false) {
			System.out.println("comming request");
			SOAPMessage soapMessage = context.getMessage();
			try {
				SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				Iterator childElements = header.getChildElements();

				while (childElements.hasNext()) {
					Node node = (Node) childElements.next();
					String name = node.getLocalName();
					if (name != null && name.equals("sitename")) {
						System.out.println("sitename " + node.getValue());
					}
				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("going response");
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("handleFault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("close");

	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("getHeaders");
		return null;
	}

}
