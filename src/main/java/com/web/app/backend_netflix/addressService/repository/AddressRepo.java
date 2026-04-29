package com.web.app.backend_netflix.addressService.repository;

import com.web.app.backend_netflix.addressService.modual.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

    //todo must be match with table Callum name
    @Query(value = "SELECT * FROM address WHERE address_id = ?1", nativeQuery = true)
    Optional<Address> findByIdAddress(int id);

    @Query(value = "SELECT * FROM address", nativeQuery = true)
    List<Address> findAllByQuery();

    //TODO jpql query
    // @Query(value = "SELECT * FROM address WHERE city= ?1", nativeQuery = true)
    //TODO Dynamic IN Clause
    @Query(value = "SELECT * FROM address WHERE city IN (?1)", nativeQuery = true)
    Address getCityByQuery(String keyWord);

}
