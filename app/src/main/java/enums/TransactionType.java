package enums;

/**
 * Created by user on 07/07/2017.
 */

public enum TransactionType {

    BUY("BUY"),
    SELL("SELL");

    private String friendlyName;

    private TransactionType(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override public String toString(){
        return friendlyName;
    }
}