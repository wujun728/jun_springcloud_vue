package pers.zb.web.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.zb.web.shop.service.UserServiceFeign;

/**
 * 服务调用者
 */
@RestController
@RefreshScope //1、要想@Value所引用的属性动态更新，就必须引入该注解，则客户端调用/bus/refresh接口刷新的时候，才会获取最新git服务器上的属性值，才会动态被更新。
              //2、表示此类scope为refresh类型。允许在运行时动态地刷新bean，如果一个bean被刷新，那么下一次访问bean(即执行一个方法)时，会创建一个新实例。
public class ShopController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    /**
     * 向前端提供一个访问地址；通过userServiceFeign调用服务并返回结果
     * @return
     */
    @RequestMapping(value = "/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(){
        String result = userServiceFeign.getUser();
        return result;
    }


    /**
     * 从配置中心获取的值，其中foo为配置文件中的key。
     *      当前配置中心就采用我的码云上的测试项目 https://gitee.com/zhoubang85/springcloud-config-test.git
     */
    @Value("${message}")
    private String message;

    /**
     * 提供一个测试方法
     * @return
     */
    @RequestMapping(value = "/config/hello")
    public String hello(){
        return message;
    }
}
