package com.moran.home.service.gateway;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.moran.home.service.gateway.api.impl.ProviderServiceImpl;

@SpringBootApplication
public class HomeServiceGatewayApplication {

	@Autowired
	private Bus bus;

	@Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(new ProviderServiceImpl()));
        return endpoint.create();
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(HomeServiceGatewayApplication.class, args);
	}
}
