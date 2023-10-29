package com.thinking.machines.util;
import com.thinking.machines.util.interfaces.*;
import com.thinking.machines.util.exception.*;
import java.lang.reflect.*;
import java.lang.String.*;
import java.awt.datatransfer.*;
import java.awt.*;
public class SetterGetterGenerator
{
public SetterGetterGenerator()
{

}
public static void main(String gg[])
{
boolean flag=true;
if(gg.length==0) 
{
System.out.println("Usage1 : java SetterGetterGenerator [class_name] -c true/false");
return;
}
if(gg.length==3 && (gg[2].compareTo("True")!=0 || gg[2].compareTo("true")!=0 || gg[2].compareTo("TRUE")!=0 || gg[2].compareTo("False")!=0 || gg[2].compareTo("false")!=0 || gg[2].compareTo("FALSE")!=0)) 
{
System.out.println("Usage2 : java SetterGetterGenerator [class_name] -c true/false");
return;
}
try
{
Class c=Class.forName(gg[0]);
Field fields[]=c.getDeclaredFields();
try
{
TMListInterface<String> result=new TMArrayList<>();
if(gg.length==3 && (gg[2].compareTo("True")!=0 || gg[2].compareTo("true")!=0 || gg[2].compareTo("TRUE")!=0)) flag=false;
if(flag)
{
result.add("public "+gg[0]+"()\r\n");
result.add("{\r\n");
for(int j=0;j<fields.length;j++) 
{
result.add("this."+fields[j].getName()+"=");
if(fields[j].getType().getName().compareTo("long")==0) result.add("0L;\r\n");
else if(fields[j].getType().getName().compareTo("int")==0) result.add("0;\r\n");
else if(fields[j].getType().getName().compareTo("short")==0) result.add("0;\r\n");
else if(fields[j].getType().getName().compareTo("byte")==0) result.add("0;\r\n");
else if(fields[j].getType().getName().compareTo("double")==0) result.add("0.0d;\r\n");
else if(fields[j].getType().getName().compareTo("float")==0) result.add("0.0f;\r\n");
else if(fields[j].getType().getName().compareTo("char")==0) result.add("\'\';\r\n");
else if(fields[j].getType().getName().compareTo("boolean")==0) result.add("false;\r\n");
else result.add("null;\r\n");
}
result.add("}\r\n");
}
for(int i=0;i<fields.length;i++) 
{
Field field=fields[i];
String fieldName=field.getName();
//Code to generate Setters
result.add("public void set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1)+"("+field.getType()+" "+fieldName+")\r\n");
result.add("{\r\n");
result.add("this."+fieldName+"="+fieldName+";\r\n");
result.add("}\r\n");
//Code to generate Getters
result.add("public "+field.getType()+" get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1)+"()\r\n");
result.add("{\r\n");
result.add("return this."+fieldName+";\r\n");
result.add("}\r\n");
}
Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
String finalCode="";
for(int i=0;i<result.size();i++) finalCode+=result.get(i);
clipboard.setContents(new StringSelection(finalCode), null);
result.forEach((String t)->{System.out.print(t);});
}catch(TMListException exception)
{
System.out.println(exception);
}
}catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe);
}
}
}