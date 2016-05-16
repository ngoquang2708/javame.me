package com.ngoquang2708.me.midp.rms.impl;

import com.ngoquang2708.me.midp.rms.RecordListener;
import com.ngoquang2708.me.midp.rms.RecordStore;

public class NativeRecordListenerForwarder implements javax.microedition.rms.RecordListener {
	
	protected final RecordListener recordListener;
	
	public NativeRecordListenerForwarder(RecordListener recordListener) {
		if ((this.recordListener = recordListener) == null)
			throw new NullPointerException();
	}

	public void recordAdded(javax.microedition.rms.RecordStore nativeRecordStore, int recordId) {
		recordListener.recordAdded(RecordStore.of(nativeRecordStore), recordId);
	}

	public void recordChanged(javax.microedition.rms.RecordStore nativeRecordStore, int recordId) {
		recordListener.recordChanged(RecordStore.of(nativeRecordStore), recordId);
	}

	public void recordDeleted(javax.microedition.rms.RecordStore nativeRecordStore, int recordId) {
		recordListener.recordDeleted(RecordStore.of(nativeRecordStore), recordId);
	}
}