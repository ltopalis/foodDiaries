
abstract class PERSON {

    protected String name;
    protected String lastname;
    protected String Email;
    protected String Password;
    protected String phone_number;
    protected WALLET wallet;
    protected ADDRESS address;

    public PERSON(String name, String lastname, String Email, String Password, String phone_number, float amount, int idWallet, String address_name, String address_number, String zipCode, String country, int address_id,
            String friendly_name) {
        this.name = name;
        this.lastname = lastname;
        this.Email = Email;
        this.Password = Password;
        this.phone_number = phone_number;
        this.wallet = new WALLET(idWallet, amount);
        this.address = new ADDRESS(address_name, address_number, zipCode, country, address_id, friendly_name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public WALLET getWallet() {
        return wallet;
    }

    public void setWallet(WALLET wallet) {
        this.wallet = wallet;
    }

    public Boolean transaction(PERSON receiver, float amount) {

        if (this.wallet.getAmount() >= amount) {

            receiver.getWallet().addAmount(amount);
            this.wallet.reduceAmount(amount);

            return true;

        } else {
            return false;
        }

    }

}
