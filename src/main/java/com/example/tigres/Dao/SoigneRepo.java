package com.example.tigres.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tigres.Entity.Soigneur;

@Repository
public interface SoigneRepo extends JpaRepository<Soigneur, Integer> {

}
