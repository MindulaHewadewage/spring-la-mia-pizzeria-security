package org.java.pizzeria.controller;

import java.util.List;

import org.java.pizzeria.pojo.Ingredient;
import org.java.pizzeria.serv.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping
	public String getIngredientIndex(Model model) {
		
		List<Ingredient>ingredients=ingredientService.findAll();
		model.addAttribute("ingredients",ingredients);
		
		return"ingredient-index";
	}
}
