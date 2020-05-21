package com.cqcfsw.databatch.configure;

import com.cqcfsw.databatch.handler.MyStringWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import javax.annotation.Resource;

/**
 * 当客户端通过 /connect url 和服务端连接通信时,使用 MyStringWebSocketHandler 处理会话。
 * withSockJS 的含义是，通信的客户端是通过 SockJS 实现
 * @author baofengxueque
 * @create 2020-05-19-14:06
 */
@Configuration
@EnableWebSocket
public class WebSocketServerConfigure implements WebSocketConfigurer {

    @Resource
    private MyStringWebSocketHandler myStringWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myStringWebSocketHandler, "/connect").withSockJS();
    }
}