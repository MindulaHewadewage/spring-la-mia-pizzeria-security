package org.java.pizzeria;

import java.time.LocalDate;
import java.util.List;

import org.java.pizzeria.pojo.Ingredient;
import org.java.pizzeria.pojo.Offer;
import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.serv.IngredientService;
import org.java.pizzeria.serv.OfferService;
import org.java.pizzeria.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaService; 
	
	@Autowired
	private OfferService offerService; 
	
	@Autowired
	private IngredientService ingredientService; 

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ingredient i1 = new Ingredient ("Tomato");
		Ingredient i2 = new Ingredient ("Tuna");
		Ingredient i3 = new Ingredient ("Pepperoni");
		Ingredient i4 = new Ingredient ("Cheese");
		Ingredient i5 = new Ingredient ("Pesto");
		Ingredient i6 = new Ingredient ("Crudo");
		
		ingredientService.save(i1);
		ingredientService.save(i2);
		ingredientService.save(i3);
		ingredientService.save(i4);
		ingredientService.save(i5);
		ingredientService.save(i6);
		
		
		
		
		Pizza p1 = new Pizza("Tonno e cipolla","Molto buona","https://media-assets.lacucinaitaliana.it/photos/61fbd8df3697f3ffd0cffbc5/3:2/w_1200,h_800,c_limit/pizza-tonno-cipolle-800.jpg",10,i1);
		Pizza p2 = new Pizza("Margerita","Molto buona","https://www.finedininglovers.it/sites/g/files/xknfdk1106/files/styles/recipes_1200_800_fallback/public/fdl_content_import_it/margherita-50kalo.jpg?itok=v9nHxNMS",12,i3);
		Pizza p3 = new Pizza("Capricciosa","Molto buona","https://www.buttalapasta.it/wp-content/uploads/2017/11/pizza-capricciosa.jpg",9,i4);
		Pizza p4 = new Pizza("Napoli","Molto buona","https://images.prismic.io/nahrin/f0adafb8-72c8-4f99-9b4d-ce0483071853_knuspriges-pizza-napoli-rezept-einfach-schnell-zubereitet.jpg?auto=compress,format",10,i5);
		Pizza p5 = new Pizza("Maialona","Molto buona","https://media-cdn.tripadvisor.com/media/photo-s/16/57/6c/e3/pizza-maialona.jpg",11,i3);
		Pizza p6 = new Pizza("Vegetariana","Molto buona","https://cdn.loveandlemons.com/wp-content/uploads/2023/02/vegetarian-pizza.jpg",8,i2);

		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		pizzaService.save(p6);
		
		Offer of1=new Offer(LocalDate.parse("2023-06-10"),LocalDate.parse("2023-06-20"), "Special Promo 20%", 20, p1);
		Offer of2=new Offer(LocalDate.parse("2023-06-20"),LocalDate.parse("2023-06-30"), "Special Promo 30%", 30, p2);
		Offer of3=new Offer(LocalDate.parse("2023-06-05"),LocalDate.parse("2023-06-10"), "Special Promo 40%", 40, p3);
		Offer of4=new Offer(LocalDate.parse("2023-07-10"),LocalDate.parse("2023-07-20"), "Special Promo 50%", 50, p4);
		Offer of5=new Offer(LocalDate.parse("2023-08-10"),LocalDate.parse("2023-08-20"), "Special Promo 40%", 40, p5);
		Offer of6=new Offer(LocalDate.parse("2023-09-10"),LocalDate.parse("2023-09-20"), "Special Promo 30%", 30, p6);
		
		offerService.save(of1);
		offerService.save(of2);
		offerService.save(of3);
		offerService.save(of4);
		offerService.save(of5);
		offerService.save(of6);

		
	}

}
