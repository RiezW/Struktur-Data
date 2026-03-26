import java.util.Scanner;

class Kos {
    protected String namaKos;
    protected int totalKamar;
    protected int kamarTerisi;
    protected double rating;
    protected double harga;

    public Kos(String namaKos, int totalKamar, int kamarTerisi, double rating, double harga) {
        this.namaKos = namaKos;
        this.totalKamar = totalKamar;
        this.kamarTerisi = kamarTerisi;
        this.rating = rating;
        this.harga = harga;
    }

    public int getKamarKosong() {
        return totalKamar - kamarTerisi;
    }

    public boolean isPenuh() {
        return kamarTerisi >= totalKamar;
    }

    public double hitungSkor() {
        return (getKamarKosong() * 2) + rating - (harga / 1000000);
    }

    public void sewaKamar() {
        if (!isPenuh()) {
            kamarTerisi++;
            System.out.println("Kamar berhasil dipesan!");
        } else {
            System.out.println("Maaf, kos sudah penuh.");
        }
    }

    public void displayInformation() {
        System.out.println("Nama Kos    : " + namaKos);
        if (this instanceof KosPremium) {
            System.out.println("Tipe        : Premium");
        } 
        else {
            System.out.println("Tipe        : Regular");
        }
        System.out.println("Sisa Kamar  : " + getKamarKosong());
        System.out.println("Rating      : " + rating);
        System.out.println("Harga       : " + harga);
        System.out.println("Status      : " + (isPenuh() ? "Penuh" : "Tersedia"));
        System.out.println("-------------------------");
    }
}

class KosPremium extends Kos {
    public KosPremium(String namaKos, int totalKamar, int kamarTerisi, double rating, double harga) {
        super(namaKos, totalKamar, kamarTerisi, rating, harga);
    }

    @Override
    public double hitungSkor() {
        return super.hitungSkor() + 2;
    }
}

class KosManager {
    private Kos[] daftarKos = new Kos[100];
    private int jumlahKos = 0;

    public void tambahKos(Kos k) {
        daftarKos[jumlahKos] = k;
        jumlahKos++;
    }

    public void tampilkanSemuaKos() {
        System.out.println("\n=== DAFTAR KOS ===");
        for (int i = 0; i < jumlahKos; i++) {
            System.out.println("No " + (i + 1));
            daftarKos[i].displayInformation();
        }
    }

    public void urutkanRating() {
        for (int i = 0; i < jumlahKos; i++) {
            for (int j = i + 1; j < jumlahKos; j++) {
                if (daftarKos[i].rating < daftarKos[j].rating) {
                    Kos temp = daftarKos[i];
                    daftarKos[i] = daftarKos[j];
                    daftarKos[j] = temp;
                }
            }
        }

        System.out.println("\n=== URUT BERDASARKAN RATING ===");
        tampilkanSemuaKos();
    }

    public void urutkanHarga() {
        for (int i = 0; i < jumlahKos; i++) {
            for (int j = i + 1; j < jumlahKos; j++) {
                if (daftarKos[i].harga > daftarKos[j].harga) {
                    Kos temp = daftarKos[i];
                    daftarKos[i] = daftarKos[j];
                    daftarKos[j] = temp;
                }
            }
        }

        System.out.println("\n=== URUT BERDASARKAN HARGA ===");
        tampilkanSemuaKos();
    }

    public void tampilkanRekomendasi() {
        for (int i = 0; i < jumlahKos; i++) {
            for (int j = i + 1; j < jumlahKos; j++) {
                if (daftarKos[i].hitungSkor() < daftarKos[j].hitungSkor()) {
                    Kos temp = daftarKos[i];
                    daftarKos[i] = daftarKos[j];
                    daftarKos[j] = temp;
                }
            }
        }

        System.out.println("\n=== REKOMENDASI KOS TERBAIK ===");

        int batas = (jumlahKos < 3) ? jumlahKos : 3;

        for (int i = 0; i < batas; i++) {
            daftarKos[i].displayInformation();
        }
    }

    public void reservasiKos(int index) {
        if (index >= 0 && index < jumlahKos) {
            daftarKos[index].sewaKamar();
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        KosManager manager = new KosManager();

        manager.tambahKos(new Kos("Kos Mawar", 10, 8, 4.5, 1000000));
        manager.tambahKos(new KosPremium("Kos Melati", 8, 5, 4.8, 1500000));
        manager.tambahKos(new Kos("Kos Anggrek", 6, 6, 4.0, 900000));
        manager.tambahKos(new Kos("Kos Sakura", 12, 7, 4.7, 1200000));
        manager.tambahKos(new KosPremium("Kos Lavender", 10, 6, 4.9, 2000000));

        int pilihan;

        do {

            System.out.println("\n=== MENU SISTEM KOS ===");
            System.out.println("1. Tampilkan Semua Kos");
            System.out.println("2. Urutkan Berdasarkan Rating");
            System.out.println("3. Urutkan Berdasarkan Harga");
            System.out.println("4. Rekomendasi Kos Terbaik");
            System.out.println("5. Reservasi Kos");
            System.out.println("6. Keluar");
            System.out.print("Pilih : ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    manager.tampilkanSemuaKos();
                    break;
                case 2:
                    manager.urutkanRating();
                    break;
                case 3:
                    manager.urutkanHarga();
                    break;
                case 4:
                    manager.tampilkanRekomendasi();
                    break;
                case 5:
                    manager.tampilkanSemuaKos();
                    System.out.print("Pilih nomor kos yang ingin dipesan: ");
                    input.nextLine();
                    int pilihKos = Integer.parseInt(input.nextLine());
                    manager.reservasiKos(pilihKos - 1);
                    break;
                case 6:
                    System.out.println("Terima Kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);

        input.close();

    }
}
