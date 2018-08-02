package javaDemo.restructure.old;

/**
 * 影片
 *
 * @author vayi
 * @date 2018/7/30
 * @since 0.0.1
 */
public class Movie {

    public static final int regular = 0; //常规片
    public static final int new_release = 1; //新片
    public static final int childrens = 2; //儿童片

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        super();
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

}
