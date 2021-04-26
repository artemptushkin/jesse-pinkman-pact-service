package io.artemptushkin.github.jessepinkmanpactservice;

import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import io.artemptushkin.github.jessepinkmanpactservice.controller.HeisenbergService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@PactTestFor(port = "8091", providerName = "heisenberg")
@ExtendWith(value = {SpringExtension.class, PactConsumerTestExt.class})
class HeisenbergServiceContractTest {

	HeisenbergService heisenbergService;

	@BeforeEach
	void setup() {
		heisenbergService = new HeisenbergService(new RestTemplate());
	}

}
