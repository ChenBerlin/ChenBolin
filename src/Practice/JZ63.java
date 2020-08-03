package Practice;

import java.util.LinkedList;

//数据流中的中位数
//题目描述
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
//知识点：进制转换、排序、堆
//思路：插入时排序，然后取中位数
public class JZ63 {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public void Insert(Integer num) {
        //降序插入
        if (list.size()==0||num<list.getFirst()){
            list.addFirst(num);
        }
        else {
            boolean haveInserted = false;
            for (Integer i: list) {
                if (num < i) {
                    int index = list.indexOf(i);
                    list.add(index,num);
                    haveInserted = true;
                    break;
                }
            }
            //num在链表元素中最大，for循环内未插入
            if(!haveInserted) {
                list.addLast(num);
            }
        }
    }

    public Double GetMedian() {
        if (list.size()==0)
            return null;
        if (list.size()%2==0){
            int i = list.size()/2;
            return (double)(list.get(i-1)+list.get(i))/2;
        }
        else{
            return (double)list.get((list.size()+1)/2-1);
        }
    }
}
