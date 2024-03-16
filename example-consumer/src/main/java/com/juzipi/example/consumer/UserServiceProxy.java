package com.juzipi.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.juzipi.common.model.User;
import com.juzipi.common.service.UserService;
import com.juzipi.model.RpcRequest;
import com.juzipi.model.RpcResponse;
import com.juzipi.serializer.JdkSerializer;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {
    public User getUser(User user) {
        //指定序列化器
        JdkSerializer serializer = new JdkSerializer();

        //发起请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();

        try {
            byte[] bodyBtytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse execute = HttpRequest.post("http://127.0.0.1:8080").body(bodyBtytes)
                    .execute()) {
                result = execute.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
