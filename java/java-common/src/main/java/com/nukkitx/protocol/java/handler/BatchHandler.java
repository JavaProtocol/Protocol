package com.nukkitx.protocol.java.handler;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.java.JavaSession;
import io.netty.buffer.ByteBuf;

import java.util.Collection;

public interface BatchHandler {

    void handle(JavaSession session, ByteBuf compressed, Collection<BedrockPacket> packets);
}
