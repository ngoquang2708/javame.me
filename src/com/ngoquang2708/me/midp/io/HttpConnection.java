package com.ngoquang2708.me.midp.io;

import java.io.IOException;

import com.ngoquang2708.me.cldc.io.ContentConnection;

public interface HttpConnection extends ContentConnection {

	static final String HEAD = javax.microedition.io.HttpConnection.HEAD;
	static final String GET = javax.microedition.io.HttpConnection.GET;
	static final String POST = javax.microedition.io.HttpConnection.POST;

	static final int HTTP_OK = javax.microedition.io.HttpConnection.HTTP_OK;
	static final int HTTP_CREATED = javax.microedition.io.HttpConnection.HTTP_CREATED;
	static final int HTTP_ACCEPTED = javax.microedition.io.HttpConnection.HTTP_ACCEPTED;
	static final int HTTP_NOT_AUTHORITATIVE = javax.microedition.io.HttpConnection.HTTP_NOT_AUTHORITATIVE;
	static final int HTTP_NO_CONTENT = javax.microedition.io.HttpConnection.HTTP_NO_CONTENT;
	static final int HTTP_RESET = javax.microedition.io.HttpConnection.HTTP_RESET;
	static final int HTTP_PARTIAL = javax.microedition.io.HttpConnection.HTTP_PARTIAL;

	static final int HTTP_MULT_CHOICE = javax.microedition.io.HttpConnection.HTTP_MULT_CHOICE;
	static final int HTTP_MOVED_PERM = javax.microedition.io.HttpConnection.HTTP_MOVED_PERM;
	static final int HTTP_MOVED_TEMP = javax.microedition.io.HttpConnection.HTTP_MOVED_TEMP;
	static final int HTTP_SEE_OTHER = javax.microedition.io.HttpConnection.HTTP_SEE_OTHER;
	static final int HTTP_NOT_MODIFIED = javax.microedition.io.HttpConnection.HTTP_NOT_MODIFIED;
	static final int HTTP_USE_PROXY = javax.microedition.io.HttpConnection.HTTP_USE_PROXY;
	static final int HTTP_TEMP_REDIRECT = javax.microedition.io.HttpConnection.HTTP_TEMP_REDIRECT;

	static final int HTTP_BAD_REQUEST = javax.microedition.io.HttpConnection.HTTP_BAD_REQUEST;
	static final int HTTP_UNAUTHORIZED = javax.microedition.io.HttpConnection.HTTP_UNAUTHORIZED;
	static final int HTTP_PAYMENT_REQUIRED = javax.microedition.io.HttpConnection.HTTP_PAYMENT_REQUIRED;
	static final int HTTP_FORBIDDEN = javax.microedition.io.HttpConnection.HTTP_FORBIDDEN;
	static final int HTTP_NOT_FOUND = javax.microedition.io.HttpConnection.HTTP_NOT_FOUND;
	static final int HTTP_BAD_METHOD = javax.microedition.io.HttpConnection.HTTP_BAD_METHOD;
	static final int HTTP_NOT_ACCEPTABLE = javax.microedition.io.HttpConnection.HTTP_NOT_ACCEPTABLE;
	static final int HTTP_PROXY_AUTH = javax.microedition.io.HttpConnection.HTTP_PROXY_AUTH;
	static final int HTTP_CLIENT_TIMEOUT = javax.microedition.io.HttpConnection.HTTP_CLIENT_TIMEOUT;
	static final int HTTP_CONFLICT = javax.microedition.io.HttpConnection.HTTP_CONFLICT;
	static final int HTTP_GONE = javax.microedition.io.HttpConnection.HTTP_GONE;
	static final int HTTP_LENGTH_REQUIRED = javax.microedition.io.HttpConnection.HTTP_LENGTH_REQUIRED;
	static final int HTTP_PRECON_FAILED = javax.microedition.io.HttpConnection.HTTP_PRECON_FAILED;
	static final int HTTP_ENTITY_TOO_LARGE = javax.microedition.io.HttpConnection.HTTP_ENTITY_TOO_LARGE;
	static final int HTTP_REQ_TOO_LONG = javax.microedition.io.HttpConnection.HTTP_REQ_TOO_LONG;
	static final int HTTP_UNSUPPORTED_TYPE = javax.microedition.io.HttpConnection.HTTP_UNSUPPORTED_TYPE;
	static final int HTTP_UNSUPPORTED_RANGE = javax.microedition.io.HttpConnection.HTTP_UNSUPPORTED_RANGE;
	static final int HTTP_EXPECT_FAILED = javax.microedition.io.HttpConnection.HTTP_EXPECT_FAILED;

	static final int HTTP_INTERNAL_ERROR = javax.microedition.io.HttpConnection.HTTP_INTERNAL_ERROR;
	static final int HTTP_NOT_IMPLEMENTED = javax.microedition.io.HttpConnection.HTTP_NOT_IMPLEMENTED;
	static final int HTTP_BAD_GATEWAY = javax.microedition.io.HttpConnection.HTTP_BAD_GATEWAY;
	static final int HTTP_UNAVAILABLE = javax.microedition.io.HttpConnection.HTTP_UNAVAILABLE;
	static final int HTTP_GATEWAY_TIMEOUT = javax.microedition.io.HttpConnection.HTTP_GATEWAY_TIMEOUT;
	static final int HTTP_VERSION = javax.microedition.io.HttpConnection.HTTP_VERSION;

	String getURL();

	String getProtocol();

	String getHost();

	String getFile();

	String getRef();

	String getQuery();

	int getPort();

	String getRequestMethod();

	void setRequestMethod(String method) throws IOException;

	String getRequestProperty(String key);

	void setRequestProperty(String key, String value) throws IOException;

	int getResponseCode() throws IOException;

	String getResponseMessage() throws IOException;

	long getExpiration() throws IOException;

	long getDate() throws IOException;

	long getLastModified() throws IOException;

	String getHeaderField(String name) throws IOException;

	int getHeaderFieldInt(String name, int def) throws IOException;

	long getHeaderFieldDate(String name, long def) throws IOException;

	String getHeaderField(int n) throws IOException;

	String getHeaderFieldKey(int n) throws IOException;

}