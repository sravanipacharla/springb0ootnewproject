package com.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.model.Person;
import com.crud.example.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personservice;

	@PostMapping("/saveperson")
	public ResponseEntity<?> saveperson(@RequestBody Person person) {
		return new ResponseEntity<>(personservice.savePerson(person), HttpStatus.CREATED);
	}

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personservice.getPersons();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
		return new ResponseEntity<Person>(personservice.updateProduct(id, person), HttpStatus.CREATED);

	}

	@PatchMapping("/changecontact/{personId}")
	public ResponseEntity<?> changepersoncontact(@PathVariable int personId, @RequestParam long contact) {
		return new ResponseEntity<>(personservice.changepersoncontact(personId, contact), HttpStatus.OK);
	}

	// @PutMapping("/changecontact/{personId}")
	// public ResponseEntity<?> changepersoncontact(@PathVariable int
	// personId,@RequestParam long contact) {
	// return new
	// ResponseEntity<>(personservice.changepersoncontact(personId,contact),
	// HttpStatus.OK);
	// }
	@DeleteMapping("/delete/{id}")
	public String deleteperson(@PathVariable int id) {
		return personservice.deletePerson(id);
	}
}
