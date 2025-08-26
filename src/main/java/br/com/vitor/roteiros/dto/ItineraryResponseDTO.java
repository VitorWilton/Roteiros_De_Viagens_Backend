package br.com.vitor.roteiros.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ItineraryResponseDTO {
    private Long id;
    private String name;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
}