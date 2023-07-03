package aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("aaa.db") // db관련 패키지 스캔, MapperScan을 여기서 안하면 코드가 길어짐
public class MybatisProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisProjApplication.class, args);
	}

}
