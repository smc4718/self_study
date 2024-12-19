package hello.itemservice.repository;

import lombok.Data;

@Data
public class ItemSearchCond2 {

    private String itemName;
    private Integer maxPrice;

    public ItemSearchCond2() {
    }

    public ItemSearchCond2(String itemName, Integer maxPrice) {
        this.itemName = itemName;
        this.maxPrice = maxPrice;
    }
}
