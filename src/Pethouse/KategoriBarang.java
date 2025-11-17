package Pethouse;

import java.util.ArrayList;
import java.util.List;

public class KategoriBarang {
    private String namaKategori;
    private List<Barang> items;

    public KategoriBarang(String namaKategori) {
        this.namaKategori = namaKategori;
        this.items = new ArrayList<>();
    }

    public void addItem(Barang barang) {
        this.items.add(barang);
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public List<Barang> getItems() {
        return items;
    }

    public void displayItems() {
        System.out.println("\n" + this.namaKategori);
        System.out.println("Q. Kembali");
        for (int i = 0; i < items.size(); i++) {
            Barang item = items.get(i);
            System.out.printf("%d. %-30s (Rp%d)\n", i + 1, item.getNama(), item.getHarga());
        }
    }
}
