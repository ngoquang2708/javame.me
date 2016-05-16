package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

public class Ticker {
	
	private static final Hashtable nativeTickerTickerMap = new Hashtable(); 

	protected final javax.microedition.lcdui.Ticker nativeTicker;
	
	Ticker(javax.microedition.lcdui.Ticker nativeTciker) {
		this.nativeTicker = nativeTciker;
		nativeTickerTickerMap.put(this.nativeTicker, this);
	}
	
	public Ticker(String str) {
		this(new javax.microedition.lcdui.Ticker(str));
	}

	public String getString() {
		return nativeTicker.getString();
	}

	public void setString(String str) {
		nativeTicker.setString(str);
	}

	public javax.microedition.lcdui.Ticker getNativeTicker() {
		return nativeTicker;
	}

	public static Ticker of(javax.microedition.lcdui.Ticker nativeTicker) {
		Ticker result;
		if ((result = (Ticker) nativeTickerTickerMap.get(nativeTicker)) == null) {
			synchronized (nativeTickerTickerMap) {
				if ((result = (Ticker) nativeTickerTickerMap.get(nativeTicker)) == null) {
					result = new Ticker(nativeTicker);
					nativeTickerTickerMap.put(nativeTicker, result);
				}
			}
		}
		return result;
	}
}