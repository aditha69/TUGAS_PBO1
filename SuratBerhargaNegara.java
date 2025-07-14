public class SuratBerhargaNegara {
    String nama;
    double bunga;
    int jangkaWaktu;
    String tanggalJatuhTempo;
    double kuotaNasional;
    String gambar;

    SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggal, double kuota, String gambar) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggal;
        this.kuotaNasional = kuota;
        this.gambar = gambar;
    }

    public String toString() {
        return nama + " - Bunga: " + bunga + "% - Kuota: Rp " + kuotaNasional;
    }
}
