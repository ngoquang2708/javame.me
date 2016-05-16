package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.cldc.io.StreamConnection;
import com.ngoquang2708.me.cldc.io.StreamConnectionNotifier;


public class StreamConnectionNotifierImpl
		extends ConnectionImpl implements StreamConnectionNotifier {
	
	protected final javax.microedition.io.ServerSocketConnection serverSocketConnection;

	public StreamConnectionNotifierImpl(Connection connection) {
		super(connection);
		this.serverSocketConnection = (javax.microedition.io.ServerSocketConnection) this.connection;
	}

	public StreamConnection acceptAndOpen() throws IOException {
		return new StreamConnectionImpl(serverSocketConnection.acceptAndOpen());
	}

}