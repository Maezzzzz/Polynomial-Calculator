import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@SuppressWarnings("DuplicatedCode")
public class Tests {
    @Test
    public void addDifferentExponentsTest() {
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
    public void addSameExponentsTest() {
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
    public void deleteMiddleTermTest() {
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
    public void deleteFirstTermTest() {
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
    public void deleteLastTermTest() {
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
    public void testNElementsTest() {
        Node test = null;
        for (int i = 0; i < 10; i++) {
            test = new Node(i,i);
            test = test.next;
        }
    }

    @Test
    public void addSingleLikeExponentPolynomialsTest() {
        Polynomial poly = new Polynomial();
        Node poly1 = new Node(3,3);
        Node poly2 = new Node(3,3);

        Node sum = poly. addPolynomials(poly1, poly2);

        Assertions.assertEquals(6, sum.getCoefficient());
    }

    @Test
    public void addSingleTermDifferentExponentPolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(3,5);
        Node poly2 = new Node(7,4);

        Node sum = poly. addPolynomials(poly1, poly2);

        Assertions.assertEquals(3, sum.getCoefficient());
        Assertions.assertEquals(7, sum.next.getCoefficient());
    }

    @Test
    public void addMultipleLikeExponentPolynomialsTest() {
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
    public void addMultipleDifferentExponentPolynomialsTest() {
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
    public void subtractSingleTermDifferentExponentPolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(3,5);
        Node poly2 = new Node(7,4);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(3, difference.getCoefficient());
        Assertions.assertEquals(-7, difference.next.getCoefficient());
    }

    @Test
    public void subtractNegativeSingleTermDifferentExponentsPolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(-3,5);
        Node poly2 = new Node(-7,4);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(-3, difference.getCoefficient());
        Assertions.assertEquals(7, difference.next.getCoefficient());
    }

    @Test
    public void subtractSingleTermSameExponentsPolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(6,4);
        Node poly2 = new Node(-5,4);

        Node negatedPoly2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPoly2);

        Assertions.assertEquals(11, difference.getCoefficient());
    }

    @Test
    public void subtractAllPositiveTermsSameExponentPolynomialsTest() {
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
    public void subtractSingleNegativeSameTermPolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(-3,3);
        Node poly2 = new Node(-7,3);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(4, difference.getCoefficient());
    }


    @Test
    public void subtractAllNegativePolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(-3,3);
        poly1.next = new Node(-4,2);
        poly1.next.next = new Node(-1,1);
        Node poly2 = new Node(-7,3);
        poly2.next = new Node(-2,2);
        poly2.next.next = new Node(-10,1);

        Node negatedPolynomial2 = poly.negatePolynomial(poly2);

        Node difference = poly.addPolynomials(poly1, negatedPolynomial2);

        Assertions.assertEquals(4, difference.getCoefficient());
        Assertions.assertEquals(-2, difference.next.getCoefficient());
        Assertions.assertEquals(9, difference.next.next.getCoefficient());
    }

    @Test
    public void nullSizePolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = null;

        Assertions.assertEquals(0, poly.size(poly1));
    }

    @Test
    public void SizePolynomialsTest() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(0,0);
        poly1.next = new Node(0,0);
        poly1.next.next = new Node(0,0);
        poly1.next.next.next = new Node(0,0);

        Assertions.assertEquals(4, poly.size(poly1));
    }

    @Test
    public void multiplySingleTermPolynomials() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(2,1);
        Node poly2 = new Node(3,4);

        Node product = poly.multiplyPolynomials(poly1,poly2);
        Assertions.assertEquals(6, product.getCoefficient());
        Assertions.assertEquals(5, product.getExponent());
    }

    @Test
    public void multiplyPoly2SmallerTermPolynomials() {
        Polynomial poly = new Polynomial();

        Node poly1 = new Node(2,2);
        poly1.next = new Node(2,1);
        poly1.next.next = new Node(2,0);
        Node poly2 = new Node(3,4);
        poly2.next = new Node(3,3);

        int poly1Size = poly.size(poly1);
        int poly2Size = poly.size(poly2);
        Node product;
        if(poly2Size < poly1Size) {
            product = poly.multiplyPolynomials(poly2,poly1);
        }else {
            product = poly.multiplyPolynomials(poly1,poly2);
        }
        Assertions.assertEquals(6, product.getCoefficient());
        Assertions.assertEquals(6, product.getExponent());

        Assertions.assertEquals(12, product.next.getCoefficient());
        Assertions.assertEquals(5, product.next.getExponent());

        Assertions.assertEquals(12, product.next.next.getCoefficient());
        Assertions.assertEquals(4, product.next.next.getExponent());

        Assertions.assertEquals(6, product.next.next.next.getCoefficient());
        Assertions.assertEquals(3, product.next.next.next.getExponent());
    }
}

