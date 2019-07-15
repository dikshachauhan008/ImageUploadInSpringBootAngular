package com.Ibt.acart.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ibt.acart.model.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
