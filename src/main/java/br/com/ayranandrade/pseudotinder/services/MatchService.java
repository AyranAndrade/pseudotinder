package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.Person;

public interface MatchService {
  public void personALikesPersonB(Person A, Person B);
  
  public void personADislikesPersonB(Person A, Person B);
}