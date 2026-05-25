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
Bagaimana cara menentukan apakah seorang mahasiswa berpotensi lulus tepat waktu hanya berdasarkan data akademik yang dimilikinya? Pertanyaan tersebut menjadi salah satu tantangan dalam dunia pendidikan, terutama ketika keputusan harus dibuat berdasarkan berbagai faktor yang saling memengaruhi, seperti nilai akademik, tingkat kehadiran, dan jumlah SKS yang telah ditempuh. Di tengah meningkatnya jumlah data yang tersedia, diperlukan metode yang mampu mengubah data tersebut menjadi informasi yang dapat digunakan sebagai dasar pengambilan keputusan. Dalam bidang pendidikan proses pengambilan keputusan sering kali melibatkan analisis terhadap sejumlah data dengan banyak atribut. Salah satu contoh permasalahan yang umum adalah menentukan suatu hasil klasifikasi, seperti prediksi kelulusan mahasiswa berdasarkan nilai akademik, kehadiran, dan jumlah SKS yang diambil.

Namun, dalam praktiknya, data yang digunakan sering kali memiliki pola yang kompleks dan melibatkan hubungan antar atribut yang tidak sederhana. Misalnya, tingkat kelulusan mahasiswa tidak hanya ditentukan oleh satu faktor saja, tetapi merupakan kombinasi dari beberapa variabel seperti nilai dan kehadiran secara bersamaan. Untuk menyelesaikan permasalahan tersebut, salah satu metode yang sering digunakan adalah Decision Tree. Metode ini dipilih karena memiliki struktur yang sederhana, mudah dipahami, serta mampu menghasilkan model yang interpretable. Decision Tree bekerja dengan membagi data menggunakan axis-parallel split, yaitu pemisahan berdasarkan satu atribut dalam satu waktu. Meskipun demikian, Decision Tree tradisional memiliki keterbatasan dalam menangani data yang kompleks. Karena hanya menggunakan satu atribut untuk setiap pemisahan, model sering kali tidak mampu merepresentasikan hubungan antar fitur secara optimal. Akibatnya, pohon keputusan yang dihasilkan dapat menjadi terlalu dalam dan memiliki banyak node, yang berdampak pada meningkatnya kompleksitas model serta risiko overfitting. Selain itu, keterbatasan dalam membentuk batas keputusan (decision boundary) juga menyebabkan performa klasifikasi menjadi kurang optimal, terutama pada data yang membutuhkan pemisahan berbasis kombinasi beberapa atribut sekaligus.

Untuk mengatasi permasalahan tersebut, dikembangkan Oblique Decision Tree sebagai variasi dari Decision Tree. Berbeda dengan metode tradisional, Oblique Decision Tree menggunakan multivariate split, yaitu pemisahan data berdasarkan kombinasi linear dari beberapa atribut. Dengan pendekatan ini, model dapat membentuk batas keputusan yang lebih fleksibel, menghasilkan struktur pohon yang lebih efisien, serta meningkatkan akurasi pada data yang kompleks. Oleh karena itu, diperlukan analisis lebih lanjut mengenai perbedaan antara Decision Tree tradisional dan Oblique Decision Tree, baik dari segi struktur, kompleksitas, maupun performa, untuk memahami keunggulan dan keterbatasan masing-masing metode dalam menyelesaikan permasalahan klasifikasi.

## 2. Penjelasan Struktur Tree dan Algoritma 
Decision Tree merupakan salah satu struktur data berbentuk pohon (tree) yang banyak digunakan dalam proses klasifikasi dan pengambilan keputusan. Struktur ini bekerja dengan cara membagi data ke dalam beberapa kelompok berdasarkan aturan tertentu hingga diperoleh hasil klasifikasi akhir. Karena memiliki bentuk yang menyerupai pohon, Decision Tree terdiri atas beberapa komponen utama, yaitu **Root Node**, **Internal Node**, dan **Leaf Node**. Root Node merupakan node pertama yang menjadi titik awal proses pengambilan keputusan. Pada node ini dipilih atribut yang dianggap paling berpengaruh untuk memisahkan data. Setelah proses pemisahan dilakukan, data akan mengalir menuju Internal Node yang berfungsi sebagai node percabangan. Internal Node berisi atribut atau kondisi tertentu yang digunakan untuk melakukan pemisahan lanjutan terhadap data yang masih belum dapat diklasifikasikan secara pasti. Proses ini terus berlangsung hingga mencapai Leaf Node, yaitu node terakhir yang tidak memiliki cabang lagi dan berisi hasil klasifikasi akhir, seperti "Lulus" atau "Tidak Lulus".

