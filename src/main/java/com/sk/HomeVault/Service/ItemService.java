package com.sk.HomeVault.Service;


import com.sk.HomeVault.Dto.RequestDto;
import com.sk.HomeVault.Dto.ResponseDto;
import com.sk.HomeVault.Entity.Item;
import com.sk.HomeVault.Repository.ItemRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public List<ResponseDto> allItems(){

        List<Item> listItems=  itemRepository.findAll();
        List<ResponseDto> responseDtoList=new ArrayList<>();
        for(Item item : listItems){

         ResponseDto responseDto=new ResponseDto();

           responseDto.setItemName(item.getItemName());
           responseDto.setItemLocation(item.getItemLocation());
           responseDto.setItemDescription(item.getItemDescription());
           responseDto.setItemUpdatedAt(item.getUpdatedAt());
           responseDto.setItemCreatedAt(item.getCreatedAt());
           responseDtoList.add(responseDto);
        }
        return  responseDtoList ;

    }

    public ResponseDto itemById(long id){
      Optional<Item> optionalItem = itemRepository.findById(id);

      if(optionalItem.isPresent()){
      ResponseDto responseDto = new ResponseDto();
        Item existedItem= optionalItem.get();
        responseDto.setItemName(existedItem.getItemName());
        responseDto.setItemDescription(existedItem.getItemDescription());
        responseDto.setItemLocation(existedItem.getItemLocation());
        responseDto.setItemUpdatedAt(existedItem.getUpdatedAt());
        responseDto.setItemCreatedAt(existedItem.getCreatedAt());
        return responseDto;
      }else{
          throw  new RuntimeException("Not Found");
      }

    }


}

