

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;



public class lineGraph extends JPanel {

    public ArrayList<Double> values;


    // public float[] values = {7000,4900,8760,6900,4500,7090,5000,6290,5000,6432,7500,7900};
    public ArrayList<String> label;
    int x =0;
    int size =0;
    public static void main(String[] args) {

        JFrame myField = new JFrame();
        myField.setSize(1000, 800);
        myField.setVisible(true);
        myField.getContentPane().add(new lineGraph());
        myField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



    public lineGraph() {
        values = new ArrayList<Double>();
        label = new ArrayList<>();
//        values.add(3456.4);
//        values.add(1234.3);
//        values.add(3567.3);
//        label.add("feb");
//        label.add("jan");
//        label.add("mach");


        setBackground(new Color(248, 248, 255));
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setLayout(null);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);




        Graphics2D g2d = (Graphics2D)g;

        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Arial", Font.PLAIN, 25);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(55), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);



        int t = 0;
        int s1 = 605;
        int s2 = 600;
        for(int a =0 ; a < 11; a++) {
            g.setFont(new Font("Arial", Font.PLAIN, 15));
            g.drawString(""+t, 30, s1);
            g.fillRect(100, s2, 800, 1);
            t += 1000;
            s1 -= 50;
            s2 -= 50;

        }





        x = 150;
        size = 11;
        for(int a = 0; a <values.size()-1;a++) {
            Double y1 = (double) (600-(values.get(a) /20));
            Double y2 = (double) (600-(values.get(a + 1) /20));
            g.setColor(new Color(255, 160, 122));
            g2.setStroke(new BasicStroke(3));
            g2.draw(new Line2D.Double(x,y1, x+50, y2));
            g.fillOval(x-5, (int) (600-(values.get(a) /20) -5), 10, 10);


            g.setColor(Color.black);
            g2.setFont(rotatedFont);
            g2.drawString(label.get(a),x,610);

                g.setColor(new Color(255, 160, 122));
                g.fillOval((x-5)+50, (int) (600-(values.get(a + 1) /20) -5), 10, 10);

                g.setColor(Color.black);
                g2.drawString(label.get(a + 1),x+50,610);

            x += 50;
        }


    }
}
