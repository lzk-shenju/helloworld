package CTGU.1;
public class WaterHeaterTest {
    public static void main(String[] args) {
        WaterHeater waterHeater = new WaterHeater();

        // 模拟晚上11点整，进入休眠状态
        waterHeater.enterSleepMode();

        // 模拟早上7点整，退出休眠状态
        waterHeater.exitSleepMode();

        // 模拟水箱中有水
        waterHeater.turnOnWater();

        // 模拟温度低于20°
        waterHeater.currentTemperature = 19;

        // 模拟晚上11点整，再次进入休眠状态
        waterHeater.enterSleepMode();
    }
}
