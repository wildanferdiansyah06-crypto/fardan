package com.kusen.controller;

import com.kusen.model.Kusen;
import com.kusen.repository.KusenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kusen")
@CrossOrigin(origins = "*")
public class KusenApiController {

    @Autowired
    private KusenRepository kusenRepository;

    @GetMapping
    public List<Kusen> getAllKusen() {
        return kusenRepository.findByTersediaTrue();
    }

    @GetMapping("/{id}")
    public Kusen getKusenById(@PathVariable Long id) {
        return kusenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Kusen tidak ditemukan: " + id));
    }

    @GetMapping("/kategori/{kategori}")
    public List<Kusen> getKusenByKategori(@PathVariable String kategori) {
        return kusenRepository.findByKategoriAndTersediaTrue(kategori);
    }

    @GetMapping("/jenis/{jenisKayu}")
    public List<Kusen> getKusenByJenisKayu(@PathVariable String jenisKayu) {
        return kusenRepository.findByJenisKayuAndTersediaTrue(jenisKayu);
    }
}
