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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "people_id")
  private People people;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "people_judged_id")
  private People peopleJudged;

  @Column(nullable = false)
  @NotNull
  private Boolean liked;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt = Instant.now();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Boolean getLiked() {
    return liked;
  }

  public void setLiked(Boolean liked) {
    this.liked = liked;
  }

  public People getPeople() {
    return people;
  }

  public void setPeople(People people) {
    this.people = people;
  }

  public People getPeopleJudged() {
    return peopleJudged;
  }

  public void setPeopleJudged(People peopleJudged) {
    this.peopleJudged = peopleJudged;
  }
}