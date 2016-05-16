package com.ngoquang2708.me.midp.lcdui.game;

import com.ngoquang2708.me.midp.lcdui.Canvas;
import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.impl.NativeCanvasForwarder;

public abstract class GameCanvas extends Canvas {

	public static final int UP_PRESSED = javax.microedition.lcdui.game.GameCanvas.UP_PRESSED;
	public static final int DOWN_PRESSED = javax.microedition.lcdui.game.GameCanvas.DOWN_PRESSED;
	public static final int LEFT_PRESSED = javax.microedition.lcdui.game.GameCanvas.LEFT_PRESSED;
	public static final int RIGHT_PRESSED = javax.microedition.lcdui.game.GameCanvas.RIGHT_PRESSED;
	public static final int FIRE_PRESSED = javax.microedition.lcdui.game.GameCanvas.FIRE_PRESSED;
	public static final int GAME_A_PRESSED = javax.microedition.lcdui.game.GameCanvas.GAME_A_PRESSED;
	public static final int GAME_B_PRESSED = javax.microedition.lcdui.game.GameCanvas.GAME_B_PRESSED;
	public static final int GAME_C_PRESSED = javax.microedition.lcdui.game.GameCanvas.GAME_C_PRESSED;
	public static final int GAME_D_PRESSED = javax.microedition.lcdui.game.GameCanvas.GAME_D_PRESSED;
	
	protected javax.microedition.lcdui.game.GameCanvas nativeGameCanvas;
	
	GameCanvas(javax.microedition.lcdui.game.GameCanvas nativeGameCanvas) {
		super(nativeGameCanvas);
		this.nativeGameCanvas = (javax.microedition.lcdui.game.GameCanvas) getNativeDisplayable();
		((NativeCanvasForwarder) getNativeDisplayable()).setCanvas(this);
	}

	protected GameCanvas(boolean suppressKeyEvents) {
		this(new NativeCanvasForwarder(suppressKeyEvents));
	}

	public void flushGraphics(int x, int y, int width, int height) {
		nativeGameCanvas.flushGraphics(x, y, width, height);
	}

	public void flushGraphics() {
		nativeGameCanvas.flushGraphics();
	}

	public int getKeyStates() {
		return nativeGameCanvas.getKeyStates();
	}
	
	public abstract void paint(Graphics g);

}