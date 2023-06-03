package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
public class ApplicationContext {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		
		// DataSource에 대한 Driver 설정
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc://localhost/spring5fs?characterEncoding=utf8");
		ds.setUsername("res_master");
		ds.setPassword("res_master");
		
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		
		return ds;
	}
}
