package io.artemptushkin.github.jessepinkmanpactservice.controller;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/crystals")
@RequiredArgsConstructor
public class ShopController {

	private final RestTemplate restTemplate;

	@RequestMapping("/:buy")
	public CrystalsResponse buy(@RequestParam Integer amount) {
		ResponseEntity<HeisenbergResponse> heisenbergResponseEntity = restTemplate
				.getForEntity("http://localhost:8091/heisenberg/crystals/v4?amount={0}", HeisenbergResponse.class, amount);
		HeisenbergResponse crystalsResponse = heisenbergResponseEntity.getBody();
		return CrystalsResponse
				.builder()
				.amount(crystalsResponse.getAmount())
				.crystals(crystalsResponse.getCrystals())
				.cost(crystalsResponse.getAmount().multiply(BigDecimal.valueOf(5)))
				.build();
	}
}
