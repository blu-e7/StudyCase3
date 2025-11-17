package Pethouse;

public class Member extends Pelanggan {
    private String password;

    public Member(String nama, String nim, String telepon, String password) {
        // Memanggil constructor dari kelas induk (Pelanggan)
        super(nama, nim, telepon);
        this.password = password;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    /**
     * Member mendapat diskon 10%.
     * @return 0.1 (10% diskon)
     */
    @Override
    public double getDiskon() {
        return 0.1;
    }

    @Override
    public String getDetail() {
        return super.getDetail() + " (Status: Member)";
    }
}