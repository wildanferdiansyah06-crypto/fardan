package com.kusen.repository;

import com.kusen.model.Kusen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KusenRepository extends JpaRepository<Kusen, Long> {
    
    List<Kusen> findByTersediaTrue();
    
    List<Kusen> findByJenisKayu(String jenisKayu);
    
    List<Kusen> findByJenisKayuAndTersediaTrue(String jenisKayu);
}
