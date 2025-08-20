package br.com.vitor.roteiros.repository;

import br.com.vitor.roteiros.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIRepository extends JpaRepository<POI, Long> {
}