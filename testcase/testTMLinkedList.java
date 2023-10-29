import com.thinking.machines.util.*;
import com.thinking.machines.util.exception.*;
import com.thinking.machines.util.interfaces.*;

class testTMLinkedList
{
public static void main(String gg[])
{
try
{
TMListInterface<Integer> list=new TMLinkedList<>();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.add(50);
System.out.println("In the test case Size of the list : "+list.size());
for(int i=0;i<list.size();i++) System.out.println(list.get(i));
System.out.println("_________________________________________");
list.add(5,5);
list.add(100,3);
for(int i=0;i<list.size();i++) System.out.println(list.get(i));
System.out.println("_________________________________________");
list.deleteFrom(3);
list.insert(100,5);
list.update(300,2);
for(int i=0;i<list.size();i++) System.out.println(list.get(i));
System.out.println("_________________________________________");
TMListIteratorInterface it=list.iterator();
while(it.hasNext())
{
System.out.println(it.next());
}
System.out.println("-_________________________________________");
list.forEach((Integer i)->{
System.out.println(i);
});

}catch(TMListException e)
{
System.out.println(e);
}
}
}
