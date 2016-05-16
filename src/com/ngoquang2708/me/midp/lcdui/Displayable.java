package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

import com.ngoquang2708.me.midp.lcdui.impl.NativeCommandListenerForwarder;


public abstract class Displayable {
	
	protected static final Hashtable nativeDisplayableDisplayableMap = new Hashtable();

	protected final javax.microedition.lcdui.Displayable nativeDisplayable;
	
	protected Display display;

	protected Displayable(javax.microedition.lcdui.Displayable nativeDisplayable) {
		if ((this.nativeDisplayable = nativeDisplayable) == null)
			throw new NullPointerException();
		nativeDisplayableDisplayableMap.put(nativeDisplayable, this);
	}
	
	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public void addCommand(Command cmd) {
		nativeDisplayable.addCommand(cmd.getNativeCommand());
	}

	public void removeCommand(Command cmd) {
		nativeDisplayable.removeCommand(cmd.getNativeCommand());
	}

	public int getWidth() {
		return nativeDisplayable.getWidth();
	}

	public int getHeight() {
		return nativeDisplayable.getHeight();
	}

	public boolean isShown() {
		return nativeDisplayable.isShown();
	}

	public Ticker getTicker() {
		return Ticker.of(nativeDisplayable.getTicker());
	}

	public void setTicker(Ticker ticker) {
		nativeDisplayable.setTicker(ticker.getNativeTicker());
	}

	public String getTitle() {
		return nativeDisplayable.getTitle();
	}

	public void setTitle(String s) {
		nativeDisplayable.setTitle(s);
	}

	public void setCommandListener(CommandListener commandListener) {
		nativeDisplayable.setCommandListener(new NativeCommandListenerForwarder(commandListener));
	}

	protected void sizeChanged(int w, int h) {
	}
	
	public javax.microedition.lcdui.Displayable getNativeDisplayable() {
		return nativeDisplayable;
	}
	
	public javax.microedition.lcdui.Alert asAlert() {
		return (javax.microedition.lcdui.Alert) nativeDisplayable;
	}
	
	public javax.microedition.lcdui.Form asForm() {
		return (javax.microedition.lcdui.Form) nativeDisplayable;
	}
	
	public javax.microedition.lcdui.Canvas asCanvas() {
		return (javax.microedition.lcdui.Canvas) nativeDisplayable;
	}
	
	public javax.microedition.lcdui.game.GameCanvas asGameCanvas() {
		return (javax.microedition.lcdui.game.GameCanvas) nativeDisplayable;
	}
	
	public javax.microedition.lcdui.TextBox asTextBox() {
		return (javax.microedition.lcdui.TextBox) nativeDisplayable;
	}
	
	public static Displayable of(javax.microedition.lcdui.Displayable nativeDisplayable) {
		return (Displayable) nativeDisplayableDisplayableMap.get(nativeDisplayable);
	}

}