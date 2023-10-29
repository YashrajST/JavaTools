package com.thinking.machines.util.interfaces;
import java.io.*;
public interface KeyboardInterface
{
public String getString();
public String getString(String message);

public long getLong();
public long getLong(String message);

public int getInt();
public int getInt(String message);

public short getShort();
public short getShort(String message);

public byte getByte();
public byte getByte(String message);

public double getDouble();
public double getDouble(String message);

public float getFloat();
public float getFloat(String message);

public boolean getBoolean();
public boolean getBoolean(String message);

}