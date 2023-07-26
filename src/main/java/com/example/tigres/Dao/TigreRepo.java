package com.example.tigres.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tigres.Entity.Tigre;

@Repository
public interface TigreRepo extends JpaRepository<Tigre, Integer> {

}
