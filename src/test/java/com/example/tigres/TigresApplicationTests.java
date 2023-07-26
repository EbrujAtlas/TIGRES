package com.example.tigres;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tigres.Dao.SoigneRepo;
import com.example.tigres.Dao.TigreRepo;
import com.example.tigres.Dao.ZooRepo;
import com.example.tigres.Entity.Tigre;
import com.example.tigres.Entity.Zoo;

@SpringBootTest
class TigresApplicationTests {

	@Autowired
	TigreRepo tigreRepo;

	@Autowired
	ZooRepo zooRepo;

	@Autowired
	SoigneRepo soigneRepo;

	@Test
	void testZoo() {
		Zoo zoo = new Zoo("laflèche", "Laflèche");
		zooRepo.save(zoo);

		Tigre samba = new Tigre("Samba");
		samba.setZoo(zoo);
		tigreRepo.save(samba);
	}

	@Test
	void getTigreAvecZoo() {
		Integer id = 2;
		Optional<Tigre> op = tigreRepo.findById(2);
		if (op.isPresent()) {
			Tigre samba = op.get();
			System.out.println(samba);
			System.out.println(samba.getZoo());
		} else {
			System.out.println("aucun tigre avec id : " + id);
		}
	}

	/*
	 * @Test
	 * void testSoigneur() {
	 * Optional<Tigre> opSamba = tigreRepo.findById(1);
	 * if (opSamba.isPresent()) {
	 * Tigre samba = opSamba.get();
	 * 
	 * Optional<Tigre> opTigrou = tigreRepo.findById(2);
	 * if (opTigrou.isPresent()) {
	 * Tigre tigrou = opTigrou.get();
	 * 
	 * Soigneur atlas = new Soigneur("atlas");
	 * 
	 * atlas.addSoignes(tigrou);
	 * atlas.addSoignes(samba);
	 * 
	 * }
	 * }
	 * 
	 * }
	 */

}
