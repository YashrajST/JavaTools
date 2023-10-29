import com.thinking.machines.util.*;
import com.thinking.machines.util.interfaces.*;
import com.thinking.machines.util.exception.*;
class testTMArrayListAdd
{
public static void main(String ff[])
{
try
{
TMArrayList tmal=new TMArrayList();
tmal.add(10);
tmal.add(20);
tmal.add(30);
tmal.add(40);
tmal.add(50);
tmal.add(60);
tmal.add(500,4);
for(int i=0;i<tmal.size();i++) System.out.println(tmal.get(i));
TMArrayList tmal1=new TMArrayList();
tmal1.add(1);
tmal1.add(2);
tmal1.add(3);
tmal1.add(4);
tmal1.add(5);
tmal1.add(6);
tmal1.appendTo(tmal);
System.out.println(" ");
for(int i=0;i<tmal.size();i++) System.out.println(tmal.get(i));
System.out.println("size, tmal: "+tmal.size()+"\n\rtmal1: "+tmal1.size());
System.out.println("Length, tmal: "+tmal.length()+"\n\rtmal1: "+tmal1.length());
System.out.println("buffersize, tmal: "+tmal.bufferSize()+"\n\rtmal1: "+tmal1.bufferSize());
System.out.println("bufferLength, tmal: "+tmal.bufferLength()+"\n\rtmal1: "+tmal1.bufferLength());
}catch(TMListException tmException)
{
System.out.println(tmException);
}

}
}