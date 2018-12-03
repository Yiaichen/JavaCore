package restructure.struct.impl;


import restructure.struct.MovieNew;
import restructure.struct.Price;

/**
 * 描述
 *
 * @author vayi
 * @date 2018/8/1
 * @since 0.0.1
 */
public class ChildrensPrice extends Price {
    public int getPriceCode() {
        return MovieNew.childrens;
    }

    public double getCharge(int dayRented) {
        double result = 1.5;
        if (dayRented > 3) {
            result += (dayRented - 3) * 1.5;
        }
        return result;
    }
}