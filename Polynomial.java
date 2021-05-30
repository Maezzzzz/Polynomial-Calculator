import java.awt.*;
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
                             "Enter 6 to get the difference of the polynomials\n" +
                             "Enter 7 to get the product of the polynomials\n" +
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
                Node negatedPolynomial2 = negatePolynomial(polynomial2);
                Node difference = addPolynomials(polynomial1,negatedPolynomial2);
                System.out.print("Difference: ");
                print(difference);
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

    public static Node addPolynomials(Node poly1, Node poly2) {
        Node sumPolynomial = new Node(0,0);
        Node p3 = sumPolynomial;

        while(true) {
            if(poly1 == null) {
                p3.next = poly2;
                break;
            }
            if(poly2 == null) {
                p3.next = poly1;
                break;
            }
            if(poly1.getExponent() < poly2.getExponent()) {
                p3.next = new Node(poly2.getCoefficient(), poly2.getExponent());
                poly2 = poly2.next;
            }else if (poly1.getExponent() > poly2.getExponent()) {
                p3.next = new Node(poly1.getCoefficient(),poly1.getExponent());
                poly1 = poly1.next;
            }else if(poly1.getExponent() == poly2.getExponent()) {
                p3.next =  new Node(poly2.getCoefficient() + poly1.getCoefficient(),poly1.getExponent());
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            p3 = p3.next;
        }
        return sumPolynomial.next;
    }

    public static Node negatePolynomial(Node poly2) {
        Node negatedPolynomial = new Node(0,0);
        Node p1 = negatedPolynomial;
        while (poly2 != null) {
            p1.next = new Node((poly2.getCoefficient() * -1), poly2.getExponent());
            poly2 = poly2.next;
            p1 = p1.next;

        }
        return negatedPolynomial.next;
    }

    public static Node multiplyPolynomials(Node poly1, Node poly2) {
        Node productPolynomial = new Node(0,0);
        //TODO
        return productPolynomial.next;
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