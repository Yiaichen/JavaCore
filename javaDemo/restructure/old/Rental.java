package javaDemo.restructure.old;

/**
 * 租赁
 *
 * @author vayi
 * @date 2018/7/30/030
 * @since 0.0.1
 */
public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        super();
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

}