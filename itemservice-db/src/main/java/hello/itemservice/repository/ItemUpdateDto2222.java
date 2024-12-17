package hello.itemservice.repository;

import lombok.Data;

@Data
public class ItemUpdateDto2222 {
    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemUpdateDto2222() {
    }

    public ItemUpdateDto2222(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
