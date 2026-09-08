package com.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.billing.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}