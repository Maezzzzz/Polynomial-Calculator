import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Polynomial {
    static Node polynomial1 = null;
    static Node polynomial2 = null;
    static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        gui();
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

    public static int size(Node head){
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static Node multiplyPolynomials(Node poly1, Node poly2) {
        Node productPolynomial = null;
        Node p1 = poly1;
        Node p2 = poly2;
        while(p1 != null) {
            while(p2 != null) {
                if(p2.getExponent() == 0 && p1.getExponent() != 0){
                    Node temp = new Node(p1.getCoefficient() * p2.getCoefficient(), p1.getExponent());
                    productPolynomial = addTerm(productPolynomial,temp);
                }else if(p1.getExponent() == 0 && p2.getExponent() != 0) {
                    Node temp = new Node(p1.getCoefficient() * p2.getCoefficient(), p2.getExponent());
                    productPolynomial = addPolynomials(productPolynomial, temp);
                }else {
                    Node temp = new Node(p1.getCoefficient() * p2.getCoefficient(), p1.getExponent() + p2.getExponent());
                    productPolynomial = addPolynomials(productPolynomial,temp);
                }
                p2 = p2.next;
            }
            p1 = p1.next;
            p2 = poly2;
        }
        return productPolynomial;
    }

    private static StringBuilder print(Node head) {
        StringBuilder polynomial = new StringBuilder();
        if (head != null) {
            Node ptr = head;
            if (ptr.next == null) {
                polynomial.append(ptr.getCoefficient()).append("x^").append(ptr.getExponent());
            } else {
                while (ptr.next != null) {
                    if (ptr.next.getCoefficient() > 0) {
                        polynomial.append(ptr.getCoefficient()).append("x^").append(ptr.getExponent()).append("+");
                    } else {
                        polynomial.append(ptr.getCoefficient()).append("x^").append(ptr.getExponent());
                    }
                    ptr = ptr.next;
                }
                polynomial.append(ptr.getCoefficient()).append("x^").append(ptr.getExponent());
            }
        }
        return polynomial;
    }

    public static void gui() {
        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel polynomial1Label = new JLabel("Polynomial 1:");
        JLabel polynomial1Print = new JLabel("");

        JLabel polynomial2Label = new JLabel("Polynomial 2:");
        JLabel polynomial2Print = new JLabel("");

        JLabel sumLabel = new JLabel("Sum:");
        JLabel sumPrint = new JLabel("");

        JLabel differenceLabel = new JLabel("Difference:");
        JLabel differencePrint = new JLabel("");

        JLabel productLabel = new JLabel("Product:");
        JLabel productPrint = new JLabel("");

        JButton addTermToPolynomial1 = new JButton("Add a term to polynomial 1");
        addTermToPolynomial1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String coefficient = JOptionPane.showInputDialog(frame, "Enter Coefficient:");
                String exponent = JOptionPane.showInputDialog(frame, "Enter Exponent:");
                Node temp = new Node(Integer.valueOf(coefficient), Integer.valueOf(exponent));
                polynomial1 = addTerm(polynomial1, temp);
                polynomial1Print.setText(print(polynomial1).toString());
                sumPrint.setText("");
                differencePrint.setText("");
                productPrint.setText("");
            }
        });

        JButton deleteTermFromPolynomial1 = new JButton("Delete a term from polynomial 1");
        deleteTermFromPolynomial1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String exponent = JOptionPane.showInputDialog(frame, "Enter Exponent of term to be deleted:");
                polynomial1 = deleteTerm(polynomial1, Integer.valueOf(exponent));
                polynomial1Print.setText(print(polynomial1).toString());
                sumPrint.setText("");
                differencePrint.setText("");
                productPrint.setText("");
            }
        });

        JButton addTermToPolynomial2 = new JButton("Add a term to polynomial 2");
        addTermToPolynomial2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String coefficient = JOptionPane.showInputDialog(frame, "Enter Coefficient:");
                String exponent = JOptionPane.showInputDialog(frame, "Enter Exponent:");
                Node temp = new Node(Integer.valueOf(coefficient), Integer.valueOf(exponent));
                polynomial2 = addTerm(polynomial2, temp);
                polynomial2Print.setText(print(polynomial2).toString());
                sumPrint.setText("");
                differencePrint.setText("");
                productPrint.setText("");
            }
        });

        JButton deleteTermFromPolynomial2 = new JButton("Delete a term from polynomial 2");
        deleteTermFromPolynomial2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                String exponent = JOptionPane.showInputDialog(frame, "Enter Exponent of term to be deleted:");
                polynomial2 = deleteTerm(polynomial2, Integer.valueOf(exponent));
                polynomial2Print.setText(print(polynomial2).toString());
                sumPrint.setText("");
                differencePrint.setText("");
                productPrint.setText("");
            }
        });

        JButton sumOfPolynomials = new JButton("Calculate sum");
        sumOfPolynomials.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node sum = addPolynomials(polynomial1, polynomial2);
                sumPrint.setText(print(sum).toString());
            }
        });

        JButton differenceOfPolynomials = new JButton("Calculate difference");
        differenceOfPolynomials.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node negatedPolynomial2 = negatePolynomial(polynomial2);
                Node difference = addPolynomials(polynomial1, negatedPolynomial2);
                differencePrint.setText(print(difference).toString());
            }
        });

        JButton productOfPolynomials = new JButton("Calculate product");
        productOfPolynomials.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int poly1Size = size(polynomial1);
                int poly2Size = size(polynomial2);
                Node product = null;
                if(poly2Size < poly1Size) {
                    product = multiplyPolynomials(polynomial2,polynomial1);
                }else {
                    product = multiplyPolynomials(polynomial1, polynomial2);
                }
                productPrint.setText(print(product).toString());
            }
        });

        JButton quotientOfPolynomials = new JButton("Calculate quotient(to be added)");

        quotientOfPolynomials.setEnabled(false);

        frame.add(polynomial1Label);
        frame.add(polynomial1Print);

        frame.add(polynomial2Label);
        frame.add(polynomial2Print);

        frame.add(sumLabel);
        frame.add(sumPrint);

        frame.add(differenceLabel);
        frame.add(differencePrint);
        frame.add(productLabel);
        frame.add(productPrint);

        frame.add(addTermToPolynomial1);
        frame.add(deleteTermFromPolynomial1);

        frame.add(addTermToPolynomial2);
        frame.add(deleteTermFromPolynomial2);

        frame.add(sumOfPolynomials);

        frame.add(differenceOfPolynomials);

        frame.add(productOfPolynomials);

        frame.add(quotientOfPolynomials);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(9,2));
        frame.setSize(550, 300);
        frame.setVisible(true);
    }
}