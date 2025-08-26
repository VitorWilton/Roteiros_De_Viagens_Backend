package br.com.vitor.roteiros.service;

import br.com.vitor.roteiros.dto.ItineraryRequestDTO;
import br.com.vitor.roteiros.dto.ItineraryResponseDTO;
import br.com.vitor.roteiros.model.Itinerary;
import br.com.vitor.roteiros.repository.ItineraryRepository;
import br.com.vitor.roteiros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private UserRepository userRepository;

    // --- MÉTODO DE CRIAÇÃO ATUALIZADO ---
    public ItineraryResponseDTO createItinerary(ItineraryRequestDTO dto) {
        // 1. Busca o usuário no banco de dados
        return userRepository.findById(dto.getUserId()).map(user -> {
            // 2. Cria uma nova entidade Itinerary com os dados do DTO
            Itinerary itinerary = new Itinerary();
            itinerary.setName(dto.getName());
            itinerary.setDestination(dto.getDestination());
            itinerary.setStartDate(dto.getStartDate());
            itinerary.setEndDate(dto.getEndDate());
            itinerary.setUser(user); // Associa o usuário encontrado

            // 3. Salva a nova entidade no banco
            Itinerary savedItinerary = itineraryRepository.save(itinerary);

            // 4. Converte a entidade salva para o DTO de resposta e retorna
            return convertToResponseDto(savedItinerary);
        }).orElseThrow(() -> new RuntimeException("Usuário com id " + dto.getUserId() + " não encontrado!"));
    }

    // --- MÉTODO DE LISTAGEM ATUALIZADO ---
    public List<ItineraryResponseDTO> getAllItinerariesByUser(Long userId) {
        return itineraryRepository.findByUserId(userId).stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    // --- MÉTODO AUXILIAR DE CONVERSÃO ---
    private ItineraryResponseDTO convertToResponseDto(Itinerary itinerary) {
        ItineraryResponseDTO dto = new ItineraryResponseDTO();
        dto.setId(itinerary.getId());
        dto.setName(itinerary.getName());
        dto.setDestination(itinerary.getDestination());
        dto.setStartDate(itinerary.getStartDate());
        dto.setEndDate(itinerary.getEndDate());
        return dto;
    }
}