package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.SecureConnection;
import com.ngoquang2708.me.midp.io.SecurityInfo;


public class SecureConnectionImpl
		extends SocketConnectionImpl implements SecureConnection {
	
	protected final javax.microedition.io.SecureConnection secureConnection;

	public SecureConnectionImpl(Connection connection) {
		super(connection);
		this.secureConnection = (javax.microedition.io.SecureConnection) this.connection;
	}

	public SecurityInfo getSecurityInfo() throws IOException {
		return new SecurityInfoImpl(secureConnection.getSecurityInfo());
	}
}