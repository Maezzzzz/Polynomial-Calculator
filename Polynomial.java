import java.util.Scanner;

public class Polynomial {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Node polynomial1 = null;
        Node polynomial2 = null;
        int selection = 1;
        while(selection != 9) {
            System.out.print("Enter 1 to enter first polynomial.\n" +
                             "Enter 2 to enter second polynomial.\n" +
                             "Enter 3 to  delete term from polynomial 1.\n" +
                             "Enter 4 to delete a term from polynomial 2.\n" +
                             "Enter 5 to get the sum of the polynomials.\n" +
                             "Enter 6 \n" +
                             "Enter 7 \n" +
                             "Enter 8 \n" +
                             "Enter 9  to quit.\n" +
                             "Selection: ");
            selection = keyboard.nextInt();
            if(selection == 1) {
                System.out.print("Enter the coefficient of term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of term: ");
                int e = keyboard.nextInt();
                Node newTerm = new Node(c,e);
                polynomial1 = addTerm(polynomial1, newTerm);
            }
            if(selection == 2) {
                System.out.print("Enter the coefficient of term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of term: ");
                int e = keyboard.nextInt();
                Node newTerm = new Node(c,e);
                polynomial2 = addTerm(polynomial2, newTerm);
            }
            if(selection == 3) {
                System.out.print("Enter the exponent of term to be deleted: ");
                int e = keyboard.nextInt();
                polynomial1 = deleteTerm(polynomial1,e);
            }
            if(selection == 4) {
                System.out.print("Enter the exponent of term to be deleted: ");
                int e = keyboard.nextInt();
                polynomial2 = deleteTerm(polynomial2,e);
            }
            if(selection == 5) {
                Node sum = addPolynomials(polynomial1,polynomial2);
                System.out.print("Sum: ");
                print(sum);
            }
            if(selection == 6) {
                //TODO
            }
            if(selection == 7) {
                //TODO
            }
            if(selection == 8) {
                //TODO
            }
            if(selection == 9) {
                System.exit(0);
            }
            System.out.print("Poly 1: ");
            print(polynomial1);
            System.out.print("Poly 2: ");
            print(polynomial2);
        }

    }

    public static int size(Node node){
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public static Node addTerm(Node head, Node newTerm) {
        Node newPolynomial = new Node(0,0);
        Node tail = newPolynomial;

        while(true) {
            if (head == null) {
                tail.next = newTerm;
                break;
            }
            if (newTerm == null) {
                tail.next = head;
                break;
            }
            if (head.getExponent() < newTerm.getExponent()) {
                tail.next = newTerm;
                newTerm = newTerm.next;
            } else if(head.getExponent() > newTerm.getExponent()){
                tail.next = head;
                head = head.next;
            } else {
                head.setCoefficient(head.getCoefficient() + newTerm.getCoefficient());
                tail.next = head;
                head = head.next;
                newTerm = newTerm.next;
            }
            tail = tail.next;
        }
        return newPolynomial.next;
    }

    public static Node deleteTerm(Node head, int e) {
        Node prev, pointer;
        pointer = head;
        prev = null;

        if (pointer != null && pointer.getExponent() == e) {
            head = pointer.next;
            return head;
        }
        while (pointer != null &&  pointer.getExponent() != e) {
            prev = pointer;
            pointer = pointer.next;
        }
        if (pointer == null) {
            System.out.println("No term with exponent of " + e + " was found.");
            return head;
        }
        prev.next = pointer.next;
        return head;
    }

    public static Node addPolynomials(Node head1, Node head2) {
        Node sumPolynomial = new Node(0,0);
        Node p1 = head1;
        Node p2 = head2;
        Node p3 = sumPolynomial;

        while(p1 != null && p2 != null) {
            if(p1 == null) {
                p3.next = new Node(p2.getCoefficient(),p2.getExponent());
                break;
            }
            if(p2 == null) {
                p3.next = new Node(p1.getCoefficient(),p1.getExponent());
                break;
            }
            if(p1.getExponent() < p2.getExponent()) {
                p3.next = new Node(p2.getCoefficient(), p2.getExponent());
                p2 = p2.next;
            }else if (p1.getExponent() > p2.getExponent()) {
                p3.next = new Node(p1.getCoefficient(),p1.getExponent());
                p1 = p1.next;
            }else if(p1.getExponent() == p2.getExponent()) {
                p3.next =  new Node(p2.getCoefficient() + p1.getCoefficient(),p1.getExponent());
                p1 = p1.next;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        return sumPolynomial.next;
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