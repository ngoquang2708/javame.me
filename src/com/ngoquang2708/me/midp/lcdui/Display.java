package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

import com.ngoquang2708.me.appmanager.ApplicationManager;
import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.impl.NullGraphics;
import com.ngoquang2708.me.midp.midlet.MIDlet;


public class Display {

	public static final int LIST_ELEMENT = javax.microedition.lcdui.Display.LIST_ELEMENT;
	public static final int CHOICE_GROUP_ELEMENT = javax.microedition.lcdui.Display.CHOICE_GROUP_ELEMENT;
	public static final int ALERT = javax.microedition.lcdui.Display.ALERT;
	public static final int COLOR_BACKGROUND = javax.microedition.lcdui.Display.COLOR_BACKGROUND;
	public static final int COLOR_FOREGROUND = javax.microedition.lcdui.Display.COLOR_FOREGROUND;
	public static final int COLOR_HIGHLIGHTED_BACKGROUND = javax.microedition.lcdui.Display.COLOR_HIGHLIGHTED_BACKGROUND;
	public static final int COLOR_HIGHLIGHTED_FOREGROUND = javax.microedition.lcdui.Display.COLOR_HIGHLIGHTED_FOREGROUND;
	public static final int COLOR_BORDER = javax.microedition.lcdui.Display.COLOR_BORDER;
	public static final int COLOR_HIGHLIGHTED_BORDER = javax.microedition.lcdui.Display.COLOR_HIGHLIGHTED_BORDER;
	
	private final Hashtable canvasNullGraphicsMap;
	private final Hashtable canvasGraphicsMap;
	private volatile Displayable currentDisplayable;
	private volatile Displayable nextDisplayable;

	public Display() {
		canvasNullGraphicsMap = new Hashtable();
		canvasGraphicsMap = new Hashtable();
	}

	public void callSerially(Runnable runnable) {
		ApplicationManager.getHostDisplay().callSerially(runnable);
	}

	public int numAlphaLevels() {
		return ApplicationManager.getHostDisplay().numAlphaLevels();
	}

	public int numColors() {
		return ApplicationManager.getHostDisplay().numColors();
	}

	public boolean flashBacklight(int duration) {
		return ApplicationManager.getHostDisplay().flashBacklight(duration);
	}

	public int getColor(int colorSpecifier) {
		return ApplicationManager.getHostDisplay().getColor(colorSpecifier);
	}

	public int getBorderStyle(boolean highlighted) {
		return ApplicationManager.getHostDisplay().getBorderStyle(highlighted);
	}

	public int getBestImageWidth(int imageType) {
		return ApplicationManager.getHostDisplay().getBestImageWidth(imageType);
	}

	public int getBestImageHeight(int imageType) {
		return ApplicationManager.getHostDisplay().getBestImageHeight(imageType);
	}

	public boolean isColor() {
		return ApplicationManager.getHostDisplay().isColor();
	}
	
	public Displayable getCurrent() {
		return currentDisplayable;
	}
	
	public Displayable getNext() {
		return nextDisplayable;
	}
	
	public Alert getAlert() {
		return currentDisplayable instanceof Alert ? (Alert) currentDisplayable : null;
	}

	public void setCurrent(Displayable nextDisplayable) {
		if (canvasNullGraphicsMap.get(nextDisplayable) == null)
			canvasNullGraphicsMap.put(nextDisplayable, new NullGraphics());
		if (canvasGraphicsMap.get(nextDisplayable) == null)
			canvasGraphicsMap.put(nextDisplayable, new Graphics());
		nextDisplayable.setDisplay(this);
		currentDisplayable = nextDisplayable;
		ApplicationManager.refreshDisplay();
	}

	public void setCurrent(Alert alert, Displayable nextDisplayable) {
		this.currentDisplayable = alert;
		this.nextDisplayable = nextDisplayable;
		if (canvasNullGraphicsMap.get(this.nextDisplayable) == null)
			canvasNullGraphicsMap.put(this.nextDisplayable, new NullGraphics());
		if (canvasGraphicsMap.get(this.nextDisplayable) == null)
			canvasGraphicsMap.put(this.nextDisplayable, new Graphics());
		this.nextDisplayable.setDisplay(this);
		ApplicationManager.refreshDisplay();
	}

	public void setCurrentItem(Item item) {
		setCurrent(item.getParent());
	}

	public boolean vibrate(int duration) {
		return ApplicationManager.getHostDisplay().vibrate(duration);
	}
	
	/*
	 * Implementation
	 */
	
	public void paint(Canvas canvas, javax.microedition.lcdui.Graphics nativeGraphics) {
		if (ApplicationManager.getCurrentDisplay() == this && getCurrent() == canvas) {
			Graphics g = (Graphics) canvasGraphicsMap.get(canvas);
			g.setNativeGraphics(nativeGraphics);
			canvas.paint(g);
			ApplicationManager.getOverlayDisplay().setCurrentCanvas(canvas);
			ApplicationManager.getOverlayDisplay().paint(nativeGraphics);
		} else {
			canvas.paint((Graphics) canvasNullGraphicsMap.get(canvas));
		}
	}
	
	public void hideNotify(Canvas canvas) {
		canvas.callHideNotify();
	}

	public void showNotify(Canvas canvas) {
		canvas.callShowNotify();
	}

	public void keyPressed(Canvas canvas, int keyCode) {
		if (!ApplicationManager.getOverlayDisplay().keyPressed(keyCode))
			canvas.callKeyPressed(keyCode);
	}

	public void keyReleased(Canvas canvas, int keyCode) {
		if (!ApplicationManager.getOverlayDisplay().keyReleased(keyCode))
			canvas.callKeyReleased(keyCode);
	}

	public void keyRepeated(Canvas canvas, int keyCode) {
		if (!ApplicationManager.getOverlayDisplay().keyRepeated(keyCode))
			canvas.callKeyRepeated(keyCode);
	}

	public void pointerDragged(Canvas canvas, int x, int y) {
		if (!ApplicationManager.getOverlayDisplay().pointerDragged(x, y))
			canvas.callPointerDragged(x, y);
	}

	public void pointerPressed(Canvas canvas, int x, int y) {
		if (!ApplicationManager.getOverlayDisplay().pointerPressed(x, y))
			canvas.callPointerPressed(x, y);
	}

	public void pointerReleased(Canvas canvas, int x, int y) {
		if (!ApplicationManager.getOverlayDisplay().pointerReleased(x, y))
			canvas.callPointerReleased(x, y);
	}

	public void sizeChanged(Canvas canvas, int w, int h) {
		canvas.callSizeChanged(w, h);
	}

	public static Display getDisplay(MIDlet m) {
		return ApplicationManager.getDisplay(m);
	}

}