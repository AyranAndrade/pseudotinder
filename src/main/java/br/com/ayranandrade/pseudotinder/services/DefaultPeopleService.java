package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.People;
import br.com.ayranandrade.pseudotinder.repositories.PeopleRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultPeopleService implements PeopleService {

  @Autowired
  private PeopleRepository peopleRep;

  @Override
  public People nextPossibleLovingPartner(People user) {
    return null;
  }

  @Override
  public void registerUser(People user) {
    this.peopleRep.save(user);
  }
}