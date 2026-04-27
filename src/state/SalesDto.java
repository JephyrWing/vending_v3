package state;

public class SalesDto {
    private int id;
    private int member_id;
    private int menu_id;
    private int price;
    private String sold_at;


    public SalesDto(int id, int member_id, int menu_id, int price, String sold_at) {
        this.id = id;
        this.member_id = member_id;
        this.menu_id = menu_id;
        this.price = price;
        this.sold_at = sold_at;
    }

    public SalesDto(int member_id, int menu_id, int price, String sold_at) {
        id = 0;
        this.member_id = member_id;
        this.menu_id = menu_id;
        this.price = price;
        this.sold_at = sold_at;
    }

    public SalesDto() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getMenuId() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSoldAt() {
        return sold_at;
    }

    public void setSold_at(String sold_at) {
        this.sold_at = sold_at;
    }

}
