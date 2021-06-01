package com.gs.test;

/**
 * @ProjectName: srpingbootdatajpa
 * @Package: com.gs.test
 * @Description: java类作用描述
 * @Author: Administrator
 * @CreateDate: 2018/4/23 17:24
 * @UpdateUser: Administrator
 * @UpdateDate: 2018/4/23 17:24
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class B {
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        B t = new B();
    }
}
