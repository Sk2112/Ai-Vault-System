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

@RestController
@RequestMapping("/vault/")
public class MyController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<ResponseDto> newItem(@Valid @RequestBody RequestDto requestDto){
        System.out.println("Controller reached");
    ResponseDto responseDto = itemService.addItem(requestDto);
     return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }



}
