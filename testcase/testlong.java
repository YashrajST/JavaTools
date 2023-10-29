import com.thinking.machines.util.*;
class test
{
public static void main(String gg[])
{
try
{
Keyboard k=new Keyboard();
System.out.print(k.getString("Enter a String : "));
System.out.print(k.getLong("Enter long value : "));
System.out.print(k.getInt("Enter Int value : "));
System.out.print(k.getShort("Enter Short value : "));
System.out.print(k.getByte("Enter byte value : "));
System.out.print(k.getDouble("Enter double value : "));
}catch(Exception ke)
{
System.out.println(ke.getMessage());
}
}
}
