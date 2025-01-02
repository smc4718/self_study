package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {   //interface에 @Mapper를 붙이면, MyBatis에서 인식해서 xml에 있는 sql을 부른다.

    void save(Item item);

    // 파라미터 1개인 경우에는 @Param 안넣어도 되지만 여러 개일 경우에는 @Param 넣어준다.
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);

    Optional<Item> findById(Long id); // Optional은 null이어도 반환, 값이 있어도 반환시키는 것.

    List<Item> findAll(ItemSearchCond itemSearch);
}
