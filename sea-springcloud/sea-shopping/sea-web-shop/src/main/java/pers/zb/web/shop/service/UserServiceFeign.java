package pers.zb.web.shop.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.zb.web.shop.service.hystrix.UserServiceHystrix;

/**
 * 这里采用的是feign处理负载均衡的。
 *      关于feign的教程，可参考 http://blog.csdn.net/forezp/article/details/69808079
 *
 * @FeignClient 注解的value的意思是：用于获取哪个服务的；其中sea-service-user是在 \sea-shopping\sea-service-user\src\main\resources\application.yml 中配置的 spring.application.name 的值，用于标识服务名
 *
 */
@FeignClient(value = "sea-service-user",fallback = UserServiceHystrix.class)
public interface UserServiceFeign {

    /**
     * @RequestMapping 用于指定调用sea-service-user服务下的 /person/1 的rest服务
     *                        这里我就写死了/person/1，实际上应该有参数传递的，使用的方法与spring的@RequestParam一样
     * @return
     */
    @RequestMapping(value = "/person/1",method = RequestMethod.GET)
    public String getUser();
}
