package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

public class Command {
	
	public static final int SCREEN = javax.microedition.lcdui.Command.SCREEN;
	public static final int BACK = javax.microedition.lcdui.Command.BACK;
	public static final int CANCEL = javax.microedition.lcdui.Command.CANCEL;
	public static final int OK = javax.microedition.lcdui.Command.OK;
	public static final int HELP = javax.microedition.lcdui.Command.HELP;
	public static final int STOP = javax.microedition.lcdui.Command.STOP;
	public static final int EXIT = javax.microedition.lcdui.Command.EXIT;
	public static final int ITEM = javax.microedition.lcdui.Command.ITEM;
	
	static final Hashtable nativeCommandCommandMap = new Hashtable();

	final javax.microedition.lcdui.Command nativeCommand;
	
	Command(javax.microedition.lcdui.Command nativeCommand) {
		this.nativeCommand = nativeCommand;
		nativeCommandCommandMap.put(this.nativeCommand, this);
	}

	public Command(String label, int commandType, int priority) {
		this(label, null, commandType, priority);
	}

	public Command(String shortLabel, String longLabel, int commandType, int priority) {
		nativeCommand = new javax.microedition.lcdui.Command(shortLabel, longLabel, commandType, priority);
		nativeCommandCommandMap.put(this.nativeCommand, this);
	}

	public int getCommandType() {
		return nativeCommand.getCommandType();
	}

	public String getLabel() {
		return nativeCommand.getLabel();
	}

	public String getLongLabel() {
		return nativeCommand.getLongLabel();
	}

	public int getPriority() {
		return nativeCommand.getPriority();
	}
	
	public String toString() {
		return "Command [nativeCommand=" + nativeCommand + "]";
	}
	
	public javax.microedition.lcdui.Command getNativeCommand() {
		return nativeCommand;
	}

	public static Command of(javax.microedition.lcdui.Command nativeCommand) {
		Command result;
		if ((result = (Command) nativeCommandCommandMap.get(nativeCommand)) == null) {
			synchronized (nativeCommandCommandMap) {
				if ((result = (Command) nativeCommandCommandMap.get(nativeCommand)) == null) {
					result = new Command(nativeCommand);
					nativeCommandCommandMap.put(nativeCommand, result);
				}
			}
		}
		return result;
	}
}