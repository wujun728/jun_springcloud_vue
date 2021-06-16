package com.zebra;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@Slf4j
public class ConfigApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("spring.devtools.restart.enabled", "false");
            ConfigurableApplicationContext application = SpringApplication.run(ConfigApplication.class, args);
            System.out.println("(♥◠‿◠)ﾉﾞ 启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " .-------.       ____     __        \n"
                    + " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n"
                    + " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n"
                    + " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n"
                    + " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
            Environment env = application.getEnvironment();
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            log.info("\n----------------------------------------------------------\n\t" +
                    "Application  is running! Access URLs:\n\t" +
                    "Local: \t\thttp://localhost:" + port + "\n\t" +
                    "External: \thttp://" + ip + ":" + port + "\n\t" +
                    "----------------------------------------------------------");
        } catch (Exception e) {
            log.error("[信息]启动异常...", e);
        }
    }

}
