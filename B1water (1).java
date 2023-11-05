package CTGU.1;
import java.util.Timer;
import java.util.TimerTask;

enum WaterHeaterState {
    STANDBY,    // 待机状态
    HEATING,    // 烧水状态
    REPAIR,     // 维修状态
    SLEEP       // 休眠状态
}

public class WaterHeater {
    private WaterHeaterState currentState;
    private boolean isWaterAvailable;
    public int currentTemperature;

    public WaterHeater() {
        currentState = WaterHeaterState.STANDBY;
        isWaterAvailable = false;
        currentTemperature = 20; 
        startWaterHeater();
    }

    public void startWaterHeater() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                switch (currentState) {
                    case STANDBY:
                        if (currentTemperature < 20 && isWaterAvailable) {
                            System.out.println("从待机状态进入烧水状态");
                            currentState = WaterHeaterState.HEATING;
                        }
                        break;
                    case HEATING:
                        if (currentTemperature >= 100) {
                            System.out.println("水温达到100°，从烧水状态进入待机状态");
                            currentState = WaterHeaterState.STANDBY;
                        }
                        if (!isWaterAvailable) {
                            System.out.println("水箱无水，从烧水状态进入待机状态");
                            currentState = WaterHeaterState.STANDBY;
                        }
                        break;
                    case REPAIR:
                       
                        break;
                    case SLEEP:
                       
                        break;
                }
            }
        }, 0, 1000); 
    }

    public void turnOnWater() {
        isWaterAvailable = true;
        System.out.println("水箱中有水");
    }

    public void turnOffWater() {
        isWaterAvailable = false;
        System.out.println("水箱中无水");
    }

    public void repairWaterHeater() {
        currentState = WaterHeaterState.REPAIR;
        System.out.println("水箱需要维修");
    }

    public void enterSleepMode() {
        currentState = WaterHeaterState.SLEEP;
        System.out.println("进入休眠状态");
    }

    public void exitSleepMode() {
        currentState = WaterHeaterState.STANDBY;
        System.out.println("退出休眠状态");
    }

    public static void main(String[] args) {
        WaterHeater waterHeater = new WaterHeater();
    }
}
