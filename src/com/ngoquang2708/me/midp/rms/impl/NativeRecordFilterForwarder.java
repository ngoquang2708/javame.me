package com.ngoquang2708.me.midp.rms.impl;

import com.ngoquang2708.me.midp.rms.RecordFilter;

public class NativeRecordFilterForwarder implements javax.microedition.rms.RecordFilter {
	
	protected final RecordFilter recordFilter;
	
	public NativeRecordFilterForwarder(RecordFilter recordFilter) {
		if ((this.recordFilter = recordFilter) == null)
			throw new NullPointerException();
	}

	public boolean matches(byte[] candidate) {
		return recordFilter.matches(candidate);
	}
}