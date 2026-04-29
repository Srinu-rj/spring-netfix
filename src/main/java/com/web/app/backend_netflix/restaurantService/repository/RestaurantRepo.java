package com.web.app.backend_netflix.restaurantService.repository;

import com.web.app.backend_netflix.restaurantService.modual.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    @Query(value = "SELECT * FROM address WHERE manager_name: ",nativeQuery = true)
    Restaurant managerName(String managerName);

    @Query(value = "SELECT * FROM address ", nativeQuery = true)
    List<Restaurant> findAllRestaurantByQuery();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bill WHERE restaurant_id = ?1", nativeQuery = true)
    void deleteByQuery(int restaurantId);

}
