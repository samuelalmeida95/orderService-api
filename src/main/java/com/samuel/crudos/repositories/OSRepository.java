package com.samuel.crudos.repositories;

import java.util.List;

import com.samuel.crudos.model.OS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer>{

    List<OS> findByStatus(Integer idOS);
    
}