package com.ngoquang2708.me.midp.lcdui.impl;

import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.game.GameCanvas;

public final class FullScreenCanvasObj extends GameCanvas {

	private FullScreenCanvasObj() {
		super(false);
		setFullScreenMode(true);
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public static FullScreenCanvasObj getInstance() {
		return null; //TODO
	}
}
