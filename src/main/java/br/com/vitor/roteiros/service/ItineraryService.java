package br.com.vitor.roteiros.service;

import br.com.vitor.roteiros.model.Itinerary;
import br.com.vitor.roteiros.repository.ItineraryRepository;
import br.com.vitor.roteiros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;


    @Autowired
    private UserRepository userRepository;

    public Itinerary createItinerary(Itinerary itinerary, Long userId) {
        // Busca o usuário pelo ID e o associa ao novo roteiro
        return userRepository.findById(userId).map(user -> {
            itinerary.setUser(user);
            return itineraryRepository.save(itinerary);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public List<Itinerary> getAllItinerariesByUser(Long userId) {
        return itineraryRepository.findByUserId(userId);
    }

    public Optional<Itinerary> getItineraryById(Long id) {
        return itineraryRepository.findById(id);
    }

    public void deleteItinerary(Long id) {
        itineraryRepository.deleteById(id);
    }

    // TODO: Implementar os métodos de update e os outros serviços (User, POI)
}