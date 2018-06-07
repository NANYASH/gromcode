package core.lesson30;


import java.util.ArrayList;
import java.util.List;

public class FirmDAO {
    private static List<Firm> firms = new ArrayList<>();

    public static Firm addFirm(Firm firm) {
        firms.add(firm);
        return firms.get(firms.indexOf(firm));
    }

    public static List<Firm> getFirms() {
        return firms;
    }

    public static void setFirms(List<Firm> firms) {
        FirmDAO.firms = firms;
    }
}
