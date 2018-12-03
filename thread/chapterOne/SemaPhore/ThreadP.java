package thread.chapterOne.SemaPhore;

public class ThreadP extends Thread {

    private RepastService service;

    public ThreadP(RepastService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
