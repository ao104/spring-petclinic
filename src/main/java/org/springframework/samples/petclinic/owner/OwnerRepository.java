package org.springframework.samples.petclinic.owner;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.annotation.Nonnull;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    List<PetType> findPetTypes();

    Page<Owner> findByLastNameStartingWith(String lastName, Pageable pageable);

    Optional<Owner> findById(@Nonnull Integer id);

    Page<Owner> findAll(Pageable pageable);

    // ⭐ 追加部分
    @Query("SELECT COUNT(o) FROM Owner o")
    long countOwners();
}
