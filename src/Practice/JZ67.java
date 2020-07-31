package Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//剪绳子
//描述：给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
//知识点：贪心
//思路：
// 1、使长度为3的绳子尽可能多
// 2、若最后剩余长度为1，则拆分一段长度为3的绳子，2*2>1*3。
public class JZ67 {
    public static int cutRope(int target) {
        //对输入进行取模
        int mode = target%3;
        //记录结果
        int result = 0;
        //分别计算余数为0、1、2时，3的个数和2的个数，传入calc()方法进行计算
        if (mode == 0){
            result = calc(target/3,0);
        }else if(mode == 1){
            result = calc((target-1)/3-1,2);
        }else if(mode == 2){
            result = calc((target-2)/3,1);
        }
        return result;
    }
    //thTimes：3的个数
    //twTimes：2的个数
    public static int calc(int thTimes, int twTimes){
        int result = 1;
        for(int i = 0;i<thTimes;i++){
            result *= 3;
        }
        for(int j = 0;j<twTimes;j++){
            result *= 2;
        }
        return result;
    }
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(cutRope(n));
    }
}
