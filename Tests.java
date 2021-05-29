import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Tests {
    @Test
    public void addTerms() throws Exception {
        Polynomial poly = new Polynomial();
        Node poly1 = null;
        Node term1 = new Node(3,3);
        Node term2 = new Node(3,2);
        Node term3 = new Node(3,1);
        poly1 = poly.addTerm(poly1,term1);
        poly1 = poly.addTerm(poly1,term2);
        poly1 = poly.addTerm(poly1,term3);
        Assertions.assertEquals(term1, poly1);
        Assertions.assertEquals(term2, poly1.next);
        Assertions.assertEquals(term3, poly1.next.next);
    }

    @Test
    public void deleteTerms() throws Exception {
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
    }

    @Test
    public void testNElements() throws Exception {
        Node test = null;
        for (int i = 0; i < 10; i++) {
            test = new Node(i,i);
            test = test.next;
        }
    }

}

