package com.moran.home.service.gateway.api.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moran.home.service.entity.provider.ServiceProvider;
import com.moran.home.service.exceptions.GatewayException;
import com.moran.home.service.gateway.api.ProviderService;
import com.moran.home.service.gateway.delegate.ProviderServiceDelegate;
import com.moran.home.service.utils.WsUtils;

@Component
public class ProviderServiceImpl implements ProviderService {
	private static final Logger logger = LoggerFactory.getLogger(ProviderServiceImpl.class);

	@Autowired
	private ProviderServiceDelegate providerServiceDelegate;

	@Override
	public Response getServiceProvider(String providerEmailOrMobile) {
		logger.debug("Fetching Provider detail");
		return WsUtils.createSuccessRsResponse(Response.ok(), "Hi", WsUtils.HTTP_SUCCESS);
	}

	@Override
	public Response registerServiceProvider(ServiceProvider providerUser) {
		try {
			providerServiceDelegate.sendRegistrationToQueue(providerUser);
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
