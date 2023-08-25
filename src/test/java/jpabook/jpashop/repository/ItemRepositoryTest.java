package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    void testItem() {
        Item book = new Book();
        book.setName("BookA");
        itemRepository.save(book);

        List<Item> items = itemRepository.findAll();

        assertThat(items.size()).isEqualTo(1);
    }
}