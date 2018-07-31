package br.com.passwordstrenghtchecker.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import br.com.passwordstrenghtchecker.entity.Password;
import br.com.passwordstrenghtchecker.service.PasswordService;

@Path("/passwordchecker")
public class PasswordResource {

	@GET
	@Produces("application/json")
	@Path("{password}")
	public Response findById(@PathParam("password") String password) {
		
		JSONObject jsonObject = new JSONObject();
		
		Password passwordChecked = new PasswordService().check(password);
		
		jsonObject.put("password", passwordChecked.getPasswordDescription());
		jsonObject.put("passwordStrength", passwordChecked.getPasswordStrength());
		jsonObject.put("complexityDescription", passwordChecked.getComplexityDescription());
		
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
}
