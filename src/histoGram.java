import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class histoGram extends JPanel {
    Random rand = new Random();

    public int[] values = {7000,4900,8760,6900,4500,7090,5000,6290,5000,6432,7500,7900};
    public String[] label = {"January","Febuary","March","April","May","June","July","Aug","sep","oct","Nov","Dec"};
    int start = 0;

    public static void main(String[] args) {

        JFrame myField = new JFrame();
        myField.setSize(1000, 800);
        myField.setVisible(true);
        myField.getContentPane().add(new histoGram());
        myField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public histoGram() {
        setBackground(new Color(248, 248, 255));
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setLayout(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D)g;

        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Arial", Font.PLAIN, 17);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(55), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);

        g.fillRect(100, 100, 2, 500);
        g.fillRect(100, 600, 800, 2);

        int t = 0;
        int s1 = 605;
        int s2 = 600;
        for(int a =0 ; a < 11; a++) {
            g.setFont(new Font("Arial", Font.PLAIN, 17));
            g.drawString(""+t, 30, s1);
            g.fillRect(100, s2, 800, 1);
            t += 1000;
            s1 -= 50;
            s2 -= 50;

        }
        start = 102;
        for(int a = 0; a < 11;a++) {
            float r = rand.nextFloat();
            float gg = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, gg, b);
            g.setColor(randomColor);
            int y1 = (int) (600-(values[a]/20));
            g.fillRect(start, y1, 70,600 - y1);
            g2.setFont(rotatedFont);
            g2.setColor(Color.black);
            g2.drawString(label[a],start+20,610);
            start+=70;
        }

    }


}
