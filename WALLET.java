public class WALLET {

    private int idWallet;
    private float amount;

    public WALLET(int idWallet, float amount) {
        this.amount = amount;
        this.idWallet = idWallet;
    }

    

    public int getIdWallet() {
        return idWallet;
    }



    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }



    public float getAmount() {
        return amount;
    }



    public void setAmount(float amount) {
        this.amount = amount;
    }



    public void addAmount(float amount) {
        this.amount += amount;
    }

    public void reduceAmount(float amount) {
        this.amount -= amount;
    }
    
}
