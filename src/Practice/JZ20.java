package Practice;
//包含min函数的栈
//题目描述
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//知识点：栈
//思路：创建辅助栈，存入每一步的最小值。
import java.util.Stack;

public class JZ20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (min_stack.isEmpty()) {
            min_stack.push(node);
        }
        else {
            min_stack.push(min_stack.peek()<node?min_stack.peek():node);
        }
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}
