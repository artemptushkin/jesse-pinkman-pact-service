package io.artemptushkin.github.jessepinkmanpactservice;

import java.math.BigDecimal;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.artemptushkin.github.jessepinkmanpactservice.controller.HeisenbergResponse;
import io.artemptushkin.github.jessepinkmanpactservice.controller.HeisenbergService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@PactTestFor(port = "8091", providerName = "heisenberg")
@ExtendWith(value = {SpringExtension.class, PactConsumerTestExt.class})
class HeisenbergServiceContractTest {

	HeisenbergService heisenbergService;

	@BeforeEach
	void setup() {
		heisenbergService = new HeisenbergService(new RestTemplate());
	}

	@Pact(consumer = "jesse-pinkman", provider = "heisenberg")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		return builder
				.given("get crystals")
				.uponReceiving("GET REQUEST")
				.method("GET")
				.path("/heisenberg/v1/crystals")
				.query("amount=2")
				.willRespondWith()
				.body(
						new PactDslJsonBody()
						.numberType("amount", 20.0)
						.array("crystals")
								.object()
									.numberValue("id", 1)
									.stringValue("color", "red")
								.closeObject()
								.object()
									.numberValue("id", 2)
									.stringValue("color", "blue")
								.closeObject()
						.closeArray())
				.status(200)
				.toPact();
	}

	@Test
	void itReturnsData() {
		HeisenbergResponse heisenbergResponse = heisenbergService.cookCrystals(2);

		assertEquals( new BigDecimal("20"), heisenbergResponse.getAmount());
	}

}
