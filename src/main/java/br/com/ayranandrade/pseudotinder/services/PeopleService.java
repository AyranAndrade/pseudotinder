package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.People;

public interface PeopleService {
  public People nextPossibleLovingPartner(People user);

  public void registerUser(People user);

  public People findPeopleByUsername(String username);
}