package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.HttpConnection;


public class HttpConnectionImpl extends ContentConnectionImpl
		implements HttpConnection {
	
	protected final javax.microedition.io.HttpConnection httpConnection;

	public HttpConnectionImpl(Connection connection) {
		super(connection);
		this.httpConnection = (javax.microedition.io.HttpConnection) this.connection;
	}

	public String getURL() {
		return httpConnection.getURL();
	}

	public String getProtocol() {
		return httpConnection.getProtocol();
	}

	public String getHost() {
		return httpConnection.getHost();
	}

	public String getFile() {
		return httpConnection.getFile();
	}

	public String getRef() {
		return httpConnection.getRef();
	}

	public String getQuery() {
		return httpConnection.getQuery();
	}

	public int getPort() {
		return httpConnection.getPort();
	}

	public String getRequestMethod() {
		return httpConnection.getRequestMethod();
	}

	public void setRequestMethod(String method) throws IOException {
		httpConnection.setRequestMethod(method);
	}

	public String getRequestProperty(String key) {
		return httpConnection.getRequestProperty(key);
	}

	public void setRequestProperty(String key, String value) throws IOException {
		httpConnection.setRequestProperty(key, value);
	}

	public int getResponseCode() throws IOException {
		return httpConnection.getResponseCode();
	}

	public String getResponseMessage() throws IOException {
		return httpConnection.getResponseMessage();
	}

	public long getExpiration() throws IOException {
		return httpConnection.getExpiration();
	}

	public long getDate() throws IOException {
		return httpConnection.getDate();
	}

	public long getLastModified() throws IOException {
		return httpConnection.getLastModified();
	}

	public String getHeaderField(String name) throws IOException {
		return httpConnection.getHeaderField(name);
	}

	public int getHeaderFieldInt(String name, int def) throws IOException {
		return httpConnection.getHeaderFieldInt(name, def);
	}

	public long getHeaderFieldDate(String name, long def) throws IOException {
		return httpConnection.getHeaderFieldDate(name, def);
	}

	public String getHeaderField(int n) throws IOException {
		return httpConnection.getHeaderField(n);
	}

	public String getHeaderFieldKey(int n) throws IOException {
		return httpConnection.getHeaderFieldKey(n);
	}
}
