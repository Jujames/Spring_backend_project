package com.claim.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claim.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
