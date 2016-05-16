package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import com.ngoquang2708.me.cldc.io.Connection;


public class ConnectionImpl implements Connection {
	
	protected final javax.microedition.io.Connection connection;
	
	public ConnectionImpl(javax.microedition.io.Connection connection) {
		if ((this.connection = connection) == null)
			throw new NullPointerException();
	}

	public void close() throws IOException {
		connection.close();
	}
}