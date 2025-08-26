package br.com.vitor.roteiros.controller;

import br.com.vitor.roteiros.dto.ItineraryRequestDTO;
import br.com.vitor.roteiros.dto.ItineraryResponseDTO;
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
    public ResponseEntity<ItineraryResponseDTO> createItinerary(@RequestBody ItineraryRequestDTO itineraryDto) {
        try {
            ItineraryResponseDTO newItinerary = itineraryService.createItinerary(itineraryDto);
            return new ResponseEntity<>(newItinerary, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Caso o usuário não seja encontrado no serviço
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ItineraryResponseDTO>> getAllItinerariesByUser(@RequestParam Long userId) {
        List<ItineraryResponseDTO> itineraries = itineraryService.getAllItinerariesByUser(userId);
        return ResponseEntity.ok(itineraries);
    }
}