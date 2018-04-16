package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.Match;
import br.com.ayranandrade.pseudotinder.models.People;
import br.com.ayranandrade.pseudotinder.repositories.MatchRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MatchServiceImpl implements MatchService {

  @Autowired
  private MatchRepository matchRep;

  @Override
  public void like(People whoIsJudging, People whoIsBeingJudged) {
    createMatch(whoIsJudging, whoIsBeingJudged, true);
  }
  
  @Override
  public void dislike(People whoIsJudging, People whoIsBeingJudged) {
    createMatch(whoIsJudging, whoIsBeingJudged, false);
  }

  private void createMatch(People whoIsJudging, People whoIsBeingJudged, Boolean like) {
    Match match = new Match(whoIsJudging, whoIsBeingJudged, like);
    this.matchRep.save(match);
  }
}