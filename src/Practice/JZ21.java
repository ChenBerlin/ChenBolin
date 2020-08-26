package Practice;
//栈的压入、弹出序列
//题目描述
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
//知识点：栈
//思路：push[push_index]和pop[pop_index]比较，不相等list.add，相等list.remove。
import java.util.ArrayList;

public class JZ21 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null || popA==null || pushA.length==0 || popA.length==0)
            return false;
        ArrayList<Integer> list = new ArrayList<>();
        int push_index = 0;
        int pop_index = 0;
        list.add(pushA[push_index]);
        //System.out.println("push "+pushA[push_index]);
        push_index++;
        while (push_index < pushA.length || pop_index < popA.length) {
            //System.out.println(list.get(list.size()-1)+"  "+popA[pop_index]);
            if (list.get(list.size()-1)!=popA[pop_index]) {
                if (push_index >= pushA.length)
                    return false;
                //System.out.println("push "+pushA[push_index]);
                list.add(pushA[push_index]);
                push_index ++;
                //System.out.println("push_index "+push_index);

            }
            else {
                //System.out.println("pop "+list.get((list.size()-1)));
                list.remove(list.size()-1);
                pop_index++;
                //System.out.println("pop_index"+pop_index);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int push[] = {1,2,3,4,5};
        int pop[] = {4,5,3,2,1};
        System.out.println(IsPopOrder(push, pop));
    }
}
