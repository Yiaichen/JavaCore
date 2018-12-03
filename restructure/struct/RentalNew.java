package restructure.struct;

/**
 * 租赁
 *
 * @author vayi
 * @date 2018/7/30/030
 * @since 0.0.1
 */
public class RentalNew {
    MovieNew movieNew;
    private int dayRented;

    public RentalNew(MovieNew movieNew, int dayRented) {
        super();
        this.movieNew = movieNew;
        this.dayRented = dayRented;
    }

    public MovieNew getMovieNew() {
        return movieNew;
    }

    public int getDayRented() {
        return dayRented;
    }

    public double getCharge() {
        return movieNew.getCharge(dayRented);
    }

    public double getRrequentRenterPoints() {
        return movieNew.getRrequentRenterPoints(dayRented);
    }
}