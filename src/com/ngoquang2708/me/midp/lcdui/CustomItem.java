package com.ngoquang2708.me.midp.lcdui;

import com.ngoquang2708.me.midp.lcdui.impl.NativeCustomItemForwarder;

public abstract class CustomItem extends Item {

	protected static final int TRAVERSE_HORIZONTAL = 1;
	protected static final int TRAVERSE_VERTICAL = 2;
	protected static final int KEY_PRESS = 4;
	protected static final int KEY_RELEASE = 8;
	protected static final int KEY_REPEAT = 0x10;
	protected static final int POINTER_PRESS = 0x20;
	protected static final int POINTER_RELEASE = 0x40;
	protected static final int POINTER_DRAG = 0x80;
	protected static final int NONE = 0x00;
	
	final NativeCustomItemForwarder nativeCustomItemForwarder;
	final Graphics graphics;
	
	protected CustomItem(String label) {
		super(new NativeCustomItemForwarder(label));
		this.nativeCustomItemForwarder = (NativeCustomItemForwarder) getNativeItem();
		this.graphics = new Graphics();
		((NativeCustomItemForwarder)this.nativeCustomItemForwarder).setCustomItem(this);
	}
	
	public int callGetMinContentHeight() {
		return getMinContentHeight();
	}

	public int callGetMinContentWidth() {
		return getMinContentWidth();
	}

	public int callGetPrefContentHeight(int height) {
		return getPrefContentHeight(height); 
	}

	public int callGetPrefContentWidth(int width) {
		return getPrefContentWidth(width);
	}

	public void callPaint(javax.microedition.lcdui.Graphics g, int w, int h) {
		graphics.setNativeGraphics(g);
		paint(graphics, w, h);
	}
	
	public void callHideNotify() {
		hideNotify();
	}

	public void callShowNotify() {
		showNotify();
	}

	public void callSizeChanged(int w, int h) {
		sizeChanged(w, h);
	}

	public boolean callTraverse(int dir, int viewportWidth, int viewportHeight, int[] visRect_inout) {
		return traverse(dir, viewportWidth, viewportHeight, visRect_inout);
	}

	public void callTraverseOut() {
		traverseOut();
	}

	public void callPointerReleased(int x, int y) {
		pointerReleased(x, y);
	}

	public void callPointerDragged(int x, int y) {
		pointerDragged(x, y);
	}

	public void callPointerPressed(int x, int y) {
		pointerPressed(x, y);
	}

	public void callKeyPressed(int keyCode) {
		keyPressed(keyCode);
	}

	public void callKeyReleased(int keyCode) {
		keyReleased(keyCode);
	}

	public void callKeyRepeated(int keyCode) {
		keyRepeated(keyCode);
	}

	public int getGameAction(int keyCode) {
		return nativeCustomItemForwarder.getGameAction(keyCode);
	}
	
	protected final void invalidate() {
		nativeCustomItemForwarder.callInvalidate();
	}

	protected final int getInteractionModes() {
		return nativeCustomItemForwarder.callGetInteractionModes();
	}

	protected final void repaint() {
		nativeCustomItemForwarder.callRepaint();
	}

	protected final void repaint(int x, int y, int w, int h) {
		nativeCustomItemForwarder.callRepaint(x, y, w, h);
	}

	protected void hideNotify() { }
	
	protected void showNotify() { }

	protected void keyPressed(int keyCode) { }

	protected void keyReleased(int keyCode) { }

	protected void keyRepeated(int keyCode) { }

	protected void pointerDragged(int x, int y) { }

	protected void pointerPressed(int x, int y) { }

	protected void pointerReleased(int x, int y) { }
	
	protected void sizeChanged(int w, int h) { }
	
	protected boolean traverse(int dir, int viewportWidth, int viewportHeight, int[] visRect_inout) { return false; }

	protected void traverseOut() { }
	
	protected abstract void paint(Graphics g, int w, int h);

	protected abstract int getMinContentHeight();

	protected abstract int getMinContentWidth();

	protected abstract int getPrefContentHeight(int width);

	protected abstract int getPrefContentWidth(int height);

}