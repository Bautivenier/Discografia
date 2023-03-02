package com.example.Discografia.service;

import com.example.Discografia.exeption.DiscografiaNotFoundException;
import com.example.Discografia.model.Discografia;
import com.example.Discografia.repository.DiscografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiscografiaService {
    private final DiscografiaRepository discografiaRepository;

    @Autowired
    public DiscografiaService(DiscografiaRepository discografiaRepository) {
        this.discografiaRepository = discografiaRepository;
    }

    public List<Discografia> findAllDiscografia() {
        return discografiaRepository.findAll();
    }

    public Discografia addDiscografia(Discografia discografia) {
        return discografiaRepository.save(discografia);
    }

    public Discografia findDiscografiaByid(Long id) {
        return discografiaRepository.findById(id)
                .orElseThrow(() -> new DiscografiaNotFoundException(id));
    }

    public void deleteDiscografia(Long id) {
        Optional<Discografia> deleteDiscografia = discografiaRepository.findById(id);
        if (deleteDiscografia.isEmpty()) {
            throw new DiscografiaNotFoundException(id);
        }else {
            discografiaRepository.deleteById(id);

        }


    }
    public Optional<Discografia> updateDiscografia(Discografia newDiscografia, Long id) {
        Optional<Discografia> updatedMovie = discografiaRepository.findById(id);
        if ((updatedMovie.isEmpty())) {
            throw new DiscografiaNotFoundException(id);
        } else {
            return updatedMovie.map(discografia -> {
                discografia.setArtista(newDiscografia.getArtista());
                discografia.setDisco(newDiscografia.getDisco());
                discografia.setFecha(newDiscografia.getFecha());
                discografia.setDiscografica(newDiscografia.getDiscografica());
                discografia.setProductores(newDiscografia.getDiscografica());
                discografia.setEstudio(newDiscografia.getEstudio());
                discografia.setPortada(newDiscografia.getPortada());
                return discografiaRepository.save(discografia);
            });

        }

    }

    }

