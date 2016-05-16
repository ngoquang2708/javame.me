package com.ngoquang2708.me.midp.lcdui.impl;

import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.game.GameCanvas;

// TODO notify events to Display so that Display can dispatch to its visible canvas...
public final class CanvasObj extends GameCanvas {
	
	private static volatile CanvasObj INSTANCE;

	private CanvasObj() {
		super(false);
		setFullScreenMode(false);
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public static CanvasObj getInstance() {
		return null; //TODO
	}
}
