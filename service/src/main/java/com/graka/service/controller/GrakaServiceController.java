package com.graka.service.controller;

import com.graka.service.exception.CustomErrorType;
import com.graka.service.model.Graka;
import com.graka.service.services.GrakaCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.text.NumberFormat;

@RestController
public class GrakaServiceController {

    public static final Logger logger = LoggerFactory.getLogger(GrakaServiceController.class);

    @Autowired
    private  GrakaCardService grakaCardService;

    @GetMapping("/graphiccard/all")
    public ResponseEntity<List<Graka>> getAllGraphicCards() {
        List<Graka> graphicCardList = grakaCardService.getAllGraphicCards();
        logger.info("Fetching All Grphic Card data : {}", graphicCardList);
        if(graphicCardList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(graphicCardList, HttpStatus.OK);
    }


    @PostMapping("/graphiccard/add")
    public ResponseEntity<?> addGraphicCardData(@Valid @RequestBody Graka graphicCard) {
        logger.info("Inserting new Grphic Card data : {}", graphicCard);
        if (grakaCardService.isGrakaExist(graphicCard)) {
            logger.error("Unable to create. A Graphic Card with name {} already exist", graphicCard.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Card with name " +
                    graphicCard.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        String currency = format.format(graphicCard.getPrice());
        System.out.println("Currency in Euro: " + currency);
        grakaCardService.addGraphicCard(graphicCard);
        return new ResponseEntity(graphicCard.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/graphiccard/{id}")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Graka> getGraphicCardByID(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}", id);
        Optional<Graka> graphicCard = grakaCardService.getGraphicCardByID(id);
        if (graphicCard == null) {
            logger.error("Graphic Card with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Graphic Card with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(graphicCard, HttpStatus.OK);
    }

}
