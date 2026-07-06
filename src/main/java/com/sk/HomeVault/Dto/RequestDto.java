package com.sk.HomeVault.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;


public class RequestDto {

    @NotBlank(message = "Item name is required")
    String itemName;
    @NotBlank(message = "Item Location is required")
    String itemLocation;
    @NotBlank(message = "Description is required")
    @Size(max = 500,message = "Description cannot exceeds 500 characters ")
    String itemDescription;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
