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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City {
    
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id")
  private Integer id;
    
  @NotEmpty
  @Size(max = 30)
  private String name;
    
  @NotNull
  private Instant createdAt;
    
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "state_id", referencedColumnName = "state_id")
  private State stateInWhichTheCityLies;

  private City() {}

  @Override
  public String toString() {
	  return "City [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", stateInWhichTheCityLies="
			  + stateInWhichTheCityLies + "]";
  }
}
