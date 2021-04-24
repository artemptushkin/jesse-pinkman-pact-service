package io.artemptushkin.github.jessepinkmanpactservice.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HeisenbergService {
	private final RestTemplate restTemplate;

	public HeisenbergResponse cookCrystals(Integer amount) {
		ResponseEntity<HeisenbergResponse> heisenbergResponseEntity = restTemplate
				.getForEntity("http://localhost:8091/heisenberg/v1/crystals?amount={0}", HeisenbergResponse.class, amount);
		return heisenbergResponseEntity.getBody();
	}
}
