package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
import java.util.Optional;

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

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "people_id")
  private People people;
  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "people_judged_id")
  private People peopleJudged;

  @Column(nullable = false)
  @NotNull
  private Boolean liked;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt = Instant.now();

  /**
  * This constructor is only for JPA use.
  */
  private Match() {}

  public Match(People whoIsJudging, People whoIsBeingJudged, Boolean liked) {
    this.people = Optional.ofNullable(whoIsJudging)
        .orElseThrow(() -> new IllegalArgumentException("The argument whoIsJudging " 
        + "can not be null."));

    this.peopleJudged = Optional.ofNullable(whoIsBeingJudged)
      .orElseThrow(() -> new IllegalArgumentException("The argument whoIsBeingJudged " 
      + "can not be null."));

    this.liked = Optional.ofNullable(liked)
      .orElseThrow(() -> new IllegalArgumentException("The argument liked " 
      + "can not be null."));
  }

  public Integer getId() {
    return id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Set the createdAt different than when this object was created. 
   * This value needs to be in the past.
   */
  public void setCreatedAt(Instant createdAt) {
    Instant createdAtNotNull = Optional.ofNullable(createdAt)
        .orElseThrow(() -> new IllegalArgumentException("Match's createdAt can not be null."));
    if (createdAtNotNull.isBefore(Instant.now())) {
      this.createdAt = createdAtNotNull;
    } else {
      throw new 
          IllegalArgumentException("The instant of creation of a match can not be in the past.");
    }
  }

  public Boolean getLiked() {
    return liked;
  }

  public People getPeople() {
    return people;
  }

  public People getPeopleJudged() {
    return peopleJudged;
  }
}