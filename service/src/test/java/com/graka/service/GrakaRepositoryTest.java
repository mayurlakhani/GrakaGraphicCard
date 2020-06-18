/*
package com.graka.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.graka.service.model.Graka;
import com.graka.service.model.Manufacturer;
import com.graka.service.repository.GrakaRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.annotation.Rollback;


//@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
public class GrakaRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private GrakaRepository grakaRepository;
	
	Manufacturer manufacture = Manufacturer.AMD;

	@Rollback(false)
    @Order(1)
	@Test
	public void testAddGraphicCard() {
		entityManager.persist(new Graka("iPhonLTS",manufacture,1000));
		Graka graka = grakaRepository.findByname("iPhonLTS");
	     
	    assertThat(graka.getId()).isGreaterThan(0);
	}
	

	@Order(2)
	@Test
	public void testGraphicCardByName() {
	    Graka graka = grakaRepository.findByname("iPhonLTS");
	    assertThat(graka.getName()).isEqualTo("iPhonLTS");
	}


	@Order(3)
	@Test
	public void testgetAllGraphicCards() {
	    List<Graka> graka = (List<Graka>) grakaRepository.findAll();
	    assertThat(graka).size().isGreaterThan(0);
	}


	@Order(4)
	@Test
	public void testGetGraphicCardByID() {
		  Graka graka = grakaRepository.findByname("iPhonLTS");
	   Optional<Graka> graphicCardByID =  grakaRepository.findById(graka.getId());
	    assertThat(graphicCardByID);
	}


}
*/
