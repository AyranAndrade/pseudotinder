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
  private People uploader;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Instant getUploadAt() {
    return uploadAt;
  }

  public void setUploadAt(Instant uploadAt) {
    this.uploadAt = uploadAt;
  }

  public People getUploader() {
    return uploader;
  }

  public void setUploader(People uploader) {
    this.uploader = uploader;
  }

  public String getUrlOrPath() {
    return urlOrPath;
  }

  public void setUrlOrPath(String urlOrPath) {
    this.urlOrPath = urlOrPath;
  }
}
