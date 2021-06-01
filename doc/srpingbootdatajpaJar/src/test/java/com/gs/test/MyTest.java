package com.gs.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: srpingbootdatajpa
 * @Package: com.gs.test
 * @Description: java类作用描述
 * @Author: Administrator
 * @CreateDate: 2018/4/23 16:44
 * @UpdateUser: Administrator
 * @UpdateDate: 2018/4/23 16:44
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class MyTest {
    public static int sum_add(int n,int sum){
        boolean is_end=true;
        sum+=n;
        is_end=(n>0) && ((sum=sum_add(sum,--n))>0);
        return sum;


    }


    public static void main(String[] args) {
       int sum =0;
      sum=  sum_add(5,sum);
        System.out.println(sum);
    }
}
