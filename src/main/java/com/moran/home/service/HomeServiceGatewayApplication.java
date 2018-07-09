package com.moran.home.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.moran.home.service.gateway.api.ProviderService;

@SpringBootApplication
public class HomeServiceGatewayApplication {

	@Autowired
	private Bus bus;

	@Autowired
	private ProviderService providerService;

	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);

		List<Object> providers = new ArrayList<>();
		providers.add(new JacksonJaxbJsonProvider());
		endpoint.setProviders(providers);

		endpoint.setAddress("/");
		endpoint.setServiceBeans(Arrays.<Object>asList(providerService));

		return endpoint.create();
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeServiceGatewayApplication.class, args);
	}
}
