package com.ngoquang2708.me.midp.lcdui.game;

import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.Image;

public class Sprite extends Layer {

	public static final int TRANS_NONE = 0;
	public static final int TRANS_ROT90 = 5;
	public static final int TRANS_ROT180 = 3;
	public static final int TRANS_ROT270 = 6;
	public static final int TRANS_MIRROR = 2;
	public static final int TRANS_MIRROR_ROT90 = 7;
	public static final int TRANS_MIRROR_ROT180 = 1;
	public static final int TRANS_MIRROR_ROT270 = 4;
	
	protected final javax.microedition.lcdui.game.Sprite nativeSprite;
	
	Sprite(javax.microedition.lcdui.game.Sprite nativeSprite) {
		super(nativeSprite);
		this.nativeSprite = (javax.microedition.lcdui.game.Sprite) getNativeLayer();
	}

	public Sprite(Image img) {
		this(new javax.microedition.lcdui.game.Sprite(img.getNativeImage()));
	}

	public Sprite(Image img, int frameWidth, int frameHeight) {
		this(new javax.microedition.lcdui.game.Sprite(img.getNativeImage(), frameWidth, frameHeight));
	}

	public Sprite(Sprite otherSprite) {
		super(otherSprite.getNativeSprite());
		this.nativeSprite = (javax.microedition.lcdui.game.Sprite) getNativeLayer();
	}

	public final boolean collidesWith(Image image, int iX, int iY, boolean pixelLevel) {
		return nativeSprite.collidesWith(image.getNativeImage(), iX, iY, pixelLevel);
	}

	public final boolean collidesWith(TiledLayer layer, boolean pixelLevel) {
		return nativeSprite.collidesWith(layer.getNativeTiledLayer(), pixelLevel);
	}

	public final boolean collidesWith(Sprite otherSprite, boolean pixelLevel) {
		return nativeSprite.collidesWith(otherSprite.getNativeSprite(), pixelLevel);
	}

	public void defineReferencePixel(int x, int y) {
		nativeSprite.defineReferencePixel(x, y);
	}

	public int getRefPixelX() {
		return nativeSprite.getRefPixelX();
	}

	public int getRefPixelY() {
		return nativeSprite.getRefPixelY();
	}

	public void setRefPixelPosition(int x, int y) {
		nativeSprite.setRefPixelPosition(x, y);
	}

	public void defineCollisionRectangle(int x, int y, int width, int height) {
		nativeSprite.defineCollisionRectangle(x, y, width, height);
	}

	public void setFrameSequence(int[] sequence) {
		nativeSprite.setFrameSequence(sequence);
	}

	public int getFrameSequenceLength() {
		return nativeSprite.getFrameSequenceLength();
	}

	public void setFrame(int frame) {
		nativeSprite.setFrame(frame);
	}

	public void nextFrame() {
		nativeSprite.nextFrame();
	}

	public void prevFrame() {
		nativeSprite.prevFrame();
	}

	public void setImage(Image img, int frameWidth, int frameHeight) {
		nativeSprite.setImage(img.getNativeImage(), frameWidth, frameHeight);
	}

	public int getRawFrameCount() {
		return nativeSprite.getRawFrameCount();
	}

	public void setTransform(int transform) {
		nativeSprite.setTransform(transform);
	}
	
	public final void paint(Graphics g) {
		nativeSprite.paint(g.getNativeGraphics());
	}
	
	public javax.microedition.lcdui.game.Sprite getNativeSprite() {
		return nativeSprite;
	}
}