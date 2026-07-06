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
import java.util.OptionalInt;

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
        responseDtoObject.setItemId(newItem.getItemId());

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
           responseDto.setItemId(item.getItemId());
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
        responseDto.setItemId(existedItem.getItemId());
        return responseDto;
      }else{
          throw  new RuntimeException("Not Found");
      }

    }


    public ResponseDto updateItem(RequestDto existedItem ,Long id){

      Optional<Item> itemOptional =itemRepository.findById(id);
      if(itemOptional.isPresent()){

         Item dbItem =itemOptional.get();
         ResponseDto responseDto=new ResponseDto();

          dbItem.setItemLocation(existedItem.getItemLocation());
          dbItem.setItemName(existedItem.getItemName());
          dbItem.setItemDescription(existedItem.getItemDescription());

          itemRepository.save(dbItem);

          responseDto.setItemDescription(dbItem.getItemDescription());
          responseDto.setItemLocation(dbItem.getItemLocation());
          responseDto.setItemName(dbItem.getItemName());
          responseDto.setItemId(dbItem.getItemId());
          responseDto.setItemUpdatedAt(LocalDateTime.now());
          responseDto.setItemCreatedAt(dbItem.getCreatedAt());

          return responseDto;
      }else{
          throw new RuntimeException("Object Does not found"+id);
      }

    }

    public void deleteItem(long id){
         Optional<Item> itemOptional =itemRepository.findById(id);
         if(itemOptional.isPresent()){
           Item dbItem =itemOptional.get();
           itemRepository.deleteById(dbItem.getItemId());
           System.out.println("Reached");
         }else{
           throw  new RuntimeException("Item not found");
         }
    }



}

