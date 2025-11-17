package Pethouse;

import java.util.List;
import java.util.Scanner;

public class PetShopApp {
    private Scanner sc;
    private SistemAkun sistemAkun;
    private ManajemenProduk manajemenProduk;
    private Transaksi transaksi;
    private Pelanggan pelangganSaatIni;

    public PetShopApp() {
        this.sc = new Scanner(System.in);
        this.sistemAkun = new SistemAkun(sc);
        this.manajemenProduk = new ManajemenProduk();
    }

    public static void main(String[] args) {
        PetShopApp app = new PetShopApp();
        app.run();
    }

    public void run() {
        menuLogin();

        if (pelangganSaatIni != null) {
            this.transaksi = new Transaksi(pelangganSaatIni);
            System.out.println("\n===== Selamat Datang di PetShop =====");
            menuUtama();
        }
    }

    // ========== LOGIN ===========
    public void menuLogin() {
        System.out.println("\n===== System Login PetShop =====");
        System.out.println("1. Member");
        System.out.println("2. Non Member");
        System.out.println("Q. Keluar");
        System.out.print("\nMasukkan pilihan Anda: ");
        char pilihan = sc.next().charAt(0);
        sc.nextLine(); // membersihkan newline

        switch (pilihan) {
            case '1' -> {
                if (!sistemAkun.isPunyaAkun()) {
                    sistemAkun.registrasi();
                    menuLogin();
                } else {
                    pelangganSaatIni = sistemAkun.login();
                    if (pelangganSaatIni == null) {
                        menuLogin();
                    }
                }
            }
            case '2' -> {
                pelangganSaatIni = sistemAkun.buatNonMember();
            }
            case 'Q', 'q' -> {
                System.out.println("\nTerima kasih telah berkunjung ke PetShop!");
                pelangganSaatIni = null;
            }
            default -> {
                System.out.println("\nPilihan tidak valid, silakan coba lagi.");
                menuLogin();
            }
        }
    }

    // ============= MAIN MENU ================
    public void menuUtama() {
        System.out.println("\n===== Menu Utama =====");
        System.out.println("Q. Keluar dan cetak struk");
        System.out.println("1. Jasa");
        System.out.println("2. Barang");
        System.out.println("\nTagihan Anda: Rp" + transaksi.getTotal());

        System.out.print("Masukkan pilihan anda: ");
        char pilihan = sc.next().charAt(0);

        switch (pilihan) {
            case '1' -> menuJasa();
            case '2' -> menuBarang();
            case 'Q', 'q' -> transaksi.cetakStruk();
            default -> {
                System.out.println("PILIHAN INVALID.");
                menuUtama();
            }
        }
    }

    // ================ JASA =================
    public void menuJasa() {
        System.out.println("======================");
        System.out.println("     PESAN JASA");
        System.out.println("======================");
        System.out.println("Q. Kembali");

        List<Produk> daftarJasa = manajemenProduk.getDaftarJasa();
        for (int i = 0; i < daftarJasa.size(); i++) {
            Produk jasa = daftarJasa.get(i);
            System.out.printf("%d. %-25s (Rp %d)\n", i + 1, jasa.getNama(), jasa.getHarga());
        }

        System.out.print("\nMasukkan pilihan anda: ");
        char pilihan = sc.next().charAt(0);
        int pilihanindex = pilihan - '1';

        if (pilihan == 'q' || pilihan == 'Q') {
            menuUtama();
        } else if (pilihanindex >= 0 && pilihanindex < daftarJasa.size()) {
            Produk jasaDipilih = daftarJasa.get(pilihanindex);
            System.out.print("Masukkan jumlah hewan untuk " + jasaDipilih.getNama() + ": ");
            int jumlah = sc.nextInt();

            transaksi.tambahItem(jasaDipilih, jumlah); // Panggilan disederhanakan

            menuJasa();
        } else {
            System.out.println("PILIHAN INVALID.");
            menuJasa();
        }
    }

    // ===================== BARANG ==========================
    public void menuBarang() {
        System.out.println("=======================");
        System.out.println("     DAFTAR BARANG     ");
        System.out.println("=======================");
        System.out.println("Q. Kembali");

        List<KategoriBarang> daftarKategori = manajemenProduk.getDaftarKategoriBarang();
        for (int i = 0; i < daftarKategori.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKategori.get(i).getNamaKategori());
        }

        System.out.print("\nMasukkan input: ");
        char pilihan = sc.next().charAt(0);
        int pilihanindex = pilihan - '1';

        if (pilihan == 'Q' || pilihan == 'q') {
            menuUtama();
        } else if (pilihanindex >= 0 && pilihanindex < daftarKategori.size()) {
            menuDetailBarang(daftarKategori.get(pilihanindex));
        } else {
            System.out.println("PILIHAN INVALID.");
            menuBarang();
        }
    }

    public void menuDetailBarang(KategoriBarang kategori) {
        kategori.displayItems();
        System.out.print("\nMasukkan input: ");
        char pilihan2 = sc.next().charAt(0);
        int pilihan2index = pilihan2 - '1';

        if (pilihan2 == 'Q' || pilihan2 == 'q') {
            menuBarang();
        } else if (pilihan2index >= 0 && pilihan2index < kategori.getItems().size()) {
            Produk barangDipilih = kategori.getItems().get(pilihan2index);
            System.out.print("Masukkan jumlah " + barangDipilih.getNama() + " yang ingin dibeli: ");
            int jumlah = sc.nextInt();

            transaksi.tambahItem(barangDipilih, jumlah); // Panggilan disederhanakan

            menuBarang();
        } else {
            System.out.println("PILIHAN INVALID.");
            menuDetailBarang(kategori);
        }
    }
}