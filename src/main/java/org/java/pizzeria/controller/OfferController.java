package org.java.pizzeria.controller;

import java.util.List;

import org.java.pizzeria.pojo.Offer;
import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.serv.OfferService;
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


@Controller
public class OfferController {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private OfferService offerService;
	
	@GetMapping("/pizzas/{id}/offers/create")
	public String createNewOfferta(
			Model model,
			@PathVariable int id
		) {
		
		Pizza pizza = pizzaService.findById(id).get();
		Offer offer = new Offer();
		offer.setPizza(pizza);
		
		model.addAttribute("offer", offer);
		
		return "offer-create";
	}
	@PostMapping("/offers/create")
	public String storeNewOfferta(
			Model model,
			@Validated @ModelAttribute Offer offer,
			BindingResult bindingResult
		) {
		
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors())
				System.err.println(err.getDefaultMessage());
			
			model.addAttribute("offer", offer);
			model.addAttribute("errors", bindingResult);
			
			return "offer-create";
		}
		
		offerService.save(offer);
	
		return "redirect:/pizzas/" + offer.getPizza().getId();
	}
	
	@GetMapping("/offer/update/{id}")
	public String updateOfferta(
			Model model,
			@PathVariable int id
		) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		Offer offer = offerService.findById(id).get();
		model.addAttribute("offer", offer);
		model.addAttribute("pizzas", pizzas);
		
		return "offer-update";
	}
	@PostMapping("/offer/update/{id}")
	public String storeOfferta(
			Model model,
			@Validated @ModelAttribute Offer offer,
			BindingResult bindingResult
		) {
		
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors())
				System.err.println(err.getDefaultMessage());
			
			List<Pizza> pizzas = pizzaService.findAll();
			
			model.addAttribute("pizzas", pizzas);
			model.addAttribute("offer", offer);
			model.addAttribute("errors", bindingResult);
			
			return "offer-update";
		}
		
		offerService.save(offer);
		
		return "redirect:/pizzas/" + offer.getPizza().getId();
	}
}




