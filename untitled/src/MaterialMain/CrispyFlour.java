package MaterialMain;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount{



    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public CrispyFlour(int id, String bột_chiên4, String s, int cost, int quantity) {
    }


    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                '}';
    }

    @Override
    public double getRealMoney() {
        return 0;
    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }
}
