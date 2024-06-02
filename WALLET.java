
public class WALLET {

    private int idWallet;
    private double amount;

    public WALLET(int idWallet, double amount) {
        this.amount = amount;
        this.idWallet = idWallet;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public boolean reduceAmount(double amount) {
        if (this.amount < amount) {
            return false;
        }
        this.amount -= amount;
        return true;
    }

}
