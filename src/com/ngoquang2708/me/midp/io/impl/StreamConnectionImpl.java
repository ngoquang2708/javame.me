package com.ngoquang2708.me.midp.io.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ngoquang2708.me.cldc.io.StreamConnection;


public class StreamConnectionImpl
		extends ConnectionImpl implements StreamConnection {

	protected final javax.microedition.io.StreamConnection streamConnection;

	public StreamConnectionImpl(
			javax.microedition.io.Connection connection) {
		super(connection);
		this.streamConnection = (javax.microedition.io.StreamConnection) this.connection;
	}

	public InputStream openInputStream() throws IOException {
		return streamConnection.openInputStream();
	}

	public DataInputStream openDataInputStream() throws IOException {
		return streamConnection.openDataInputStream();
	}

	public OutputStream openOutputStream() throws IOException {
		return streamConnection.openOutputStream();
	}

	public DataOutputStream openDataOutputStream() throws IOException {
		return streamConnection.openDataOutputStream();
	}
}