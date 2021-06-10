package Activities;


@Provider("UserProvider")
@PactFolder("target/pacts")
public class PactProviderTest {
  
	@BeforeEach
	void before(PactVerificationContext context) {
	    // Set target for provider to send request to
	    context.setTarget(new HttpTestTarget("localhost", 8282));
	}
	
	 @TestTemplate
     @ExtendWith(PactVerificationInvocationContextProvider.class)
     void pactTestTemplate(PactVerificationContext context) {
   	   // Verify the interaction between Consumer and Provider
   	   // using the contract generated in target/pacts
   	   context.verifyInteraction();
     }

	// State to send the call to consumer
	@State("A request to create a user")
	public void sampleState() {}

}
