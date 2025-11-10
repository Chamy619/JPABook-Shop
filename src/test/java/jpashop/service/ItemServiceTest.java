package jpashop.service;

import jpashop.domain.Category;
import jpashop.domain.item.Album;
import jpashop.domain.item.Item;
import jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        // Given
        Item item = new Album();
        item.setName("이문세 뮤직 앨범");
        item.setPrice(1000);
        item.setStockQuantity(5);

        // When
        itemService.saveItem(item);

        // Then
        assertEquals(item, itemRepository.findOne(item.getId()));
    }
}
