package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.entity.Item;
import com.sparta.myselectshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    // 판매 게시글 작성 API
    @PostMapping("/post")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    // 판매 게시글 전체 조회 API
    @GetMapping("/post")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    // 판매 게시글 수정 API
    @PutMapping("/post/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody Item newItem) {
        Item updatedItem = itemService.updateItem(id, newItem);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 판매 게시글 삭제 API
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}