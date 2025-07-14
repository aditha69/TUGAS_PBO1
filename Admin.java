import java.util.*;

public class Admin extends User {
    Admin(String u, String p) {
        super(u, p);
    }

    void menu(Scanner sc, List<Saham> sahamList, List<SuratBerhargaNegara> sbnList,
              Map<String, Map<String, Integer>> portfolioSaham,
              Map<String, Map<String, Double>> portfolioSBN) {
        while (true) {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Kelola Saham");
            System.out.println("2. Kelola SBN");
            System.out.println("3. Logout");
            System.out.print("Pilihan: ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("\n--- Kelola Saham ---");
                System.out.println("1. Tambah Saham");
                System.out.println("2. Ubah Harga Saham");
                System.out.println("3. Kembali");
                System.out.print("Pilihan: ");
                String sub = sc.nextLine();
                if (sub.equals("1")) {
                    System.out.print("Kode Saham: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama Perusahaan: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga: Rp ");
                    double harga = Double.parseDouble(sc.nextLine());
                    sahamList.add(new Saham(kode, nama, harga, ""));
                    System.out.println("Saham berhasil ditambahkan.");
                } else if (sub.equals("2")) {
                    System.out.println("\n--- Daftar Saham ---");
                    for (int i = 0; i < sahamList.size(); i++) {
                        System.out.println(i + ". " + sahamList.get(i));
                    }
                    System.out.print("Pilih indeks saham: ");
                    int idx = Integer.parseInt(sc.nextLine());
                    System.out.print("Harga baru: Rp ");
                    sahamList.get(idx).harga = Double.parseDouble(sc.nextLine());
                    System.out.println("Harga saham berhasil diperbarui.");
                }
            } else if (choice.equals("2")) {
                System.out.println("\n--- Kelola SBN ---");
                System.out.println("1. Tambah SBN");
                System.out.println("2. Kembali");
                System.out.print("Pilihan: ");
                String sub = sc.nextLine();
                if (sub.equals("1")) {
                    System.out.print("Nama SBN: ");
                    String nama = sc.nextLine();
                    System.out.print("Bunga (%): ");
                    double bunga = Double.parseDouble(sc.nextLine());
                    System.out.print("Jangka Waktu (tahun): ");
                    int waktu = Integer.parseInt(sc.nextLine());
                    System.out.print("Tanggal Jatuh Tempo (dd-mm-yyyy): ");
                    String tgl = sc.nextLine();
                    System.out.print("Kuota Nasional: Rp ");
                    double kuota = Double.parseDouble(sc.nextLine());
                    sbnList.add(new SuratBerhargaNegara(nama, bunga, waktu, tgl, kuota, ""));
                    System.out.println("SBN berhasil ditambahkan.");
                }
            } else {
                System.out.println("Logout...");
                break;
            }
        }
    }
}
