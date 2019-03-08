package br.com.ayranandrade.pseudotinder.repositories.integrationtests;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Photo;
import br.com.ayranandrade.pseudotinder.models.Person;
import br.com.ayranandrade.pseudotinder.repositories.PhotoRepository;
import br.com.ayranandrade.pseudotinder.repositories.PersonRepository;

public class PhotoRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private PhotoRepository photoRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Test
    public void shouldAddPhotoToDatabaseAndGetItById() {
      Person uploader = personRepository.getOne(10);
      String url = "https://dummyimage.com/600x400/000/0011ff.jpg&text=A+beautiful+person";
    	Photo photo = new Photo(url, uploader);
    	photoRepository.save(photo);
    	Integer photoId = photo.getId();
    	Optional<Photo> optionalPhoto = photoRepository.findById(photoId);
    	assertTrue(optionalPhoto.isPresent());
    }
    
    @Test
    public void shouldDeletePhotoFromDatabaseAndDoNotGetItById() {
    	photoRepository.deleteById(1);
    	Optional<Photo> optionalPhoto = photoRepository.findById(1);
    	assertTrue(optionalPhoto.isEmpty());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldUrlOrPathBeLessThan1024Characters() {
      Person uploader = personRepository.getOne(10);
      String url = "n1LMPthRAEgEzdG7vjrN4LyVwUz9j7DVzeXwuxe5vClObqvIJBZ4DpYZWUNASieG" 
      + "TFMR4C5bWx5lVDX3LJgfS6Fg8JW0NKe3XCuYlTqIYgAGxi14IOqeBplnuowrNjmcUvyHeeNQ4eu" 
      + "UUMhuex0TcJxGCE7fzvq3f5lPr7EWrORsws7GksRdE9EoEBLRhMVmzjEOjDlR5PsyiFDtTZOFLs" 
      + "qOteO7F7CcVPduHnm5zc79M27ANdI8Bc7dJKBZtdue4KIulyjLZKacd6aHtMKm2i7baZlOLsW3o" 
      + "3AqRbliaqlsNVYLjazhikpynE5p79yl89gYSNrJT3qsNU6lzoQgetvyjmqSXXxEBuzZDvphSXBL" 
      + "sr58J2Axm9QNXNDB9r11qjZqtvadiWWaAl74Va1txz2E6PlUujtR2dY5xb4eq19tne78GI2Ggam" 
      + "Sn8A2KOL0OKUY9E9oCA4nGO7mSG2bKMSr9DJG8WnvP1YeuwhhPGXyngs9yxKhJGx3u4j535rnKc" 
      + "7qSfS8m9fMWNt5Uia5XaAv0ZpqjZRfK9cYHaLCWYdk0SkU4Acgo8fxfyzHJHBdI49n9ydrFmHgu"
      + "ocX9TEj012vLljpVma0vJjOb0sn9hU1xSam84okZxROYsvX9SAUM9y5PfZi5KCfjaQBDkax2ZJpZ17"
      + "Fw4lR9zu5kSDrbefFt0cAwaaK3qahEmwS06t8i9oDkVL42UnLPVEHnZyGtG5jniDzEN2glNgOdljju"
      + "YKjkrARkdCu5eE1jlGpmwUxMeH2vTdU7LBtWUgIskCbz5EAtfxwUYRkmFvxpIZITvpvyTUsonzcmzS"
      + "HT78szQ6jlZfVbkMXcrfevmtDnY0fRhQQL1pMzMF7HLEbXy75PaCZg6aEmrF4YEaWpI91sySkqwpiU"
      + "25Ilqlc6N5gESE1jDBT5VTHpMnMRszCAFX7C5MfhZv5nhInmlVYhK12mYuhGdZaxLRipH1WESPUKes"
      + "eqQRD29eqwLAxbIAJreEYND2WxacZ888QyL9bzcsK3FD02";
    	Photo photo = new Photo(url, uploader);
    	photoRepository.save(photo);
    }    

    @Test(expected = ConstraintViolationException.class)
    public void shouldUrlOrPathNotBeNull() {
      Person uploader = personRepository.getOne(10);
      String url = null;
    	Photo photo = new Photo(url, uploader);
    	photoRepository.save(photo);
    }    

    @Test(expected = ConstraintViolationException.class)
    public void shouldUrlOrPathNotBeEmpty() {
      Person uploader = personRepository.getOne(10);
      String url = "";
    	Photo photo = new Photo(url, uploader);
    	photoRepository.save(photo);
    }  

}
