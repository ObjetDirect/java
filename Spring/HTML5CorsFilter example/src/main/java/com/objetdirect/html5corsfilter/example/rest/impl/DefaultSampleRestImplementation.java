package com.objetdirect.html5corsfilter.example.rest.impl;

import java.io.StringWriter;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.springframework.stereotype.Component;

import com.objetdirect.pacme.backend.model.Pacelement;
import com.objetdirect.pacme.backend.model.Pacparty;
import com.objetdirect.pacme.backend.repository.PacmapRepository;
import com.objetdirect.pacme.backend.repository.PacpartyRepository;
import com.objetdirect.pacme.backend.rest.PacmeRest;
import com.objetdirect.pacme.backend.rest.bean.ElementBean;
import com.objetdirect.pacme.backend.rest.bean.MapBean;
import com.objetdirect.pacme.backend.rest.bean.PartyBean;

/**
 * Rest service implementation
 * 
 * @author jroche
 * @since 1.0
 */
@Component
@Path("/service")
public class DefaultSampleRestImplementation implements SampleRest {
	@GET
	@Override
	public Response sample() {		
		ResponseBuilder builder = Response.status(200).entity("All roght folks, it works !");
		return builder.build();
	}
}
