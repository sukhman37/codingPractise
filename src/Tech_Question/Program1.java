package Tech_Question;
import java.util.*;
public class Program1
{
public static void main(String[] args)
{
int[] array = {6,9,8};
List<Integer> list = new ArrayList<>();
list.add(array[0]);
list.add(array[2]);
list.set(1, array[1]);
list.remove(0);
System.out.println(list);

Map<Integer,String> map = new HashMap<>();
map.put(1,"abc");
map.put(2, "def");

for(Map.Entry<Integer, String> entry : map.entrySet()) {
	
	System.out.println(entry.getKey()+" "+entry.getValue());
}

}
}