public class Saham {
    String kode;
    String namaPerusahaan;
    double harga;
    String gambar;

    Saham(String kode, String nama, double harga, String gambar) {
        this.kode = kode;
        this.namaPerusahaan = nama;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String toString() {
        return kode + " - " + namaPerusahaan + " (Rp " + harga + ")";
    }
}
