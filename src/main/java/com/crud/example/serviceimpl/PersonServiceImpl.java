package com.crud.example.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.model.Person;
import com.crud.example.repository.PersonRepository;
import com.crud.example.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personrepository;

	@Override
	public Map<String, Object> savePerson(Person person) {
		Person p = personrepository.save(person);
		Map<String, Object> map = new HashMap<>();
		if (p != null) {

			map.put("msg", "person details addded successfully");

			map.put("person", p.getId());
		}

		return map;
	}

	@Override
	public List<Person> getPersons() {
		return personrepository.findAll();
	}

	@Override
	public Person updateProduct(int id, Person person) {
		Person existingPerson = personrepository.findById(id).orElse(null);
		existingPerson.setFullName(person.getFullName());
		existingPerson.setEmail(person.getEmail());
		existingPerson.setContact(person.getContact());
		existingPerson.setPassword(person.getPassword());
		return personrepository.save(existingPerson);
	}

	@Override
	public String changepersoncontact(int personId, long contact) {
		Person p = personrepository.findById(personId).get();
		p.setContact(contact);
		personrepository.save(p);
		return "person contact changed";
	}

	@Override
	public String deletePerson(int id) {
		personrepository.deleteById(id);
		return "person removed" + id;

	}

}
