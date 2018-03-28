package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sexual_orientations")
public class SexualOrientation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sexual_orientation_id")
  private Integer id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private SexualOrientationType name;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt = Instant.now();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name.getOrientation();
  }

  public void setName(SexualOrientationType name) {
    this.name = name;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}