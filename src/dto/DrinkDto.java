package dto;

public class DrinkDto {
    private int id;
    private String name;
    private int price;
    private int stock;

    public DrinkDto(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public DrinkDto(String name, int price, int stock) {
        id = 0;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public DrinkDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
