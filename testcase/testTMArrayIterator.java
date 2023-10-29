import com.thinking.machines.util.*;
import com.thinking.machines.util.exception.*;
import com.thinking.machines.util.interfaces.*;
class testTMArrayIterator
{
public static void main(String ss[])
{
try
{
TMListInterface tmal=new TMArrayList();
tmal.add(19);
tmal.add(13);
tmal.add(15);
tmal.add(165);
tmal.add(16);
TMListIteratorInterface it=tmal.iterator();
while(it.hasNext()) System.out.println(it.next());
TMListItemAcceptorInterface<Integer> tmit=(Integer t)->{System.out.println(t);};
tmal.forEach(tmit);
}catch(TMListException tmle)
{
System.out.println(tmle);
}
}
}
