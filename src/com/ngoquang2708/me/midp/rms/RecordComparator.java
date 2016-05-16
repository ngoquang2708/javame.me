package com.ngoquang2708.me.midp.rms;

public interface RecordComparator {

	static final int EQUIVALENT = 0;
	static final int FOLLOWS = 1;
	static final int PRECEDES = -1;

	int compare(byte[] rec1, byte[] rec2);

}
