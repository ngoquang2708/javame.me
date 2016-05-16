package com.ngoquang2708.me.cldc.io;


public interface ContentConnection extends StreamConnection {

	String getType();

	String getEncoding();

	long getLength();

}