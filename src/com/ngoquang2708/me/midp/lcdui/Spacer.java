package com.ngoquang2708.me.midp.lcdui;

public class Spacer extends Item {
	
	protected final javax.microedition.lcdui.Spacer nativeSpacer;
	
	Spacer(javax.microedition.lcdui.Spacer nativeSpacer) {
		super(nativeSpacer);
		this.nativeSpacer = (javax.microedition.lcdui.Spacer) getNativeItem();
	}

	public Spacer(int minWidth, int minHeight) {
		this(new javax.microedition.lcdui.Spacer(minWidth, minHeight));
	}

	public void setLabel(String label) {
		super.setLabel(label);
	}

	public void addCommand(Command cmd) {
		super.addCommand(cmd);
	}

	public void setDefaultCommand(Command cmd) {
		super.setDefaultCommand(cmd);
	}
}