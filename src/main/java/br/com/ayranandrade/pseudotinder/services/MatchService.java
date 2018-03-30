package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.People;

public interface MatchService {
  public void like(People whoIsJudging, People whoIsBeingJudged);
  
  public void dislike(People whoIsJudging, People whoIsBeingJudged);
}