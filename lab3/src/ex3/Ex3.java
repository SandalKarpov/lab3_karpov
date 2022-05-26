package ex3;

public class Ex3 {
    public static Node createHead(int count){
        Node head = new Node(0, null);
        Node ref = head;
        for (int i = 1; i < count; i++){
            ref.next = new Node(i, null);
            ref = ref.next;
        }
        return head;
    }
    public static Node createHeadRec(Node head, int i){
        if(i > 0){
            head = new Node(i, head);
            return createHeadRec(head, i-1);
        }
        //1->2->3->4
        //1<-2<-3<-4
        return head;
    }
    public static Node createTailRec(Node tail, int g, int i){
        if (i < g){
            tail.next = new Node(i+1, null);
            tail = tail.next;
            System.out.print(tail.value + " ");
            return createTailRec(tail,g, i+1);
        }
    //4->2->3->1
    //4<-3<-2<-1
        return tail;
    }
    public static Node createTail(int count){
        Node head = new Node(0, null);
        for (int i = count-2; i >= 0; i--){
            head = new Node (i, head);
        }
        return head;
    }
    public static void printList(Node head){
        Node ref = head;
        while (ref != null){
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
    public static void toStringRec(Node head){
        if(head != null){
            System.out.print(head.value + " ");
            toStringRec(head.next);
        }
        System.out.println();
    }
    public static Node addFirst(Node oldHead, Node newElement){
        Node head = newElement;
        newElement.next = oldHead;
        return head;
    }
    public static Node addLast(Node head, Node newElement){
        Node ref = head;
        while (ref.next != null){
            ref = ref.next;
        }
        ref.next = newElement;
        return head;
    }
    public static Node removeFirst(Node head){
        head = head.next;
        return head;
    }
    public static Node removeLast(Node head){
        Node ref = head;
        while (ref.next.next != null){
            ref = ref.next;
        }
        ref.next = null;
        return head;
    }
    public static Node Remove(Node head, int k){
        Node ref = head;
        int i = 2;
        while (i != k){
            ref = ref.next;
            i++;
        }
        ref.next = ref.next.next;
        return head;
    }
    public static void main(String[] args) {
        Node head = createHead(10);
        printList(head);
        head = addFirst(head, new Node(-10, null));
        printList(head);
        head = addLast(head, new Node(100, null));
        printList(head);
        head = removeFirst(head);
        printList(head);
        head = removeLast(head);
        printList(head);
        head = Remove(head, 3);
        printList(head);
        //Node headRec = createHeadRec(null, 6);
        //printList(headRec);
        Node tailRec = createTailRec(new Node(0, null), 6, 0);
        toStringRec(head);
    }
}

