package jpabook.jpashop.service;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ItemServiceTest {
    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        // Given
        Item book = new Book();
        book.setName("BookA");

        // When
        itemService.saveItem(book);
        Long savedId = book.getId();

        // Then
        assertThat(book).isEqualTo(itemRepository.findOne(savedId));

    }
}