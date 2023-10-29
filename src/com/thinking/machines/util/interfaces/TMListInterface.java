package com.thinking.machines.util.interfaces;
import com.thinking.machines.util.exception.*;
public interface TMListInterface<T> 
{

public void add(T data) throws TMListException;
public void add(T data,int index) throws TMListException;

public T deleteFrom(int index) throws TMListException;
public void deleteAll() throws TMListException;
public void clear() throws TMListException;

public void insert(T data,int index) throws TMListException;
public void insertAt(T data,int index) throws TMListException;

public void update(T data,int index) throws TMListException;
public void updateAt(T data,int index) throws TMListException;

public void copyFrom(TMListInterface list) throws TMListException;
public void copyTo(TMListInterface list) throws TMListException;

public void appendFrom(TMListInterface list) throws TMListException;
public void appendTo(TMListInterface list) throws TMListException;

public T get(int index) throws TMListException;

public int size() throws TMListException;
public int length() throws TMListException;
public int bufferSize() throws TMListException;
public int bufferLength() throws TMListException;

public TMListIteratorInterface<T> iterator();
public void forEach(TMListItemAcceptorInterface<T> tmia);

}