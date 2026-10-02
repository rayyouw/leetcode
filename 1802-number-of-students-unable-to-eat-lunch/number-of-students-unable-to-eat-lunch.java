class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack stack = new Stack();
        Queue queue = new Queue();

        for(int i = sandwiches.length - 1; i >= 0; i--){
            stack.push(sandwiches[i]);
        }

        for(int s : students){
            queue.enqueue(s);
        }

        int skipped = 0;
        while (!queue.isEmpty() && skipped < queue.size()) {
            if (queue.getfront() == stack.peek()) {
                queue.dequeue();
                stack.pop();
                skipped = 0;
            } else {
                queue.skip();
                skipped++;
            }
        }
        return queue.size();
    }

    static class Node{
        int val;
        Node next;

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    static class Stack{
        Node top;
        int size;

        void push(int v){
            top = new Node(v, top);
            size++;
        }

        int pop() {
            if(top == null) return 0;
            int v = top.val;
            top = top.next;
            size--;
            return v;
        }

        int peek() {
            if(top == null) return 0;
            return top.val;
        }

        boolean isEmpty(){
            return top == null;
        }

        int size() {
            return size;
        }
    }

    static class Queue {
        Node head, tail;
        int size;

        void enqueue(int v) {
            Node n = new Node(v, null);
            if(tail == null){
                head = tail = n;
            }else{
                tail.next = n;
                tail = n;
            }
            size++;
        }

        int dequeue() {
            int v = head.val;
            head = head.next;
            if(head == null) tail = null;
            size--;
            return v;
        }

        boolean isEmpty() {
            return head == null;
        }

        int size() {
            return size;
        }

        int getfront() {
            if(isEmpty()){
                return 0;
            }

            return head.val;
        }

        int getback() {
            if(isEmpty()){
                return 0;
            }

            return tail.val;
        }

        int skip() {
            int v = head.val;
            if(head != tail){
                Node n = head;
                head = head.next;
                n.next = null;
                tail.next = n;
                tail = n;
            }

            return v;
        }
    }
}