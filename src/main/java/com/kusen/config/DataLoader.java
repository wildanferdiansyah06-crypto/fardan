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
            // Pintu Products
            kusenRepository.save(new Kusen(
                "Kusen Pintu Meranti Premium",
                "Kusen pintu kayu meranti berkualitas tinggi dengan finishing natural. Cocok untuk rumah modern dengan desain minimalis. Tahan lama dan anti rayap dengan perlindungan khusus.",
                750000.0,
                "Meranti",
                200.0,
                80.0,
                4.0,
                15,
                "Pintu",
                "https://images.pexels.com/photos/1571460/pexels-photo-1571460.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Solid Meranti",
                "Natural Wood",
                4.8,
                45
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Mahoni Modern",
                "Kusen pintu kayu mahoni dengan finishing halus dan elegan. Memberikan kesan mewah untuk hunian Anda. Dilengkapi dengan engsel premium dan kunci pengaman.",
                950000.0,
                "Mahoni",
                210.0,
                90.0,
                4.5,
                12,
                "Pintu",
                "https://images.pexels.com/photos/2119713/pexels-photo-2119713.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Mahoni Grade A",
                "Dark Brown",
                4.7,
                38
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Ulin Tahan Air",
                "Kusen pintu kayu ulin yang sangat tahan air dan cuaca ekstrem. Ideal untuk area lembab seperti kamar mandi atau outdoor. Kayu ulin dikenal sebagai kayu besi karena kekuatannya.",
                1500000.0,
                "Ulin",
                200.0,
                85.0,
                5.0,
                8,
                "Pintu",
                "https://images.pexels.com/photos/1758144/pexels-photo-1758144.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Ulin Borneo",
                "Natural",
                4.9,
                52
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Ganda Meranti",
                "Kusen pintu ganda kayu meranti untuk ruangan besar seperti ruang tamu atau aula. Desain elegan dengan detail ukiran halus. Sangat cocok untuk rumah bergaya klasik.",
                1800000.0,
                "Meranti",
                220.0,
                160.0,
                5.0,
                5,
                "Pintu",
                "https://images.pexels.com/photos/209216/pexels-photo-209216.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Solid Meranti",
                "Walnut Finish",
                4.6,
                28
            ));

            kusenRepository.save(new Kusen(
                "Kusen Pintu Jati Klasik",
                "Kusen pintu kayu jati dengan desain klasik yang elegan. Sangat kuat dan tahan cuaca. Finishing natural yang mempertahankan keindahan serat kayu asli.",
                2200000.0,
                "Jati",
                210.0,
                90.0,
                5.5,
                10,
                "Pintu",
                "https://images.pexels.com/photos/259962/pexels-photo-259962.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Jati TPK",
                "Golden Oak",
                5.0,
                67
            ));

            // Jendela Products
            kusenRepository.save(new Kusen(
                "Kusen Jendela Jati Klasik",
                "Kusen jendela kayu jati dengan desain klasik yang elegan. Sangat kuat dan tahan cuaca. Cocok untuk rumah bergaya tradisional maupun modern.",
                1200000.0,
                "Jati",
                150.0,
                60.0,
                5.0,
                10,
                "Jendela",
                "https://images.pexels.com/photos/2119714/pexels-photo-2119714.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Jati Premium",
                "Natural",
                4.8,
                41
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Pinus Ekonomis",
                "Kusen jendela kayu pinus dengan harga terjangkau. Cocok untuk budget terbatas tanpa mengorbankan kualitas. Finishing putih bersih yang modern.",
                450000.0,
                "Pinus",
                120.0,
                50.0,
                3.5,
                20,
                "Jendela",
                "https://images.pexels.com/photos/3734539/pexels-photo-3734539.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Pinus",
                "White Paint",
                4.3,
                89
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Bengkirai Kuat",
                "Kusen jendela kayu bengkirai dengan kekuatan ekstra. Tahan terhadap perubahan suhu dan kelembaban. Sangat cocok untuk area tropis.",
                850000.0,
                "Bengkirai",
                140.0,
                55.0,
                4.0,
                14,
                "Jendela",
                "https://images.pexels.com/photos/2119715/pexels-photo-2119715.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Bengkirai",
                "Teak Finish",
                4.5,
                56
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Jati Minimalis",
                "Kusen jendela kayu jati dengan desain minimalis modern. Finishing natural yang menawan. Sangat cocok untuk rumah dengan desain kontemporer.",
                1350000.0,
                "Jati",
                100.0,
                40.0,
                4.0,
                18,
                "Jendela",
                "https://images.pexels.com/photos/271667/pexels-photo-271667.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Jati",
                "Natural",
                4.7,
                73
            ));

            kusenRepository.save(new Kusen(
                "Kusen Jendela Meranti Modern",
                "Kusen jendela kayu meranti dengan desain modern yang sleek. Tahan lama dan mudah perawatannya. Dilengkapi dengan kaca tempered premium.",
                680000.0,
                "Meranti",
                130.0,
                55.0,
                3.8,
                25,
                "Jendela",
                "https://images.pexels.com/photos/2119716/pexels-photo-2119716.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Meranti",
                "Grey Finish",
                4.4,
                94
            ));

            // Daun Pintu Products
            kusenRepository.save(new Kusen(
                "Daun Pintu Panel Jati",
                "Daun pintu panel kayu jati dengan desain elegan. Kualitas premium dengan serat kayu yang indah. Dilengkapi dengan handle dan kunci pengaman.",
                2500000.0,
                "Jati",
                210.0,
                90.0,
                4.0,
                8,
                "Daun Pintu",
                "https://images.pexels.com/photos/175823/pexels-photo-175823.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Jati Solid",
                "Natural",
                4.9,
                34
            ));

            kusenRepository.save(new Kusen(
                "Daun Pintu Minimalis Mahoni",
                "Daun pintu minimalis dari kayu mahoni. Desain modern dengan finishing halus. Cocok untuk apartemen atau rumah modern.",
                1800000.0,
                "Mahoni",
                210.0,
                85.0,
                4.0,
                12,
                "Daun Pintu",
                "https://images.pexels.com/photos/209216/pexels-photo-209216.jpeg?auto=compress&cs=tinysrgb&w=800",
                "Kayu Mahoni",
                "Dark Walnut",
                4.6,
                47
            ));

            System.out.println("Sample data loaded successfully!");
        }
    }
}
