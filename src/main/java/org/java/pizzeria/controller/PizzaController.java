package org.java.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getPizzaIndex(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		
		return "index";
	}
	
	@PostMapping("/pizzas/search")
	public String getPizzasByName(
			Model model,
			@RequestParam("search") String name
			) {
		
		List<Pizza> pizzas = pizzaService.findByName(name);
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("search", name);
		
		return "index";
	}
	
	@GetMapping("/pizzas/new")
	public String createNewPizza(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "create";
	}
	
	@PostMapping("/pizzas/new")
	public String storeNewPizza(
			Model model,
		    @Validated @ModelAttribute Pizza pizza,
		    BindingResult bindingResult
			) {
		
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors())
				System.err.println(err.getDefaultMessage());
			
			model.addAttribute("pizza", pizza);
			model.addAttribute("errors", bindingResult);
			
			return "create";
		}
		
		pizzaService.save(pizza);
		
		return "redirect:/pizzas/" + pizza.getId();
	}
	
	@GetMapping("/pizzas/{id}")
	public String getPizzaShow(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
	
	@GetMapping("/pizzas/update/{id}")
	public String getPizzaUpdate(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "update";
	}
	
	@PostMapping("/pizzas/update/{id}")
	public String storePizzaUpdated(
			Model model,
			@Validated @ModelAttribute Pizza pizza,
			BindingResult bindingResult
		) {
		
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors())
				System.err.println(err.getDefaultMessage());
			
			model.addAttribute("pizza", pizza);
			model.addAttribute("errors", bindingResult);
			
			return "update";
		}
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizzas/delete/{id}")
	public String deletePizza(
			@PathVariable int id
		) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		pizzaService.delete(pizza);
		
		return "redirect:/"; 
	}
}