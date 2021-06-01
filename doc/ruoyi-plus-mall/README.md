#### RuoYi-plus温馨提示：
```
1. Ruoyi-plus 下个阶段将重点打造一款多商户商城开源系统。
2. 加入vip群，将优先享受项目资源（视频/文档等）一对一技术支持等服务。
3. 数据库脚本请加QQ群，在群文件下载。
```
【技术交流群】751872263<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5wYOaQe
"><img border="0" src="https://images.gitee.com/uploads/images/2019/0808/111020_23a5e7c3_2038874.png" alt="ruoyi-plus" title="ruoyi-plus"></a>【技术支持群】687672649<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5eBNzMW"><img border="0" src="https://images.gitee.com/uploads/images/2019/0808/111020_23a5e7c3_2038874.png" alt="ruoyi-plus" title="ruoyi-plus"></a>【vip技术支持群】973275029<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5PyBndu
"><img border="0" src="https://images.gitee.com/uploads/images/2019/0808/111020_23a5e7c3_2038874.png" alt="ruoyi-plus" title="ruoyi-plus"></a>

#### 通知！！！
**RuoYi-plusv3.0-4.0版本介绍：**

1. API微服务接口实现分布式事务解决方案seata，调整API模块结构_v4。
2. 升级了代码生成模块，更大限度的提高了开发效率_v4。
3. SMP管理平台集成多商户管理模式，完美的与基础框架相融合_v3。
4. 核心模块API服务增加网关gateway基础版本_v3。 
5. v3.0为过度版本，v4.0将增加网关限流，SMP微服务介入等功能。
******************************************************************************************************************************

#### 项目介绍

-  **架构技术：**   _基于SpringBoot2.x， springcloud G版本eureka、hystrix、feign、config、gateway微服务架构体系的全新版本，集成分布式事务解决方案seata，集成redis、quartz、tk.mybatis、lombok、各种设计模式等。_ 
-  **项目优势：**   _架构更清晰、技术更前沿、代码更整洁、页面更美观、学习商用均可。可用于OA系统、 CRM系统、 PDM系统等二次开发，微服务架构学习，非常适用于公司管理平台旧版本升级、新平台搭建快速整合、同时提供API接口服务（供APP、微端、h5等使用）。_ 

#### 项目架构

RuoYi-plus-commons【通用模块架构】：

```
zebra-yritsz-smp-parent模块：所有项目父类，负责jar的依赖和版本管理。
zebra-yritsz-commons-dbean模块：通用db和bean。
zebra-yritsz-commons-redis模块：通用redis。
zebra-yritsz-commons-api模块：API服务通用jar、bean、util等。
```
RuoYi-plus-core-server【核心服务模块架构】：

```
zebra-yritsz-server-config模块：cloud配置中心服务。
zebra-yritsz-server-eureka模块：Eureka注册中心。
zebra-yritsz-server-gateway：服务网关。
```
RuoYi-plus-smp【多商户管理平台架构】：

```
zebra-yritsz-smp-smp模块：管理平台，主要为controller层和视图文件。
zebra-yritsz-smp-generator模块：代码生成器。
zebra-yritsz-smp-quartz模块：定时任务。
zebra-yritsz-smp-core模块：核心模块，包括权限处理、持久化操作、工具类、配置中心客户端、数据源等。
```
RuoYi-plus-api-service【API接口服务架构】：

```
zebra-yritsz-api-bussiness模块：业务处理模块。
zebra-yritsz-api-commodity模块：产品管理模块。
zebra-yritsz-api-order模块：订单管理模块。 
```

 
 **后台框架介绍：** 
|  序号  |  核心技术  |  框架   | 阐述 |
| --- | --- | --- | --- |
|1|核心框架|Spring Boot2.x，springcloud G版本|微服务架构体系|
|2|安全框架|Apache Shiro|core模块|
|3|模板引擎|Thymeleaf|smp模块|
|4|持久层框架|MyBatis|实现：dbean模块 配置：core模块|
|5|定时任务|Quartz|quartz模块|
|6|数据库连接池|Druid|实现：dbean模块 配置：core模块|
|7|代码生成|Velocity|generator模块    |
|8|项目管理|Maven|缺省  |
|9|缓存技术|Redis，Shiro自带缓存| （实现：redis模块， 配置：core模块），core模块   |
|10|注册中心|Eureka|注册中心application-eureka模块   |
|11|负载均衡|Feign|服务消费者consumer模块 |
|12|熔断机制|Hystrix|服务提供者provider模块 |
|13|网关路由|gateway|网关路由gateway模块 |
|14|配置中心|config|配置中心config模块 |
|15|其他插件|tk.mybatis，lombok等|（dben模块，core模块），全局  |

 **前端框架：**
