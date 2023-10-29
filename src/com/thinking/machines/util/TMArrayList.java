package com.thinking.machines.util;
import com.thinking.machines.util.interfaces.*;
import com.thinking.machines.util.exception.*;

public class TMArrayList<T> implements TMListInterface<T>
{
private Object[] collection;
private int size;
public TMArrayList()
{
this.size=0;
this.collection=new Object[10];
}

public class TMListIterator<T> implements TMListIteratorInterface<T>
{
private int index;
private TMListIterator()
{
this.index=0;
}

public boolean hasNext()
{
if(this.index<TMArrayList.this.size) return true;
return false;
}
public T next()
{
T returnVal=(T)TMArrayList.this.collection[this.index];
index++;
return returnVal;
}
}

public void add(T data) throws TMListException
{
//System.out.println("add(1) got called.");
if(this.size==this.collection.length)
{
//System.out.println("Increasing the size by 10, new buffer Size: "+(10+collection.length));
Object tempCollection[]=new Object[size+10];
for(int i=0;i<size;i++) tempCollection[i]=this.collection[i];
this.collection=tempCollection;
}
this.collection[size]=data;
this.size++;
}
public void add(T data,int index) throws TMListException
{
//System.out.println("add(2) got called. ("+data+","+index+")");
if(index>=this.collection.length)
{
//System.out.println("Increasing the size by 10, new buffer Size: "+(10+collection.length));
Object tempCollection[]=new Object[size+10];
int i;
for(i=0;i<index;i++) tempCollection[i]=this.collection[i];
tempCollection[i]=data;
for(;i<size;i++) tempCollection[i+1]=this.collection[i];
this.collection=tempCollection;
}else
{
Object tempCollection[]=new Object[this.collection.length];
int i;
for(i=0;i<index;i++) tempCollection[i]=this.collection[i];
tempCollection[i]=data;
for(;i<size;i++) tempCollection[i+1]=this.collection[i];
this.collection=tempCollection;
}
this.size++;
}

public T deleteFrom(int index) throws TMListException
{
T deletedData;
if(index>=this.size) throw new TMListException("Invalid index, please enter a valid index");
deletedData=(T)this.collection[index];
for(int i=index;i<this.size;i++) this.collection[i]=this.collection[i+1];
this.size--;
return deletedData;
}
public void deleteAll() throws TMListException
{
this.size=0;
}
public void clear() throws TMListException
{
this.size=0;
}


public void insert(T data,int index) throws TMListException
{
if(index>this.size) throw new TMListException("Invalid index, please enter a valid index");
add(data,index);
}
public void insertAt(T data,int index) throws TMListException
{
if(index>this.size) throw new TMListException("Invalid index, please enter a valid index");
add(data,index);
}


public void update(T data,int index) throws TMListException
{
if(index>=this.size) throw new TMListException("Invalid index, please enter a valid index");
this.collection[index]=data;
}
public void updateAt(T data,int index) throws TMListException
{
update(data,index);
}

public void copyFrom(TMListInterface list) throws TMListException
{
int i;
for(i=0;i<list.size();i++) this.add((T)list.get(i));
this.size=i;
}
public void copyTo(TMListInterface list) throws TMListException
{
if(list.size()==0) return;
int i;
for(i=0;i<this.size;i++) list.add(this.collection[i],i);
for(i=list.size();i>this.size;i--) list.deleteFrom(i-1);
}

public void appendFrom(TMListInterface list) throws TMListException
{
int i,j;
for(i=this.size,j=0;j<list.size();j++,i++) this.add((T)list.get(j),i);
}
public void appendTo(TMListInterface list) throws TMListException
{
int i,j;
for(i=list.size(),j=0;j<this.size;i++,j++) list.add((T)this.collection[j],i);
}

public T get(int index) throws TMListException
{
if(index>=this.size) throw new TMListException("Invalid Index, please enter a valid index");
return (T)this.collection[index];
}

public int size() throws TMListException
{
return this.size;
}	
public int length() throws TMListException
{
return this.size;
}
public int bufferSize() throws TMListException
{
return this.collection.length;
}
public int bufferLength() throws TMListException
{
return this.collection.length;
}

public TMListIteratorInterface<T> iterator()
{
return new TMListIterator();
}

public void forEach(TMListItemAcceptorInterface<T> tmia)
{
for(int i=0;i<this.size;i++)
{
tmia.accept((T)this.collection[i]);
}
}



}