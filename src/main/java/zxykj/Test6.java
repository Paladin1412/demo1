package zxykj;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.ArrayList;
import java.util.List;

/**
 * - （选答）单链表处理
 * 假设线性表 L = {A1, A2, A3, A4, …, An-2, An-1, An}，
 * 采⽤用带头节点的单链表保存。
 * 链接节点定义如 下：
 * typedef struct node {
 * int data;
 * struct node * next;
 * } NODE; 请
 * 设计一个算法，编程实现，重新排列列 L 中的各节点，
 * 得到线性表 L’ = {A1, An,  A2, An-1,  A3, An2, … }。
 */
// 1 2 3 4 5 6
// 6 5 4 3 2 1
// 1 6 2 5 3 4

//    1 2 3 4 5 6 7
//    7 6 5 4 3 2 1
//
//    1 7 2 6 3 5 4
public class Test6 {
    static Node first;
//    static Node last;
    static Node prev;
    static int size = 0;

    /**
     * 1.初始化数据
     * 2.将原数据写入自定义链式集合中
     * 3.重新排序（取最后的node，并插入当前index之后，将倒数第2个node的next设置为null
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        init(list);
        System.out.println(list);
        //将集合中的数据，按链式保存
        for (int i = 0; i < list.size(); i++) {
            Node node = new Node(list.get(i), null);
            add(node);
        }
        //重新排序
        reSort();
        System.out.println(first);
        showData();
    }

    public static void showData() {
        Node next = first;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(next.getData());
            next = next.next;
        }
        System.out.println(list);
    }

    public static void reSort() {
        for (int i = 0; i < size - 1; i += 2) {
            Node lastNode = get(size - 1);
            get(size - 2).setNext(null);  //末尾是指为空
            //插入操作，每次将末尾的插入i、(i+1)的中间
            Node node1 = get(i);
            Node node2 = get(i + 1);
            node1.setNext(lastNode);
            lastNode.setNext(node2);
        }
    }

    public static Node get(int index) {
        Node next = first;
        for (int k = 0; k < index; k++) {
            next = next.next;
        }
        return next;
    }


    public static void add(Node node) {
        if (size == 0) {
            first = node;
//            last = node;
            prev = node;
        } else {
            Node pre = prev;
            pre.next = node;
//            last = node;
            prev = node;
        }
        size++;
    }

    static void init(List<Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
    }


}
