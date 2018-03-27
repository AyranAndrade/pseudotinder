package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents a state.
 * @author ayran
 */
@Entity
@Table(name = "states")
public class State {
    
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "state_id")
  private Integer id;
  
  @NotNull
  @Size(max = 30)
  @Column(nullable = false, length = 30, unique = true)
  private String name;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
