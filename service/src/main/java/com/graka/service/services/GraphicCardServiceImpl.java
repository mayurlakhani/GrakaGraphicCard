package com.graka.service.services;

import com.graka.service.model.Graka;
import com.graka.service.repository.GrakaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GraphicCardServiceImpl implements GrakaCardService {

    @Autowired
    private GrakaRepository grakaRepository;

    @Override
    public Graka addGraphicCard(Graka graka) {
        return grakaRepository.save(graka);
    }

    @Override
    public List<Graka> getAllGraphicCards() {
        return grakaRepository.findAll();
    }

    @Override
    public Optional<Graka> getGraphicCardByID(Long id) {
            return grakaRepository.findById(id);
    }

    @Override
    public boolean isGrakaExist(Graka graka) {

        return grakaRepository.findByname(graka.getName())!=null;
    }


}
