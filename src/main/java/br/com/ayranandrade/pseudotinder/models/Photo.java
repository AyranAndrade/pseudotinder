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
@Table(name = "photos")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_id")
	private Integer id;

	@NotEmpty
	@Size(max = 1024)
	private String urlOrPath;

	@NotNull
	private Instant uploadAt;

	@NotNull
	private Boolean active;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "people_id")
	private Person uploader;

	private Photo() {
		initiliazeAttributes();
	}

	private void initiliazeAttributes() {
		active = true;
		uploadAt = Instant.now();
	}

	public Photo(String urlOrPath, Person uploader) {
		this.urlOrPath = urlOrPath;
		this.uploader = uploader;
		initiliazeAttributes();
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", urlOrPath=" + urlOrPath + ", uploadAt="
				+ uploadAt + ", active=" + active + ", uploader=" + uploader + "]";
	}

}
