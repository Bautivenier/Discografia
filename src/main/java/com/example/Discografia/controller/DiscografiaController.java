package com.example.Discografia.controller;

import com.example.Discografia.model.Discografia;
import com.example.Discografia.service.DiscografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discografia")
public class DiscografiaController {
    private final DiscografiaService discografiaService;

    @Autowired
    public DiscografiaController(DiscografiaService discografiaService) {
        this.discografiaService = discografiaService;
    }

    @GetMapping("/{id}")
    public Discografia findDiscografiaByid(@PathVariable("id") Long id) {
        return discografiaService.findDiscografiaByid(id);
    }

    @GetMapping("/all")
    public List<Discografia> findAllDiscografia() {
        return discografiaService.findAllDiscografia();

    }

    @PostMapping("/addDiscografia")
    public Discografia addDiscografia(@RequestBody Discografia discografia) {
        return discografiaService.addDiscografia(discografia);
    }

    @DeleteMapping("/delete/{id}")
            public void deleteDiscografia(@PathVariable("id") Long id){
            discografiaService.deleteDiscografia(id);
    }
    @PutMapping("/updateDiscografia/{id}")
    public Optional<Discografia> updateDiscografia(@RequestBody Discografia discografia, @PathVariable Long id) {
        return discografiaService.updateDiscografia(discografia, id);
    }

}


