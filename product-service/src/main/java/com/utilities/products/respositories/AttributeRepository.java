package com.utilities.products.respositories;

import com.utilities.products.models.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
    List<Attribute> findAll();
    Optional<Attribute> findById(UUID id);
}
