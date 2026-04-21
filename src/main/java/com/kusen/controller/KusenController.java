package com.kusen.controller;

import com.kusen.model.Kusen;
import com.kusen.repository.KusenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KusenController {

    @Autowired
    private KusenRepository kusenRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("kusenList", kusenRepository.findByTersediaTrue());
        return "index";
    }

    @GetMapping("/produk")
    public String listProduk(Model model) {
        model.addAttribute("kusenList", kusenRepository.findByTersediaTrue());
        return "produk";
    }

    @GetMapping("/produk/{id}")
    public String detailProduk(@PathVariable Long id, Model model) {
        Kusen kusen = kusenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produk tidak ditemukan: " + id));
        model.addAttribute("kusen", kusen);
        return "detail";
    }

    @GetMapping("/jenis/{jenisKayu}")
    public String filterByJenis(@PathVariable String jenisKayu, Model model) {
        model.addAttribute("kusenList", kusenRepository.findByJenisKayuAndTersediaTrue(jenisKayu));
        model.addAttribute("jenisFilter", jenisKayu);
        return "produk";
    }

    @GetMapping("/tambah-produk")
    public String formTambahProduk(Model model) {
        model.addAttribute("kusen", new Kusen());
        return "form-produk";
    }

    @PostMapping("/tambah-produk")
    public String simpanProduk(@ModelAttribute Kusen kusen) {
        kusen.setTersedia(true);
        kusenRepository.save(kusen);
        return "redirect:/produk";
    }

    @GetMapping("/edit/{id}")
    public String formEditProduk(@PathVariable Long id, Model model) {
        Kusen kusen = kusenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produk tidak ditemukan: " + id));
        model.addAttribute("kusen", kusen);
        return "form-produk";
    }

    @PostMapping("/edit/{id}")
    public String updateProduk(@PathVariable Long id, @ModelAttribute Kusen kusen) {
        kusen.setId(id);
        kusenRepository.save(kusen);
        return "redirect:/produk/" + id;
    }

    @GetMapping("/hapus/{id}")
    public String hapusProduk(@PathVariable Long id) {
        Kusen kusen = kusenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produk tidak ditemukan: " + id));
        kusen.setTersedia(false);
        kusenRepository.save(kusen);
        return "redirect:/produk";
    }
}
