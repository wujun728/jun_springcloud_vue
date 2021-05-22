package com.zebra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * Title: 启动类<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@Slf4j
//微服务配置
@EnableFeignClients(basePackages = {"com.zebra.bussiness.feign.client"})
@EnableHystrix
public class SmpApplication {
    public static void main(String[] args) {
        try{
            System.setProperty("spring.devtools.restart.enabled", "false");
            ConfigurableApplicationContext application = SpringApplication.run(SmpApplication.class, args);
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