package Pethouse;

public class Produk {

    // Attributes (Data)
    private String nama;
    private int harga;
    private String tipeProduk; // "Jasa" atau "Barang"

    // Constructor
    public Produk(String nama, int harga, String tipeProduk) {
        this.nama = nama;
        this.harga = harga;
        this.tipeProduk = tipeProduk;
    }

    // Methods (Getters)
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getTipeProduk() {
        return tipeProduk;
    }
}
