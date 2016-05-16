package com.ngoquang2708.me.appmanager;


import com.ngoquang2708.me.midp.lcdui.Canvas;
import com.ngoquang2708.widget.BaseContainer;

public abstract class OverlayDisplay extends BaseContainer {

	private javax.microedition.lcdui.Canvas c = new javax.microedition.lcdui.Canvas() {

		protected void paint(javax.microedition.lcdui.Graphics g) {
		}
	};

	private volatile Canvas currentCanvas;

	protected OverlayDisplay() { }

	public void setCurrentCanvas(Canvas canvas) {
		this.currentCanvas = canvas;
	}

	public Canvas getCurrentCanvas() {
		return currentCanvas;
	}

	public int getAbsX() {
		return 0;
	}

	public int getX() {
		return 0;
	}

	public int getAbsY() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public int getScrollX() {
		return 0;
	}

	public int getScrollY() {
		return 0;
	}

	public int getPrefW() {
		return c.getWidth();
	}

	public int getPrefH() {
		return c.getHeight();
	}
}