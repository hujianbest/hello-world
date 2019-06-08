import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Solution2 {
    public static void main(String[] args) {
        int count = 10000;
        int range = count*2;
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            nums.add(random.nextInt(range));
        }
        System.out.println("数据生成完毕,打印原始数据");
        for (int n : nums)
            System.out.println(n);

        List<Integer> res = new LinkedList<>();
        res.add(0,nums.get(0));
        
        for (int i = 1; i < count; i++)
            insert(res,nums.get(i));
        
        System.out.println("排序完毕，开始打印");

        for (int r : res)
            System.out.println(r);
    }
    
    public static void insert(List<Integer> list,int n) {
    	int i=0;
    	while(i<list.size()&&n>list.get(i)) {
    		i++;
    	}
    	list.add(i, n);
    }
}