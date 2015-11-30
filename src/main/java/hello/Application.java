package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tankwar.model.Battle;
import tankwar.repo.BattleRepository;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
public class Application {

	public static BattleRepository repo;
	
    public static void main(String[] args) {
    	
    	repo = new BattleRepository();
    	
    	repo.addBattle(new Battle("Test Player1", "Begin... End..."));
    	repo.addBattle(new Battle("Test Player2", "Begin... End..."));
    	
        SpringApplication.run(Application.class, args);
        
    }
    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/tanks/.*"))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "My Project's REST API",
            "This is a description of your API.",
            "API TOS",
            "me@wherever.com",
            "API License",
            "API License URL", null
        );
        return apiInfo;
    }
    
    @Bean
    UiConfiguration uiConfig() {
      return new UiConfiguration(
          "validatorUrl");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
