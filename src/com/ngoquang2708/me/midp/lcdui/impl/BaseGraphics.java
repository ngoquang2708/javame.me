package com.ngoquang2708.me.midp.lcdui.impl;

import javax.microedition.lcdui.Font;

import com.ngoquang2708.me.midp.lcdui.Image;


public class BaseGraphics {
	
	public static final int SOLID = 0;

	public static final int DOTTED = 1;

	public static final int LEFT = 4;

	public static final int RIGHT = 8;

	public static final int TOP = 16;

	public static final int BASELINE = 64;

	public static final int BOTTOM = 32;

	public static final int HCENTER = 1;

	public static final int VCENTER = 2;
	
	protected javax.microedition.lcdui.Graphics nativeGraphics;
	
	public BaseGraphics() {
		;
	}
	
	public BaseGraphics(javax.microedition.lcdui.Graphics nativeGraphics) {
		if ((this.nativeGraphics = nativeGraphics) == null)
			throw new NullPointerException();
	}

	public void clipRect(int x, int y, int width, int height) {
		nativeGraphics.clipRect(x, y, width, height);
	}

	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		nativeGraphics.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	public void drawChar(char character, int x, int y, int anchor) {
		nativeGraphics.drawChar(character, x, y, anchor);
	}

	public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
		nativeGraphics.drawChars(data, offset, length, x, y, anchor);
	}

	public void drawImage(Image img, int x, int y, int anchor) {
		nativeGraphics.drawImage(img.getNativeImage(), x, y, anchor);
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		nativeGraphics.drawLine(x1, y1, x2, y2);
	}

	public void drawRect(int x, int y, int width, int height) {
		nativeGraphics.drawRect(x, y, width, height);
	}

	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		nativeGraphics.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
	}

	public void drawString(String str, int x, int y, int anchor) {
		nativeGraphics.drawString(str, x, y, anchor);
	}

	public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
		nativeGraphics.drawSubstring(str, offset, len, x, y, anchor);
	}

	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		nativeGraphics.fillArc(x, y, width, height, startAngle, arcAngle);
	}

	public void fillRect(int x, int y, int width, int height) {
		nativeGraphics.fillRect(x, y, width, height);
	}

	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		nativeGraphics.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
	}

	public int getBlueComponent() {
		return nativeGraphics.getBlueComponent();
	}

	public int getClipHeight() {
		return nativeGraphics.getClipHeight();
	}

	public int getClipWidth() {
		return nativeGraphics.getClipWidth();
	}

	public int getClipX() {
		return nativeGraphics.getClipX();
	}

	public int getClipY() {
		return nativeGraphics.getClipY();
	}

	public int getColor() {
		return nativeGraphics.getColor();
	}

	public Font getFont() {
		return nativeGraphics.getFont();
	}

	public int getGrayScale() {
		return nativeGraphics.getGrayScale();
	}

	public int getGreenComponent() {
		return nativeGraphics.getGreenComponent();
	}

	public int getRedComponent() {
		return nativeGraphics.getRedComponent();
	}

	public int getStrokeStyle() {
		return nativeGraphics.getStrokeStyle();
	}

	public int getTranslateX() {
		return nativeGraphics.getTranslateX();
	}

	public int getTranslateY() {
		return nativeGraphics.getTranslateY();
	}

	public void setClip(int x, int y, int width, int height) {
		nativeGraphics.setClip(x, y, width, height);
	}

	public void setColor(int RGB) {
		nativeGraphics.setColor(RGB);
	}

	public void setColor(int red, int green, int blue) {
		nativeGraphics.setColor(red, green, blue);
	}

	public void setFont(Font font) {
		nativeGraphics.setFont(font);
	}

	public void setGrayScale(int grey) {
		nativeGraphics.setGrayScale(grey);
	}

	public void setStrokeStyle(int style) {
		nativeGraphics.setStrokeStyle(style);
	}

	public void translate(int x, int y) {
		nativeGraphics.translate(x, y);
	}

	public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x_dest, int y_dest, int anchor) {
		if (x_src + width <= src.getWidth() && y_src + height <= src.getHeight())
			nativeGraphics.drawRegion(src.getNativeImage(), x_src, y_src, width, height, transform, x_dest, y_dest, anchor);
	}

	public void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height, boolean processAlpha) {
		nativeGraphics.drawRGB(rgbData, offset, scanlength, x, y, width, height, processAlpha);
	}

	public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		nativeGraphics.fillTriangle(x1, y1, x2, y2, x3, y3);
	}

	public void copyArea(int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor) {
		nativeGraphics.copyArea(x_src, y_src, width, height, x_dest, y_dest, anchor);
	}

	public int getDisplayColor(int color) {
		return nativeGraphics.getDisplayColor(color);
	}
	
	public void setNativeGraphics(javax.microedition.lcdui.Graphics g) {
		if ((this.nativeGraphics = g) == null)
			throw new NullPointerException();
	}
	
	public javax.microedition.lcdui.Graphics getNativeGraphics() {
		return nativeGraphics;
	}
}
