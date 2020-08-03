package Practice;
//用两个栈实现队列
//题目描述
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//知识点：队列、栈
//思路：stack1顺序保存，stack2逆序保存。
import java.util.Stack;

public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //!stack2.empty()==true:stack2不为空，此时数据存放逆序在stack2，须转移至stack1再进行操作。
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        //与push的while判断同理
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
