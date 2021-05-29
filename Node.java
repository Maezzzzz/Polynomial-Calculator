
public class Node {
    int coefficient;
    int exponent;
    Node next;
    Node(int c,int e) {
        coefficient = c;
        exponent = e;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

}
