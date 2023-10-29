package com.thinking.machines.util;
import com.thinking.machines.util.interfaces.*;
import java.io.*;
public class Keyboard implements KeyboardInterface
{
private BufferedReader bufferedReader;
public Keyboard()
{
bufferedReader=new BufferedReader(new InputStreamReader(System.in));
}

public String getString()
{
String str;
try
{
str=bufferedReader.readLine();
}catch(IOException ioException)
{
str="";
}
return str;
}
public String getString(String message)
{
System.out.print(message);
return getString();
}

public long getLong()
{
long x;
try
{
x=Long.parseLong(getString());
}catch(Exception e)
{
x=0;
}
return x;
}
public long getLong(String message)
{
System.out.print(message);
return getLong();
}

public int getInt()
{
int x;
try
{
x=Integer.parseInt(getString());
}catch(Exception e)
{
x=0;
}
return x;
}
public int getInt(String message)
{
System.out.print(message);
return getInt();
}


public short getShort()
{
short x;
try
{
x=Short.parseShort(getString());
}catch(Exception e)
{
x=0;
}
return x;
}
public short getShort(String message)
{
System.out.print(message);
return getShort();
}

public byte getByte()
{
byte x;
try
{
x=Byte.parseByte(getString());
}catch(Exception e)
{
x=0;
}
return x;
}
public byte getByte(String message)
{
System.out.print(message);
return getByte();
}

public double getDouble()
{
double x;
try
{
x=Double.parseDouble(getString());
}catch(Exception e)
{
x=0;
}
return x;
}
public double getDouble(String message)
{
System.out.print(message);
return getDouble();
}

public float getFloat()
{
float x;
try
{
x=Float.parseFloat(getString());
}catch(Exception e)
{
x=0;
}
return x;
}
public float getFloat(String message)
{
System.out.print(message);
return getFloat();
}

public boolean getBoolean()
{
boolean x;
try
{
x=Boolean.parseBoolean(getString());
}catch(Exception e)
{
x=false;
}
return x;
}
public boolean getBoolean(String message)
{
System.out.print(message);
return getBoolean();
}



}