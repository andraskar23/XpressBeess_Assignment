package com.neo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavadApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavadApplication.class, args);
	}
	
}
//	@SpringBootApplication
//	public class JavadApplication  implements CommandLineRunner {
//
//		public static void main(String[] args) {
//			SpringApplication.run(JavadApplication.class, args);
//		}
	
//	@Autowired
//	private ProductRepository productRepo;	
//	
//	@Autowired
//	private ReviewRepository reviewRepo;	
//	
//	@Override
//	public void run(String... args) throws Exception {
//		Product p1 = new Product("Watch", 4999);
//		p1.setProductId(10);
//		Product product = productRepo.save(p1);
//		Review r1 = new Review(10, 8, "Good", product);
//		Review r2 = new Review(11, 8, "Better", product);
//		Review r3 = new Review(12, 8, "Best", product);		
//		reviewRepo.save(r1);
//		reviewRepo.save(r2);
//		reviewRepo.save(r3);		
//	}	

	
//}





