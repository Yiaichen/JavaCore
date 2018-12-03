package thread.chapterOne.SemaPhore;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        RepastService repastService = new RepastService();
        ThreadP[] arrayP = new ThreadP[20];
        ThreadC[] arrayC = new ThreadC[20];

        for (int i = 0; i < 20; i++) {
            arrayP[i] = new ThreadP(repastService);
            arrayC[i] = new ThreadC(repastService);
        }

        Thread.sleep(2000);

        for (int i = 0; i < 20; i++) {
            arrayP[i].start();
            arrayC[i].start();
        }

    }

}
