package enums;

/**
 * Created by user on 09/07/2017.
 */

public enum CurrencyName {

    BITCOIN("BITCOIN"),
    MONERO("MONERO"),
    LITECOIN("LITECOIN"),
    ETHEREUM("ETHEREUM"),
    MAIDSAFE("MAIDSAFE"),
    UBIQ("UBIQ"),
    RIPPLE("RIPPLE");

    private String friendlyName;

    private CurrencyName(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override public String toString(){
        return friendlyName;
    }

}