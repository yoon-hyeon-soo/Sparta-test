package com.sparta.myselectshop.service;

import com.sparta.myselectshop.entity.Item;
import com.sparta.myselectshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // 판매 게시글 작성
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // 판매 게시글 전체 조회
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // 판매 게시글 수정
    public Item updateItem(Long id, Item newItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setTitle(newItem.getTitle());
            existingItem.setContent(newItem.getContent());
            existingItem.setPrice(newItem.getPrice());
            existingItem.setUsername(newItem.getUsername());
            return itemRepository.save(existingItem);
        } else {
            return null;  // 수정할 게시글이 없는 경우 처리
        }
    }

    // 판매 게시글 삭제
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
