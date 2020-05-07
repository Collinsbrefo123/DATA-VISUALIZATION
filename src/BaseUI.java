import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseUI extends JFrame implements ActionListener {

    //menu
    private JMenuBar mainBar = new JMenuBar();
    //menu list
    private JMenu file = new JMenu("File");
    private JMenu home = new JMenu("Home");
    private JMenu insert1 = new JMenu("Insert");
    private JMenu graph = new JMenu("Graph");
    private JMenu chart = new JMenu("Chart");

    //items under File
    private JMenuItem newFile = new JMenuItem("New");
    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem saveAs = new JMenuItem("Save As");
    private JMenuItem exit = new JMenuItem("Exit");

    //items under Insert
    private JMenuItem pieChart = new JMenuItem("Pie Chart");
    private JMenuItem doughnutC = new JMenuItem("Doughnut Chart");
    private JMenuItem lineGraph = new JMenuItem("Line Graph ");
    private JMenuItem histogram = new JMenuItem("Histogram ");



    public BaseUI() {
        super("Data Visualization App");
        setLayout(new FlowLayout());
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(mainBar); //add menu bar
        file.setMnemonic('w');
        //add tabs
        mainBar.add(file);
        mainBar.add(home);
        mainBar.add(insert1);

        //File Menu
        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(exit);

        //Insert Menu
        insert1.add(graph);
        graph.setIcon(new ImageIcon("yllw.jpg"));
        insert1.add(chart);
        chart.add(pieChart);
        chart.add(doughnutC);
        graph.add(lineGraph);
        graph.add(histogram);


        //action listeners
        exit.addActionListener(this);
        open.addActionListener(this);
        newFile.addActionListener(this);
        saveAs.addActionListener(this);
        save.addActionListener(this);




    }


    public static void main(String[] args) {
        BaseUI frame = new BaseUI();
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Container con = getContentPane();

        if (source == exit)
            System.exit(0);

    }
}
