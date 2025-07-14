import java.util.*;

public abstract class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    abstract void menu(Scanner sc, List<Saham> sahamList, List<SuratBerhargaNegara> sbnList,
                       Map<String, Map<String, Integer>> portfolioSaham,
                       Map<String, Map<String, Double>> portfolioSBN);
}
