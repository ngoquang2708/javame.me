package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.HttpsConnection;
import com.ngoquang2708.me.midp.io.SecurityInfo;


public class HttpsConnectionImpl extends HttpConnectionImpl implements HttpsConnection {
	
	protected final javax.microedition.io.HttpsConnection httpsConnection;

	public HttpsConnectionImpl(Connection connection) {
		super(connection);
		this.httpsConnection = (javax.microedition.io.HttpsConnection) this.connection;
	}

	public SecurityInfo getSecurityInfo() throws IOException {
		return new SecurityInfoImpl(httpsConnection.getSecurityInfo());
	}
}
