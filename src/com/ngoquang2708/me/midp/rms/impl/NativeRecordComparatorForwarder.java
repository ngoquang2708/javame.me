package com.ngoquang2708.me.midp.rms.impl;

import com.ngoquang2708.me.midp.rms.RecordComparator;

public class NativeRecordComparatorForwarder
		implements javax.microedition.rms.RecordComparator {
	
	protected final RecordComparator recordComparator;
	
	public NativeRecordComparatorForwarder(RecordComparator recordComparator) {
		if ((this.recordComparator = recordComparator) == null)
			throw new NullPointerException();
	}

	public int compare(byte[] rec1, byte[] rec2) {
		return recordComparator.compare(rec1, rec2);
	}
}
