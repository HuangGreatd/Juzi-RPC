package com.juzipi.example.provider;

import com.juzipi.common.service.UserService;
import com.juzipi.registry.LocalRegistry;
import com.juzipi.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        //提供服务
        VertxHttpServer vertxHttpServer = new VertxHttpServer();
        vertxHttpServer.doStart(8080);
    }
}
