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

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(unique = true)
  private SexualOrientationType name;

  @NotNull
  private Instant createdAt;

  private SexualOrientation() {
    initiliazeAttributes();
  }

  private void initiliazeAttributes() {
    createdAt = Instant.now();
  }

  public SexualOrientation(SexualOrientationType type) {
    name = type;
    initiliazeAttributes();
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return "SexualOrientation [id=" + id + ", name=" + name + ", createdAt=" 
    + createdAt + "]";
  }

}
