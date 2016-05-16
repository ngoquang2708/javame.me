package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.ServerSocketConnection;


public class ServerSocketConnectionImpl
		extends StreamConnectionNotifierImpl
		implements ServerSocketConnection {

	protected final javax.microedition.io.ServerSocketConnection serverSocketConnection;

	public ServerSocketConnectionImpl(Connection connection) {
		super(connection);
		this.serverSocketConnection = (javax.microedition.io.ServerSocketConnection) this.connection;
	}

	public String getLocalAddress() throws IOException {
		return serverSocketConnection.getLocalAddress();
	}

	public int getLocalPort() throws IOException {
		return serverSocketConnection.getLocalPort();
	}
}