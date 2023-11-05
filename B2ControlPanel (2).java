package CTGU.2;
public class ControlPanelTest {
    public static void main(String[] args) {
        ControlPanel controlPanel = new ControlPanel();

        // 模拟用户输入密码
        controlPanel.simulateInput();

        // 获取并输出当前状态
        ControlPanelState currentState = controlPanel.getCurrentState();
        System.out.println("Current State: " + currentState);

        // 模拟验证密码
        controlPanel.validatePassword("1234");

        // 获取并输出当前状态
        currentState = controlPanel.getCurrentState();
        System.out.println("Current State: " + currentState);

        // 模拟锁定状态
        char[] presetIncorrectInput = {'5', '6', '7', '8', '9', '8', '7', '6', '5', '4', '3', '2'};

        for (char character : presetIncorrectInput) {
            controlPanel.inputCharacter(character);
        }

        // 获取并输出当前状态
        currentState = controlPanel.getCurrentState();
        System.out.println("Current State: " + currentState);

        // 模拟解锁状态
        controlPanel.unlockControlPanel();

        // 获取并输出当前状态
        currentState = controlPanel.getCurrentState();
        System.out.println("Current State: " + currentState);
    }
}
