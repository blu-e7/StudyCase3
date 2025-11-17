package Pethouse;

import java.util.ArrayList;
import java.util.List;

public class ManajemenProduk {
    private List<Jasa> daftarJasa = new ArrayList<>();
    private List<KategoriBarang> daftarKategoriBarang = new ArrayList<>();

    // Constructor ini langsung mengisi data produk saat objek dibuat
    public ManajemenProduk() {
        initJasa();
        initBarang();
    }

    private void initJasa() {
        daftarJasa.add(new Jasa("Grooming", 50000));
        daftarJasa.add(new Jasa("Vaksinasi", 75000));
        daftarJasa.add(new Jasa("Penitipan", 100000));
        daftarJasa.add(new Jasa("Klinik", 150000));
        daftarJasa.add(new Jasa("Pet training", 200000));
        daftarJasa.add(new Jasa("Layanan adopsi hewan", 300000));
    }

    private void initBarang() {
        // Kategori 1: Rumah Hewan
        KategoriBarang rumah = new KategoriBarang("RUMAH HEWAN");
        rumah.addItem(new Barang("Kandang Anjing Standar", 1500000));
        rumah.addItem(new Barang("Kandang Anjing Besar", 2500000));
        rumah.addItem(new Barang("Kandang Kucing Standar", 250000));
        rumah.addItem(new Barang("Kandang Kucing Besar", 500000));
        daftarKategoriBarang.add(rumah);

        // Kategori 2: Makanan Hewan
        KategoriBarang makanan = new KategoriBarang("MAKANAN HEWAN");
        makanan.addItem(new Barang("Makanan Anjing", 90000));
        makanan.addItem(new Barang("Makanan Kucing", 30000));
        daftarKategoriBarang.add(makanan);

        // Kategori 3: Mainan Hewan
        KategoriBarang mainan = new KategoriBarang("MAINAN HEWAN");
        mainan.addItem(new Barang("Mainan Anjing", 120000));
        mainan.addItem(new Barang("Mainan Kucing", 70000));
        daftarKategoriBarang.add(mainan);

        // Kategori 4: Obat Hewan
        KategoriBarang obat = new KategoriBarang("OBAT HEWAN");
        obat.addItem(new Barang("Obat Anjing", 400000));
        obat.addItem(new Barang("Obat Kucing", 90000));
        daftarKategoriBarang.add(obat);

        // Kategori 5: Kebutuhan Hewan
        KategoriBarang kebutuhan = new KategoriBarang("BARANG KEBUTUHAN HEWAN");
        kebutuhan.addItem(new Barang("Collar", 10000));
        kebutuhan.addItem(new Barang("Tempat Makan", 30000));
        kebutuhan.addItem(new Barang("Tempat Minum", 46000));
        kebutuhan.addItem(new Barang("Sampo Anjing", 50000));
        kebutuhan.addItem(new Barang("Sampo Kucing", 50000));
        daftarKategoriBarang.add(kebutuhan);
    }

    public List<Jasa> getDaftarJasa() {
        return daftarJasa;
    }

    public List<KategoriBarang> getDaftarKategoriBarang() {
        return daftarKategoriBarang;
    }
}
