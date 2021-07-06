package pers.zb.server.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * 配置中心
 */
@EnableConfigServer //开启配置中心服务
@EnableEurekaClient
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        System.out.println("================================================== 开始启动 Config Server配置中心服务 =============================================================");
        System.out.println("请在控制台指定Config Server配置中心服务的端口号 —— [端口号随意指定，注意不要与本机端口号出现冲突即可]");

        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine(); //让用户指定端口号
        new SpringApplicationBuilder(ConfigApplication.class).properties("server.port=" + port).run(args);//启动项目

        System.out.println("================================================== Config Server配置中心服务启动成功 =============================================================");

    }
}
