package ass4;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // 入队
    public void push(int x) {
        inStack.push(x);
    }

    // 出队
    public int pop() {
        shiftStacks();
        return outStack.pop();
    }

    // 查看队首
    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    // 队空判断
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // 辅助函数：必要时把 inStack 倒入 outStack
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

}
