# Tugas Eksplorasi dan Implementasi Tree

# Anggota Kelompok:
| Nama | NRP | Kelas |
| :---: | :---: | :---: |
| Iqbal Rizki Muhammad Fadhli | 5027251027 | Struktur Data dan OOP B |
| Nayla Arsha Adyuta | 5027251042 | Struktur Data dan OOP B |
| Riezco Eka Bayu Witantra | 5027251057 | Struktur Data dan OOP B |
| Najla Tufailah | 5027251078 | Struktur Data dan OOP B |

# Laporan:
## 1. Problem Statement 
Dalam berbagai bidang, seperti pendidikan, kesehatan, dan bisnis, proses pengambilan keputusan sering kali melibatkan analisis terhadap sejumlah data dengan banyak atribut. Salah satu contoh permasalahan yang umum adalah menentukan suatu hasil klasifikasi, seperti prediksi kelulusan mahasiswa berdasarkan nilai akademik, kehadiran, dan jumlah SKS yang diambil.

Namun, dalam praktiknya, data yang digunakan sering kali memiliki pola yang kompleks dan melibatkan hubungan antar atribut yang tidak sederhana. Misalnya, tingkat kelulusan mahasiswa tidak hanya ditentukan oleh satu faktor saja, tetapi merupakan kombinasi dari beberapa variabel seperti nilai dan kehadiran secara bersamaan.

Untuk menyelesaikan permasalahan tersebut, salah satu metode yang sering digunakan adalah Decision Tree. Metode ini dipilih karena memiliki struktur yang sederhana, mudah dipahami, serta mampu menghasilkan model yang interpretable. Decision Tree bekerja dengan membagi data menggunakan axis-parallel split, yaitu pemisahan berdasarkan satu atribut dalam satu waktu.

Meskipun demikian, Decision Tree tradisional memiliki keterbatasan dalam menangani data yang kompleks. Karena hanya menggunakan satu atribut untuk setiap pemisahan, model sering kali tidak mampu merepresentasikan hubungan antar fitur secara optimal. Akibatnya, pohon keputusan yang dihasilkan dapat menjadi terlalu dalam dan memiliki banyak node, yang berdampak pada meningkatnya kompleksitas model serta risiko overfitting.

Selain itu, keterbatasan dalam membentuk batas keputusan (decision boundary) juga menyebabkan performa klasifikasi menjadi kurang optimal, terutama pada data yang membutuhkan pemisahan berbasis kombinasi beberapa atribut sekaligus.

Untuk mengatasi permasalahan tersebut, dikembangkan Oblique Decision Tree sebagai variasi dari Decision Tree. Berbeda dengan metode tradisional, Oblique Decision Tree menggunakan multivariate split, yaitu pemisahan data berdasarkan kombinasi linear dari beberapa atribut. Dengan pendekatan ini, model dapat membentuk batas keputusan yang lebih fleksibel, menghasilkan struktur pohon yang lebih efisien, serta meningkatkan akurasi pada data yang kompleks.

Oleh karena itu, diperlukan analisis lebih lanjut mengenai perbedaan antara Decision Tree tradisional dan Oblique Decision Tree, baik dari segi struktur, kompleksitas, maupun performa, untuk memahami keunggulan dan keterbatasan masing-masing metode dalam menyelesaikan permasalahan klasifikasi.

## 2. Penjelasan Struktur Tree dan Algoritma 
Decision Tree merupakan struktur data berbentuk pohon (tree) yang digunakan untuk proses klasifikasi atau pengambilan keputusan.

Komponen utama:
1. Root Node (Akar)
    - Node pertama
    - Berisi atribut awal untuk melakukan pemisahan data

2. Internal Node
    - Node percabangan
    - Berisi atribut yang digunakan untuk split data

3. Leaf Node (Daun)
    - Node akhir
    - Berisi hasil klasifikasi (misal: Lulus / Tidak Lulus)

## 3. Visualisasi Diagram
1. Visualisasi Dataset Mahasiswa

    Pada penelitian ini digunakan data mahasiswa yang terdiri dari beberapa atribut, yaitu nilai akademik, tingkat kehadiran, dan jumlah SKS yang diambil. Data tersebut digunakan untuk menentukan apakah mahasiswa dinyatakan lulus atau tidak lulus.

    Contoh dataset:

    | Nilai | Kehadiran (%) | Jumlah SKS | Status |
    |---|---|---|---|
    | 85 | 90 | 24 | Lulus |
    | 78 | 82 | 22 | Lulus |
    | 60 | 70 | 18 | Tidak Lulus |
    | 72 | 75 | 20 | Tidak Lulus |
    | 88 | 95 | 24 | Lulus |

    Data tersebut dapat divisualisasikan menggunakan scatter plot dengan:
    - Sumbu X = Nilai Akademik
    - Sumbu Y = Kehadiran
    - Titik biru = Mahasiswa lulus
    - Titik merah = Mahasiswa tidak lulus

    Visualisasi ini menunjukkan bahwa status kelulusan mahasiswa tidak hanya dipengaruhi oleh satu atribut saja, tetapi juga dipengaruhi oleh kombinasi beberapa atribut secara bersamaan.

