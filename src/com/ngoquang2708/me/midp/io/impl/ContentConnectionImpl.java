package com.ngoquang2708.me.midp.io.impl;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.cldc.io.ContentConnection;


public class ContentConnectionImpl
		extends StreamConnectionImpl
		implements ContentConnection {
	
	protected final javax.microedition.io.ContentConnection contentConnection;

	public ContentConnectionImpl(Connection connection) {
		super(connection);
		this.contentConnection = (javax.microedition.io.ContentConnection) this.connection;
	}

	public String getType() {
		return contentConnection.getType();
	}

	public String getEncoding() {
		return contentConnection.getEncoding();
	}

	public long getLength() {
		return contentConnection.getLength();
	}
}