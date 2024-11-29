package com.xter.ifornetty;

import com.xter.ifornetty.codec.NormalClientEncoder;
import com.xter.ifornetty.common.FunctionsChannelHandler;
import com.xter.ifornetty.common.NettyConnector;
import com.xter.util.L;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.GenericFutureListener;

public class CommonClient2 {
	private NettyConnector mConnector212;

	public static void main(String[] args) {
		CommonClient2 commonClient2 = new CommonClient2();
		commonClient2.createEnviroConnector();
		new Thread(new Runnable() {
			@Override
			public void run() {
				commonClient2.mConnector212.connect();
			}
		}).start();
	}

	private void createEnviroConnector() {
		mConnector212 = new NettyConnector.Builder()
				.group(new NioEventLoopGroup(2))
				.handler(new NettyConnector.HandlerSet() {
					@Override
					public ChannelHandler[] handlers() {
						return new ChannelHandler[]{
								new StringDecoder(),
								new StringEncoder(),
								new Common2Handler(),
								this
						};
					}
				})
				.build();
		mConnector212.setRemoteAddress("192.168.21.106", 10400);

		mConnector212.setChannelStateListener(new NettyConnector.IChannelStateListener() {
			@Override
			public void onConnectSuccess(Channel channel) {
				System.out.println(channel.remoteAddress() + " connected");
			}

			@Override
			public void onConnectFailed() {
			}

			@Override
			public void onDisconnect() {

			}

		});
	}
}
