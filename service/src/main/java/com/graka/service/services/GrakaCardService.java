package com.graka.service.services;
import com.graka.service.model.Graka;
import java.util.List;
import java.util.Optional;

public interface GrakaCardService {

    Graka addGraphicCard(Graka graka);
    List<Graka> getAllGraphicCards();
    Optional<Graka> getGraphicCardByID(Long id);
    boolean isGrakaExist(Graka graka);

}
