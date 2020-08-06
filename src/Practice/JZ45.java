package Practice;
//扑克牌顺子
//题目描述
//56张牌，大王小王各两张可以当作任意牌，A=1 JQK分别为11、12、13，从中抽取5张。
//知识点：字符串
//思路：排序再计算
import java.util.Arrays;

public class JZ45 {
    public boolean isContinuous(int [] numbers) {
        int zero_num=0;
        int len=numbers.length;
        int gap=0;
        if(len!=5)return false;
        int[] isCurrent=new int[14];
        Arrays.sort(numbers);
        for(int i=0;i<len;i++){
            if(numbers[i]==0)zero_num++;
            else{
                if(isCurrent[numbers[i]]!=0){
                    return false;
                }
                isCurrent[numbers[i]]=1;
                if(i!=0&&numbers[i-1]!=0){
                    gap+=numbers[i]-numbers[i-1]-1;
                }
            }
        }
        if(zero_num==5||zero_num<gap)return false;
        return true;
    }
}
