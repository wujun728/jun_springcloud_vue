package com.zebra;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class EurekaApplication {
	public static void main(String[] args) {
		try{
			System.setProperty("spring.devtools.restart.enabled", "false");
			ConfigurableApplicationContext application = SpringApplication.run(EurekaApplication.class, args);
			System.out.println("(♥◠‿◠)ﾉﾞ 启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " .-------.       ____     __        \n"
					+ " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n"
					+ " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n"
					+ " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n"
					+ " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
			Environment env = application.getEnvironment();
			String ip = InetAddress.getLocalHost().getHostAddress();
			String port = env.getProperty("server.port");
			String path = env.getProperty("server.servlet.context-path");
			log.info("\n----------------------------------------------------------\n\t" +
					"Application  is running! Access URLs:\n\t" +
					"Local: \t\thttp://localhost:" + port + path + "\n\t" +
					"External: \thttp://" + ip + ":" + port + path + "\n\t" +
					"----------------------------------------------------------");
		}catch (Exception e){
			log.error("[信息]启动异常...",e);
		}
	}
}