|  序号  |  核心技术  |  框架   | 阐述 |
| --- | --- | --- | --- |
|1|核心框架|JQuery、Bootstrap|缺省|
|2|table表格|bootstrap-table|缺省|
|3|表格树插件|bootstrap-treetable|缺省|
|4|表单导出|bootstrap-table-export、tableExport|缺省|
|5|遮罩层弹出框|layui、layer|缺省|
|6|ztree树插件|jquery.ztree|缺省|
|7|下拉框插件|select2.min、bootstrap-select|缺省|
|8|时间插件|bootstrap-datetimepicker|缺省|
|9|富文本编辑|summernote|缺省|
|10|文件上传|bootstrap-fileinput|缺省|
|11|统计报表|echarts-all、jquery.peity、jquery.sparkline|缺省|
|12|表单验证|jquery.validate|缺省|

> **特别注意： 本项目是在开源项目RuoYi4.0（若依） 的基础上进行升级调整，感谢诺依大神。**

#### 原版RuoYi升级调整介绍

1.  **取消项目聚合：** 本人多接触快速搭建管理平台的需求，评估后感觉聚合项目不太适合，所以改使用普通父类子类集成，有新项目时直接继承统一父类，保障快速开发，版本统一。 
2.  **模块调整：** 整合system持久化模块，为通用的zebra-yritsz-commons-dbean可以供其他服务（如：微端服务、APP接口服务）使用。整合common通用模块，framework核心模块为zebra-yritsz-smp-core核心模块，对于中小项目来说，原项目模块太繁琐，各个模块分工不明确，整合为一个模块当有新项目需求时可以快速搭建。
3. **项目调整：** 增加Redis存储系统、java代码神器lombok、消息转换器HttpMessageConverter...
4. **框架管理：** 增加tk.mybatis插件，原项目虽然可以用代码生成器直接生成增删改查语句，但是繁琐业务下，需要在xml写sql映射过于繁琐，使用tk.mybatis插件可以直接使用封装快速方法，极高的保障了开发的效率。
5.  **配置管理：** 增加cloud config配置中心，当项目生态系统不仅限于管理平台，繁琐的配置成为增加工作量和出现问题的关键，所以增加配置中心，统一管理配置文件。
6.  **增加模块：** 增加redis通用模块（可选），config-servser配置中心模块（可选），API接口服务模块（独立）。 
7.  **服务体系：** 3.0版本不在局限于单一的后台管理框架，重点打造RuoYi-plus管理平台生态圈，增加API接口服务（供APP、微端、h5等使用），该服务以spring cloud为核心，使用Eureka为注册中心、gateway网关、Feign负载、Hystrix熔断器，4.0版本成功集成分布式事务解决方案seata。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0714/135757_cbf2decc_2038874.jpeg "1562921075(1).jpg")

#### 项目部署要求
- JDK-v1.8
- MySql-v5.7.x（建议）
- Maven-v3.3.x（建议）
- SVN服务器（可选）如果使用配置中心则需要此项，反之 **需要调整代码不通过springCloud config获取配置信息** ，或者使用git。
- GIT服务器（可选）如果使用配置中心则需要此项，反之 **需要调整代码不通过springCloud config获取配置信息** ，或者使用svn。
******************************************************************************************************************************

#### 项目运行须知
1. 项目运行有两种模式，详细见项目运行步骤。
2. redis如果不需要，可以保留（不用搭建redis服务器也可以启动成功）。 

