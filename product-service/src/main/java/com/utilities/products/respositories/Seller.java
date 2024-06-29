package com.utilities.products.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Seller extends JpaRepository<Seller, UUID> {
}
