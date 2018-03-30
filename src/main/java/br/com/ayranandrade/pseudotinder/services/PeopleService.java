package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.People;

public interface PeopleService {
  public People nextPretender(People whoIsJudging);

  public void registerUser(People user);
}