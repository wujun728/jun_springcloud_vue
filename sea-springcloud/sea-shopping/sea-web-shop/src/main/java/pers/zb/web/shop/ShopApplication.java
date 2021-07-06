package pers.zb.web.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import java.util.Scanner;

/**
 * @EnableDiscoveryClient 注解的作用：使得服务调用者，有能力去Eureka中发现服务；
 * @EnableFeignClients 注解的作用：提供负载均衡的能力，同时需要在pom.xml中引入spring-cloud-starter-feign依赖
 *
 * 关于feign的教程，可参考 http://blog.csdn.net/forezp/article/details/69808079
 */
@EnableDiscoveryClient //【知识点】：服务发现的接口DiscoveryClient是Spring Cloud对服务治理做的一层抽象，所以可以屏蔽Eureka和Consul服务治理的实现细节，我们的程序不需要做任何改变，只需要引入不同的服务治理依赖，并配置相关的配置属性就能轻松的将微服务纳入Spring Cloud的各个服务治理框架中。
@EnableFeignClients
@EnableCircuitBreaker //开启断路器功能，同时在pom.xml中引入了spring-cloud-starter-hystrix，则在浏览器访问 /hystrix.stream 接口的时候，页面不会报错，这样才会使监控程序正常返回数据给页面
@EnableTurbine //开启Turbine集群监控；Turbine有一个重要的功能就是汇聚监控信息，并将汇聚到的监控信息提供给Hystrix Dashboard来集中展示和监控。Turbine汇聚的是hystrix.stream接口的数据，所以，如果是监控的当前项目自身，则还需要添加注解@EnableCircuitBreaker开启断路器，让hystrix.stream接口生效，否则turbine.stream接口不会有结果返回、同时监控仪表盘也不会显示监控内容。
@SpringBootApplication
public class ShopApplication {
    public static void main(String[] args) {
        System.out.println("================================================== 开始启动 消费者应用shop =============================================================");
        System.out.println("请在控制台指定shop应用的端口号 —— [端口号随意指定，注意不要与本机端口号出现冲突即可]");

        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine(); //让用户指定端口号
        new SpringApplicationBuilder(ShopApplication.class).properties("server.port=" + port).run(args);//启动项目

        System.out.println("================================================== 消费者应用shop 启动成功 =============================================================");
        //SpringApplication.run(ShopApplication.class,args);

        /**
         * 这样也可以启动springboot应用；
         *      其实SpringApplicationBuilder只是对SpringApplication的启动进行了封装而已；
         *      看源码就知道了，最终还是调用的SpringApplication.run方法；
         */
        //new SpringApplicationBuilder(ShopApplication.class).run(args);
    }
}
