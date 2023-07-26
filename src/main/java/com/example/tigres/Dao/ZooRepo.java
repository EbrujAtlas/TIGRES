package com.example.tigres.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tigres.Entity.Zoo;

@Repository
public interface ZooRepo extends JpaRepository<Zoo, Integer> {

}
