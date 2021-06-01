package com.zebra;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * Title: web容器中进行部署<br/>
 * Description: 如果不需要外部tomcat可以不用此类<br/>
 *
 * @author zebra
 * @Date 2020年3月12日
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SmpApplication.class);
	}
}
