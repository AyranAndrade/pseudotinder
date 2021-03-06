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
@Table(name = "streets")
public class Street {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "street_id")
	private Integer id;

	@NotEmpty
	@Size(max = 60)
	private String name;

	@NotNull
	private Instant createdAt;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "region_id", referencedColumnName = "region_id")
	private Region regionInWhichStreetLies;

	protected Street() {
		initializeAttributes();
	}

	public Street(String name, Region region) {
		this.name = name;
		regionInWhichStreetLies = region;
		initializeAttributes();
	}

	private void initializeAttributes() {
		createdAt = Instant.now();
	}

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", createdAt="
				+ createdAt + ", region=" + regionInWhichStreetLies + "]";
	}

}
