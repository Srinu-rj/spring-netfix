package com.web.app.backend_netflix.itemService.service;

import com.web.app.backend_netflix.itemService.request.ItemRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    ItemRequest save(@Valid ItemRequest itemRequest);
    ItemRequest getItemId(Long itemId);
    ItemRequest deleteItem(Long itemId);
    ItemRequest updateItemById(Long itemId);
}
