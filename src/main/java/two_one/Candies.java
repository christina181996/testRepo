package two_one;

public class Candies extends Sweets {
    private boolean isContainingChocolate;

    public Candies(String sweetBrand, int sweetPrice, int sweetWeight, String type, boolean isContainingChocolate) {
        super(sweetBrand, sweetPrice, sweetWeight, type);
        this.isContainingChocolate = isContainingChocolate;
    }

    public boolean isContainingChocolate() {
        return isContainingChocolate;
    }

    public void setContainingChocolate(boolean containingChocolate) {
        isContainingChocolate = containingChocolate;
    }
}
