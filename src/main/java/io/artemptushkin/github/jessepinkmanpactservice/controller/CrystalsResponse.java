package io.artemptushkin.github.jessepinkmanpactservice.controller;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CrystalsResponse {
	private BigDecimal amount;
	private BigDecimal cost;
	private List<Crystal> crystals;
}
