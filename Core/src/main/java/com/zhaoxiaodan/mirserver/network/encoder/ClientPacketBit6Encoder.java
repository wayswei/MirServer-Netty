package com.zhaoxiaodan.mirserver.network.encoder;

import com.zhaoxiaodan.mirserver.network.Bit6Coder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;


public class ClientPacketBit6Encoder extends MessageToMessageEncoder<ByteBuf> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		ByteBuf buf = Unpooled.buffer();

		buf.writeByte('#');     // 加上 头分割符
		buf.writeByte(in.readByte());

		byte[] body = new byte[in.readableBytes()];
		in.readBytes(body);
		buf.writeBytes(Bit6Coder.encoder6BitBuf(body));

		buf.writeByte('!');     // 加上 尾分割符

		out.add(buf);
	}
}
