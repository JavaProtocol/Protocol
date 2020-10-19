package com.nukkitx.protocol.java.wrapper;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.java.JavaPacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import java.util.Collection;

public abstract class BedrockWrapperSerializer {
    protected static final InternalLogger log = InternalLoggerFactory.getInstance(BedrockWrapperSerializerV9_10.class);

    /**
     * Compress packets to a buffer for sending
     *
     * @param buffer buffer to write batched packets to
     * @param codec  packet codec
     * @param level  compression level
     */
    public abstract void serialize(ByteBuf buffer, JavaPacketCodec codec, Collection<BedrockPacket> packets, int level);

    /**
     * Decompress packets to handle
     *
     * @param buffer  buffer to write batched packets to
     * @param codec   packet codec
     * @param packets received packets
     */
    public abstract void deserialize(ByteBuf buffer, JavaPacketCodec codec, Collection<BedrockPacket> packets);
}