2. Visualisasi Decision Tree Tradisional

    Decision Tree tradisional bekerja dengan membagi data berdasarkan satu atribut pada setiap proses pemisahan.

    Contoh struktur Decision Tree:

    ```text
                    Nilai > 75?
                    /          \
                Ya            Tidak
            Kehadiran > 80?    Tidak Lulus
                /      \
            Ya         Tidak
        Lulus      Tidak Lulus
    ````

    Penjelasan:

    * Root node digunakan sebagai keputusan awal.
    * Internal node digunakan untuk proses pemisahan data.
    * Leaf node digunakan untuk menentukan hasil akhir klasifikasi.

    Pada metode ini, proses pemisahan dilakukan menggunakan axis-parallel split, yaitu pemisahan berdasarkan satu atribut dalam satu waktu.

3. Visualisasi Decision Boundary pada Decision Tree

    Pada Decision Tree tradisional, batas keputusan (decision boundary) berbentuk garis vertikal atau horizontal karena pemisahan data hanya dilakukan menggunakan satu atribut.

    Contoh split:

    ```text
    Nilai > 75
    ```

    Visualisasi sederhana:

    ```text
    |
    |      Lulus
    |
    |-------------
    |
    | Tidak Lulus
    |
    ```

    Pendekatan ini cukup baik untuk data sederhana, tetapi menjadi kurang optimal ketika data memiliki hubungan antar atribut yang lebih kompleks.

4. Visualisasi Oblique Decision Tree

    Oblique Decision Tree merupakan pengembangan dari Decision Tree tradisional yang menggunakan kombinasi beberapa atribut sekaligus dalam proses pemisahan data.

    Contoh split:

    ```text
    2 × Nilai + Kehadiran > 230
    ```

    Visualisasi sederhana:

    ```text
    \      Lulus
     \
      \
       \-------------
        \
        Tidak Lulus
    ```

    Dengan menggunakan kombinasi atribut, Oblique Decision Tree mampu membentuk batas keputusan yang lebih fleksibel sehingga lebih efektif dalam menangani data yang kompleks.

    Selain itu, struktur pohon yang dihasilkan juga cenderung lebih ringkas dibandingkan Decision Tree tradisional.

## 4. Aplikasi Struktur Tree
**A. Input Data Mahasiswa**, digunakan untuk menyimpan informasi akademik mahasiswa yang akan digunakan sebagai dataset dalam proses pelatihan (training) maupun pengujian (testing) model klasifikasi. Data yang dimasukkan terdiri dari beberapa atribut yang dianggap memengaruhi kelulusan mahasiswa, yaitu:
- Nilai Akademik → menunjukkan performa akademik mahasiswa selama perkuliahan.
- Persentase Kehadiran → menunjukkan tingkat kehadiran mahasiswa dalam mengikuti kegiatan perkuliahan.
- Jumlah SKS → menunjukkan jumlah mata kuliah yang berhasil ditempuh mahasiswa.
- Status Kelulusan → digunakan sebagai label atau target klasifikasi yang akan dipelajari oleh model.
  
Data-data tersebut nantinya akan dianalisis oleh algoritma Decision Tree maupun Oblique Decision Tree untuk menemukan pola yang dapat digunakan dalam memprediksi status kelulusan mahasiswa baru. Sebagai contoh, mahasiswa dengan nilai tinggi, kehadiran yang baik, dan jumlah SKS yang mencukupi umumnya memiliki peluang lebih besar untuk lulus dibandingkan mahasiswa yang memiliki nilai rendah dan tingkat kehadiran yang buruk. Berikut implementasi kodenya:
```java
class Mahasiswa {
    int nilai;
    int kehadiran;
    int sks;
    String status;

    public Mahasiswa(int nilai, int kehadiran, int sks, String status) {
        this.nilai = nilai;
        this.kehadiran = kehadiran;
        this.sks = sks;
        this.status = status;
    }
}

