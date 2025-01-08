package com.neo.controller.extrafeatures;

import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//for hateoas
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.neo.dto.ApiResponse;
import com.neo.dto.ProductRequest;
import com.neo.dto.ValidationChecker;
import com.neo.entity.Category;
import com.neo.entity.Product;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/extra-features")
public class ExtraFeature {
	@Autowired
	private MessageSource messageSource;

	@PostMapping("/check-validation")
	public ResponseEntity<ApiResponse> checkValidation(@RequestBody @Valid ValidationChecker validate) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Validation Successful"));
	}


	// Add Header Accept-Language:marathi
	@GetMapping("/get-message-i18n")
	public String getMessage() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/get-Product-using-model-mapper")
	public ProductRequest getProductModelMapper() {
		Category category = new Category(22, "Smart Phone", null);
		Product product = Product.builder()
								 .productId( 101 )
								 .name("Samsung S24 Ultra")
								 .price(89999.0f)
								 .category(category)
								 .build();

		ProductRequest dto = modelMapper.map(product, ProductRequest.class);
	
		return dto;
	}
	
}
