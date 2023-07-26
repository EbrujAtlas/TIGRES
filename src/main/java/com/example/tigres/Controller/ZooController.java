package com.example.tigres.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tigres.Entity.Zoo;

import com.example.tigres.Service.AnnuaireZoo;

@RestController
public class ZooController {

    @Autowired
    AnnuaireZoo service;

    @GetMapping("zoo")
    public List<Zoo> getZoos() {
        return service.getZoos();

    }

    @PostMapping("zoo")
    public void postZoo(@RequestBody Zoo newZoo) {
        System.out.println(newZoo);

        service.addZoo(newZoo);

    }

    @DeleteMapping("zoo/{id}")
    public ResponseEntity<String> deleteZoo(@PathVariable("id") Integer id) {

        Optional<Zoo> optional = service.getZoo(id);

        if (optional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        service.deleteZoo(id);
        {
            return ResponseEntity.ok("object supprime");
        }

    }

    @GetMapping("zoo/{id}")
    public ResponseEntity<Zoo> getTigre(@PathVariable("id") Integer id) {

        Optional<Zoo> optional = service.getZoo(id);

        if (optional.isPresent()) {
            Zoo zoo = optional.get();
            return ResponseEntity.ok(zoo);

        } else { // if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("zoo/{id}")
    public ResponseEntity<Zoo> putZoo(@PathVariable("id") Integer id, @RequestBody Zoo zoo) {

        if (!id.equals(zoo.getId())) {

            return ResponseEntity.badRequest().build(); // renvoie badrequest
        }

        if (service.getZoo(id).isEmpty()) {

            return ResponseEntity.notFound().build(); // renvoie erreur 404
        }

        service.editZoo(id, zoo);
        Optional<Zoo> t = service.getZoo(id);
        return ResponseEntity.ok(t.get()); // renvoie objet modifié dans body
    }

}
