package com.web.app.backend_netflix.itemService.repository;

import com.web.app.backend_netflix.itemService.modual.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
