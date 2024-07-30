package com.andylee.springbootmall.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderRequest {

    // 巢狀式結構


    @NotEmpty // 不可為空
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
