package JavaCore.restructure.struct;


import JavaCore.restructure.struct.impl.ChildrensPrice;
import JavaCore.restructure.struct.impl.NewReleasePrice;
import JavaCore.restructure.struct.impl.RegularPrice;

/**
 * 影片
 *
 * @author vayi
 * @date 2018/7/30
 * @since 0.0.1
 */
public class MovieNew {

    public static final int childrens = 2;
    public static final int regular = 0;
    public static final int new_release = 1;

    private String title;
    private int priceCode;
    private Price price;

    public MovieNew(String title, int priceCode) {
        super();
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case regular:
                price = new RegularPrice();
                break;

            case childrens:
                price = new ChildrensPrice();
                break;

            case new_release:
                price = new NewReleasePrice();
                break;

            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    /**
     * 重构出来的部分
     *
     * @param dayRented
     * @return
     */
    public double getCharge(int dayRented) {
        return price.getCharge(dayRented);
    }

    public double getRrequentRenterPoints(int dayRented) {
        return price.getRrequentRenterPoints(dayRented);
    }
}
