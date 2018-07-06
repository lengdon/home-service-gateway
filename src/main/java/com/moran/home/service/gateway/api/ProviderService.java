package com.moran.home.service.gateway.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.moran.home.service.gateway.models.ServiceProvider;

@Service
@Path("/provider")
public interface ProviderService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{providerEmailOrMobile}")
	public Response getServiceProvider(@PathParam("providerEmailOrMobile") String providerEmailOrMobile);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerServiceProvider(ServiceProvider providerUser);
}
