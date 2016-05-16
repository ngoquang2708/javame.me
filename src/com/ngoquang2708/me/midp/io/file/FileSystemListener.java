package com.ngoquang2708.me.midp.io.file;

public interface FileSystemListener {

	static final int ROOT_ADDED = javax.microedition.io.file.FileSystemListener.ROOT_ADDED;

	static final int ROOT_REMOVED = javax.microedition.io.file.FileSystemListener.ROOT_REMOVED;

	void rootChanged(int state, String rootName);

}
