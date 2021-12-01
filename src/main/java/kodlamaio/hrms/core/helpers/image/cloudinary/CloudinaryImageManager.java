package kodlamaio.hrms.core.helpers.image.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.helpers.image.ImageService;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorDataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.entities.concrates.Image;

@Service
public class CloudinaryImageManager implements ImageService {
	private final Cloudinary cloudinary;

	@Autowired
	public CloudinaryImageManager() {
		// cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name",
		// environment.getProperty("cloudinary.cloud.name"),
		// "api_key", environment.getProperty("cloudinary.api.key"), "api_secret",
		// environment.getProperty("cloudinary.api.secret")));

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "my_cloudname", "api_key", "my_api_key",
				"api_secret", "my_api_secret", "secure", true));

		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<Image> save(final MultipartFile file) {
		final Map result;
		try {
			result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>(e.getMessage());
		}

		Image image = Image.builder().id(String.valueOf(result.get("public_id"))).url(String.valueOf(result.get("url")))
				.bytes(Integer.parseInt(String.valueOf(result.get("bytes"))))
				.format(String.valueOf(result.get("format")))
				.height(Integer.parseInt(String.valueOf(result.get("height"))))
				.width(Integer.parseInt(String.valueOf(result.get("width")))).build();

		return new SuccessDataResult<>(image);
	}

	@Override
	public Result delete(final String id) {
		try {
			cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
			return new ErrorResult(e.getMessage());
		}

		return new SuccessResult();
	}
}