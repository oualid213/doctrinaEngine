public class GameTime {
    private static final int SLEEP = 25;
    private Long before;

    public static long getCurrentTime(){
        return System.currentTimeMillis();
    }

    GameTime(){
        updateSyncTime();
    }



    public void sleep(){
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private long getSleepTime() {
        Long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep<4){
            sleep = 4L;
        }
        return sleep;
    }
    private void updateSyncTime(){
        before = System.currentTimeMillis();

    }

}
