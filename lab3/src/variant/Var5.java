package variant;
import ex3.Node;

import java.util.Scanner;

public class Var5 {
    static Scanner sc;
    public static Node createHead(int count){
        Node head = new Node(sc.nextInt(), null);
        Node ref = head;
        for (int i = 1; i < count; i++){
            ref.next = new Node(sc.nextInt(), null);
            ref = ref.next;
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

    public static void exOne(Node head){
        int sum =0;
        int k = 0;
        Node ref = head;
        while (ref != null){
            if (ref.value % 2 == 0 && ref.value > 0){
                sum = sum + ref.value;
                k++;
            }
            ref = ref.next;
        }
        if (k != 0){
            System.out.println("summ-> "+ sum);
            System.out.println("count-> "+ k);
            System.out.println("average-> "+sum/k);
        }
        else{
            System.out.println("there are no numbers satisfying the condition");
        }
    }

    public static int exTwoMax(Node head){
        int max = 0;
        Node ref = head;
        while (ref != null){
            if (ref.value % 2 == 0 && ref.value > 0){
                if (ref.value > max){
                    max = ref.value;
                }
            }
            ref = ref.next;
        }
        if(max != 0){
            System.out.println("Max value -> " + max );
        }
        else {
            System.out.println("there are no numbers satisfying the condition");
        }
        return max;
    }
    public static int exTwoMin(Node head){
        int min = 2147483647;
        Node ref = head;
        while (ref != null) {

            if (ref.value % 2 == 0 && ref.value > 0 && ref.value < min ) {
                min = ref.value;
            }
            ref = ref.next;
        }
        if(min != 0){
            System.out.println("Min value -> " + min );
        }
        else {
            System.out.println("there are no numbers satisfying the condition");
        }
        return min;
    }

    public static void replace(Node head) {
        Node ref = head;
        int max, min;
        max = exTwoMax(head);
        min = exTwoMin(head);
        while (ref != null) {
            if (ref.value == max) {
                ref.value = min;
            }
            else if(ref.value == min)
                ref.value = max;

            ref = ref.next;
        }
        printList(head);
    }



    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("count");
        int count = sc.nextInt();
        System.out.println("input values");
        Node head = createHead(count);
        printList(head);
        exOne(head);
       /* exTwoMax(head);
        exTwoMin(head);*/
        replace(head);
    }
}
