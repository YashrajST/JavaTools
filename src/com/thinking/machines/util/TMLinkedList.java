package com.thinking.machines.util;
import com.thinking.machines.util.interfaces.*;
import com.thinking.machines.util.exception.*;
public class TMLinkedList<T> implements TMListInterface<T>
{
private TMListNode start;
private TMListNode end;
int size;

public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public class TMListNode<T>
{
private T value;
private TMListNode next;
public TMListNode()
{
this.value=null;
this.next=null;
}
public void setValue(T value)
{
this.value=value;
}
public T getValue()
{
return  this.value;
}
public void setNext(TMListNode<T> node)
{
this.next=node;
}
public TMListNode<T> getNext()
{
return this.next;
}
}

public void add(T data) throws TMListException
{
TMListNode<T> node=new TMListNode<>();
node.setValue(data);
//System.out.println("In the add methord.");
if(this.start==null)
{
//System.out.println("adding the first element");
this.start=node;
this.end=node;
}else
{
//System.out.println("adding the "+this.size+"th element.");
this.end.setNext(node);
this.end=node;
}
this.size++;
}
public void add(T data,int index) throws TMListException
{
TMListNode<T> node=new TMListNode<>();
node.setValue(data);
if(this.start==null || index>this.size) throw new TMListException("Invalid Index: Please enter a valid index"); 
else if(index==0)
{
node.setNext(this.start);
this.start=node;
this.size++;
}
else if(index==this.size) add(data);
else
{
TMListNode<T> node1=null,node2=null;
for(int i=0;i<index;i++)
{
if(i==0)
{
node1=this.start;
node2=node1.getNext();
}else
{
node1=node1.getNext();
node2=node2.getNext();
}
}
node1.setNext(node);
node.setNext(node2);
this.size++;
}
}

public T get(int index) throws TMListException
{
if(this.start==null || this.size==0 || this.size==index) throw new TMListException("Invalid Index: Please enter a valid index");
TMListNode node=null;
for(int i=0;i<=index;i++) 
{
if(i==0) node=this.start;
else node=node.getNext();
//System.out.println("Node "+i+"in the loop: "+node);
}
//System.out.println("Node AT LAST :: "+node);
return (T)node.getValue();
}



public T deleteFrom(int index) throws TMListException
{
TMListNode node=null;
if(index>=size) throw new TMListException("Invalid Index: Please enter a valid index");
if(index==0)
{
node=this.start;
this.start=this.start.getNext();
}else
{
TMListNode node1=this.start,node2=this.start.getNext();
for(int i=1;i<index;i++)
{
node1=node1.getNext();
node2=node2.getNext();
}
node1.setNext(node2.getNext());
node=node2;
}
this.size--;
return (T)node.getValue();
}
public void deleteAll() throws TMListException
{
this.start=null;
this.end=null;
this.size=0;
}
public void clear() throws TMListException
{
deleteAll();
}

public void insert(T data,int index) throws TMListException
{
add(data,index);
}
public void insertAt(T data,int index) throws TMListException
{
add(data,index);
}

public void update(T data,int index) throws TMListException
{
add(data,index);
deleteFrom(index+1);
}
public void updateAt(T data,int index) throws TMListException
{
add(data,index);
deleteFrom(index+1);
}

public void copyFrom(TMListInterface list) throws TMListException
{
this.deleteAll();
for(int i=0;i<list.size();i++) this.add((T)list.get(i));
}
public void copyTo(TMListInterface list) throws TMListException
{
list.deleteAll();
for(int i=0;i<this.size;i++) list.add((T)this.get(i));
}

public void appendFrom(TMListInterface list) throws TMListException
{
for(int i=0;i<list.size();i++) this.add((T)list.get(i));
}
public void appendTo(TMListInterface list) throws TMListException
{
for(int i=0;i<this.size;i++) list.add((T)this.get(i));
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
return this.size;
}
public int bufferLength() throws TMListException
{
return this.size;
}

class TMListIterator implements TMListIteratorInterface
{
private TMListNode node=TMLinkedList.this.start;
public boolean hasNext()
{
if(TMLinkedList.this.size==0 || node==null) return false;
return true;
}
public T next()
{
T value=(T)node.getValue();
node=node.getNext();
return value;
}
}

public TMListIteratorInterface<T> iterator()
{
return new TMListIterator();
}

public void forEach(TMListItemAcceptorInterface<T> tmia)
{
TMListIteratorInterface iterator=new TMListIterator();
while(iterator.hasNext())
{
tmia.accept((T)iterator.next());
}
}

}