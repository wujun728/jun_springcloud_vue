package pers.zb.service.user.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * user服务
 */
@RestController
public class UserController {

    /**
     * 只是用于测试，没有实际的业务作用。
     *      具体调用的地方，请查看 \sea-shopping\sea-web-shop\src\main\java\pers\zb\web\shop\service\UserServiceFeign.java 中的getUser() 方法的注解以及类注解；
     *
     * @param request
     * @param personId
     * @return
     */
    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(HttpServletRequest request, @PathVariable("personId") Integer personId){
        /**
         *  这里只是模拟一个用户数据，返回给客户端
         */
        Person person = new Person();
        person.setAge(30);
        person.setName("Eureka Test");
        person.setPersonId(personId);
        /**
         * 为了方便客户端浏览器清楚的看到具体调用的是哪一个user服务节点，故通过 request.getRequestURL() 来获取显示；
         * 我们都知道，request.getRequestURL() 获取的是客户端请求的地址，比如 http://localhost:8084/person/1 ，这里的8084端口，代表的就是user服务的端口号
         *
         * 假如在启动 sea-service-user服务的时候，分别指定了 8083与8084这2个端口号，则，通过浏览器访问 http://localhost:8088/router 的时候，你会发现，浏览器依次显示的内容是：
         * 第1次访问显示的内容 ： {"personId":1,"name":"Eureka Test","age":30,"msg":"http://localhost:8084/person/1"}
         * 第2次访问显示的内容 ： {"personId":1,"name":"Eureka Test","age":30,"msg":"http://localhost:8083/person/1"}
         * 第3次访问显示的内容 ： {"personId":1,"name":"Eureka Test","age":30,"msg":"http://localhost:8084/person/1"}
         * 第4次访问显示的内容 ： {"personId":1,"name":"Eureka Test","age":30,"msg":"http://localhost:8083/person/1"}
         *
         * 从浏览器显示的内容来看你会发现，客户端在调用user服务的时候，不是一味的调用相同的服务节点，而是按照对应的策略，分别调用不同的user服务器节点；
         * 这也就实现了负载均衡了；
         * 具体的，还请亲自访问看一看，这样印象深刻！
         */
        person.setMsg(request.getRequestURL().toString());
        return person;
    }






    /**
     * 模拟一个用户bean
     */
    class Person{
        private Integer personId;
        private String name;
        private int age;
        private String msg;

        public Integer getPersonId() {
            return personId;
        }

        public void setPersonId(Integer personId) {
            this.personId = personId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
