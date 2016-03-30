package au.com.ko.samples.jersey;

import au.com.ko.samples.prov.Signer;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/")
public class SignerService {

	@Inject
	private Signer signer;

	@POST
	@Path("sign")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response log(String dataToSign) {

		return Response.ok().entity(signer.sign(dataToSign)).build();
	}

}

