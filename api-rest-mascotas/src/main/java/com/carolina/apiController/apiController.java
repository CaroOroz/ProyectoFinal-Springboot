package com.carolina.apiController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.data.MascotaRepository;
import com.carolina.modelo.Mascota;

@RestController
@RequestMapping(path="/api",produces="application/json")
@CrossOrigin(origins="*")
 class apiController {

	@Autowired
	private MascotaRepository mascotaRepo;

	//Mostrar Mascota por ID
	@GetMapping ("/mascotaId/{id}")
	public ResponseEntity<Mascota> mascotaById(@PathVariable("id") Long id){
		Optional <Mascota> optMascota = mascotaRepo.findById(id);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

	//Subir Mascota
	@PostMapping(path="/mascota",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota postMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}

	//Listar todas las mascotas
	@GetMapping("/mascota")
	public Iterable<Mascota> allMascotas(){
		return mascotaRepo.findAll();
	}

	//Borrar Mascota
	@DeleteMapping("/mascota/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMascota(@PathVariable("id")Long id) {
		mascotaRepo.deleteById(id);
	}

	//Mostrar mascota por nombre
	@GetMapping ("/mascotaName/{nombre}")
	public ResponseEntity<Mascota> mascotaByName(@PathVariable("nombre") String nombre){
		Optional <Mascota> optMascota = mascotaRepo.findMascotaByNombre(nombre);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

	//Mostrar mascota con pagina y listado especifico 
	@GetMapping("/mascota/youngers/{pag}/{qtty}")
	public Iterable<Mascota> littleMascotas (@PathVariable("pag")int pag, @PathVariable("qtty")int qtty){
		PageRequest page = PageRequest.of(pag, qtty, Sort.by("fechaNac").descending());
		return mascotaRepo.findAll(page);
	}





}
