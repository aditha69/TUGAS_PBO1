import java.util.List;

public class DummyData {
    public static void isiDummy(List<Saham> sahamList, List<SuratBerhargaNegara> sbnList) {
        sahamList.add(new Saham("BBCA", "Bank BCA", 9000, ""));
        sahamList.add(new Saham("TLKM", "Telkom Indonesia", 4000, ""));
        sahamList.add(new Saham("ASII", "Astra International", 6000, ""));

        sbnList.add(new SuratBerhargaNegara("ORI023", 6.5, 3, "15-07-2027", 1000000000, ""));
        sbnList.add(new SuratBerhargaNegara("SR017", 6.1, 3, "10-03-2027", 500000000, ""));
    }
}
