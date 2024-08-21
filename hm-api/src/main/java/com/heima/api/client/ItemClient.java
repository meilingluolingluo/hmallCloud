package com.heima.api.client;


import com.heima.api.client.fallback.ItemClientFallback;
import com.heima.api.config.DefaultFeignConfig;
import com.heima.api.dto.ItemDTO;
import com.heima.api.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "item-service",
             configuration = DefaultFeignConfig.class,
             fallbackFactory = ItemClientFallback.class)
public interface ItemClient {

    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);

    @PutMapping("/item/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);
}