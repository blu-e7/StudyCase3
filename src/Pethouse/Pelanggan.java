package Pethouse;

public class Pelanggan {
    protected String nama;
    protected String nim;
    protected String telepon;

    public Pelanggan(String nama, String nim, String telepon) {
        this.nama = nama;
        this.nim = nim;
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public String getDetail() {
        return "Nama: " + nama + " | NIM: " + nim + " | Telepon: " + telepon;
    }

    /**
     * Member biasa tidak mendapat diskon.
     * @return 0.0 (0% diskon)
     */
    public double getDiskon() {
        return 0.0;
    }
}
