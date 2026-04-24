package dto;

public class MemberDto {
    private int id;
    private String user_id;
    private int isadmin;
    private String name;
    private int balance;

    public MemberDto(int id, String user_id, int isadmin, String name, int balance) {
        this.id = id;
        this.user_id = user_id;
        this.isadmin = isadmin;
        this.name = name;
        this.balance = balance;
    }

    public MemberDto(String user_id, int isadmin, String name, int balance) {
        id = 0;
        this.user_id = user_id;
        this.isadmin = isadmin;
        this.name = name;
        this.balance = balance;
    }

    public MemberDto() {}

    public int getId() {
        return id;
    }

    public String getUserId() {
        return user_id;
    }
    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public int getIsAdmin() {
        return isadmin;
    }
    public void setIsAdmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }
    public void addBalance(int money) {
        balance += money;
    }
}
