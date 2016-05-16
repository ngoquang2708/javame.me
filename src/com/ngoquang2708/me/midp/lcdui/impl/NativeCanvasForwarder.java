package com.ngoquang2708.me.midp.lcdui.impl;

import javax.microedition.lcdui.Graphics;

import com.ngoquang2708.me.midp.lcdui.Canvas;


public class NativeCanvasForwarder extends
		javax.microedition.lcdui.game.GameCanvas {

	private Canvas canvas;

	public NativeCanvasForwarder(boolean suppressKeyEvents) {
		super(suppressKeyEvents);
	}

	public NativeCanvasForwarder setCanvas(Canvas canvas) {
		if ((this.canvas = canvas) == null)
			throw new NullPointerException();
		return this;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	protected void hideNotify() {
		canvas.getDisplay().hideNotify(canvas);
	}

	protected void showNotify() {
		canvas.getDisplay().showNotify(canvas);
	}

	protected void keyPressed(int keyCode) {
		canvas.getDisplay().keyPressed(canvas, keyCode);
	}

	protected void keyReleased(int keyCode) {
		canvas.getDisplay().keyReleased(canvas, keyCode);
	}

	protected void keyRepeated(int keyCode) {
		canvas.getDisplay().keyRepeated(canvas, keyCode);
	}

	protected void pointerDragged(int x, int y) {
		canvas.getDisplay().pointerDragged(canvas, x, y);
	}

	protected void pointerPressed(int x, int y) {
		canvas.getDisplay().pointerPressed(canvas, x, y);
	}

	protected void pointerReleased(int x, int y) {
		canvas.getDisplay().pointerReleased(canvas, x, y);
	}

	protected void sizeChanged(int w, int h) {
		canvas.getDisplay().sizeChanged(canvas, w, h);
	}

	public void paint(Graphics g) {
		canvas.getDisplay().paint(canvas, g);
	}
}