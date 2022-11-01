package com.mbavellar.coursesb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mbavellar.coursesb.domain.Address;
import com.mbavellar.coursesb.domain.Category;
import com.mbavellar.coursesb.domain.City;
import com.mbavellar.coursesb.domain.Client;
import com.mbavellar.coursesb.domain.Product;
import com.mbavellar.coursesb.domain.State;
import com.mbavellar.coursesb.domain.enums.ClientType;
import com.mbavellar.coursesb.repositories.AddressRepository;
import com.mbavellar.coursesb.repositories.CategoryRepository;
import com.mbavellar.coursesb.repositories.CityRepository;
import com.mbavellar.coursesb.repositories.ClientRepository;
import com.mbavellar.coursesb.repositories.ProductRepository;
import com.mbavellar.coursesb.repositories.StateRepository;

@SpringBootApplication
public class CoursesbApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoursesbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "IT");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.0);
		Product p2 = new Product(null, "Printer", 800.0);
		Product p3 = new Product(null, "Mouse", 80.0);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().add(p2);
		
		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().add(cat1);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");
		
		City city1 = new City(null, "Uberlândia", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		
		state1.getCities().add(city1);
		state2.getCities().addAll(Arrays.asList(city2, city3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.NATURAL_PERSON);
		client1.getPhoneNumbers().addAll(Arrays.asList("27363323", "93838393"));
		
		Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", client1, city1);
		Address address2 = new Address(null, "Ave Matos", "105", "Sala 800", "Centro", "38777012", client1, city2);
		
		client1.getAddresses().addAll(Arrays.asList(address1, address2));
		
		clientRepository.save(client1);
		addressRepository.saveAll(Arrays.asList(address1, address2));
		
	}

}
