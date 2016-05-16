package com.ngoquang2708.me.midp.lcdui;

import com.ngoquang2708.me.midp.lcdui.impl.NativeItemCommandListenerForwarder;

public class Gauge extends Item {
	
	protected final javax.microedition.lcdui.Gauge nativeGauge;
	
	Gauge(javax.microedition.lcdui.Gauge nativeGauge) {
		super(nativeGauge);
		this.nativeGauge = (javax.microedition.lcdui.Gauge) getNativeItem();
	}

	public Gauge(String label, boolean interactive, int maxValue, int initialValue) {
		this(new javax.microedition.lcdui.Gauge(label, interactive, maxValue, initialValue));
	}

	public void setValue(int value) {
		nativeGauge.setValue(value);
	}

	public int getValue() {
		return nativeGauge.getValue();
	}

	public void setMaxValue(int maxValue) {
		nativeGauge.setMaxValue(maxValue);
	}

	public int getMaxValue() {
		
		return nativeGauge.getMaxValue();
	}

	public boolean isInteractive() {
		return nativeGauge.isInteractive();
	}

	public void setPreferredSize(int w, int h) {
		nativeGauge.setPreferredSize(w, h);
	}

	public void setLayout(int layout) {
		nativeGauge.setLayout(layout);
	}

	public void setLabel(String label) {
		nativeGauge.setLabel(label);
	}

	public void addCommand(Command cmd) {
		nativeGauge.addCommand(cmd.getNativeCommand());
	}

	public void setDefaultCommand(Command cmd) {
		nativeGauge.setDefaultCommand(cmd.getNativeCommand());
	}

	public void setItemCommandListener(final ItemCommandListener itemCommandListener) {
		nativeGauge.setItemCommandListener(new NativeItemCommandListenerForwarder(itemCommandListener));
	}
	
	public javax.microedition.lcdui.Gauge getNativeGauge() {
		return nativeGauge;
	}
	
	public static Gauge valueOf(javax.microedition.lcdui.Gauge nativeGauge) {
		Gauge result;
		if ((result = (Gauge) nativeItemItemMap.get(nativeGauge)) == null) {
			synchronized (nativeItemItemMap) {
				if ((result = (Gauge) nativeItemItemMap.get(nativeGauge)) == null) {
					result = new Gauge(nativeGauge);
					nativeItemItemMap.put(nativeGauge, result);
				}
			}
		}
		return result;
	}
}