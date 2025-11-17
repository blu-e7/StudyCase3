package Pethouse;

public class Transaksi {
    private Pelanggan pelanggan;
    private int total = 0;
    private String strukJasa = "";
    private String strukBarang = "";

    public Transaksi(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public int getTotal() {
        return total;
    }

    public void tambahItem(Produk produk, int jumlah) {
        int subtotal = produk.getHarga() * jumlah;
        this.total += subtotal;
        String itemStruk = produk.getNama() + " x" + jumlah + " = Rp " + subtotal + "\n";

        // Kita cek tipe produk langsung dari objeknya
        if (produk.getTipeProduk().equals("Jasa")) {
            strukJasa += itemStruk;
        } else {
            strukBarang += itemStruk;
        }

        System.out.println("Ditambahkan ke struk: " + produk.getNama() + " x" + jumlah + " = Rp " + subtotal);
        System.out.println();
    }

    public void cetakStruk() {
        String struk = "=============== STRUK ===============\n" +
                "Pelanggan: " + pelanggan.getNama() + "\n" +
                pelanggan.getDetail() + "\n\n" +
                "JASA:\n" + (strukJasa.isEmpty() ? "-\n" : strukJasa) + "\n" +
                "BARANG:\n" + (strukBarang.isEmpty() ? "-\n" : strukBarang);

        System.out.println(struk);

        double diskon = 0.0;
        // Logika diskon diganti menggunakan 'if' sederhana
        if (pelanggan.isMember()) {
            diskon = 0.1; // Diskon 10%
        }

        int totalAkhir = (int) (total * (1.0 - diskon));

        System.out.printf("Total: Rp%d\nDiskon: %.0f%c \nTotal Akhir: Rp%d",
                total, (diskon * 100), '%', totalAkhir);
        System.out.println("\n\nTerima kasih telah berkunjung ke PetShop!");
    }
}