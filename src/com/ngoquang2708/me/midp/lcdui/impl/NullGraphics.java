package com.ngoquang2708.me.midp.lcdui.impl;

import javax.microedition.lcdui.Font;

import com.ngoquang2708.me.midp.lcdui.Graphics;
import com.ngoquang2708.me.midp.lcdui.Image;


/**
 * Dummy Graphics implementation that just ignore all painting calls
 */
public class NullGraphics extends Graphics {
	
	private int clipX1;
	private int clipY1;
	private int clipX2;
	private int clipY2;
	
	private int translateX;
	private int translateY;
	
	private int color;
	private int strokeStyle;

	private Font font;
	
	public NullGraphics() {
		clipX1 = 0;
		clipY1 = 0;
		clipX2 = Integer.MAX_VALUE;
		clipY2 = Integer.MAX_VALUE;
		
		translateX = 0;
		translateX = 0;
		
		color = 0;
		strokeStyle = 0;
		
		font = Font.getDefaultFont();
	}

	public void clipRect(int x, int y, int width, int height) {
		clipX1 = Math.max(x, clipX1);
		clipY1 = Math.max(y, clipY1);
		clipX2 = Math.min(x + width, clipX2);
		clipY2 = Math.min(y + height, clipY2);
	}

	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
	}

	public void drawChar(char character, int x, int y, int anchor) {
	}

	public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
	}

	public void drawImage(Image img, int x, int y, int anchor) {
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
	}

	public void drawRect(int x, int y, int width, int height) {
	}

	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
	}

	public void drawString(String str, int x, int y, int anchor) {
	}

	public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
	}

	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
	}

	public void fillRect(int x, int y, int width, int height) {
	}

	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
	}

	public int getBlueComponent() {
		return color & 0xff;
	}

	public int getClipHeight() {
		return clipY2 - clipY1;
	}

	public int getClipWidth() {
		return clipX2 - clipX1;
	}

	public int getClipX() {
		return clipX1;
	}

	public int getClipY() {
		return clipY1;
	}

	public int getColor() {
		return color;
	}

	public Font getFont() {
		return font;
	}

	public int getGrayScale() {
		return 0;
	}

	public int getGreenComponent() {
		return (color & 0xff00) >> 8;
	}

	public int getRedComponent() {
		return (color & 0xff0000) >> 16;
	}

	public int getStrokeStyle() {
		return strokeStyle;
	}

	public int getTranslateX() {
		return translateX;
	}

	public int getTranslateY() {
		return translateY;
	}

	public void setClip(int x, int y, int width, int height) {
		clipX1 = x;
		clipY1 = y;
		clipX2 = x + width;
		clipY2 = y + height;
	}

	public void setColor(int RGB) {
		color = RGB;
	}

	public void setColor(int red, int green, int blue) {
		color = ((red &= 0xff) << 16) & ((green &= 0xff) << 8) & (blue &= 0xff);
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setGrayScale(int grey) {
		grey &= 0xff;
		color = (grey << 16) & (grey << 8) & grey; 
	}

	public void setStrokeStyle(int style) {
		this.strokeStyle = style;
	}

	public void translate(int x, int y) {
		translateX += x;
		translateY += y;
	}

	public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x_dest, int y_dest, int anchor) {
	}

	public void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height, boolean processAlpha) {
	}

	public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
	}

	public void copyArea(int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor) {
	}

	public int getDisplayColor(int color) {
		return color == 0 ? 0 : 1;
	}
	
	public void setNativeGraphics(javax.microedition.lcdui.Graphics g) {
	}
}