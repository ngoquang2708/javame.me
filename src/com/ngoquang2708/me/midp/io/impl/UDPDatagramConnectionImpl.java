package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.UDPDatagramConnection;


public class UDPDatagramConnectionImpl extends DatagramConnectionImpl implements UDPDatagramConnection {
	
	protected final javax.microedition.io.UDPDatagramConnection udpDatagramConnection;

	public UDPDatagramConnectionImpl(Connection connection) {
		super(connection);
		this.udpDatagramConnection = (javax.microedition.io.UDPDatagramConnection) this.connection;
	}

	public String getLocalAddress() throws IOException {
		return udpDatagramConnection.getLocalAddress();
	}

	public int getLocalPort() throws IOException {
		return udpDatagramConnection.getLocalPort();
	}
}
