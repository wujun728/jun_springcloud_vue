package com.wms.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.wms.common.security.annotation.EnableCustomConfig;
import com.wms.common.security.annotation.EnableRyFeignClients;
import com.wms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author wms
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class WmsGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WmsGenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
