package restructure;


import restructure.old.Customer;
import restructure.old.Movie;
import restructure.old.Rental;
import restructure.struct.CustomerNew;
import restructure.struct.MovieNew;
import restructure.struct.RentalNew;

/**
 * 测试类
 *
 * @author vayi
 * @date 2018/7/30
 * @since 0.0.1
 */
class test01 {

    public static void main(String[] args) {
        System.out.println("=========================重构前结果=========================");
        Movie mov = new Movie("xxx", 2);
        Rental ren = new Rental(mov, 8);
        Customer cus = new Customer("Cheng");
        cus.addRental(ren);

        System.out.println(cus.statement());
        System.out.println("=========================重构前结果=========================");

        System.out.println("=========================重构后结果=========================");
        MovieNew newMov = new MovieNew("xxx", 2);
        RentalNew newRen = new RentalNew(newMov, 8);
        CustomerNew cusNew = new CustomerNew("Cheng");
        cusNew.addRentalNew(newRen);

        System.out.println(cusNew.statement());
        System.out.println("=========================重构后结果=========================");
    }

}