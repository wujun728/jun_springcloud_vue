<br/>

 **项目wiki文档 [https://gitee.com/zhoubang85/sea-springcloud/wikis/pages](https://gitee.com/zhoubang85/sea-springcloud/wikis/pages)** 


#### springcloud全家桶
> 项目中使用的技术如下：
- Eureka注册中心 （支持集群部署）
- Config注册中心 （支持集群部署）
- Zuul 服务网关  （支持集群部署）
- Hystrix 断路器
- Ribbon 负载均衡
- Feign 负载均衡
- Turbine 聚合监控
- Bus 消息总线

> 服务与应用
- user服务提供者 （支持集群部署）
- shop服务消费者 （支持集群部署）


#### 项目启动
##### 1、前期准备
- 首先在本地电脑的host文件中，配置好虚拟域名；
> 虚拟域名需要与sea-server-eureka、sea-service-user、sea-web-shop中application.yml中配置的eureka.client.service-url.defaultZone的域名一致；
 
我本地host文件中的配置如下（注意中间空格）：
```
127.0.0.1 server.eureka.slave1.com server.eureka.slave2.com
```
- 安装rabbitmq
```
rabbitmq目前只用在配置中心，实现动态刷新spring bean，建议安装。
```

##### 2、开发环境（以下是我本机环境）

- jdk1.8
- idea 2017.3

##### 3、服务启动
1、启动eureka注册中心 - 运行\sea-server-eureka\src\main\java\pers\zb\server\eureka\EurekaServer.java 中的main方法
```
（建议运行至少2个eureka服务器节点，方可看到高可用集群效果）
```
<br/>

2、启动config配置中心 - 运行\sea-server-config\src\main\java\pers\zb\server\config\ConfigApplication.java 中的main方法
```
（建议运行至少2个config配置中心节点，方可看到高可用集群效果）
```
<br/>

3、启动zuul服务网关 - 运行\sea-service-zuul\src\main\java\pers\zb\service\zuul\ZuulApplication.java 中的main方法
```
（建议运行至少2个zuul服务网关节点，方可看到高可用集群效果）
```
<br/>

4、启动hystrix dashboard仪表盘服务 - 运行\sea-web-hystrix-dashboard\src\main\java\pers\zb\web\hystrix\dashboard\HystrixDashboardApplication.java 中的main方法

<br/>

5、启动user服务 - 运行\sea-service-user\src\main\java\pers\zb\service\user\UserServiceApplication.java 中的main方法
```
（建议运行至少2个user服务节点，方可看到高可用集群效果）
```
<br/>

6、启动shop应用 - 运行\sea-web-shop\src\main\java\pers\zb\web\shop\ShopApplication.java 中的main方法
```
（建议运行至少2个shop应用节点，方可看到高可用集群效果）
```
<br/>

#### 打开eureka控制台，查看各服务的集群信息
- 根据在\sea-server-eureka\src\main\resources\application.yml中配置的eureka服务器的地址，在浏览器中输入：
<br/>http://127.0.0.1:18761 或者 http://127.0.0.1:28761 即可进入eureka控制台（其中，18761和28761代表不同的eureka服务器的端口号）

- eureka控制台截图
![springcloud eureka控制台](https://gitee.com/uploads/images/2018/0323/044238_7c12e81e_341760.jpeg "springcloud eureka控制台.jpg")


#### 访问项目，查看效果
 -  **直接访问shop应用**
 > http://127.0.0.1:(shop应用的端口号)/router
```
查看user服务的调用效果：观察浏览器的输出内容，通过 msg 的值可以看到其中的端口号发生了变化，也就说明调用了不同的user服务节点，实现了负载均衡。具体代码请查看 \sea-web-shop\src\main\java\pers\zb\web\shop\service\UserServiceFeign.java
```
 -  **通过zuul服务网关访问shop应用**
 > http://127.0.0.1:(zuul服务网关的端口号)/api-shop/router
```
最终效果与上面的直接访问shop的效果是一样的，主要区别就是访问路径发生了变化。被zuul网关拦截处理，再进行转发请求shop应用。具体zuul配置请查看 \sea-service-zuul\src\main\resources\application.yml
```
 -  **修改git仓库配置文件属性值，实现动态刷新spring bean属性**
> git使用的是我的码云的项目 https://gitee.com/zhoubang85/springcloud-config-test

> 具体需要测试的地方在 \sea-web-shop\src\main\java\pers\zb\web\shop\controller\ShopController.java中的@Value("${message}")<br/><br/>
> 这个message的值是shop应用启动的时候从config配置中心获取的，而配置中心是从git远程仓库获取的<br/><br/>
> 当git仓库的配置文件属性值发生了变化后，要想让shop应用在不需要重启的状态下，动态刷新@Value("${message}")的值，就需要结合Bus消息总线来实现<br/><br/>
> 故：本地需要提前安装好rabbitmq，这里就不演示如何安装了，请自行解决<br/><br/>

> 下面开始操作：<br/><br/>
1、首先查看一下message的值，浏览器访问http://localhost:(shop应用的端口号)/config/hello ，显示的内容就是当前应用上下文中的message属性值
<br/><br/>2、访问上面的码云git项目，找到sea-web-shop-dev.properties属性文件，修改文件中的message属性值并提交
<br/><br/>3、git仓库中午文件修改之后，shop应用并没有动态更新message的值，需要我们手动调用一下接口http://localhost:(shop应用的端口号)/bus/refresh ，该接口只支持POST请求，本地测试的话建议使用postmain工具
<br/><br/>4、请求/bus/refresh后，及时切换到idea并打开shop应用控制台（如果启动多个shop应用的话，每个shop应用都会有更新），就会看到shop应用会自动获取git仓库最新内容，并实现动态更新bean属性值，其中的实现原理就是利用了MQ。
<br/><br/>5、在shop应用不重启的情况下，浏览器再次访问http://localhost:(shop应用的端口号)/config/hello ，这时候你就会发现，显示的内容已经是git仓库最新值

 -  **Turbine聚合监控**
> 当前项目都是集群环境，所以我们采用Turbine实现服务的监控；至于如何配置实现的，请查看\sea-web-shop\pom.xml与\sea-web-hystrix-dashboard\pom.xml中的相关依赖配置，以及启动类的注解配置。
> 访问仪表盘，查看服务运行状态：<br/><br/>
> 1、浏览器访问http://localhost:2001/hystrix ，会进入Hystrix Dashboard界面；其中的2001是hystrix-dashboard应用的端口号<br/><br/>
> 2、在文本框中输入要监控的服务地址http://localhost:(shop应用的端口号)/turbine.stream ，这里我们就监控shop应用，在title文本框中随意输入名称即可，然后点击Monitor Stream按钮进入监控后台页面<br/><br/>
> 3、监控效果截图：<br/>
![Hystrix Dashboard监控仪表盘](https://gitee.com/uploads/images/2018/0323/044320_5e55e8e7_341760.jpeg "Hystrix Dashboard监控仪表盘.jpg")

> 至于监控仪表的内容都是什么含义，请自行网上查找资料

 -  **Hystrix断路器效果**
> 断路器的作用，我就不多说了，请网上自行查找资料了解<br/><br/>
> 我本地启动的是2个shop应用实例，端口分别是8087、8088<br/><br/>
> 在这2个应用都正常的情况下，浏览器分别访问这2个应用的/router方法（http://localhost:8087/router和http://localhost:8088/router）， 都会正常的返回JSON结果，比如：{"personId":1,"name":"EurekaTest","age":30,"msg":"http://localhost:8084/person/1"}<br/><br/>
> 这时候，我们随意关闭其中一个user服务（这里我关闭的是8087端口的服务），浏览器重新访问shop的/router方法<br/><br/>
> 这时候你会发现：<br/>
> - 在前2、3分钟内，网页上显示的内容有可能是正常的JSON数据，有时会出现“hystrix断路器生效了...”的字样！说明断路器生效了
> - 然后等eureka注册中心剔除这个down掉的user节点后，再重新访问/router方法，你会发现一直返回的是正常的JSON数据，不再出现“hystrix断路器生效了...”的字样，毕竟还有一个user节点是可用状态的。<br/>

> 断路器效果：<br/>
![Hystrix断路器效果](https://gitee.com/uploads/images/2018/0323/044340_55bc14d8_341760.jpeg "Hystrix断路器效果.jpg")

> 具体的断路器代码处理，请查看\sea-web-shop\src\main\java\pers\zb\web\shop\service\UserServiceFeign.java与UserServiceHystrix.java的相关注解，以及main启动类的相关注解

#### 《发行版》板块的说明
《发行版》板块中的内容，是一些细化的springcloud技术的案例，方便大家的学习；在不同版本中，都是独立的技术，需要学习什么技术的，可以按照需要下载对应的案例源码；
详细的内容，请看当前项目上面菜单栏中的《发行版》。

#### 项目动态
> 目前项目中只有这几样技术内容，涉及到多数springcloud的技术，后面会根据自己所学，一点点的积累，基础学习之后再进行深入的研究学习，并在项目中更新并分享给大家。
