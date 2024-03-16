package com.juzipi.example.consumer;

import com.juzipi.common.model.User;
import com.juzipi.common.service.UserService;
import com.juzipi.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class ExampleConsumerExample {

    public static void main(String[] args) {
        //todo 需要获取 UserService 的实现类对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("juzipi");
        //调用
        User newUser = userService.getUser(user);
        if (newUser!= null) {
            System.out.println(newUser.getName());
        }else {
            System.out.println("user == null");
        }
    }

}
