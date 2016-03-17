package hello.rest;

import java.sql.SQLException;
import java.util.HashMap;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import hello.rest.DaoClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Named
@Path("/")
	public class CSVDetails {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomers() throws ClassNotFoundException, SQLException, JsonProcessingException {
		DaoClass.connectionSetup();
        HashMap<String, String> rs = DaoClass.retrieveRecord();
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonResp = mapperObj.writeValueAsString(rs); 
        
        
		return Response.status(200).entity(jsonResp).build();
	}
	
}