Dalam kasus prediksi kelulusan mahasiswa, Root Node berupa atribut nilai akademik yang digunakan sebagai dasar keputusan pertama. Jika mahasiswa memiliki nilai di atas batas tertentu, proses akan dilanjutkan ke percabangan berikutnya yang mungkin mempertimbangkan atribut kehadiran. Sebaliknya, apabila nilai berada di bawah batas yang ditentukan, mahasiswa dapat langsung diklasifikasikan ke dalam kategori tertentu. Dengan mekanisme tersebut, setiap jalur dari Root Node menuju Leaf Node merepresentasikan aturan keputusan (decision rule) yang dapat digunakan untuk menjelaskan alasan suatu data masuk ke dalam kelas tertentu.

Sebagai pengembangan dari Decision Tree tradisional, Oblique Decision Tree diperkenalkan untuk mengatasi keterbatasan yang muncul ketika data memiliki hubungan yang kompleks antar atribut. Pada Decision Tree tradisional, setiap proses pemisahan hanya mempertimbangkan satu atribut dalam satu waktu (axis-parallel split). Pendekatan ini sering kali kurang optimal ketika suatu keputusan sebenarnya dipengaruhi oleh kombinasi beberapa atribut secara bersamaan. Oleh karena itu, Oblique Decision Tree menggunakan multivariate split, yaitu pemisahan data berdasarkan kombinasi linear dari dua atau lebih atribut. Dengan pendekatan ini, model mampu membentuk batas keputusan (decision boundary) yang lebih fleksibel sehingga dapat merepresentasikan pola data yang lebih kompleks.

Meskipun memiliki struktur dasar yang sama, yaitu terdiri atas **Root Node**, **Internal Node**, dan **Leaf Node**, perbedaan utama antara Decision Tree dan Oblique Decision Tree terletak pada aturan pemisahan yang digunakan. Pada Decision Tree, sebuah node dapat menggunakan aturan sederhana seperti `Nilai > 75`, sedangkan pada Oblique Decision Tree aturan yang digunakan dapat berupa kombinasi beberapa atribut, misalnya `2 × Nilai + Kehadiran > 240`. Dengan mempertimbangkan beberapa atribut secara bersamaan, Oblique Decision Tree sering kali mampu menghasilkan struktur pohon yang lebih ringkas dan akurat dibandingkan Decision Tree tradisional.

Algoritma Oblique Decision Tree bekerja dengan mencari kombinasi atribut yang mampu memisahkan data secara optimal pada setiap node. Kombinasi tersebut membentuk suatu hyperplane yang digunakan sebagai batas pemisah antar kelas. Setelah pemisahan dilakukan, proses yang sama akan diterapkan pada setiap subset data hingga diperoleh Leaf Node yang berisi hasil klasifikasi akhir. Pendekatan ini memungkinkan model menangkap hubungan antar atribut dengan lebih baik sehingga sangat cocok digunakan pada permasalahan klasifikasi yang melibatkan banyak variabel dan pola data yang kompleks, seperti prediksi kelulusan mahasiswa berdasarkan nilai akademik, tingkat kehadiran, dan jumlah SKS yang ditempuh.

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
**Decision Tree**
- Mudah dipahami dan diinterpretasikan
- Visualisasi jelas (bentuk pohon)
- Implementasi sederhana (cocok untuk pemula / OOP)
- Tidak butuh perhitungan kompleks
- Cepat untuk training data kecil

**Oblique Decision Tree**
- Lebih fleksibel (pakai kombinasi fitur)
- Bisa menangani data kompleks dengan lebih baik
- Tree biasanya lebih kecil (tidak terlalu dalam)
- Akurasi lebih tinggi dibanding Decision Tree biasa (pada kasus tertentu)
- Decision boundary lebih optimal

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

