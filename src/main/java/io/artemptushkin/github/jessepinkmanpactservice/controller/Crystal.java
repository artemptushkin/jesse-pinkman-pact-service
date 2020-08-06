package io.artemptushkin.github.jessepinkmanpactservice.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crystal {
	private Long id;
	private String color;
}
