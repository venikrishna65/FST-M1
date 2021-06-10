package Activities;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.expression.ParseException;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

@ExtendWith(PactConsumerTestExt.class)

public class PactConsumerTest {

	// Create Map for the headers
	Map<String, String> headers = new HashMap<String, String>();
	// Set resource URI
	String createUser = "/api/users";


	// Create Pact contract
	@Pact(provider = "UserProvider", consumer = "UserConsumer")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException { 

		// Add headers
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");


		// Create request JSON
		DslPart bodySentCreateUser = new PactDslJsonBody()
		    .numberType("id", 1)
		    .stringType("firstName", "string")
		    .stringType("lastName", "string")
		    .stringType("email", "string");

		DslPart bodyReceivedCreateUser = new PactDslJsonBody()
			    .numberType("id", 1)
			    .stringType("firstName", "string")
			    .stringType("lastName", "string")
			    .stringType("email", "string");
	
	return builder.given("A request to create a user")
		    .uponReceiving("A request to create a user")
		        .path(createUser)
		        .method("POST")
		        .headers(headers)
		        .body(bodySentCreateUser)
		    .willRespondWith()
		        .status(201)
		        .body(bodyReceivedCreateUser)
		    .toPact();
}


@Test
@PactTestFor(providerName = "UserProvider", port = "8080")
public void runTest() {

	// Mock url
	RestAssured.baseURI = "http://localhost:8080";
	// Create request specification
	RequestSpecification rq = RestAssured.given().headers(headers).when();

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("id", 1);
	map.put("firstName", "Justin");
	map.put("lastName", "Case");
	map.put("email", "justincase@mail.com");



	// Send POST request
	Response response = rq.body(map).post(createUser);
	// Assertion
	assert (response.getStatusCode() == 201);
	}
}


