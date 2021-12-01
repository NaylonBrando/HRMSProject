package kodlamaio.hrms.core.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.entities.concrates.Image;

public interface ImageService {

	DataResult<Image> save(MultipartFile file);

	Result delete(String id);

}
