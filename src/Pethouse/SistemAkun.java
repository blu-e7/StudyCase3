package Pethouse;

import java.util.Scanner;

public class SistemAkun {
    private Pelanggan member;
    private boolean punyaAkun = false;
    private Scanner sc;

    public SistemAkun(Scanner scanner) {
        this.sc = scanner;
    }

    public boolean isPunyaAkun() {
        return punyaAkun;
    }

    public void registrasi() {
        System.out.println("\n--- Registrasi Member ---");
        System.out.print("Masukkan NIM       : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama      : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Password  : ");
        String password = sc.nextLine();
        System.out.print("Masukkan No. HP    : ");
        String telepon = sc.nextLine();

        this.member = new Pelanggan(nama, nim, telepon, password);
        this.punyaAkun = true;
        System.out.println("\n>>> Registrasi Member Berhasil!");
        System.out.println(member.getDetail());
    }

    public Pelanggan login() {
        System.out.println("\n--- Login Member ---");
        System.out.print("Masukkan Nama/NIM : ");
        String loginNama = sc.nextLine();
        System.out.print("Masukkan Password : ");
        String loginPass = sc.nextLine();

        if (punyaAkun && (loginNama.equals(member.getNama()) || loginNama.equals(member.getNim())) && member.checkPassword(loginPass)) {
            System.out.println("\n>>> Login Berhasil! Selamat datang, " + member.getNama());
            System.out.println(member.getDetail());
            System.out.println("Anda mendapatkan diskon 10% untuk setiap transaksi!");
            return member;
        } else {
            System.out.println("\nLogin gagal! Nama/NIM atau Password salah.");
            return null;
        }
    }

    public Pelanggan buatNonMember() {
        System.out.println("\n--- Data Non Member ---");
        System.out.print("Masukkan Nama        : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NIM         : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan No. Telepon : ");
        String telp = sc.nextLine();

        Pelanggan nonMember = new Pelanggan(nama, nim, telp);
        System.out.println("\n>>> Data Non Member Berhasil Disimpan!");
        System.out.println(nonMember.getDetail());
        return nonMember;
    }
}