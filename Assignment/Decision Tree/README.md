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

Meskipun memiliki struktur dasar yang sama, yaitu terdiri atas **Root Node**, **Internal Node**, dan **Leaf Node**, perbedaan utama antara Decision Tree dan Oblique Decision Tree terletak pada aturan pemisahan yang digunakan. Pada Decision Tree, sebuah node dapat menggunakan aturan sederhana seperti `Nilai > 75`, sedangkan pada Oblique Decision Tree aturan yang digunakan dapat berupa kombinasi beberapa atribut, misalnya `2 × Nilai + Kehadiran > 230`. Dengan mempertimbangkan beberapa atribut secara bersamaan, Oblique Decision Tree sering kali mampu menghasilkan struktur pohon yang lebih ringkas dan akurat dibandingkan Decision Tree tradisional.

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
- Status Kelulusan → digunakan sebagai label atau target klasifikasi yang akan dipelajari oleh model.

Data-data tersebut nantinya akan dianalisis oleh algoritma Decision Tree maupun Oblique Decision Tree untuk menemukan pola yang dapat digunakan dalam memprediksi status kelulusan mahasiswa baru. Sebagai contoh, mahasiswa dengan nilai tinggi dan kehadiran yang baik yang mencukupi umumnya memiliki peluang lebih besar untuk lulus dibandingkan mahasiswa yang memiliki nilai rendah dan tingkat kehadiran yang buruk. Berikut implementasi kodenya:
```java
class Mahasiswa {

    String nama;
    int nilai;
    int kehadiran;

    public Mahasiswa(String nama, int nilai, int kehadiran) {
        this.nama = nama;
        this.nilai = nilai;
        this.kehadiran = kehadiran;
    }
}
Scanner input = new Scanner(System.in);

System.out.print("Jumlah Mahasiswa : ");
int jumlah = input.nextInt();
input.nextLine();

Mahasiswa[] data = new Mahasiswa[jumlah];

for (int i = 0; i < jumlah; i++) {

    System.out.println("\nData Mahasiswa ke-" + (i + 1));

    System.out.print("Nama             : ");
    String nama = input.nextLine();

    System.out.print("Nilai            : ");
    int nilai = input.nextInt();

    System.out.print("Kehadiran        : ");
    int kehadiran = input.nextInt();
    input.nextLine();

    data[i] = new Mahasiswa(
            nama,
            nilai,
            kehadiran
    );
}
```

B. **Model Decision Tree dan Oblique Decision Tree**, Fitur ini digunakan untuk membangun model klasifikasi yang akan menentukan status kelulusan mahasiswa. Sistem menggunakan dua pendekatan yang berbeda, yaitu Decision Tree tradisional dan Oblique Decision Tree. Pada Decision Tree tradisional, proses pemisahan data dilakukan berdasarkan satu atribut pada setiap node. Dalam implementasi ini, atribut nilai digunakan sebagai root node, kemudian atribut kehadiran digunakan sebagai node berikutnya untuk menentukan status kelulusan. Sementara itu, Oblique Decision Tree menggunakan kombinasi beberapa atribut sekaligus dalam satu aturan pemisahan. Pada implementasi ini digunakan persamaan linear:
```java
2 × Nilai + Kehadiran > 230
```
Pendekatan tersebut memungkinkan model membentuk batas keputusan yang lebih fleksibel dibandingkan Decision Tree tradisional.Berikut implementasi kodenya:
```java
public static String decisionTree( // Decision Tree
        int nilai,
        int kehadiran
) {

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
public static String obliqueDecisionTree( // Oblique Decision Tree
        int nilai,
        int kehadiran
) {

    if ((2 * nilai) + kehadiran > 230) {
        return "Lulus";
    } else {
        return "Tidak Lulus";
    }
}
```

