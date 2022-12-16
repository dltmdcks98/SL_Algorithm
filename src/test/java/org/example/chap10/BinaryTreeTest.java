package org.example.chap10;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void traverse(){

        //Java 자체 Tree
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("ddd","zzz");
        treeMap.put("aaa","zzz");
        treeMap.put("zzz","zzz");

        System.out.println(treeMap);
        /*
          HASH Map 은 빠르게 저장하기 위한 map
          Tree Map 은 정렬하면서 저장
         */

        BinaryTree tree = new BinaryTree();

        /*
                              50
                27                              68
        12              36              55              82
    7      19      **       49      **      **      76      **

         */
        tree.add(50);
        tree.add(27);
        tree.add(68);

        tree.add(12);
        tree.add(36);
        tree.add(55);
        tree.add(82);
        tree.add(7);
        tree.add(19);
        tree.add(49);
        tree.add(76);

        System.out.println("============ 순회 ===============");
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());

        //트리 출력
        System.out.println("\n===================트리 출력==========");
        tree.display();
        tree.delete(27);
        System.out.println("\n===================27 삭제 트리 출력==========");
        tree.display();
    }


}