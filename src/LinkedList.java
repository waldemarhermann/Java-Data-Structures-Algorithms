
public class LinkedList {
    private Node head;
    private Node tail;
    private int length;


    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

    }


    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void show() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public Node removeFirst() {
        if (length == 0) return null;

            Node temp = head;
            head = head.next;
            temp.next = null;
            length --;

            if (length == 0) {
                tail = null;
            }
            return temp;
    }

    public Node get(int index) {
        Node temp = head;
        if (index < 0 || index >= length) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            length ++;
            return true;
        }

    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        /*Node pre = head;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            pre = temp;
            temp = temp.next;
        }*/

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length --;
        return temp;

    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;


        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;

        }
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public void partitionList(int pivot) {
        Node smallerDummy = new Node(0);
        Node greaterDummy = new Node(0);
        Node smaller = smallerDummy;
        Node greater = greaterDummy;
        Node current = head;

        while(current != null) {
            if(current.value < pivot) {
                smaller.next = current;
                smaller = current;
            } else {
                greater.next = current;
                greater = current;
            }
            current = current.next;
        }
        smaller.next = greaterDummy.next;
        greater.next = null;
        head = smallerDummy.next;
    }

    public void removeDuplicates() {
        Node current = head;

        while(current != null && current.next != null) {
            Node runner = current;

            while(runner.next != null) {
                if(runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length--;
                    if(runner.next == null) {
                        tail = runner;
                    }
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }



}

