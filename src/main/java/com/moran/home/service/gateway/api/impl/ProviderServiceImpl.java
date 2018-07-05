package com.moran.home.service.gateway.api.impl;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.moran.home.service.entity.provider.ServiceProvider;
import com.moran.home.service.gateway.api.ProviderService;

@Component
public class ProviderServiceImpl implements ProviderService {

	@Override
	public Response getServiceProvider(String providerEmailOrMobile) {
		return null;
	}

	@Override
	public Response registerServiceProvider(ServiceProvider providerUser) {
		
		return null;
		
	}

}
