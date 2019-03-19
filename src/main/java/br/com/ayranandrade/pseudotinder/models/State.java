package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "states")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Integer id;

	@NotEmpty
	@Size(max = 30)
	@Column(unique = true)
	private String name;

	@NotNull
	private Instant createdAt;

	protected State() {
		initializeAttributes();
	}

	private void initializeAttributes() {
		createdAt = Instant.now();
	}

	public State(String name) {
		this.name = name;
		initializeAttributes();
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", createdAt=" + createdAt + "]";
	}
}
