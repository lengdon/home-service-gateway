package com.moran.home.service.gateway.delegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.moran.home.service.constants.HsConstants;
import com.moran.home.service.entity.provider.ServiceProvider;
import com.moran.home.service.exceptions.GatewayException;

@Service
public class ProviderServiceDelegate {
	private static final Logger logger = LoggerFactory.getLogger(ProviderServiceDelegate.class);

	private final JmsTemplate jmsTemplate;

	@Autowired
	public ProviderServiceDelegate(JmsTemplate jmsTemplate2) {
		this.jmsTemplate = jmsTemplate2;
	}

	public void sendRegistrationToQueue(ServiceProvider providerUser) {
		try {
			logger.debug("Sending Registration request to Queue");
			jmsTemplate.convertAndSend(HsConstants.PROVIDER_REQUEST_ACCEPT_QUEUE, providerUser);
		} catch (Exception e) {
			throw new GatewayException(e);
		}
	}
}
