package com.ngoquang2708.me.midp.io.impl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.cldc.io.InputConnection;


public class InputConnectionImpl
		extends ConnectionImpl implements InputConnection {
	
	protected final javax.microedition.io.InputConnection inputConnection;

	public InputConnectionImpl(Connection connection) {
		super(connection);
		this.inputConnection = (javax.microedition.io.InputConnection) this.connection;
	}

	public InputStream openInputStream() throws IOException {
		return inputConnection.openInputStream();
	}

	public DataInputStream openDataInputStream() throws IOException {
		return inputConnection.openDataInputStream();
	}
}