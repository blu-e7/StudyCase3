package Pethouse;

public class Jasa implements Produk {
    private String nama;
    private int harga;

    public Jasa(String nama, int harga) {
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
