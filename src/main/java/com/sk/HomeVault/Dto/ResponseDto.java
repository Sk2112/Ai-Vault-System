package com.sk.HomeVault.Dto;

import java.time.LocalDateTime;

public class ResponseDto {

    Long itemId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    String itemName;
    String itemLocation;
    String itemDescription;
    LocalDateTime itemCreatedAt;
    LocalDateTime itemUpdatedAt;

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

    public LocalDateTime getItemCreatedAt() {
        return itemCreatedAt;
    }

    public void setItemCreatedAt(LocalDateTime itemCreatedAt) {
        this.itemCreatedAt = itemCreatedAt;
    }

    public LocalDateTime getItemUpdatedAt() {
        return itemUpdatedAt;
    }

    public void setItemUpdatedAt(LocalDateTime itemUpdatedAt) {
        this.itemUpdatedAt = itemUpdatedAt;
    }
}
