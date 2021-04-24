package io.artemptushkin.github.jessepinkmanpactservice.controller;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/crystals")
@RequiredArgsConstructor
public class ShopController {

	private final HeisenbergService heisenbergService;

	@RequestMapping("/:buy")
	public CrystalsResponse buy(@RequestParam Integer amount) {
		HeisenbergResponse crystalsResponse = heisenbergService.cookCrystals(amount);
		return CrystalsResponse
				.builder()
				.amount(crystalsResponse.getAmount())
				.crystals(crystalsResponse.getCrystals())
				.cost(crystalsResponse.getAmount().multiply(BigDecimal.valueOf(5)))
				.build();
	}
}
