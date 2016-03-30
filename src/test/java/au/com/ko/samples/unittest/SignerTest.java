package au.com.ko.samples.unittest;

import au.com.ko.samples.unittest.support.TestServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(JUnit4.class)
public class SignerTest {

	private static TestServer testServer;
	private static WebTarget target;

	@BeforeClass
	public static void startServer() throws IOException {
		Properties config = new Properties();
		config.load(SignerTest.class.getResourceAsStream("/config.properties"));

		String contextPath = config.getProperty("test.server.contextPath");

		URI baseURI = UriBuilder.fromUri("http://localhost/" + contextPath)
				.port(Integer.parseInt(config.getProperty("test.server.port"))).build();

		testServer = new TestServer(baseURI);
		testServer.start();

		Client client = ClientBuilder.newClient();

		target = client.target(baseURI);
	}

	@AfterClass
	public static void stopServer() {
		if (testServer != null) {
			testServer.stop();
		}
	}

	@Test
	public void testSignData() throws IOException {

		Response response = target
				.path("sign")
				.request(APPLICATION_JSON)
				.post(Entity.entity("Data", MediaType.TEXT_PLAIN), Response.class);

		assertEquals("Status code returned should be 200 ",Response.Status.OK.getStatusCode(),response.getStatus());
		assertNotNull("Response: ", response);

		System.out.println(response.readEntity(String.class));
	}

}
