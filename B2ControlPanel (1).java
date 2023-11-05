package CTGU.2;
import java.util.Random;

enum ControlPanelState {
    READING_INPUT,          // 读取键入字符状态
    VALIDATING_PASSWORD,    // 验证密码状态
    LOCKED,                 // 锁定状态
    SELECTING_FUNCTION      
}

public class ControlPanel {
    private ControlPanelState currentState;
    private int passwordAttempts;
    private StringBuilder enteredPassword;
    private long lockTimestamp;

    public ControlPanel() {
        currentState = ControlPanelState.READING_INPUT;
        passwordAttempts = 0;
        enteredPassword = new StringBuilder();
        lockTimestamp = 0; // 初始化 lockTimestamp
    }

    public void inputCharacter(char character) {
        System.out.println("Input: " + character);  // 输出输入的字符

        switch (currentState) {
            case READING_INPUT, VALIDATING_PASSWORD:
                enteredPassword.append(character);
                if (enteredPassword.length() == 4) {
                    currentState = ControlPanelState.VALIDATING_PASSWORD;
                }
                break;
            case LOCKED:
                // 锁定状态下不接受输入
                break;
            case SELECTING_FUNCTION:
                // 系统功能选择状态下不接受输入
                break;
        }
    }

    public void validatePassword(String correctPassword) {
        if (currentState == ControlPanelState.VALIDATING_PASSWORD) {
            if (enteredPassword.toString().equals(correctPassword)) {
                currentState = ControlPanelState.SELECTING_FUNCTION;
            } else {
                passwordAttempts++;
                if (passwordAttempts >= 3) {
                    currentState = ControlPanelState.LOCKED;
                    enteredPassword.setLength(0);
                    lockTimestamp = System.currentTimeMillis(); // 记录锁定时间
                }
            }
        }
    }

    public void unlockControlPanel() {
        if (currentState == ControlPanelState.LOCKED) {
            long currentTime = System.currentTimeMillis();
            long lockTime = currentTime - lockTimestamp;
            if (lockTime > 120000) {
                currentState = ControlPanelState.READING_INPUT;
                passwordAttempts = 0;
                enteredPassword.setLength(0);
                lockTimestamp = 0; // 重置 lockTimestamp
            }
        }
    }

    public void simulateInput() {
        Random random = new Random();
        char[] presetInput = new char[] {'1', '2', '3', '4'};

        for (char character : presetInput) {
            inputCharacter(character);

            try {
                // 休眠一段时间以模拟用户输入速度
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ControlPanelState getCurrentState() {
        return currentState;
    }
}
