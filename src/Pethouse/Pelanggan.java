package Pethouse;

public class Pelanggan {
    // Attributes (Data)
    private String nama;
    private String nim;
    private String telepon;

    // Atribut ini menggantikan class Member
    private boolean isMember;
    private String password; // Akan null jika bukan member

    // Constructor untuk Non-Member
    public Pelanggan(String nama, String nim, String telepon) {
        this.nama = nama;
        this.nim = nim;
        this.telepon = telepon;
        this.isMember = false; // Jelas bahwa ini bukan member
    }

    // Constructor untuk Member
    public Pelanggan(String nama, String nim, String telepon, String password) {
        this.nama = nama;
        this.nim = nim;
        this.telepon = telepon;
        this.password = password;
        this.isMember = true; // Jelas bahwa ini adalah member
    }

    // Methods (Getters)
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public boolean isMember() {
        return isMember;
    }

    public String getDetail() {
        String status = isMember ? "Member" : "Non-Member";
        return "Nama: " + nama + " | NIM: " + nim + " | Status: " + status;
    }

    // Method khusus untuk login
    public boolean checkPassword(String inputPassword) {
        // Hanya cek password jika dia adalah member dan password-nya cocok
        if (this.isMember) {
            return this.password.equals(inputPassword);
        }
        return false;
    }
}
