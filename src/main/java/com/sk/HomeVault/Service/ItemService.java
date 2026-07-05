package com.sk.HomeVault.Service;


import com.sk.HomeVault.Dto.RequestDto;
import com.sk.HomeVault.Dto.ResponseDto;
import com.sk.HomeVault.Entity.Item;
import com.sk.HomeVault.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemService {



    @Autowired
    private ItemRepository itemRepository;

    // adding item
    public ResponseDto addItem(RequestDto requestDto){

        ResponseDto responseDtoObject=new ResponseDto();
        Item newItem = new Item();


        // making new Item for each request....
        newItem.setItemName(requestDto.getItemName());
        newItem.setItemLocation( requestDto.getItemLocation());
        newItem.setItemDescription(requestDto.getItemDescription());
        newItem.setCreatedAt(LocalDateTime.now());
        newItem.setUpdatedAt(LocalDateTime.now());

        // making new responseDtoObject for each...
        responseDtoObject.setItemName(newItem.getItemName());
        responseDtoObject.setItemLocation(newItem.getItemLocation());
        responseDtoObject.setItemDescription(newItem.getItemDescription());
        responseDtoObject.setItemCreatedAt(newItem.getCreatedAt());
        responseDtoObject.setItemUpdatedAt(newItem.getUpdatedAt());

        // saving item in db;
        itemRepository.save(newItem);

        // sending response dto;
        return  responseDtoObject;
    }





}

