package com.sk.HomeVault.Controller;

import com.sk.HomeVault.Dto.RequestDto;
import com.sk.HomeVault.Dto.ResponseDto;
import com.sk.HomeVault.Entity.Item;
import com.sk.HomeVault.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vault/")
public class MyController {

    @Autowired
    private ItemService itemService;

    @PostMapping("item")
    public ResponseEntity<ResponseDto> newItem(@Valid @RequestBody RequestDto requestDto){
        System.out.println("Controller reached");
    ResponseDto responseDto = itemService.addItem(requestDto);
     return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("items")
    public ResponseEntity<List<ResponseDto>> allItems(){
        return ResponseEntity.ok(itemService.allItems());
    }

        @GetMapping("item/{id}")
        public ResponseEntity<ResponseDto> itemByid(@PathVariable long id){
          ResponseDto responseDto = itemService.itemById(id);
          return ResponseEntity.ok(responseDto);
        }

        @PutMapping("itemUpdate/{id}")
        public ResponseEntity<ResponseDto> itemUpdate(@RequestBody RequestDto requestDto , @PathVariable long id ){
                 ResponseDto responseDto =itemService.updateItem(requestDto,id);
                 return ResponseEntity.ok(responseDto);
        }

        @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable long id ){
        itemService.deleteItem(id);
       return ResponseEntity.noContent().build();
        }
    }
