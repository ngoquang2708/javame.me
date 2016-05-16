package com.ngoquang2708.me.midp.io.file.impl;

import com.ngoquang2708.me.midp.io.file.FileSystemListener;

public class NativeFileSystemListenerForwarder implements javax.microedition.io.file.FileSystemListener {
	
	protected final FileSystemListener fileSystemListener;
	
	public NativeFileSystemListenerForwarder(FileSystemListener fileSystemListener) {
		if ((this.fileSystemListener = fileSystemListener) == null)
			throw new NullPointerException();
	}

	public void rootChanged(int state, String rootName) {
		fileSystemListener.rootChanged(state, rootName);
	}
}