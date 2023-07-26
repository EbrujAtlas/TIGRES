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

import com.example.tigres.Entity.Soigneur;
import com.example.tigres.Service.AnuaireSoigne;

@RestController
public class SoigneurController {

    @Autowired
    AnuaireSoigne service;

    @GetMapping("soigneurs")
    public List<Soigneur> getSoigneurs() {
        return service.getSoignes();

    }

    @PostMapping("soigneurs")
    public void postSoigne(@RequestBody Soigneur newSoigneur) {
        System.out.println(newSoigneur);

        service.addSoigne(newSoigneur);

    }

    @DeleteMapping("soigneurs/{id}")
    public ResponseEntity<String> deleteSoigne(@PathVariable("id") Integer id) {

        Optional<Soigneur> optional = service.getSoigne(id);

        if (optional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        service.deleteSoigne(id);
        {
            return ResponseEntity.ok("object supprime");
        }

    }

    @GetMapping("soigneurs/{id}")
    public ResponseEntity<Soigneur> getSoigneur(@PathVariable("id") Integer id) {

        Optional<Soigneur> optional = service.getSoigne(id);

        if (optional.isPresent()) {
            Soigneur soigneur = optional.get();
            return ResponseEntity.ok(soigneur);

        } else { // if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("soigneurs/{id}")
    public ResponseEntity<Soigneur> putSoigneur(@PathVariable("id") Integer id, @RequestBody Soigneur newSoigneur) {

        if (!id.equals(newSoigneur.getId())) {

            return ResponseEntity.badRequest().build(); // renvoie badrequest
        }

        if (service.getSoigne(id).isEmpty()) {

            return ResponseEntity.notFound().build(); // renvoie erreur 404
        }

        service.editSoigne(id, newSoigneur);
        Optional<Soigneur> t = service.getSoigne(id);
        return ResponseEntity.ok(t.get()); // renvoie objet modifié dans body
    }

}
