import java.util.Scanner;

public class Polynomial {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Node polynomial1 = null;
        Node polynomial2 = null;
        int selection = 1;
        while(selection != 3) {
            System.out.print("Enter 1 to enter first polynomial.\n" +
                             "Enter 2 to enter second polynomial.\n" +
                             "Enter 3 to quit.\n" +
                             "Selection: ");
            selection = keyboard.nextInt();

            if(selection == 1) {
                System.out.print("Enter the coefficient of term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of term: ");
                int e = keyboard.nextInt();
                polynomial1 = addTerm(polynomial1, c, e);
            }

            if(selection == 2) {
                System.out.print("Enter the coefficient of term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of term: ");
                int e = keyboard.nextInt();
                polynomial2 = addTerm(polynomial2, c, e);
            }

            if(selection == 3) {
                System.exit(0);
            }

            print(polynomial1);
            print(polynomial2);
        }
    }

    private static Node addTerm(Node head, int c, int e) {
        Node temp = new Node(c,e);
        Node returnPoly = new Node(0,0);
        Node tail = returnPoly;

        while(true) {
            if (head == null) {
                tail.next = temp;
                break;
            }

            if (temp == null) {
                tail.next = head;
                break;
            }

            if (head.getExponent() < temp.getExponent()) {
                tail.next = temp;
                temp = temp.next;
            } else if(head.getExponent() > temp.getExponent()){
                tail.next = head;
                head = head.next;
            } else {
                head.setCoefficient(head.getCoefficient() + temp.getCoefficient());
                tail.next = head;
                head = head.next;
                temp = temp.next;
            }
            tail = tail.next;
        }
        return returnPoly.next;
    }

    private static void print(Node head) {
        String polynomial = "";
        if(head == null) {
            System.out.println(polynomial);
        }else {
            Node ptr = head;
            if(ptr.next == null) {
                polynomial += (ptr.getCoefficient() + "x^" + ptr.getExponent());
            }else {
                while(ptr.next != null) {
                    if (ptr.next.getCoefficient() > 0) {
                        polynomial += (ptr.getCoefficient() + "x^" + ptr.getExponent() + "+");
                    }else {
                        polynomial += (ptr.getCoefficient() + "x^" + ptr.getExponent() );
                    }
                    ptr = ptr.next;
                }
                polynomial += (ptr.getCoefficient() + "x^" + ptr.getExponent());
            }
            System.out.println(polynomial);
        }
    }
}