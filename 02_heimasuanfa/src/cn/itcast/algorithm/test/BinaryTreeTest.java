package cn.itcast.algorithm.test;

import cn.itcast.algorithm.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        tree.put(8,"张三");
        tree.put(9,"李四");
        tree.put(5,"王五");
        tree.put(2,"王2");
        tree.put(6,"王6");
        tree.put(3,"王3");
        tree.put(7,"王7");
        System.out.println(tree.size());
        System.out.println("5位置的值："+tree.get(5));
        System.out.println(tree.min());
        System.out.println(tree.max());
        tree.delete(5);
        System.out.println(tree.size());
        System.out.println("5位置的值："+tree.get(5));
        System.out.println(tree.get(7));


    }

}
