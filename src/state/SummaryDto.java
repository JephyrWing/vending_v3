package state;

public class SummaryDto {
    private String user_id;
    private String name;
    private int totalpurchase;
    private int balance;

    public SummaryDto(String user_id, String name, int totalpurchase, int balance) {
        this.user_id = user_id;
        this.name = name;
        this.totalpurchase = totalpurchase;
        this.balance = balance;
    }
    public SummaryDto() {
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTotalpurchase() {
        return totalpurchase;
    }
    public void setTotalpurchase(int totalpurchase) {
        this.totalpurchase = totalpurchase;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}


