package kodlamaio.hrms;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
@EnableSwagger2
public class HmrsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HmrsApplication.class, args);

		//Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "javakamp", "api_key", "479489798361487",
				//"api_secret", "wvfduiLw87e9D-y3GHCKdf6kGZE", "secure", true));

		//File file = new File("pictures/b.jpg");
		//Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		
		//System.out.println(uploadResult.get("url"));
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms")).build();
	}

}
