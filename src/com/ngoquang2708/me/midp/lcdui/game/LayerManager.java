package com.ngoquang2708.me.midp.lcdui.game;

import javax.microedition.lcdui.game.Layer;

import com.ngoquang2708.me.midp.lcdui.Graphics;


public class LayerManager extends javax.microedition.lcdui.game.LayerManager {

	public LayerManager() {
		super();
	}

	public void append(Layer layer) {
		super.append(layer);
	}

	public Layer getLayerAt(int i) {
		return super.getLayerAt(i);
	}

	public int getSize() {
		return super.getSize();
	}

	public void insert(Layer layer, int i) {
		super.insert(layer, i);
	}

	public void remove(Layer layer) {
		super.remove(layer);
	}

	public void setViewWindow(int x, int y, int width, int height) {
		super.setViewWindow(x, y, width, height);
	}
	
	public void paint(javax.microedition.lcdui.Graphics g, int x, int y) {
		super.paint(g, x, y);
	}

	public void paint(Graphics g, int x, int y) {
		this.paint(g.getNativeGraphics(), x, y);
	}
}
