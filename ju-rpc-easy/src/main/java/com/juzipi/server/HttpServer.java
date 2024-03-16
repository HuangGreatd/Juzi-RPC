package com.juzipi.server;

/**
 * HTTP 服务器接口
 *
 * 策略模式思想
 */
public interface HttpServer {
    /**
     * 启动服务器
     * @param port
     */
    void doStart(int port);
}
