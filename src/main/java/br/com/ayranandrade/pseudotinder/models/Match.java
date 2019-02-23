package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "matches")
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "match_id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "people_id")
  private People userThatIsUsingThisApp;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "people_judged_id")
  private People personThatIsBeingAnalyzed;

  @Column(name = "liked", nullable = false)
  @NotNull
  private Boolean userLikesThePerson;

  @Column(nullable = false)
  @NotNull
  private Instant createdAt;

  private Match() {}

  @Override
  public String toString() {
	  return "Match [id=" + id + ", userThatIsUsingThisApp=" + userThatIsUsingThisApp + ", personThatIsBeingAnalyzed="
			  + personThatIsBeingAnalyzed + ", userLikesThePerson=" + userLikesThePerson + ", createdAt=" + createdAt
			  + "]";
  }
  
}
