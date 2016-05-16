package com.ngoquang2708.me.midp.rms;

public interface RecordFilter {

	boolean matches(byte[] candidate);

}
