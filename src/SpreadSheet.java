import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SpreadSheet extends BaseUI {
    private Container con = getContentPane();
    

    private JTable table1 = new JTable(26,26);

    public SpreadSheet (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(new FlowLayout());

         add(table1);


    }

    public static void main(String [] args){
        SpreadSheet frame = new SpreadSheet();
        frame.setVisible(true);
    }

}
