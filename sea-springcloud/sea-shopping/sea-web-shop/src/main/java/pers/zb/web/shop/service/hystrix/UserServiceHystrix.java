package pers.zb.web.shop.service.hystrix;

import org.springframework.stereotype.Component;
import pers.zb.web.shop.service.UserServiceFeign;

/**
 * 需要实现 UserServiceFeign 接口
 *
 * 【注意点】feign是自带断路器hystrix的，只是没有默认打开hystrix。需要在配置文件中配置打开，将feign.hystrix.enabled设置为true，则hystrix断路器方可生效，如果不配置或者为false，则页面会报错
 *
 * @Component 将UserServiceHystrix类注入到Ioc容器中
 */
@Component
public class UserServiceHystrix implements UserServiceFeign{

    /**
     * 当 UserServiceFeign 服务不可用的时候，会回调这个方法
     * @return
     */
    @Override
    public String getUser() {
        return "hystrix断路器生效了：sorry，user is empty！";
    }
}
