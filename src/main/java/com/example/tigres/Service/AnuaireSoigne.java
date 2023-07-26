package com.example.tigres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigres.Dao.SoigneRepo;
import com.example.tigres.Entity.Soigneur;

@Service
public class AnuaireSoigne {

    @Autowired
    SoigneRepo soigneRepo;

    public void addSoigne(Soigneur soigne) {
        soigneRepo.save(soigne);

    }

    public List<Soigneur> getSoignes() {
        return soigneRepo.findAll();
    }

    public void deleteSoigne(int id) {
        soigneRepo.deleteById(id);
    }

    public Optional<Soigneur> getSoigne(Integer id) {
        return soigneRepo.findById(id);

    }

    public void editSoigne(Integer id, Soigneur newSoigneur) {
        soigneRepo.save(newSoigneur);

    }
}