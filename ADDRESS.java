
public class ADDRESS {

    private String address_name;
    private String address_number;
    private String zipCode;
    private String country;
    private int address_id;
    private String friendly_name;

    public ADDRESS(String address_name, String address_number, String zipCode, String country, int address_id,
            String friendly_name) {
        this.address_name = address_name;
        this.address_number = address_number;
        this.zipCode = zipCode;
        this.country = country;
        this.address_id = address_id;
        this.friendly_name = friendly_name;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getFriendly_name() {
        return friendly_name;
    }

    public void setFriendly_name(String friendly_name) {
        this.friendly_name = friendly_name;
    }

}
