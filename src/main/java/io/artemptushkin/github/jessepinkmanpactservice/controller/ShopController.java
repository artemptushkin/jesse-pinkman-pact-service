package io.artemptushkin.github.jessepinkmanpactservice.controller;

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
		ResponseEntity<CrystalsResponse> heisenbergResponse = restTemplate
				.getForEntity("http://localhost:8091/heisenberg/crystals?amount={0}", CrystalsResponse.class, amount);
		CrystalsResponse crystalsResponse = heisenbergResponse.getBody();
		return crystalsResponse.setAmount(crystalsResponse.getAmount());
	}
}
