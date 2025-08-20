package br.com.vitor.roteiros.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class POI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "TEXT") // Para descrições mais longas
    private String description;
    private String category;
    private Double latitude;
    private Double longitude;
    private String googlePlaceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itinerary_id") // Chave estrangeira
    private Itinerary itinerary;
}