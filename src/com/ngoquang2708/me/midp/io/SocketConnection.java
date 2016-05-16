package com.ngoquang2708.me.midp.io;

import java.io.IOException;

import com.ngoquang2708.me.cldc.io.StreamConnection;

public interface SocketConnection extends StreamConnection {

	static final byte DELAY = javax.microedition.io.SocketConnection.DELAY;

	static final byte LINGER = javax.microedition.io.SocketConnection.LINGER;

	static final byte KEEPALIVE = javax.microedition.io.SocketConnection.KEEPALIVE;

	static final byte RCVBUF = javax.microedition.io.SocketConnection.RCVBUF;

	static final byte SNDBUF = javax.microedition.io.SocketConnection.SNDBUF;

	String getLocalAddress() throws IOException;
	
	String getAddress() throws IOException;

	int getLocalPort() throws IOException;

	int getPort() throws IOException;
	
	void setSocketOption(byte option, int value) throws IllegalArgumentException, IOException;

	int getSocketOption(byte option) throws IllegalArgumentException, IOException;

}
