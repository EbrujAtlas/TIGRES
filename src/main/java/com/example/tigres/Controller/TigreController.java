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

import com.example.tigres.Entity.Tigre;
import com.example.tigres.Service.AnnuaireTigre;

@RestController
public class TigreController {

    @Autowired
    AnnuaireTigre service;

    @GetMapping("tigres")
    public List<Tigre> getTigres() {
        return service.getTigres();
    }

    /*
     * public ResponseEntity<List<Tigre>> getTigres() {
     * 
     * Optional<List<Tigre>> optionalTigreList = service.getTigres();
     * 
     * if (optionalTigreList.isEmpty()) {
     * return ResponseEntity.notFound().build();
     * } else {
     * List<Tigre> tigres = optionalTigreList.get(); // renvoie ce qu il y a dans
     * boite Optional
     * return ResponseEntity.ok(tigres);
     * }
     * }
     */
    @PostMapping("tigres")
    public void postTigre(@RequestBody Tigre newTigre) {
        System.out.println(newTigre);

        service.addTigre(newTigre);

    }
    /*
     * public ResponseEntity<Tigre> postTigres(@RequestBody Tigre newTigre) {
     * System.out.println(newTigre);
     * 
     * Optional<Tigre> optionalTigreList = service.addTigre(newTigre);
     * 
     * if (newTigre.getId() != null || newTigre.getPrenom() == null) {
     * return ResponseEntity.badRequest().build();
     * } else {
     * Tigre tigre = optionalTigreList.get(); // renvoie ce qu il y a dans boite
     * Optional
     * return ResponseEntity.ok(tigre);
     * }
     * 
     * }
     */

    @DeleteMapping("tigres/{id}")
    public ResponseEntity<String> deleteTigre(@PathVariable("id") Integer id) {

        Optional<Tigre> optional = service.getTigre(id);

        if (optional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        service.deleteTigre(id);
        {
            return ResponseEntity.ok("object supprime");
        }

    }

    @GetMapping("tigres/{id}")
    public ResponseEntity<Tigre> getTigre(@PathVariable("id") Integer id) {

        Optional<Tigre> optional = service.getTigre(id);

        if (optional.isPresent()) {
            Tigre tigre = optional.get();
            return ResponseEntity.ok(tigre);

        } else { // if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("tigres/{id}")
    public ResponseEntity<Tigre> putTigre(@PathVariable("id") Integer id, @RequestBody Tigre tigre) {

        if (!id.equals(tigre.getId())) {

            return ResponseEntity.badRequest().build(); // renvoie badrequest
        }

        if (service.getTigre(id).isEmpty()) {

            return ResponseEntity.notFound().build(); // renvoie erreur 404
        }

        service.editTigre(id, tigre);
        Optional<Tigre> t = service.getTigre(id);
        return ResponseEntity.ok(t.get()); // renvoie objet modifié dans body
    }

}
