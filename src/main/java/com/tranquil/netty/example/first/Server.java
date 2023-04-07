package com.tranquil.netty.example.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: tranquil_chen
 * @Time: 2023/3/23  15:49
 * @description: netty学习
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //1、定义两个事件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //2、服务端启动方法
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer());

            //3、绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(8999).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            //4、关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