public class DatasetMahasiswa {
    public static void main(String[] args) {

        Mahasiswa[] data = {
            new Mahasiswa(85, 90, 24, "Lulus"),
            new Mahasiswa(78, 82, 22, "Lulus"),
            new Mahasiswa(60, 70, 18, "Tidak Lulus"),
            new Mahasiswa(72, 75, 20, "Tidak Lulus"),
            new Mahasiswa(88, 95, 24, "Lulus")
        };

        for (Mahasiswa m : data) {
            System.out.println(
                "Nilai: " + m.nilai +
                ", Kehadiran: " + m.kehadiran +
                ", SKS: " + m.sks +
                ", Status: " + m.status
            );
        }
    }
}
```

B. Fitur ini digunakan untuk membangun struktur pohon keputusan (Decision Tree) berdasarkan dataset mahasiswa yang telah dimasukkan sebelumnya. Pada tahap ini, sistem akan mencari atribut terbaik yang dapat digunakan untuk memisahkan data menjadi beberapa kelompok. Pemilihan atribut dilakukan berdasarkan kemampuan atribut tersebut dalam membedakan mahasiswa yang lulus dan tidak lulus. Sebagai contoh, sistem dapat menemukan bahwa atribut Nilai Akademik merupakan atribut yang paling berpengaruh sehingga dipilih sebagai root node. Contoh aturan yang dapat dihasilkan:
```java
Jika Nilai > 75
    Jika Kehadiran > 80
        Lulus
    Jika tidak
        Tidak Lulus
Jika Nilai <= 75
    Tidak Lulus
```
Hasil dari proses ini adalah sebuah pohon keputusan yang dapat digunakan untuk melakukan prediksi terhadap data baru. Berikut implementasi kodenya:
```java
public class DecisionTreeSederhana {

    public static String prediksi(int nilai, int kehadiran) {

        if (nilai > 75) {
            if (kehadiran > 80) {
                return "Lulus";
            } else {
                return "Tidak Lulus";
            }
        } else {
            return "Tidak Lulus";
        }
    }

    public static void main(String[] args) {

        String hasil = prediksi(80, 85);

        System.out.println("Prediksi: " + hasil);
    }
}
```

**C. Prediksi Kelulusan Mahasiswa**, digunakan untuk menentukan status kelulusan mahasiswa berdasarkan model yang telah dibangun sebelumnya. Pengguna hanya perlu memasukkan data mahasiswa berupa nilai akademik, tingkat kehadiran, dan jumlah SKS. Sistem kemudian akan menelusuri aturan yang terdapat pada pohon keputusan hingga mencapai leaf node yang berisi hasil klasifikasi. Dengan adanya fitur ini, pihak akademik dapat melakukan evaluasi terhadap mahasiswa sejak dini dan memberikan tindakan yang sesuai apabila ditemukan potensi keterlambatan kelulusan. Berikut implementasi kodenya:
```java
public class PrediksiKelulusan {

    public static String prediksi(int nilai, int kehadiran) {

        if (nilai > 75 && kehadiran > 80) {
            return "Lulus";
        }

        return "Tidak Lulus";
    }

    public static void main(String[] args) {

        int nilai = 82;
        int kehadiran = 88;

        String hasil = prediksi(nilai, kehadiran);

        System.out.println("Status Kelulusan: " + hasil);
    }
}
```

**D. Perbandingan Hasil Prediksi**, digunakan untuk membandingkan hasil klasifikasi yang diperoleh dari Decision Tree dan Oblique Decision Tree. Tujuannya adalah untuk mengetahui metode mana yang memberikan hasil yang lebih baik berdasarkan data yang digunakan. Perbandingan dapat dilakukan menggunakan metrik seperti akurasi, precision, recall, dan F1-score. Hasil evaluasi ini dapat digunakan untuk menentukan model yang paling sesuai dalam memprediksi kelulusan mahasiswa. Berikut implementasi kodenya:
```java
public class PerbandinganModel {

    public static void main(String[] args) {

        double akurasiDecisionTree = 82.5;
        double akurasiObliqueTree = 89.7;

        System.out.println("Decision Tree : " +
                           akurasiDecisionTree + "%");

        System.out.println("Oblique Decision Tree : " +
                           akurasiObliqueTree + "%");

        if (akurasiObliqueTree > akurasiDecisionTree) {
            System.out.println(
                "Oblique Decision Tree memiliki performa lebih baik."
            );
        }
    }
}
```

## 5. Keunggulan 
## 6. Kekurangan
**Decision Tree**
- Tree bisa sangat besar
- Tidak optimal untuk data yang komples
- Split terbatas hanya 1 fitur
- Akurasi Lebih rendah

**Oblique Decision Tree**
- Implementasi lebih sulit
- Perhitungan lebih komples
- Butuh effort lebih untuk memahami
  
## 7. Perbandingan Antara Tree Dasar dan Modifikasi Secara Teori 
## 8. Analisis Kompleksitas Berdasarkan Struktur Tree 
## 9. Potensi Pengembangan ke Depan 
## 10. Hasil Implementasi
## 11. Perbandingan performa real

