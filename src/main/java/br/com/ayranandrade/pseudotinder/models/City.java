package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents a city.
 * @author ayran
 */
@Entity
@Table(name = "cities")
public class City {
    
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id")
  private Integer id;
    
  @NotNull
  @Size(max = 30)
  @Column(nullable = false, length = 30)
  private String name;
    
  @NotNull
  @Column(name = "created_at", nullable = false)
  private Instant createdAt;
    
  @ManyToOne
  @JoinColumn(name = "state_id", referencedColumnName = "state_id")
  private State state;

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
