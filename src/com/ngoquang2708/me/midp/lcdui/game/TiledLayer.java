package com.ngoquang2708.me.midp.lcdui.game;

import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.Image;

public class TiledLayer extends Layer {
	
	protected final javax.microedition.lcdui.game.TiledLayer nativeTiledLayer;
	
	TiledLayer(javax.microedition.lcdui.game.TiledLayer nativeTiledLayer) {
		super(nativeTiledLayer);
		this.nativeTiledLayer = (javax.microedition.lcdui.game.TiledLayer) getNativeLayer();
	}
    
    public TiledLayer(int cols, int rows, Image img, int tileWidth, int tileHeight) {
    	this(new javax.microedition.lcdui.game.TiledLayer(cols, rows, img.getNativeImage(), tileWidth, tileHeight));
    }
    
    public int createAnimatedTile(int staticTileIndex) {
    	return nativeTiledLayer.createAnimatedTile(staticTileIndex);
    }
    
    public int getAnimatedTile(int index) {
    	return nativeTiledLayer.getAnimatedTile(index);
    }
    
    public void setAnimatedTile(int index, int staticTileIndex) {
    	nativeTiledLayer.setAnimatedTile(index, staticTileIndex);
    }
    
    public int getCell(int col, int row) {
    	return nativeTiledLayer.getCell(col, row);
    }

    public void setCell(int col, int row, int index) {
    	nativeTiledLayer.setCell(col, row, index);
    }
    
    public void setStaticTileSet(Image image, int tileWidth, int tileHeight) {
    	nativeTiledLayer.setStaticTileSet(image.getNativeImage(), tileWidth, tileHeight);
    }

    public void fillCells(int col, int row, int numCols, int numRows, int index) {
    	nativeTiledLayer.fillCells(col, row, numCols, numRows, index);
    }
    
    public final void paint(Graphics g) {
    	nativeTiledLayer.paint(g.getNativeGraphics());
    }
    
    public javax.microedition.lcdui.game.TiledLayer getNativeTiledLayer() {
    	return nativeTiledLayer;
    }
}