package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sexual_orientations")
public class SexualOrientation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sexual_orientation_id")
  private Integer id;

  @Column(nullable = false, length = 30, unique = true)
  @NotBlank
  @Size(max = 30)
  private String name;

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
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}