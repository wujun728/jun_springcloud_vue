package com.gs.controller;

import com.gs.entity.Oauth2Client;
import com.gs.entity.Oauth2User;
import com.gs.request.RequestInfo;
import com.gs.service.CilentService;
import com.gs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author Administrator
 * @CreateDate 2018/4/17 10:21
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;
    @Resource
    private CilentService cilentService;

    @RequestMapping(value = "/findByName", method = {RequestMethod.GET, RequestMethod.POST})
    public Oauth2User show(@RequestParam(value = "name", required = false) String name) {
        logger.info("-----------name的值是：" + name);
        Oauth2User u = null;
        try {
            u = userService.findOauth2UsersByName(name);

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.info("执行请求出错：" + sw);
        }


        return u;


    }

    @RequestMapping(value = "/findByName1", method = {RequestMethod.POST})
    public Oauth2User show1(HttpSession session, @RequestBody RequestInfo requestInfo) {

        Oauth2User ooo = new Oauth2User();
        ooo.setId(354454L);
        ooo.setUsername("32432");
        ooo.setPassword("123");
        ooo.setSalt("1");

        logger.info("-----------name的值是：" + requestInfo.getName());
        Oauth2User u = userService.findOauth2UsersByName(requestInfo.getName());

        try {
            userService.saveUser(ooo);

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.info("执行请求出错：" + sw);
        }
        return u;


    }


    @RequestMapping(value = "/findClientByName", method = {RequestMethod.POST})
    public Oauth2Client show3(HttpSession session, @RequestBody RequestInfo requestInfo) {

        logger.info("-----------name的值是：" + requestInfo.getName());

        Oauth2Client o1= new Oauth2Client();
        o1.setClientId("435454-ty454-gt-45435-67");
        o1.setClientName("mmm");
        o1.setClientSecret("83423-dfr-4354-gb-32432-435");
        try{
            cilentService.saveClient(o1);
        }catch (Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.info("保存数据时发生错误："+sw);
        }

        Oauth2Client o = cilentService.findOauth2UsersByName(requestInfo.getName());
        return o;


    }

    @RequestMapping(value = "/saveClientByName", method = {RequestMethod.GET})
    public void saveshow3() {

        logger.info("-----------name的值：" );

        Oauth2Client o1= new Oauth2Client();
        o1.setClientId("werewrewfewrfew");
        o1.setClientName("ewrewewtew");
        o1.setClientSecret("sgdgrtytjuyjuyi677j6i");
        try{
            cilentService.saveClient(o1);
        }catch (Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.info("保存数据时发生错误："+sw);
        }


    }
}