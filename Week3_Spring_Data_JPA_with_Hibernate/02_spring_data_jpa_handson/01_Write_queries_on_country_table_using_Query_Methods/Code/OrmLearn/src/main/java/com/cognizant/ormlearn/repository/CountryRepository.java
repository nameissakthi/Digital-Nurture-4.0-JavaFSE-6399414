package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    public List<Country> findByNameContaining(String keyword);

    public List<Country> findByNameContainingOrderByNameAsc(String keyword);

    public List<Country> findByNameStartingWith(String keyword);
}