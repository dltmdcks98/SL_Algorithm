package org.example.chap10;

class Node {
    private int key; // 트리의 키 (데이터)
    private Node leftChild; // 왼쪽 자식
    private Node rightChild; // 오른쪽 자식

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.format("[ %d ]", key);
    }
}

public class BinaryTree {
    private Node root; // 루트 노드

    //트레에 데이터 삽입
    public void add(int key){
        //삽입할 데이터 노드 생성
        Node newNode = new Node(key);

        //지금 삽입된 노드가 트리의 첫번째 노드라면?
        if(root ==null){//빈 트리라면
            root = newNode;
        }else{
            Node current = root;//탐색을 root부터 시작하니까
            Node parent;//부모 노드

            while(true){
                parent = current;

                //삽입될 데이터가 타겟노드의 데이터보다 작은 경우
                if(key < current.getKey()){
                    current =current.getLeftChild();

                    //자식이 없는 경우
                    if(current == null){
                        parent.setLeftChild(newNode);
                        return;
                    }
                }else {
                    current = current.getRightChild();

                    if(current == null){
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }
}