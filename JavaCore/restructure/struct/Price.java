package JavaCore.restructure.struct;

/**
 * 抽象出一个计算价格的Price
 *
 * @author vayi
 * @date 2018/8/1
 * @since 0.0.1
 */
public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int dayRented);

    public double getRrequentRenterPoints(int dayRented) {
        return 1;
    }
}