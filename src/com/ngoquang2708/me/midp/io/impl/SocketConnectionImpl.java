package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.SocketConnection;


public class SocketConnectionImpl
		extends StreamConnectionImpl implements SocketConnection {
	
	protected final javax.microedition.io.SocketConnection socketConnection;

	public SocketConnectionImpl(Connection connection) {
		super(connection);
		this.socketConnection = (javax.microedition.io.SocketConnection) this.connection;
	}

	public void setSocketOption(byte option, int value)
			throws IllegalArgumentException, IOException {
		socketConnection.setSocketOption(option, value);
		
	}

	public int getSocketOption(byte option)
			throws IllegalArgumentException, IOException {
		return socketConnection.getSocketOption(option);
	}

	public String getLocalAddress() throws IOException {
		return socketConnection.getLocalAddress();
	}

	public int getLocalPort() throws IOException {
		return socketConnection.getLocalPort();
	}

	public String getAddress() throws IOException {
		return socketConnection.getAddress();
	}

	public int getPort() throws IOException {
		return socketConnection.getPort();
	}
}
