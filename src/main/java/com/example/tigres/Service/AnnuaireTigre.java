package com.example.tigres.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tigres.Dao.TigreRepo;
import com.example.tigres.Entity.Tigre;

import java.util.List;
import java.util.Optional;

@Service
public class AnnuaireTigre {

    @Autowired
    TigreRepo tigreRepo;

    /*
     * private int nextId = 0;
     * 
     * private List<Tigre> tigres = new ArrayList<>();
     */

    public Tigre addTigre(Tigre tigre) {
        return tigreRepo.save(tigre); // la methode save permet d envoyer un objet
        /*
         * nextId++;
         * tigre.setId(nextId);
         * tigres.add(tigre);
         * return Optional.of(tigre);
         */
    }

    public List<Tigre> getTigres() {
        return tigreRepo.findAll();
    }

    /*
     * public Optional<List<Tigre>> getTigres() {
     * 
     * if (tigres.isEmpty()) {
     * return Optional.empty();
     * }
     * return Optional.of(tigres);
     * }
     */
    public void deleteTigre(int id) {
        tigreRepo.deleteById(id);

        /*
         * int index = 0;
         * while (index < tigres.size() && tigres.get(index).getId() != id) {
         * index++;
         * }
         * if (index < tigres.size()) {
         * tigres.remove(index);
         * 
         * }
         */

    }

    public Optional<Tigre> getTigre(Integer id) { // click sur findBy pour voir Optional
        return tigreRepo.findById(id);

        /*
         * for (Tigre tigre : tigres) {
         * if (id.equals(tigre.getId())) {
         * return Optional.of(tigre);
         * }
         * }
         * return Optional.empty(); // return null
         */
    }

    public void editTigre(Integer id, Tigre newTigre) {
        tigreRepo.save(newTigre);
        /*
         * int index = 0;
         * while (index < tigres.size()) {
         * if (id.equals(tigres.get(index).getId())) {
         * tigres.set(index, tigre);
         * }
         * index++;
         * }
         */
    }

}
