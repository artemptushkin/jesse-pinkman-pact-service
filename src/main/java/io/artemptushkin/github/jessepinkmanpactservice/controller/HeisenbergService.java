package io.artemptushkin.github.jessepinkmanpactservice.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HeisenbergService {
	private final RestTemplate restTemplate;

	public HeisenbergResponse cookCrystals(Integer amount) {
		return null;
	}
}
