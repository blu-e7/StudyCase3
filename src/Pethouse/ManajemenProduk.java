package Pethouse;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ManajemenProduk {
    private List<Produk> daftarJasa = new ArrayList<>();
    private List<KategoriBarang> daftarKategoriBarang = new ArrayList<>();

    public ManajemenProduk() {
        initJasa();
        initBarang();
    }

    private void initJasa() {
        daftarJasa.add(new Produk("Grooming", 50000, "Jasa"));
        daftarJasa.add(new Produk("Vaksinasi", 75000, "Jasa"));
        daftarJasa.add(new Produk("Penitipan", 100000, "Jasa"));
        daftarJasa.add(new Produk("Klinik", 150000, "Jasa"));
        daftarJasa.add(new Produk("Pet training", 200000, "Jasa"));
        daftarJasa.add(new Produk("Layanan adopsi hewan", 300000, "Jasa"));
    }

    private void initBarang() {
        KategoriBarang rumah = new KategoriBarang("RUMAH HEWAN");
        rumah.addItem(new Produk("Kandang Anjing Standar", 1500000, "Barang"));
        rumah.addItem(new Produk("Kandang Anjing Besar", 2500000, "Barang"));
        rumah.addItem(new Produk("Kandang Kucing Standar", 250000, "Barang"));
        rumah.addItem(new Produk("Kandang Kucing Besar", 500000, "Barang"));
        daftarKategoriBarang.add(rumah);

        KategoriBarang makanan = new KategoriBarang("MAKANAN HEWAN");
        makanan.addItem(new Produk("Makanan Anjing", 90000, "Barang"));
        makanan.addItem(new Produk("Makanan Kucing", 30000, "Barang"));
        daftarKategoriBarang.add(makanan);

        KategoriBarang mainan = new KategoriBarang("MAINAN HEWAN");
        mainan.addItem(new Produk("Mainan Anjing", 120000, "Barang"));
        mainan.addItem(new Produk("Mainan Kucing", 70000, "Barang"));
        daftarKategoriBarang.add(mainan);

        KategoriBarang obat = new KategoriBarang("OBAT HEWAN");
        obat.addItem(new Produk("Obat Anjing", 400000, "Barang"));
        obat.addItem(new Produk("Obat Kucing", 90000, "Barang"));
        daftarKategoriBarang.add(obat);

        KategoriBarang kebutuhan = new KategoriBarang("BARANG KEBUTUHAN HEWAN");
        kebutuhan.addItem(new Produk("Collar", 10000, "Barang"));
        kebutuhan.addItem(new Produk("Tempat Makan", 30000, "Barang"));
        kebutuhan.addItem(new Produk("Tempat Minum", 46000, "Barang"));
        kebutuhan.addItem(new Produk("Sampo Anjing", 50000, "Barang"));
        kebutuhan.addItem(new Produk("Sampo Kucing", 50000, "Barang"));
        daftarKategoriBarang.add(kebutuhan);
    }

    public List<Produk> getDaftarJasa() {
        return daftarJasa;
    }

    public List<KategoriBarang> getDaftarKategoriBarang() {
        return daftarKategoriBarang;
    }
}