package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.People;
import br.com.ayranandrade.pseudotinder.repositories.PeopleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

  @Override
  public People findPeopleByUsername(String username) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}