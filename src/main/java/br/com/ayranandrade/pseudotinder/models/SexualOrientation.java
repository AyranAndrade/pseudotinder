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

@Entity
@Table(name = "sexual_orientations")
public class SexualOrientation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sexual_orientation_id")
  private Integer id;

  @Column(nullable = false, length = 30, unique = true)
  @NotNull
  @Size(max = 30)
  private String name;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt;

  /**
   * return the id.
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * set the id.
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * return the name.
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * set the name.
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * return the createdAt.
   * @return the createdAt
   */
  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * set the createdAt.
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}