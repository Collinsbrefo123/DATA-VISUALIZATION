public class Main{

public static void main(String []args) {
    final int WIDTH = 500;
    final int HEIGHT = 500;
    BaseUI frame = new BaseUI();
    frame.setBounds(850, 100, WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setTableSize();
}
}