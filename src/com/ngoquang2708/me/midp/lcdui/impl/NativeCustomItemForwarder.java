package com.ngoquang2708.me.midp.lcdui.impl;

import javax.microedition.lcdui.Graphics;

import com.ngoquang2708.me.midp.lcdui.CustomItem;


public class NativeCustomItemForwarder extends javax.microedition.lcdui.CustomItem {

	CustomItem customItem;

	public NativeCustomItemForwarder(String label) {
		super(label);
	}

	public CustomItem getCustomItem() {
		return customItem;
	}

	public void setCustomItem(CustomItem customItem) {
		this.customItem = customItem;
	}

	public void callInvalidate() {
		invalidate();
	}

	public int callGetInteractionModes() {
		return getInteractionModes();
	}

	public void callRepaint() {
		repaint();
	}

	public void callRepaint(int x, int y, int w, int h) {
		repaint(x, y, w, h);
	}

	protected int getMinContentHeight() {
		return customItem.callGetMinContentHeight();
	}

	protected int getMinContentWidth() {
		return customItem.callGetMinContentWidth();
	}

	public int getPrefContentHeight(int width) {
		return customItem.callGetPrefContentHeight(width);
	}

	public int getPrefContentWidth(int height) {
		return customItem.callGetPrefContentWidth(height);
	}

	protected void hideNotify() {
		customItem.callHideNotify();
	}

	protected void showNotify() {
		customItem.callShowNotify();
	}

	protected void sizeChanged(int w, int h) {
		customItem.callSizeChanged(w, h);
	}

	protected boolean traverse(int dir, int viewportWidth, int viewportHeight, int[] visRect_inout) {
		return customItem.callTraverse(dir, viewportWidth, viewportHeight, visRect_inout);
	}

	protected void traverseOut() {
		customItem.callTraverseOut();
	}

	protected void pointerReleased(int x, int y) {
		customItem.callPointerReleased(x, y);
	}

	protected void pointerDragged(int x, int y) {
		customItem.callPointerDragged(x, y);
	}

	protected void pointerPressed(int x, int y) {
		customItem.callPointerPressed(x, y);
	}

	protected void keyPressed(int keyCode) {
		customItem.callKeyPressed(keyCode);
	}

	protected void keyReleased(int keyCode) {
		customItem.callKeyReleased(keyCode);
	}

	protected void keyRepeated(int keyCode) {
		customItem.callKeyRepeated(keyCode);
	}

	protected void paint(Graphics g, int w, int h) {
		customItem.callPaint(g, w, h);
	}
}