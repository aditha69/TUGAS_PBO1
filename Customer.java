import java.util.*;

public class Customer extends User {
    Customer(String u, String p) {
        super(u, p);
    }

    void menu(Scanner sc, List<Saham> sahamList, List<SuratBerhargaNegara> sbnList,
              Map<String, Map<String, Integer>> portfolioSaham,
              Map<String, Map<String, Double>> portfolioSBN) {
        while (true) {
            System.out.println("\n===== Menu Customer =====");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Lihat Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilihan: ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("\n--- Daftar Saham ---");
                for (int i = 0; i < sahamList.size(); i++) {
                    System.out.println(i + ". " + sahamList.get(i));
                }
                System.out.print("Pilih indeks saham: ");
                int idx = Integer.parseInt(sc.nextLine());
                System.out.print("Jumlah lembar: ");
                int jumlah = Integer.parseInt(sc.nextLine());
                portfolioSaham.computeIfAbsent(username, k -> new HashMap<>())
                        .merge(sahamList.get(idx).kode, jumlah, Integer::sum);
                System.out.println("Pembelian saham berhasil.");
            } else if (choice.equals("2")) {
                Map<String, Integer> userSaham = portfolioSaham.getOrDefault(username, new HashMap<>());
                if (userSaham.isEmpty()) {
                    System.out.println("Belum memiliki saham.");
                    continue;
                }
                System.out.println("\n--- Portofolio Saham ---");
                List<String> keys = new ArrayList<>(userSaham.keySet());
                for (int i = 0; i < keys.size(); i++) {
                    String kode = keys.get(i);
                    System.out.println(i + ". " + kode + " - " + userSaham.get(kode) + " lembar");
                }
                System.out.print("Pilih indeks saham: ");
                int idx = Integer.parseInt(sc.nextLine());
                System.out.print("Jumlah jual: ");
                int jumlah = Integer.parseInt(sc.nextLine());
                String kode = keys.get(idx);
                if (userSaham.get(kode) < jumlah) {
                    System.out.println("Gagal: jumlah melebihi kepemilikan.");
                } else {
                    userSaham.put(kode, userSaham.get(kode) - jumlah);
                    if (userSaham.get(kode) == 0) userSaham.remove(kode);
                    System.out.println("Penjualan saham berhasil.");
                }
            } else if (choice.equals("3")) {
                System.out.println("\n--- Daftar SBN ---");
                for (int i = 0; i < sbnList.size(); i++) {
                    System.out.println(i + ". " + sbnList.get(i));
                }
                System.out.print("Pilih indeks SBN: ");
                int idx = Integer.parseInt(sc.nextLine());
                System.out.print("Nominal beli: Rp ");
                double nominal = Double.parseDouble(sc.nextLine());
                SuratBerhargaNegara sbn = sbnList.get(idx);
                if (sbn.kuotaNasional < nominal) {
                    System.out.println("Gagal: kuota tidak cukup.");
                } else {
                    sbn.kuotaNasional -= nominal;
                    portfolioSBN.computeIfAbsent(username, k -> new HashMap<>())
                            .merge(sbn.nama, nominal, Double::sum);
                    System.out.println("Pembelian SBN berhasil.");
                }
            } else if (choice.equals("4")) {
                System.out.println("\n--- Simulasi Kupon SBN ---");
                for (SuratBerhargaNegara sbn : sbnList) {
                    double nominal = portfolioSBN.getOrDefault(username, new HashMap<>())
                            .getOrDefault(sbn.nama, 0.0);
                    if (nominal > 0) {
                        double bungaPerBulan = sbn.bunga / 12.0 / 100.0 * 0.9 * nominal;
                        System.out.println(sbn.nama + ": Kupon/Bulan: Rp " + bungaPerBulan);
                    }
                }
            } else if (choice.equals("5")) {
                System.out.println("\n--- Portofolio Anda ---");
                System.out.println(">> Saham:");
                Map<String, Integer> userSaham = portfolioSaham.getOrDefault(username, new HashMap<>());
                for (Map.Entry<String, Integer> e : userSaham.entrySet()) {
                    Saham s = sahamList.stream().filter(x -> x.kode.equals(e.getKey())).findFirst().orElse(null);
                    if (s != null) {
                        double nilai = s.harga * e.getValue();
                        System.out.println("- " + s.kode + " (" + s.namaPerusahaan + "): " + e.getValue() + " lembar, Nilai Pasar: Rp " + nilai);
                    }
                }

                System.out.println("\n>> SBN:");
                Map<String, Double> userSBN = portfolioSBN.getOrDefault(username, new HashMap<>());
                for (Map.Entry<String, Double> e : userSBN.entrySet()) {
                    SuratBerhargaNegara sbn = sbnList.stream().filter(x -> x.nama.equals(e.getKey())).findFirst().orElse(null);
                    if (sbn != null) {
                        double bungaPerBulan = sbn.bunga / 12.0 / 100.0 * 0.9 * e.getValue();
                        System.out.println("- " + sbn.nama + ": Rp " + e.getValue() + ", Kupon/bulan: Rp " + bungaPerBulan);
                    }
                }
            } else {
                System.out.println("Logout...");
                break;
            }
        }
    }
}
