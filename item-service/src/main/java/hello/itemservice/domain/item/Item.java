package hello.itemservice.domain.item;

import lombok.Data;

@Data     //@Data 는 핵심 모델에 사용하기 위험하다(여러가지가 작동할 수 있어서). 그래서 @Getter , @Setter 따로 써줌. 하지만 예제에서는 @Data로 써봄.
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
