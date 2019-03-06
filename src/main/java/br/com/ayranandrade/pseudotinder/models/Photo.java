package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "photos")
public class Photo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "photo_id")
  private Integer id;

  @Column(name = "url_or_path", length = 1024, nullable = false)
  @NotBlank
  @Max(1024)
  private String urlOrPath;

  @Column(name = "upload_at", nullable = false)
  @NotNull
  private Instant uploadAt = Instant.now();

  @Column(nullable = false)
  @NotNull
  private Boolean active = true;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "people_id")
  private Person uploader;

  /**
  * This constructor is only for JPA use.
  */
  private Photo() {}

  public Photo(String urlOrPath, Person uploader) {
    String urlOrPathNotNull = Optional.ofNullable(urlOrPath)
        .orElseThrow(() -> new IllegalArgumentException("The url or path from photo " 
        + "can not be null."));

    if (!urlOrPathNotNull.isEmpty()) {
      this.urlOrPath = urlOrPathNotNull;
    } else {
      throw new IllegalArgumentException("The url or path from photo can not be empty.");
    }

    this.uploader = Optional.ofNullable(uploader)
        .orElseThrow(() -> new IllegalArgumentException("The uploader from photo " 
        + "can not be null."));
  }

  public Integer getId() {
    return id;
  }

  public Boolean getActive() {
    return active;
  }

  public Instant getUploadAt() {
    return uploadAt;
  }

  /**
  * Set the sentAt different than when this object was created. 
  * This value needs to be in the past.
  */
  public void setUploadAt(Instant uploadAt) {
    Instant uploadAtNotNull = Optional.ofNullable(uploadAt)
        .orElseThrow(() -> new IllegalArgumentException("Photo's uploadAt can not be null."));
    if (uploadAtNotNull.isBefore(Instant.now())) {
      this.uploadAt = uploadAtNotNull;
    } else {
      throw new 
          IllegalArgumentException("The instant of creation of a photo can not be in the past.");
    }
  }

  public Person getUploader() {
    return uploader;
  }

  public String getUrlOrPath() {
    return urlOrPath;
  }
}