#### SMP项目运行步骤一： **使用配置中心** 
1. 创建数据库，执行数据库脚本;导入项目，导入完成后需要确保是maven项目，如果不是需要转换成maven项目。
2. 发布项目到maven仓库，依次为zebra-yritsz-smp-parent->zebra-yritsz-commons-dbean->zebra-yritsz-smp-core/generator/quartz 。
3. 启动zebra-yritsz-server-config模块，该模块为springCloud config-server端 ，需要svn服务器或git服务器把配置中心文件放到对应svn/git上，并且需要配置bootstrap.properties文件。![输入图片说明](https://images.gitee.com/uploads/images/2019/0715/134215_78272869_2038874.jpeg "1563169313(1).jpg")
4. 启动zebra-yritsz-smp-smp，如果使用springCloud config需要配置bootstrap.properties文件。![输入图片说明](https://images.gitee.com/uploads/images/2019/0715/135500_380c9fc3_2038874.jpeg "1563170081(1).jpg")

#### SMP项目运行步骤二： **不使用配置中心** 
1. 创建数据库，执行数据库脚本;导入项目，导入完成后需要确保是maven项目，如果不是需要转换成maven项目。
2. 发布项目到maven仓库，依次为zebra-yritsz-smp-parent->zebra-yritsz-commons-dbean->zebra-yritsz-smp-core/generator/quartz。
4. 把配置中心文件放入项目resources目录下，删除config相关依赖，启动zebra-yritsz-smp-smp。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0809/095055_bf4c3fd1_2038874.jpeg "1565315429(1).jpg")

#### API项目运行步骤：
1. 启动zebra-yritsz-application-eureka注册中心模块。
2. 启动zebra-yritsz-server-config配置中心模块。
3. 启动zebra-yritsz-server-gateway网关模块。
4. 启动zebra-yritsz-api-bussiness业务模块。
5. 启动zebra-yritsz-api-commodity产品模块。
6. 启动zebra-yritsz-api-order订单模块。
7. 如需使用分布式事务，需要启动seata服务。

注：参考SMP项目运行步骤
![输入图片说明](https://images.gitee.com/uploads/images/2019/0813/105232_d3785635_2038874.jpeg "1565664767(1).jpg")
******************************************************************************************************************************

#### RuoYi-plus版本介绍：
 **RuoYi-plusv2.0版本：** ，该版本不在局限于单一的后台管理框架，重点打造RuoYi-plus管理平台生态圈，增加API接口服务（供APP、微端、h5等使用），API接口服务概述：
1. API接口服务与smp管理平台完全分离，只依赖通用dbean模块和统一父类。 
2. 服务提供者负责DB交互通用dbean模块。
3. 服务消费者负对外开放包括APP、微端、h5等，不负责业务逻辑处理（后期增加【验签】保证API接口服务的安全性）。
4. API接口服务使用Eureka为注册中心，消费者负载使用Feign并使用Hystrix熔断器。

#### 技术交流
- 官方技术QQ交流号：1579927646  **技术支持（不涉及复杂问题免费）** 
- 官方QQ技术交流群：751872263<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5wYOaQe
"><img border="0" src="https://images.gitee.com/uploads/images/2019/0808/111020_23a5e7c3_2038874.png" alt="ruoyi-plus" title="ruoyi-plus"></a> 免费入群，数据库脚本和配置中心文件在群文件 。
- 官方QQ技术支持群：687672649<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5eBNzMW"><img border="0" src="https://images.gitee.com/uploads/images/2019/0808/111020_23a5e7c3_2038874.png" alt="ruoyi-plus" title="ruoyi-plus"></a>技术问题讨论群。
- 【vip技术支持群】973275029<a target="_blank" href="https://jq.qq.com/?_wv=1027&k=5PyBndu
"><img border="0" src="https://images.gitee.com/uploads/images/2019/0808/111020_23a5e7c3_2038874.png" alt="ruoyi-plus" title="ruoyi-plus"></a> 进群前请私聊群主，购买入群码进去。
### 商用须知
本项目遵循MIT协议，无需授权,留言备注公司信息即可。

已接入的公司包括不限于：
> 1. 中体路跑体育产业文化公司
> 2. 盈远智慧科技(深圳)有限公司
> 3. 重庆市雾洲软件有限公司

#### 演示地址
- 地址：http://www.yritsz.com/ruoyi-plus
- 账号：tecom 
- 密码：123456

#### 源码地址
- Gitee(主)：https://gitee.com/aimeng2017/RuoYi-plus
- Github(辅)：https://github.com/zebra-ruoyi-plus/ruoyi-plus

#### 加入社区
![输入图片说明](https://images.gitee.com/uploads/images/2020/0313/114313_3651665d_2038874.png "扫码_搜索联合传播样式-标准色版.png")