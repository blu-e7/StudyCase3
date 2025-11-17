package Pethouse;

public class Barang implements Produk {
    private String nama;
    private int harga;

    public Barang(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public int getHarga() {
        return harga;
    }
}
