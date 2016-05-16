package com.ngoquang2708.me.midp.lcdui;

import com.ngoquang2708.me.appmanager.ApplicationManager;
import com.ngoquang2708.me.midp.lcdui.impl.CanvasAccessor;
import com.ngoquang2708.me.midp.lcdui.impl.NativeCanvasForwarder;

public abstract class Canvas extends Displayable implements CanvasAccessor {

	public static final int UP = javax.microedition.lcdui.Canvas.UP;
	public static final int DOWN = javax.microedition.lcdui.Canvas.DOWN;
	public static final int LEFT = javax.microedition.lcdui.Canvas.LEFT;
	public static final int RIGHT = javax.microedition.lcdui.Canvas.RIGHT;
	public static final int FIRE = javax.microedition.lcdui.Canvas.FIRE;
	
	public static final int GAME_A = javax.microedition.lcdui.Canvas.GAME_A;
	public static final int GAME_B = javax.microedition.lcdui.Canvas.GAME_B;
	public static final int GAME_C = javax.microedition.lcdui.Canvas.GAME_C;
	public static final int GAME_D = javax.microedition.lcdui.Canvas.GAME_D;
	
	public static final int KEY_NUM0 = javax.microedition.lcdui.Canvas.KEY_NUM0;
	public static final int KEY_NUM1 = javax.microedition.lcdui.Canvas.KEY_NUM1;
	public static final int KEY_NUM2 = javax.microedition.lcdui.Canvas.KEY_NUM2;
	public static final int KEY_NUM3 = javax.microedition.lcdui.Canvas.KEY_NUM3;
	public static final int KEY_NUM4 = javax.microedition.lcdui.Canvas.KEY_NUM4;
	public static final int KEY_NUM5 = javax.microedition.lcdui.Canvas.KEY_NUM5;
	public static final int KEY_NUM6 = javax.microedition.lcdui.Canvas.KEY_NUM6;
	public static final int KEY_NUM7 = javax.microedition.lcdui.Canvas.KEY_NUM7;
	public static final int KEY_NUM8 = javax.microedition.lcdui.Canvas.KEY_NUM8;
	public static final int KEY_NUM9 = javax.microedition.lcdui.Canvas.KEY_NUM9;
	public static final int KEY_STAR = javax.microedition.lcdui.Canvas.KEY_STAR;
	public static final int KEY_POUND = javax.microedition.lcdui.Canvas.KEY_POUND;
	
	protected final NativeCanvasForwarder nativeCanvas;
	
	protected Canvas(javax.microedition.lcdui.Canvas nativeCanvas) {
		super(nativeCanvas);
		this.nativeCanvas = (NativeCanvasForwarder) getNativeDisplayable();
	}

	protected Canvas() {
		this(new NativeCanvasForwarder(false));
		((NativeCanvasForwarder) getNativeDisplayable()).setCanvas(this);
	}
	
	public int getGameAction(int keyCode) {
		return nativeCanvas.getKeyCode(keyCode);
	}

	public int getKeyCode(int gameAction) {
		return nativeCanvas.getKeyCode(gameAction);
	}

	public String getKeyName(int keyCode) {
		return nativeCanvas.getKeyName(keyCode);
	}

	public boolean hasPointerEvents() {
		return nativeCanvas.hasPointerEvents();
	}

	public boolean hasPointerMotionEvents() {
		return nativeCanvas.hasPointerMotionEvents();
	}

	public boolean hasRepeatEvents() {
		return nativeCanvas.hasRepeatEvents();
	}

	public boolean isDoubleBuffered() {
		return nativeCanvas.isDoubleBuffered();
	}
	
	public final void repaint(int x, int y, int width, int height) {
		Display display;
		if ((display = getDisplay()) == ApplicationManager.getCurrentDisplay())
			nativeCanvas.repaint(x, y, width, height);
		else
			display.paint(this, null);
	}

	public final void repaint() {
		repaint(0, 0, getWidth(), getHeight());
	}		
	
	public final void serviceRepaints() {
		if (getDisplay().getCurrent() == this)
			nativeCanvas.serviceRepaints();
	}
	
	public void callKeyRepeated(int keyCode) {
		keyRepeated(keyCode);
	}
	
	public void callKeyReleased(int keyCode) {
		keyReleased(keyCode);
	}
	
	public void callKeyPressed(int keyCode) {
		keyPressed(keyCode);
	}
	
	public void callPointerDragged(int x, int y) {
		pointerDragged(x, y);
	}
	
	public void callPointerReleased(int x, int y) {
		pointerReleased(x, y);
	}
	
	public void callPointerPressed(int x, int y) {
		pointerPressed(x, y);
	}
	
	public void callSizeChanged(int w, int h) {
		sizeChanged(w, h);
	}
	
	public void callHideNotify() {
		hideNotify();
	}
	
	public void callShowNotify() {
		showNotify();
	}
	
	public void setCommandListener(CommandListener commandListener) {
		super.setCommandListener(commandListener);
	}

	public void setFullScreenMode(boolean mode) {
		nativeCanvas.setFullScreenMode(mode);
	}
	
	protected void hideNotify() { }

	protected void showNotify() { }
	
	protected void keyPressed(int keyCode) { }
	
	protected void keyReleased(int keyCode) { }
	
	protected void keyRepeated(int keyCode) { }
	
	protected void pointerDragged(int x, int y) { }
	
	protected void pointerPressed(int x, int y) { }
	
	protected void pointerReleased(int x, int y) { }
	
	public abstract void paint(Graphics g);

}