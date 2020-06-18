package com.graka.service;
import com.graka.service.model.Graka;
import com.graka.service.model.Manufacturer;
import com.graka.service.repository.GrakaRepository;
import org.junit.rules.ExpectedException;

import com.graka.service.services.GrakaCardService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Rule;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ServiceApplicationTests.class);
    @Autowired
    private DataSource dataSource;

    @Autowired
    private GrakaCardService grakaCardService;

    @Autowired
    private GrakaRepository grakaRepository;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    Manufacturer manufacturer = Manufacturer.AMD;
    @Test
    void contextLoads() {
    }

    @Test
    public void testSaveFetchGrakaDetails() throws Exception{
        Graka graka = new Graka();
        graka.setName("Portgas D. Ace");
        graka.setManufacturerEnum(manufacturer);
        graka.setPrice(4000);
        log.info("Graka Card Details Saved:");
        log.info("-------------------------------");
        grakaCardService.addGraphicCard(graka);
        assertNotNull(graka.getId());

        Graka graphicCard = grakaRepository.findByname(graka.getName());
        log.info("Graka Card Details fetched By Name:");
        log.info("-------------------------------");
        assertEquals("Portgas D. Ace", graphicCard.getName());
        log.info("List of Graka Card Details fetched:");
        log.info("-------------------------------");
        List<Graka> cardList = grakaCardService.getAllGraphicCards();
        for (Graka ListGraka :cardList) {
            log.info(ListGraka.toString());
        }
        log.info("Fetch  Graka Card By ID:");
        log.info("-------------------------------");
        Optional<Graka> g = grakaCardService.getGraphicCardByID(graka.getId());
        log.info(g.toString());
        assertNotNull(g.toString());
    }

}
