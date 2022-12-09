package org.example.chap05.stack;

class Node<E>{
    private E item;//저장할 값
    private Node<E> Link;//스택의 다음 노드를 가리킬 포인터

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getLink() {
        return Link;
    }

    public void setLink(Node<E> link) {
        Link = link;
    }
}

public class Stack <E>{
    //스택의 맨 위 노드를 감시할 노드
    private Node<E> top;

    public Stack() {
        this.top = new Node<>();
    }
    //스택이 비었는지?
    public boolean isEmpty(){
        return top.getLink()==null;
    }


    //스택에 자료 삽입(PUSH)
    public void push(E item){
        //새 노드를 생성
        Node<E> newNode = new Node<>();
        newNode.setItem(item);//노드에 값 저장

        //새노드는 기존의 top노드가 감시하고 있던 노드를 연결
        newNode.setLink(top.getLink());
        //top 노드는 새로운 노드를 감시한다.
        top.setLink(newNode);
    }

    //스택에서 자료 제거
    public E pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return null;
        }else{
            //리턴할 데이터 가져오기
            E data = top.getLink().getItem();

            //top이 제거될 노드의 다음 노드를 감시하도록 설정
            top.setLink(top.getLink().getLink());
            return data;
        }
    }

    public E peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return null;
        }else{
            //리턴할 데이터 가져오기
            E data = top.getLink().getItem();
            return data;
        }
    }
}
