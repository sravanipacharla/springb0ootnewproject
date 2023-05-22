package com.crud.example.service;

import java.util.List;
import java.util.Map;

import com.crud.example.model.Person;

public interface PersonService {

	// public Person savePerson(Person person);

	public Map<String, Object> savePerson(Person person);

	List<Person> getPersons();

	public String changepersoncontact(int personId, long contact);

	Person updateProduct(int id, Person person);

	String deletePerson(int id);

}
