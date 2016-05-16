package com.ngoquang2708.me.midp.lcdui.game;

import java.util.Hashtable;

import com.ngoquang2708.me.midp.lcdui.Graphics;


public abstract class Layer {
	
	private static final Hashtable nativeLayerLayerMap = new Hashtable();
	
	protected final javax.microedition.lcdui.game.Layer nativeLayer;
	
	protected Layer(javax.microedition.lcdui.game.Layer nativeLayer) {
		if ((this.nativeLayer = nativeLayer) == null)
			throw new NullPointerException();
		nativeLayerLayerMap.put(nativeLayer, this);
	}
    
    public final int getWidth() {
        return nativeLayer.getWidth();
    }
    
    public final int getHeight() {
        return nativeLayer.getHeight();
    }
    
    public final int getX() {
        return nativeLayer.getX();
    }
    
    public final int getY() {
        return nativeLayer.getY();
    }
    
    public final boolean isVisible() {
        return nativeLayer.isVisible();
    }
    
    public void move(int dx, int dy) {
    	nativeLayer.move(dx, dy);
    }
    
    public void setPosition(int x, int y) {
    	nativeLayer.setPosition(x, y);
    }
    
    public void setVisible(boolean visible) {
    	nativeLayer.setVisible(visible);
    }
    
    public javax.microedition.lcdui.game.Layer getNativeLayer() {
    	return nativeLayer;
    }
    
    public static Layer valueOf(javax.microedition.lcdui.game.Layer nativeLayer) {
    	return (Layer) nativeLayerLayerMap.get(nativeLayer);
    }
    
    public abstract void paint(Graphics g);
}
