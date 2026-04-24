package state;

public class MemberInfoDto {
    private int id;
    private String user_id;
    private String password;
    private String name;
    private String tel;
    private int balance;
    private String card_num;
    private int isadmin;

    public MemberInfoDto(int id, String user_id, String password, String name, String tel, int balance, String card_num, int isadmin) {
        this.id = id;
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.balance = balance;
        this.card_num = card_num;
        this.isadmin = isadmin;
    }

    public MemberInfoDto(String user_id, String password, String name, String tel, int balance, String card_num, int isadmin) {
        id = 0;
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.balance = balance;
        this.card_num = card_num;
        this.isadmin = isadmin;
    }

    public MemberInfoDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public void setCardNum(String card_num) {
        this.card_num = card_num;
    }

    protected boolean passCompare(String pass) {
        boolean result = false;
        if (pass == password) {
            result = true;
        }
        return result;
    }
}


