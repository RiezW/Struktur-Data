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

    Pada penelitian ini, digunakan contoh data mahasiswa yang terdiri dari beberapa atribut, yaitu nilai akademik, tingkat kehadiran, dan jumlah SKS yang diambil. Data tersebut digunakan untuk menentukan status kelulusan mahasiswa.

    Contoh dataset:

    | Nilai | Kehadiran (%) | Jumlah SKS | Status |
    |---|---|---|---|
    | 85 | 90 | 24 | Lulus |
    | 78 | 82 | 22 | Lulus |
    | 60 | 70 | 18 | Tidak Lulus |
    | 72 | 75 | 20 | Tidak Lulus |
    | 88 | 95 | 24 | Lulus |

    Visualisasi data dapat direpresentasikan menggunakan scatter plot dengan:
    - Sumbu X = Nilai Akademik
    - Sumbu Y = Kehadiran
    - Titik biru = Mahasiswa lulus
    - Titik merah = Mahasiswa tidak lulus

    Visualisasi ini menunjukkan bahwa data tidak selalu dapat dipisahkan secara optimal hanya dengan satu atribut saja.

2. Visualisasi Decision Tree Tradisional

    Decision Tree tradisional bekerja dengan melakukan pemisahan data menggunakan satu atribut pada setiap node.

    Contoh struktur Decision Tree:

    ```text
                    Nilai > 75?
                    /          \
                Ya            Tidak
            Kehadiran >80?    Tidak Lulus
                /      \
            Ya         Tidak
        Lulus      Tidak Lulus
    ````

    Pada struktur tersebut:

    * Root node digunakan sebagai keputusan awal.
    * Internal node digunakan untuk proses pemisahan data.
    * Leaf node digunakan untuk menentukan hasil klasifikasi akhir.

    Decision Tree tradisional menggunakan axis-parallel split, yaitu pemisahan berdasarkan satu atribut dalam satu waktu.

3. Visualisasi Decision Boundary pada Decision Tree

    Pada Decision Tree tradisional, batas keputusan (decision boundary) berbentuk garis vertikal atau horizontal karena pemisahan hanya dilakukan berdasarkan satu atribut.

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

    Keterbatasan pendekatan ini adalah model sulit merepresentasikan hubungan antar atribut yang kompleks.

4. Visualisasi Oblique Decision Tree

    Oblique Decision Tree menggunakan multivariate split, yaitu pemisahan berdasarkan kombinasi beberapa atribut sekaligus.

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

    Dengan pendekatan ini, model mampu membentuk decision boundary yang lebih fleksibel dibandingkan Decision Tree tradisional.
## 4. Aplikasi Struktur Tree
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

