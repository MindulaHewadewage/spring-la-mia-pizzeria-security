package org.java.pizzeria.serv;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class PizzaService {
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public List<Pizza>findAll(){
		return pizzaRepo.findAll();
	}
	
	public Pizza save(Pizza pizza) {
		return pizzaRepo.save(pizza);
	}
	
	public List<Pizza> findByName(String name){
		return pizzaRepo.findByName(name);
	}
	
    public Optional<Pizza> findById(int id) {
        return pizzaRepo.findById(id);
    }
    
    @Transactional
    public Optional<Pizza>findByIdWithOffers(int id){
    	Optional<Pizza> optPizza=pizzaRepo.findById(id);
    	Hibernate.initialize(optPizza.get().getOffers());
    	return optPizza;
    }
    
    public void delete(Pizza pizza) {
    	pizzaRepo.delete(pizza);
    }
}


