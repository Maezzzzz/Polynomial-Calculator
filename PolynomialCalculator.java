import java.util.LinkedList;
import java.util.Scanner;

public class PolynomialCalculator {
    static class Term {
        private Term head;
        int coefficient;
        int exponent;
        Term next;
        public Term(int c, int e) {
            coefficient = c;
            exponent = e;
            next = null;
        }

        public int getCoefficient() {
            return coefficient;
        }

        public int getExponent() {
            return exponent;
        }
    }
    public static void main(String[] args) {
        LinkedList<Term> polynomial1 = new LinkedList<Term>();
        LinkedList<Term> polynomial2 = new LinkedList<Term>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the polynomial calculator!");
        int selection = 1;
        while(selection > 0) {
            System.out.print("Enter '1' to add a term to the first polynomial.\n" +
                             "Enter '2' to delete a term to the first polynomial.\n" +
                             "Enter '3' to add a term to the second polynomial.\n" +
                             "Enter '4' to delete a term from the second polynomial.\n" +
                             "Enter '5' to calculate sum of polynomial 1 and polynomial 2.\n" +
                             "Enter '6' to calculate difference of polynomial 1 and polynomial 2.\n" +
                             "Enter '7' to quit\n" +
                             "Selection: ");
            selection = keyboard.nextInt();
            if(selection == 1) {
                System.out.print("Enter coefficient: ");
                int c = keyboard.nextInt();
                System.out.print("Enter exponent: ");
                int e = keyboard.nextInt();
                addTerm(polynomial1, c, e);
                printPolys(polynomial1, polynomial2);
            }
            if(selection == 2) {
                //TODO
            }
            if(selection == 3) {
                System.out.print("Enter coefficient: ");
                int c = keyboard.nextInt();
                System.out.print("Enter exponent: ");
                int e = keyboard.nextInt();
                addTerm(polynomial2, c, e);
                printPolys(polynomial1, polynomial2);
            }
            if(selection == 4) {
                //TODO
            }
            if(selection == 5) {
                //TODO
            }
            if(selection == 6) {
                //TODO
            }
            if(selection == 7) {
                System.exit(0);
            }
        }

        int numOfTerms = keyboard.nextInt();
        for(int i = 1; i <= numOfTerms; i++) {
            if(i == 1){
               System.out.print("Enter the coefficient of the " + i + "st term: ");
               int c = keyboard.nextInt();
               System.out.print("Enter the exponent of the " + i + "st term: ");
               int e = keyboard.nextInt();
               polynomial1.add(new Term(c,e));
            }
            if(i == 2) {
                System.out.print("Enter the coefficient of the " + i + "nd term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of the " + i + "nd term: ");
                int e = keyboard.nextInt();
                polynomial1.add(new Term(c,e));
            }
            if(i == 3) {
                System.out.print("Enter the coefficient of the " + i + "rd term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of the " + i + "rd term: ");
                int e = keyboard.nextInt();
                polynomial1.add(new Term(c,e));
            }
            if(i > 3 && i < 21) {
                System.out.print("Enter the coefficient of the " + i + "rd term: ");
                int c = keyboard.nextInt();
                System.out.print("Enter the exponent of the " + i + "rd term: ");
                int e = keyboard.nextInt();
                polynomial1.add(new Term(c,e));
            }
        }
        String print = "Polynomial: ";
        for(Term term : polynomial1) {
            print += (term.getCoefficient() + "x^" + term.getExponent() + " ");
        }
        System.out.println(print);
    }
    private static void addTerm(LinkedList<Term> poly, int c,int e) {
        //TODO
    }
    private static void printPolys(LinkedList<Term> poly1, LinkedList<Term> poly2) {
        String poly1ToString = "Polynomial 1: ";
        String poly2ToString = "Polynomial 2: ";
        for(Term term : poly1) {
            //if (term == term.head){
            //    if(term.getCoefficient() < 0) {
                    //TODO
            //    }
            //    if(term.getCoefficient() == 0) {
            //        //TODO
            //    }
            //    if(term.getCoefficient() == 1) {
                    //TODO
            //    }
            //}
            if(term.next != null) {
                poly1ToString += (term.getCoefficient() + "x^" + term.getExponent() + " ");
            }else{
                poly1ToString += (term.getCoefficient() + "x^" + term.getExponent());
            }
        }
        for(Term term : poly2) {
            //if (term == term.head){
            //    if(term.getCoefficient() < 0) {
                    // TODO
            //    }
            //    if(term.getCoefficient() == 0) {
                    //TODO
            //    }
            //    if(term.getCoefficient() == 1) {
                    //TODO
            //    }
            //}
            if(term.next != null) {
                poly2ToString += (term.getCoefficient() + "x^" + term.getExponent() + " ");
            }else{
                poly2ToString += (term.getCoefficient() + "x^" + term.getExponent());
            }
        }
        System.out.println(poly1ToString);
        System.out.println(poly2ToString);
    }
}