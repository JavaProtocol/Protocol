package com.nukkitx.protocol.java;

import com.nukkitx.network.raknet.RakNetSession;
import com.nukkitx.protocol.java.wrapper.BedrockWrapperSerializer;
import io.netty.channel.EventLoop;

public class JavaClientSession extends JavaSession {

    JavaClientSession(RakNetSession connection, EventLoop eventLoop, BedrockWrapperSerializer serializer) {
        super(connection, eventLoop, serializer);
    }

    @Override
    public void disconnect() {
        this.checkForClosed();
        this.connection.disconnect();
    }
}
