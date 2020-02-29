package two_one;

public class Sweets {
    private String sweetBrand;
    private int sweetPrice;
    private int sweetWeight;
    private String type;

    public Sweets(String sweetBrand, int sweetPrice, int sweetWeight, String type) {
        this.sweetBrand = sweetBrand;
        this.sweetPrice = sweetPrice;
        this.sweetWeight = sweetWeight;
        this.type = type;
    }

    public String getSweetBrand() {
        return sweetBrand;
    }

    public void setSweetBrand(String sweetBrand) {
        this.sweetBrand = sweetBrand;
    }

    public int getSweetPrice() {
        return sweetPrice;
    }

    public void setSweetPrice(int sweetPrice) {
        this.sweetPrice = sweetPrice;
    }

    public int getSweetWeight() {
        return sweetWeight;
    }

    public void setSweetWeight(int sweetWeight) {
        this.sweetWeight = sweetWeight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
