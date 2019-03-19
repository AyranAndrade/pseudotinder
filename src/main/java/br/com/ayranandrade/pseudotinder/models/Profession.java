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
@Table(name = "professions")
public class Profession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profession_id")
	private Integer id;

	@Column(unique = true)
	@NotEmpty
	@Size(max = 100)
	private String name;

	@NotNull
	private Instant createdAt;

	protected Profession() {
		initializeAttributes();
	}

	private void initializeAttributes() {
		createdAt = Instant.now();
	}

	public Profession(String name) {
		this.name = name;
		initializeAttributes();
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Profession [id=" + id + ", name=" + name + ", createdAt="
				+ createdAt + "]";
	}

}
