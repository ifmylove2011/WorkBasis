package com.xter.ifornetty;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Common2Handler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		String msg = "##0313QN=20191012133710130;ST=22;CN=2011;PW=123456;MN=Y80110010000010;Flag=4;CP=&&DataTime=20191012133710;a21007-Flag=N,a21007-Rtd=0.033;a21006-Flag=N,a21006-Rtd=0.036;a21001-Flag=N,a21001-Rtd=25.4;a21002-Flag=N,a21002-Rtd=49.2;a21003-Flag=N,a21003-Rtd=101.94;a21005-Flag=N,a21005-Rtd=0.0;a21004-Flag=N,a21004-Rtd=0.0&&0b40\r\n";
//		ctx.writeAndFlush(identifiedPackage);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ctx.writeAndFlush(msg);
			}
		}).start();
	}
}
