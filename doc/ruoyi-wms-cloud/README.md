## 平台简介

基于若依微服务源码做一个集成docker脚本的小demo,原代码结构不变，只添加了部分功能模块。

* 采用前后端分离的模式，微服务版本前端(基于 [RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue))。
* 后端采用Spring Boot、Spring Cloud & Alibaba。
* 注册中心、配置中心选型Nacos，权限认证使用Redis。
* 流量控制框架选型Sentinel，分布式事务选型Seata。


#### 友情链接 [若依/RuoYi-Cloud](https://gitee.com/zhangmrit/ruoyi-cloud) Ant Design版本。


## 架构图

<img src="https://oscimg.oschina.net/oscnet/up-82e9722ecb846786405a904bafcf19f73f3.png"/>

## ruoyi内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 在线构建器：拖动表单元素生成相应的HTML代码。
17. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 新增wms-oms模块

1.  商品管理：商品类型，规格，详情等设置。
2.  采购管理：采购单录入。
3.  销售管理：销售单录入。
4.  库存管理：库存查询。


##代码改动：
1.  添加mybatis-plus,多租户简单实现。
2.  添加dockerfile,镜像打包。
3.  添加docker-compose脚本，集成yapi
4.  添加junit测试。
5.  改动了数据库脚本。
6.  前端功能还没开发完成，暂未开源发布。

nacos指令：startup  -m standalone 
本地运行先设置hosts

127.0.0.1   nacos<br>
127.0.0.1   mysql<br>
127.0.0.1   redis<br>
127.0.0.1   wms-auth<br>
127.0.0.1   wms-gateway<br>
127.0.0.1   wms-system<br>
127.0.0.1   wms-oms<br>
127.0.0.1   wms-file<br>
127.0.0.1   wms-gen<br>
127.0.0.1   wms-job<br>

## 演示图

<table>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/082529_01488c76_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/082724_2cfc86d1_9060750.png"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/082826_f3ac5383_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/082928_3d86bb01_9060750.png"/></td>
    </tr>
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083055_e237ebfb_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083134_b8ab0184_9060750.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083218_104e17ab_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083253_7eba203b_9060750.png"/></td>
    </tr>	 
    <tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083352_5489594d_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083431_c1d75e55_9060750.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083524_ac35d5cc_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083635_d4693b81_9060750.png"/></td>
    </tr>
	<tr>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083728_bcb6250b_9060750.png"/></td>
        <td><img src="https://images.gitee.com/uploads/images/2021/0530/083830_ae25cef1_9060750.png"/></td>
    </tr>
</table>

## 测试地址：
http://8.135.119.210:70/
用户名：test<br>
密码:123456
## 联系方式：
![输入图片说明](https://images.gitee.com/uploads/images/2021/0530/085933_54db39b6_9060750.jpeg "微信图片_20210530085923.jpg")