package br.com.vitor.roteiros.controller;

import br.com.vitor.roteiros.model.Itinerary;
import br.com.vitor.roteiros.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;


    @PostMapping
    public ResponseEntity<Itinerary> createItinerary(@RequestBody Itinerary itinerary, @RequestParam Long userId) {
        Itinerary newItinerary = itineraryService.createItinerary(itinerary, userId);
        return new ResponseEntity<>(newItinerary, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Itinerary>> getAllItinerariesByUser(@RequestParam Long userId) {
        List<Itinerary> itineraries = itineraryService.getAllItinerariesByUser(userId);
        return ResponseEntity.ok(itineraries);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable Long id) {
        return itineraryService.getItineraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Long id) {
        itineraryService.deleteItinerary(id);
        return ResponseEntity.noContent().build();
    }
}