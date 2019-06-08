package dailyprg0806;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapIterateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] demo = {
			"好雨知时节",
			"当春乃发生",
			"随风潜入夜",
			"润物细无声",
			"夜径云俱黑",
			"江船火独明",
			"晓看红湿处",
			"花重锦官城"
		};
		Map<String,Integer> map = new LinkedHashMap<>();
		for(String s : demo){
			map.put(s,0);
		}
		for(String s : map.keySet()){
			//System.out.println(s.hashCode()%map.size());
			System.out.println(s);
		}
		System.out.println();
		map.forEach((key,val)->{
			System.out.println(key);
		});
		System.out.println();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
