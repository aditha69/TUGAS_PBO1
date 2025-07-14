import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Saham> sahamList = new ArrayList<>();
        List<SuratBerhargaNegara> sbnList = new ArrayList<>();
        Map<String, Map<String, Integer>> portfolioSaham = new HashMap<>();
        Map<String, Map<String, Double>> portfolioSBN = new HashMap<>();

        List<User> users = List.of(
                new Admin("admin", "admin123"),
                new Customer("krisna", "123"),
                new Customer("aditha", "123")
        );

        DummyData.isiDummy(sahamList, sbnList);

        while (true) {
            System.out.println("\n===== LOGIN =====");
            System.out.print("Username: ");
            String user = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();

            User current = null;
            for (User u : users) {
                if (u.username.equals(user) && u.password.equals(pass)) {
                    current = u;
                    break;
                }
            }

            if (current != null) {
                current.menu(sc, sahamList, sbnList, portfolioSaham, portfolioSBN);
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        }
    }
}
