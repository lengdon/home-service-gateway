package com.moran.home.service.gateway.api.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.moran.home.service.constants.HsConstants;
import com.moran.home.service.exceptions.GatewayException;
import com.moran.home.service.gateway.api.ProviderService;
import com.moran.home.service.gateway.models.ServiceProvider;
import com.moran.home.service.utils.WsUtils;

@Component
public class ProviderServiceImpl implements ProviderService {
	private static final Logger logger = LoggerFactory.getLogger(ProviderServiceImpl.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public Response getServiceProvider(String providerEmailOrMobile) {
		logger.info("APIs are working,,,,,,,,,,,,,,,,,,,,,,,,,,," + providerEmailOrMobile);
		return WsUtils.createSuccessRsResponse(Response.ok(), "Hi", WsUtils.HTTP_SUCCESS);
	}

	@Override
	public Response registerServiceProvider(ServiceProvider providerUser) {
		try {
			jmsTemplate.convertAndSend(HsConstants.PROVIDER_REQUEST_ACCEPT_QUEUE, providerUser);
			Map<String, String> selfLinks = new HashMap<>();
			selfLinks.put("rel", "provider");
			selfLinks.put("href", "/provider/" + providerUser.getEmail());
			selfLinks.put("action", "GET");
			selfLinks.put("types", "application/json");

			String message = WsUtils.createSuccessResponseMessage(
					"Provider Registration has been accepted. Please check your email.", selfLinks);
			return WsUtils.createSuccessRsResponse(Response.ok(), message, WsUtils.HTTP_CREATED);
		} catch (Exception e) {
			throw new GatewayException(e);
		}
	}
}
