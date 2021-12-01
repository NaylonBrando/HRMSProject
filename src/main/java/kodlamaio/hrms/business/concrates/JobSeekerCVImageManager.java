package kodlamaio.hrms.business.concrates;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerCVImageService;
import kodlamaio.hrms.core.business.abtracts.BaseManager;
import kodlamaio.hrms.core.helpers.image.ImageService;
import kodlamaio.hrms.core.helpers.image.cloudinary.CloudinaryImageHelper;
import kodlamaio.hrms.core.ultilities.results.DataResult;
import kodlamaio.hrms.core.ultilities.results.ErrorDataResult;
import kodlamaio.hrms.core.ultilities.results.Result;
import kodlamaio.hrms.core.ultilities.results.SuccessDataResult;
import kodlamaio.hrms.core.ultilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVImageDao;
import kodlamaio.hrms.entities.concrates.Image;
import kodlamaio.hrms.entities.concrates.JobSeekerCVImage;
import kodlamaio.hrms.core.business.constants.Messages;

@Service
public class JobSeekerCVImageManager extends BaseManager<JobSeekerCVImageDao, JobSeekerCVImage, Integer>
		implements JobSeekerCVImageService {
	private final JobSeekerCVImageDao jobSeekerCVImageDao;
	private final ImageService imageService;

	@Autowired
	public JobSeekerCVImageManager(final JobSeekerCVImageDao jobSeekerCVImageDao, final ImageService imageService) {
		super(jobSeekerCVImageDao, "Job seeker CV image");
		this.jobSeekerCVImageDao = jobSeekerCVImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result addAndSave(final JobSeekerCVImage jobSeekerCVImage, final MultipartFile file) {
		final Image result = imageService.save(file).getData();
		jobSeekerCVImage.setUrl(result.getUrl());

		return super.add(jobSeekerCVImage);
	}

	@Override
	public Result delete(final Integer id) {
		final Optional<JobSeekerCVImage> jobSeekerCVImage = jobSeekerCVImageDao.findById(id);
		if (jobSeekerCVImage.isEmpty())
			return new ErrorDataResult<JobSeekerCVImage>(Messages.deleted("Job seeker CV image"));

		final var imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(jobSeekerCVImage.get().getUrl());
		imageService.delete(imagePublicId);

		jobSeekerCVImageDao.delete(jobSeekerCVImage.get());
		return new SuccessResult(Messages.deleted("Job seeker CV Image"));
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVImages);
	}
}
