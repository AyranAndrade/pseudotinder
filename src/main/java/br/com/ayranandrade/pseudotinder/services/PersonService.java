package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.Person;

public interface PersonService {
  public Person nextPossibleLovingPartner(Person user);

  public void registerUser(Person user);

  public Person findPeopleByUsername(String username);
}