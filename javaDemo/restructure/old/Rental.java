package javaDemo.restructure.old;

/**
 * 租赁
 *
 * @author vayi
 * @date 2018/7/30
 * @since 0.0.1
 */
public class Rental {

    private Movie movie; // 租的电影
    private int dayRented; // 租的时间

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