import java.util.concurrent.TimeUnit;


public class GameTime {
    private static final int FPS_TARGET = 120;
    private static int currentFps;
    private static int fpsCount;
    private static long fpsTimeDelta;
    private static long gameStartTime;
    private Long syncTime;


    public static long getCurrentTime(){
        return System.currentTimeMillis();
    }

    GameTime(){
        updateSyncTime();
        gameStartTime = System.currentTimeMillis();
        fpsTimeDelta = 0 ;
        currentFps = 0;
    }

    public static long getCurrentFps(){
        return (currentFps > 0 ) ? currentFps : fpsCount;
    }
    public static long getElapseTime(){
        return System.currentTimeMillis()  - gameStartTime;
    }
    public static String getElapsedFormatTime(){
        long time = getElapseTime();
        long hours = TimeUnit.MILLISECONDS.toHours(time);

        time -= TimeUnit.HOURS.toMillis(hours);

        long minute = TimeUnit.MILLISECONDS.toMinutes(time);

        time -= TimeUnit.MINUTES.toMillis(minute);
        long second = TimeUnit.MILLISECONDS.toSeconds(time);

        return String.format("%02d:%02d:%02d", hours,minute,second);
    }


    public void synchronize(){
        update();
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        updateSyncTime();
    }
    private long getSleepTime() {
        long targetTime = 1000L / FPS_TARGET;


        Long sleep = targetTime - (System.currentTimeMillis() - syncTime);

        if (sleep<0){
            sleep = 4L;
        }
        return sleep;
    }

    private void update() {
        fpsCount++;
        long currentSecond = TimeUnit.MILLISECONDS.toSeconds(getElapseTime());

        if(fpsTimeDelta != currentSecond){
            currentFps = fpsCount;
            fpsCount = 0;
        }

        fpsTimeDelta = currentSecond;

    }

    private void updateSyncTime(){
        syncTime = System.currentTimeMillis();

    }

}
