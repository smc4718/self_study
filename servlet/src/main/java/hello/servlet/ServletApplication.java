package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan	//서블릿 자동 등록 (스프링이 자동으로 패키지 포함해서 하위 패키지 다 뒤져서 서블릿을 다 찾아서 자동으로 서블릿을 등록해서 실행할 수 있도록 도와줍니다.)
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
