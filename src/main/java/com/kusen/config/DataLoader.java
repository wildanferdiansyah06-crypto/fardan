package com.kusen.config;

import com.kusen.model.Kusen;
import com.kusen.repository.KusenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final KusenRepository kusenRepository;

    public DataLoader(KusenRepository kusenRepository) {
        this.kusenRepository = kusenRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (kusenRepository.count() == 0) {
            kusenRepository.save(new Kusen(
                "Kusen Pintu Meranti Premium",
                "Kusen pintu kayu meranti berkualitas tinggi, cocok untuk rumah modern. Tahan lama dan anti rayap.",
                750000.0,
                "Meranti",
                200.0,
                80.0,
                4.0,
                15
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Jati Klasik",
                "Kusen jendela kayu jati dengan desain klasik yang elegan. Sangat kuat dan tahan cuaca.",
                1200000.0,
                "Jati",
                150.0,
                60.0,
                5.0,
                10
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Mahoni Modern",
                "Kusen pintu kayu mahoni dengan finishing halus. Memberikan kesan mewah untuk hunian Anda.",
                950000.0,
                "Mahoni",
                210.0,
                90.0,
                4.5,
                12
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Pinus Ekonomis",
                "Kusen jendela kayu pinus dengan harga terjangkau. Cocok untuk budget terbatas tanpa mengorbankan kualitas.",
                450000.0,
                "Pinus",
                120.0,
                50.0,
                3.5,
                20
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Ulin Tahan Air",
                "Kusen pintu kayu ulin yang sangat tahan air dan cuaca ekstrem. Ideal untuk area lembab.",
                1500000.0,
                "Ulin",
                200.0,
                85.0,
                5.0,
                8
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Bengkirai Kuat",
                "Kusen jendela kayu bengkirai dengan kekuatan ekstra. Tahan terhadap perubahan suhu dan kelembaban.",
                850000.0,
                "Bengkirai",
                140.0,
                55.0,
                4.0,
                14
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Ganda Meranti",
                "Kusen pintu ganda kayu meranti untuk ruangan besar. Desain elegan dan kokoh.",
                1800000.0,
                "Meranti",
                220.0,
                160.0,
                5.0,
                5
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Jati Minimalis",
                "Kusen jendela kayu jati dengan desain minimalis modern. Finishing natural yang menawan.",
                1350000.0,
                "Jati",
                100.0,
                40.0,
                4.0,
                18
            ));

            System.out.println("Sample data loaded successfully!");
        }
    }
}
