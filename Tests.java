import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Tests {
    @Test
    public void addDifferentExponentTermsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = null;
        Node term1 = new Node(3,3);
        Node term2 = new Node(3,2);
        Node term3 = new Node(3,1);
        Node term4 = new Node(0,0);

        poly1 = poly.addTerm(poly1,term1);
        poly1 = poly.addTerm(poly1,term2);
        poly1 = poly.addTerm(poly1,term3);
        poly1 = poly.addTerm(poly1,term4);

        Assertions.assertEquals(term1, poly1);
        Assertions.assertEquals(term2, poly1.next);
        Assertions.assertEquals(term3, poly1.next.next);
        Assertions.assertEquals(term4, poly1.next.next.next);
    }

    @Test
    public void addSameExponentTermsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = null;
        Node term1 = new Node(3,3);
        Node term2 = new Node(2,3);
        Node term3 = new Node(-1,3);
        Node term4 = new Node(-3,3);

        poly1 = poly.addTerm(poly1,term1);
        poly1 = poly.addTerm(poly1,term2);
        poly1 = poly.addTerm(poly1,term3);
        poly1 = poly.addTerm(poly1,term4);

        Assertions.assertEquals(1, poly1.getCoefficient());
    }

    @Test
    public void deleteMiddleTermTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = null;
        Node term1 = new Node(3,3);
        Node term2 = new Node(3,2);
        Node term3 = new Node(3,1);

        poly1 = poly.addTerm(poly1,term1);
        poly1 = poly.addTerm(poly1,term2);
        poly1 = poly.addTerm(poly1,term3);

        poly1 = poly.deleteTerm(poly1,2);

        Assertions.assertEquals(term1, poly1);
        Assertions.assertEquals(term3, poly1.next);
    }

    @Test
    public void deleteFirstTermTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = null;
        Node term1 = new Node(3,3);
        Node term2 = new Node(3,2);
        Node term3 = new Node(3,1);

        poly1 = poly.addTerm(poly1,term1);
        poly1 = poly.addTerm(poly1,term2);
        poly1 = poly.addTerm(poly1,term3);

        poly1 = poly.deleteTerm(poly1,3);

        Assertions.assertEquals(term2, poly1);
        Assertions.assertEquals(term3, poly1.next);
    }

    @Test
    public void deleteLastTermTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = null;
        Node term1 = new Node(3,3);
        Node term2 = new Node(3,2);
        Node term3 = new Node(3,1);

        poly1 = poly.addTerm(poly1,term1);
        poly1 = poly.addTerm(poly1,term2);
        poly1 = poly.addTerm(poly1,term3);

        poly1 = poly.deleteTerm(poly1,1);

        Assertions.assertEquals(term1, poly1);
        Assertions.assertEquals(term2, poly1.next);
    }

    @Test
    public void testNElementsTest() throws Exception {
        Node test = null;
        for (int i = 0; i < 10; i++) {
            test = new Node(i,i);
            test = test.next;
        }
    }

    @Test
    public void addSingleLikeTermPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();
        Node poly1 = new Node(3,3);
        Node poly2 = new Node(3,3);

        Node sum = poly. addPolynomials(poly1, poly2);

        Assertions.assertEquals(6, sum.getCoefficient());
    }

    @Test
    public void addMultipleLikeTermPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 =      new Node(3,3);
        poly1.next =      new Node(2,2);
        poly1.next.next = new Node(5,1);
        Node poly2 =      new Node(7,3);
        poly2.next =      new Node(3,2);
        poly2.next.next = new Node(-3,1);

        Node sum = poly. addPolynomials(poly1, poly2);

        Assertions.assertEquals(10, sum.getCoefficient());
        Assertions.assertEquals(5, sum.next.getCoefficient());
        Assertions.assertEquals(2, sum.next.next.getCoefficient());
    }

    @Test
    public void addMultipleDifferentTermPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 =      new Node(3,5);
        poly1.next =      new Node(2,3);
        poly1.next.next = new Node(5,1);
        Node poly2 =      new Node(7,4);
        poly2.next =      new Node(3,2);
        poly2.next.next = new Node(-3,0);

        Node sum = poly. addPolynomials(poly1, poly2);

        Assertions.assertEquals(3, sum.getCoefficient());
        Assertions.assertEquals(7, sum.next.getCoefficient());
        Assertions.assertEquals(2, sum.next.next.getCoefficient());
        Assertions.assertEquals(3, sum.next.next.next.getCoefficient());
        Assertions.assertEquals(5, sum.next.next.next.next.getCoefficient());
        Assertions.assertEquals(-3, sum.next.next.next.next.next.getCoefficient());
    }

    @Test
    public void addSingleTermDifferentExponentPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(3,5);
        Node poly2 = new Node(7,4);

        Node sum = poly. addPolynomials(poly1, poly2);

        Assertions.assertEquals(3, sum.getCoefficient());
        Assertions.assertEquals(7, sum.next.getCoefficient());
    }

    @Test
    public void subtractSingleTermDifferentPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(3,5);
        Node poly2 = new Node(7,4);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(3, difference.getCoefficient());
        Assertions.assertEquals(-7, difference.next.getCoefficient());
    }

    @Test
    public void subtractSingleNegativeDifferentExponentsDifferentPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(-3,5);
        Node poly2 = new Node(-7,4);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(-3, difference.getCoefficient());
        Assertions.assertEquals(7, difference.next.getCoefficient());
    }

    @Test
    public void subtractSingleTermSameExponentsPolynomialsTest() throws Exception {
        //TODO
    }

    @Test
    public void subtractAllPositiveTermsSameExponentPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(3,3);
        poly1.next = new Node(5,2);
        poly1.next.next = new Node(1,1);
        Node poly2 = new Node(7,3);
        poly2.next = new Node(10, 2);
        poly2.next.next = new Node(3, 1);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(-4, difference.getCoefficient());
        Assertions.assertEquals(-5, difference.next.getCoefficient());
        Assertions.assertEquals(-2, difference.next.next.getCoefficient());
    }
    @Test
    public void subtractSingleNegativeSameTermPolynomialsTest() throws Exception {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(-3,3);
        Node poly2 = new Node(-7,3);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(-4, difference.getCoefficient());
        Assertions.assertEquals(-5, difference.next.getCoefficient());
        Assertions.assertEquals(-2, difference.next.next.getCoefficient());
    }
}

