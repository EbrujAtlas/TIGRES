package com.example.tigres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigres.Dao.ZooRepo;
import com.example.tigres.Entity.Zoo;

@Service
public class AnnuaireZoo {

    @Autowired
    ZooRepo zooRepo;

    public void addZoo(Zoo zoo) {
        zooRepo.save(zoo);

    }

    public List<Zoo> getZoos() {
        return zooRepo.findAll();
    }

    public void deleteZoo(int id) {
        zooRepo.deleteById(id);
    }

    public Optional<Zoo> getZoo(Integer id) { // Optional est une class
        return zooRepo.findById(id);
    }

    public void editZoo(Integer id, Zoo newZoo) {
        zooRepo.save(newZoo);

    }
}