**C. Prediksi dan Perbandingan Kelulusan Mahasiswa**, fitur ini digunakan untuk melakukan prediksi status kelulusan mahasiswa menggunakan kedua model yang telah dibangun. Setiap data mahasiswa akan diproses oleh Decision Tree dan Oblique Decision Tree, kemudian hasil prediksi dari kedua metode ditampilkan secara berdampingan. Melalui fitur ini, pengguna dapat mengamati perbedaan hasil klasifikasi yang diberikan oleh kedua model. Perbandingan tersebut menjadi dasar untuk menganalisis efektivitas penggunaan split tunggal pada Decision Tree dan split multivariat pada Oblique Decision Tree. Berikut Implementasi kodenya:
```java
public static void tampilkanHasil(Mahasiswa m) {

    String hasilDecisionTree =
            decisionTree(
                    m.nilai,
                    m.kehadiran
            );

    String hasilOblique =
            obliqueDecisionTree(
                    m.nilai,
                    m.kehadiran
            );

    System.out.println("\n==============================");
    System.out.println("HASIL PREDIKSI MAHASISWA");
    System.out.println("==============================");

    System.out.println("Nama             : " + m.nama);
    System.out.println("Nilai            : " + m.nilai);
    System.out.println("Kehadiran        : " + m.kehadiran + "%");

    System.out.println("\nDecision Tree");
    System.out.println("Status           : " + hasilDecisionTree);

    System.out.println("\nOblique Decision Tree");
    System.out.println("Status           : " + hasilOblique);
}
for (Mahasiswa m : data) {
    tampilkanHasil(m);
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
- Tidak optimal untuk data yang kompleks
- Split terbatas hanya 1 fitur
- Akurasi Lebih rendah

**Oblique Decision Tree**
- Implementasi lebih sulit
- Perhitungan lebih kompleks
- Butuh effort lebih untuk memahami
  
## 7. Perbandingan Antara Tree Dasar dan Modifikasi Secara Teori

Berdasarkan pembahasan pada poin sebelumnya, **Decision Tree** dan **Oblique Decision Tree** memiliki perbedaan mendasar yang dapat dianalisis dari segi konsep, struktur, kemampuan representasi data, kompleksitas, serta kelebihan dan keterbatasannya dalam menyelesaikan permasalahan klasifikasi.

**A. Perbandingan Berdasarkan Konsep Dasar**

**Decision Tree** merupakan metode klasifikasi yang menggunakan pemisahan berbasis satu atribut (*axis-parallel split*) pada setiap node. Artinya, setiap proses pengambilan keputusan hanya mempertimbangkan satu variabel dalam satu waktu. Pendekatan ini membuat Decision Tree mudah dipahami dan diinterpretasikan karena setiap aturan keputusan dapat dibaca secara sederhana, misalnya `Nilai > 75`.

Sebaliknya, **Oblique Decision Tree** menggunakan pemisahan berbasis kombinasi beberapa atribut (*multivariate split*). Pemisahan dilakukan menggunakan fungsi linear yang melibatkan lebih dari satu variabel secara bersamaan, misalnya `2 × Nilai + Kehadiran > 230`. Dengan pendekatan ini, model mampu menangkap hubungan antar atribut yang tidak dapat direpresentasikan secara optimal oleh Decision Tree tradisional.

Perbedaan konsep ini menjelaskan mengapa Decision Tree kurang optimal pada data yang memiliki hubungan kompleks antar atribut, sedangkan Oblique Decision Tree mampu memberikan representasi yang lebih baik terhadap pola data tersebut.

**B. Perbandingan Berdasarkan Struktur Tree**

Dari sisi struktur, **Decision Tree** cenderung menghasilkan pohon yang lebih dalam (*deep tree*) dengan jumlah node yang lebih banyak. Hal ini terjadi karena proses pemisahan dilakukan secara bertahap menggunakan satu atribut pada setiap node. Akibatnya, diperlukan lebih banyak percabangan untuk mencapai hasil klasifikasi akhir.

Sebaliknya, **Oblique Decision Tree** umumnya menghasilkan pohon yang lebih dangkal (*shallow tree*) dengan jumlah node yang lebih sedikit. Karena setiap pemisahan dapat mempertimbangkan beberapa atribut sekaligus, proses klasifikasi dapat dilakukan dengan lebih efisien dalam jumlah langkah yang lebih sedikit.

Secara visual, perbedaan ini juga terlihat pada bentuk batas keputusan (*decision boundary*), yaitu:

- **Decision Tree** → batas keputusan berbentuk garis lurus (vertikal atau horizontal)
- **Oblique Decision Tree** → batas keputusan berbentuk garis miring yang lebih fleksibel

**C. Perbandingan Berdasarkan Kemampuan Representasi Data**

Dalam konteks prediksi kelulusan mahasiswa, kemampuan representasi data menjadi aspek yang sangat penting. **Decision Tree** hanya mampu memproses atribut secara terpisah, sehingga hubungan antar variabel seperti nilai akademik dan tingkat kehadiran tidak dapat dipertimbangkan secara langsung dalam satu keputusan.

Sebaliknya, **Oblique Decision Tree** mampu menggabungkan beberapa atribut dalam satu aturan pemisahan. Sebagai contoh, kombinasi nilai akademik dan kehadiran dapat digunakan secara bersamaan untuk menentukan kemungkinan kelulusan mahasiswa. Hal ini membuat model lebih representatif terhadap kondisi nyata, karena keputusan dalam dunia pendidikan umumnya dipengaruhi oleh banyak faktor secara simultan.

Dengan demikian, Oblique Decision Tree memiliki keunggulan dalam menangani data yang memiliki pola kompleks dan keterkaitan antar atribut yang kuat.

**D. Perbandingan Berdasarkan Kompleksitas**

Dari sisi kompleksitas, kedua metode memiliki karakteristik yang berbeda.

Pada **Decision Tree**, kompleksitas lebih dipengaruhi oleh:

- Kedalaman tree
- Jumlah node yang terbentuk
- Panjang jalur traversal menuju leaf node

Semakin besar struktur pohon, semakin panjang proses pengambilan keputusan yang harus dilakukan.

Sementara itu, pada **Oblique Decision Tree**, kompleksitas lebih dipengaruhi oleh:

- Perhitungan kombinasi linear pada setiap node
- Proses optimasi dalam menentukan hyperplane terbaik

Meskipun struktur pohonnya lebih kecil, proses komputasi pada setiap node menjadi lebih berat dibandingkan Decision Tree biasa.

Secara umum dapat disimpulkan bahwa:

- **Decision Tree** → sederhana pada setiap node, tetapi kompleks pada struktur pohon
- **Oblique Decision Tree** → kompleks pada setiap node, tetapi lebih sederhana pada struktur pohon

**E. Perbandingan Berdasarkan Kelebihan dan Kekurangan**

Setiap metode memiliki kelebihan dan kekurangan masing-masing.

**Decision Tree** unggul dalam:

- Kemudahan implementasi
- Interpretasi model yang sederhana
- Cocok digunakan untuk data dengan pola sederhana

Namun, metode ini memiliki keterbatasan dalam:

- Menangani data kompleks
- Merepresentasikan hubungan antar atribut
- Menjaga akurasi pada data multidimensi

Sementara itu, **Oblique Decision Tree** unggul dalam:

- Fleksibilitas model yang lebih tinggi
- Kemampuan menangani data kompleks
- Akurasi yang lebih baik pada kasus tertentu
- Struktur pohon yang lebih efisien

Namun, metode ini memiliki beberapa kekurangan, seperti:

- Implementasi yang lebih sulit
- Perhitungan yang lebih kompleks
- Interpretasi model yang lebih sulit dibandingkan Decision Tree tradisional

**Ringkasan Perbandingan**

| Aspek Perbandingan | Decision Tree | Oblique Decision Tree |
|---|---|---|
| **Konsep Dasar** | Menggunakan pemisahan berbasis satu atribut (*axis-parallel split*) pada setiap node | Menggunakan pemisahan berbasis kombinasi beberapa atribut (*multivariate split*) |
| **Aturan Pemisahan** | Contoh: `Nilai > 75` | Contoh: `2 × Nilai + Kehadiran > 230` |
| **Struktur Tree** | Cenderung lebih dalam (*deep*) dan memiliki lebih banyak node | Cenderung lebih dangkal (*shallow*) dan memiliki lebih sedikit node |
| **Decision Boundary** | Berbentuk garis lurus (vertikal atau horizontal) | Berbentuk garis miring (*oblique*) yang lebih fleksibel |
| **Representasi Data** | Sulit menangkap hubungan antar atribut secara langsung | Mampu merepresentasikan hubungan antar atribut dengan lebih baik |
| **Kemampuan pada Data Kompleks** | Kurang optimal | Lebih optimal |
| **Kompleksitas Struktur** | Lebih tinggi karena jumlah node lebih banyak | Lebih rendah karena struktur lebih ringkas |
| **Kompleksitas Perhitungan** | Lebih sederhana pada setiap node | Lebih kompleks karena memerlukan perhitungan kombinasi linear |
| **Kemudahan Implementasi** | Lebih mudah diimplementasikan | Lebih sulit diimplementasikan |
| **Interpretasi Model** | Lebih mudah dipahami | Lebih sulit dipahami |
| **Akurasi pada Kasus Kompleks** | Cenderung lebih rendah | Cenderung lebih tinggi |

Berdasarkan perbandingan tersebut, dapat disimpulkan bahwa **Decision Tree** lebih cocok digunakan pada data sederhana yang membutuhkan interpretasi yang mudah, sedangkan **Oblique Decision Tree** lebih sesuai untuk data kompleks yang membutuhkan akurasi lebih tinggi serta kemampuan menangkap hubungan antar variabel secara lebih optimal.

## 8. Analisis Kompleksitas Berdasarkan Struktur Tree 

**Decision Tree**

1. Analisis Struktur
   - menggunakan axis pararel split 1
   - perlu beberapa tahap keputusan sehingga dept bertambah, dan jumlah node
  
2. Kompleksitas
   - Training (Hitung entropy & information gain di setiap node)
   - Dilakukan berulang (rekusif)
    ```
     O(n log n)
    ```
   - Prediksi
     - Telusuri dari root ke leaf
    ```
    O(depth)
    ```

3. Kaitannya dengan Objek (Mahasiswa)

   Karena kelulusan dipengaruhi:
   - nilai
   - kehadiran
   - SKS
   Decision Tree:
   - memproses secara bertahap (tidak sekaligus)
   - menyebabkan:
      - pohon lebih dalam
      - proses lebih panjang

**Oblique Decision Tree**
Bedasarkan konsep Oblique menggunakan
```
2 × Nilai + Kehadiran > 230
```

1. Analisis Struktur
   - Menggunakan multivariate split
   - Bisa langsung menggabungkan beberapa atribut (sehingga depth lebih kecil,       node lebih sedikit)
2. Kompleksitas
   - Training (Mencari kombinasi atribut terbaik dan menghitung fungsi linear)
     ```c
      O(n × m) atau lebih tinggi
     ```
  Prediksi
  -  Setiap node
     ```
     2*nilai + kehadiran
     ```
  -  Kompleksitas
     ```
     O(depth × m)
     ```
3. Kaitannya dengan objek (Mahasiswa)
   
   Karena kelulusan = kombinasi faktor
   
   Oblique Tree:
    - langsung mempertimbangkan hubungan:
       - nilai + kehadiran + SKS
         
   sehingga:
    - tidak perlu banyak percabangan
    - tree lebih ringkas

**Kesimpulan**

Berdasarkan struktur tree yang dihasilkan pada implementasi, Decision Tree memiliki kompleksitas yang dipengaruhi oleh kedalaman pohon dan jumlah node yang relatif lebih besar akibat penggunaan pemisahan berbasis satu atribut. Hal ini menyebabkan proses prediksi menjadi lebih panjang pada data dengan banyak faktor seperti kelulusan mahasiswa.

Sebaliknya, Oblique Decision Tree mampu menghasilkan struktur pohon yang lebih dangkal dengan jumlah node yang lebih sedikit karena menggunakan kombinasi beberapa atribut dalam proses pemisahan. Namun, kompleksitas perhitungan pada setiap node menjadi lebih tinggi. Dengan demikian, terdapat trade-off antara kompleksitas struktur dan kompleksitas komputasi dalam kedua metode tersebut.

## 9. Potensi Pengembangan ke Depan 

Berdasarkan hasil analisis yang telah dilakukan, Decision Tree dan Oblique Decision Tree masih memiliki potensi untuk dikembangkan lebih lanjut agar mampu menghasilkan performa klasifikasi yang lebih baik.

Pada Decision Tree tradisional, pengembangan dapat dilakukan dengan menerapkan teknik pruning untuk mengurangi jumlah node yang tidak diperlukan. Dengan pruning, struktur pohon dapat menjadi lebih sederhana sehingga risiko overfitting dapat dikurangi. Selain itu, penggunaan dataset yang lebih besar juga dapat membantu model dalam menghasilkan pola klasifikasi yang lebih stabil.

Sementara itu, pada Oblique Decision Tree, pengembangan dapat difokuskan pada proses pencarian kombinasi atribut terbaik pada setiap node. Karena metode ini menggunakan multivariate split, proses perhitungannya cenderung lebih kompleks dibandingkan Decision Tree biasa. Oleh karena itu, diperlukan metode optimasi yang lebih efisien agar proses training dapat berjalan lebih cepat tanpa mengurangi akurasi model.

Dalam konteks prediksi kelulusan mahasiswa, sistem juga dapat dikembangkan dengan menambahkan atribut lain yang lebih beragam, seperti IPK, jumlah pengulangan mata kuliah, aktivitas organisasi, maupun hasil evaluasi dosen. Dengan data yang lebih lengkap, model diharapkan mampu menghasilkan prediksi yang lebih akurat dan sesuai dengan kondisi nyata mahasiswa.

Selain itu, implementasi sistem dapat dikembangkan menjadi aplikasi berbasis web atau dashboard interaktif sehingga proses prediksi dan evaluasi mahasiswa dapat dilakukan secara langsung oleh pihak akademik dengan lebih mudah dan efisien.

Dengan adanya pengembangan tersebut, Decision Tree dan Oblique Decision Tree diharapkan dapat digunakan secara lebih optimal dalam membantu proses pengambilan keputusan, khususnya pada bidang pendidikan.

## 10. Hasil Implementasi
<img width="274" height="1315" alt="WhatsApp Image 2026-05-25 at 14 36 17" src="https://github.com/user-attachments/assets/2328e9ff-229a-4148-9029-ec07845a2e09" />

## 11. Perbandingan performa real

Berdasarkan hasil implementasi yang telah dilakukan, Decision Tree dan Oblique Decision Tree menunjukkan perbedaan dalam proses klasifikasi data mahasiswa.

Pada Decision Tree tradisional, proses pengambilan keputusan dilakukan menggunakan satu atribut pada setiap node. Dalam implementasi yang dilakukan, mahasiswa dinyatakan lulus apabila memenuhi syarat nilai di atas 75 dan tingkat kehadiran di atas 80%.

Sementara itu, Oblique Decision Tree menggunakan kombinasi beberapa atribut secara bersamaan dalam proses pemisahan data. Pada implementasi ini digunakan persamaan:

```text
2 × Nilai + Kehadiran > 230
```
Hasil pengujian menunjukkan bahwa terdapat perbedaan hasil klasifikasi pada beberapa data mahasiswa.

Contoh hasil pengujian:

|Nama|	Decision Tree|	Oblique Decision Tree|
|---|---|---|
|Ciko|	Tidak Lulus|	Tidak Lulus|
|Najel| Tidak Lulus|	Lulus|
|Iqbal|	Tidak Lulus|	Tidak Lulus|
|Acha| Tidak Lulus| Lulus|

Pada kasus mahasiswa bernama Najel, Decision Tree menghasilkan status "Tidak Lulus" karena tingkat kehadiran berada di bawah batas minimum. Namun, Oblique Decision Tree menghasilkan status "Lulus" karena metode ini mempertimbangkan kombinasi nilai akademik dan kehadiran secara bersamaan.

Hal tersebut menunjukkan bahwa Oblique Decision Tree memiliki kemampuan yang lebih fleksibel dalam merepresentasikan hubungan antar atribut dibandingkan Decision Tree tradisional.

Selain itu, struktur keputusan pada Oblique Decision Tree cenderung lebih ringkas karena satu proses pemisahan dapat melibatkan beberapa atribut sekaligus. Namun, proses perhitungannya juga menjadi lebih kompleks dibandingkan Decision Tree biasa.
