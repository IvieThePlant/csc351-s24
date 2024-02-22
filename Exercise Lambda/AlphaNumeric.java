public class AlphaNumeric {

    /** The alpha part */
    private String alpha = null;

    /** The numeric part */
    private Integer number = null;

    /** Constructor with specified values of alpha and numeric */
    public AlphaNumeric(String a, Integer n) {
        alpha = a;
        number = n;
    }

    @Override
    public String toString() {
        return "["+alpha()+","+number()+"]";
    }

    // GETTERS
    public String alpha() {
        return alpha;
    }

    public Integer number() {
        return number;
    }
}