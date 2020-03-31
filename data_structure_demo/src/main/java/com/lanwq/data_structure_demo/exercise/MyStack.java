package com.lanwq.data_structure_demo.exercise;

import java.util.Arrays;

/**
 * @program: javaDemo->MyStack
 * @description: 自己使用数组实现栈
 * 使用数组实现栈
 * 自己实现一个栈，要求这个栈具有push()、pop()（返回栈顶元素并出栈）、peek() （返回栈顶元素不出栈）、isEmpty()、size()这些基本的方法。
 *
 * 提示：每次入栈之前先判断栈的容量是否够用，如果不够用就用Arrays.copyOf()进行扩容；
 * @author: lanwenquan
 * @date: 2020-03-31 20:18
 */
public class MyStack {
    private int[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;

    // 不带初始容量的初始化的栈
    public MyStack() {
        this.count = 0;
        this.capacity = 8;
        this.storage = new int[this.capacity];
    }

    // 初始化时带容量的栈
    public MyStack(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.storage = new int[this.capacity];
    }

    //TODO：确保容量大小
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    // push操作
    public void push(int value) {
        if (this.count == this.capacity) {
            ensureCapacity();
        }
        this.storage[count++] = value; // 新增一个容量就加1
    }

    // 返回栈顶元素并出栈
    public int pop() {
        count --;
        if (count < 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        return this.storage[count];
    }

    public int peek() {
        if (count == 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        return this.storage[count-1];
    }

    //TODO：判断栈是否为空
    private boolean isEmpty() {
        return count == 0;
    }

    //TODO：返回栈中元素的个数
    private int size() {
        return count;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
    }
}
