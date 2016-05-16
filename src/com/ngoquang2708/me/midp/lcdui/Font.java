package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

public final class Font {

	public static final int STYLE_PLAIN = javax.microedition.lcdui.Font.STYLE_PLAIN;
	public static final int STYLE_BOLD = javax.microedition.lcdui.Font.STYLE_BOLD;
	public static final int STYLE_ITALIC = javax.microedition.lcdui.Font.STYLE_ITALIC;
	public static final int STYLE_UNDERLINED = javax.microedition.lcdui.Font.STYLE_UNDERLINED;

	public static final int SIZE_SMALL = javax.microedition.lcdui.Font.SIZE_SMALL;
	public static final int SIZE_MEDIUM = javax.microedition.lcdui.Font.SIZE_MEDIUM;
	public static final int SIZE_LARGE = javax.microedition.lcdui.Font.SIZE_LARGE;

	public static final int FACE_SYSTEM = javax.microedition.lcdui.Font.FACE_SYSTEM;
	public static final int FACE_MONOSPACE = javax.microedition.lcdui.Font.FACE_MONOSPACE;
	public static final int FACE_PROPORTIONAL = javax.microedition.lcdui.Font.FACE_PROPORTIONAL;

	public static final int FONT_STATIC_TEXT = javax.microedition.lcdui.Font.FONT_STATIC_TEXT;
	public static final int FONT_INPUT_TEXT = javax.microedition.lcdui.Font.FONT_INPUT_TEXT;
	
	private static final Hashtable nativeFontFontMap = new Hashtable();
	
	protected final javax.microedition.lcdui.Font nativeFont;
	
	Font(javax.microedition.lcdui.Font nativeFont) {
		if ((this.nativeFont = nativeFont) == null)
			throw new NullPointerException();
	}

	public static Font getDefaultFont() {
		return Font.of(javax.microedition.lcdui.Font.getDefaultFont());
	}

	public static Font getFont(int specifier) {
		return Font.of(javax.microedition.lcdui.Font.getFont(specifier));
	}

	public static Font getFont(int face, int style, int size) {
		return Font.of(javax.microedition.lcdui.Font.getFont(face, style, size));
	}

	public int getStyle() {
		return nativeFont.getStyle();
	}

	public int getSize() {
		return nativeFont.getSize();
	}

	public int getFace() {
		return nativeFont.getFace();
	}

	public boolean isPlain() {
		return nativeFont.isPlain();
	}

	public boolean isBold() {
		return nativeFont.isBold();
	}

	public boolean isItalic() {
		return nativeFont.isItalic();
	}

	public boolean isUnderlined() {
		return nativeFont.isUnderlined();
	}

	public int getHeight() {
		return nativeFont.getHeight();
	}

	public int getBaselinePosition() {
		return nativeFont.getBaselinePosition();
	}

	public int charWidth(char ch) {
		return nativeFont.charWidth(ch);
	}

	public int charsWidth(char[] ch, int offset, int length) {
		return nativeFont.charsWidth(ch, offset, length);
	}

	public int stringWidth(String str) {
		return nativeFont.stringWidth(str);
	}

	public int substringWidth(String str, int offset, int len) {
		return nativeFont.substringWidth(str, offset, len);
	}

	public int hashCode() {
		return nativeFont.hashCode();
	}

	public javax.microedition.lcdui.Font getNativeFont() {
		return nativeFont;
	}

	public static Font of(javax.microedition.lcdui.Font nativeFont) {
		Font result;
		if ((result = (Font) nativeFontFontMap.get(nativeFont)) == null) {
			synchronized (nativeFontFontMap) {
				if ((result = (Font) nativeFontFontMap.get(nativeFont)) == null) {
					result = new Font(nativeFont);
					nativeFontFontMap.put(nativeFont, result);
				}	
			}
		}
		return result;
	}
}
