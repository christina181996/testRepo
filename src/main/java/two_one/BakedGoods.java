package two_one;

public class BakedGoods extends Sweets {
    private boolean isGlazed;

    public BakedGoods(String sweetBrand, int sweetPrice, int sweetWeight, String type, boolean isGlazed) {
        super(sweetBrand, sweetPrice, sweetWeight, type);
        this.isGlazed = isGlazed;
    }

    public boolean isGlazed() {
        return isGlazed;
    }

    public void setGlazed(boolean glazed) {
        isGlazed = glazed;
    }
}
