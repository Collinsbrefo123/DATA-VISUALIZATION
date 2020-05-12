import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BaseUI extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private Container con;
    private int rowCount = 0;
    private JTable table1 = new JTable(50, 50);


    //toolbar
    private JToolBar toolBar = new JToolBar();
    //buttons on toolbar
    private ImageIcon pieIcon = new ImageIcon("piechart.png");
    private JButton button1 = new JButton(pieIcon);
    private ImageIcon barG = new ImageIcon("bar.png");
    private JButton button2 = new JButton(barG);
    private ImageIcon lineG = new ImageIcon("linegraph.png");
    private JButton button3 = new JButton(lineG);
    private ImageIcon histoIcon = new ImageIcon("histogram.png");
    private JButton button4 = new JButton(histoIcon);
    private ImageIcon doughIcon = new ImageIcon("doughnut.png");
    private JButton button5 = new JButton(doughIcon);

    //menu
    private JMenuBar mainBar = new JMenuBar();
    //menu items
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
    private JMenuItem barGraph = new JMenuItem("Bar Graph");
    private JMenuItem doughnutC = new JMenuItem("Doughnut Chart");
    private JMenuItem lineGraph = new JMenuItem("Line Graph ");
    private JMenuItem histogram = new JMenuItem("Histogram ");

    //Chart Windows
    JFrame pieFrame = new JFrame();
    JFrame barFrame = new JFrame();
    JFrame lineFrame = new JFrame();
    JFrame histoFrame = new JFrame();
    JFrame doughnutFrame = new JFrame();



    //Column sizes
    public void setTableSize() {
        TableColumn column = null;

        for (int i = 0; i < 49; i++) {
            column = table1.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(50);
            } else {
                column.setPreferredWidth(100);
            }
        }


    }


    //Constructor
    public BaseUI() {
        super("Data Visualization App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = getContentPane();
        setLayout(new BorderLayout());
        con.add(scrollPane);
        panel.add(toolBar);

        //toolbar layout
        add(toolBar, BorderLayout.NORTH);
        toolBar.add(button1);
        toolBar.addSeparator(new Dimension(10, 10));
        toolBar.add(button2);
        toolBar.addSeparator(new Dimension(10, 10));
        toolBar.add(button3);
        toolBar.addSeparator(new Dimension(10, 10));
        toolBar.add(button4);
        toolBar.addSeparator(new Dimension(0, 10));
        toolBar.add(button5);

        //add table
        panel.add(table1, BorderLayout.CENTER);


        //column letters
        table1.setValueAt("              A", 0, 1);
        table1.setValueAt("              B", 0, 2);
        table1.setValueAt("              C", 0, 3);
        table1.setValueAt("              D", 0, 4);
        table1.setValueAt("              E", 0, 5);
        table1.setValueAt("              F", 0, 6);
        table1.setValueAt("              G", 0, 7);
        table1.setValueAt("              H", 0, 8);
        table1.setValueAt("              I", 0, 9);
        table1.setValueAt("              J", 0, 10);
        table1.setValueAt("              K", 0, 11);
        table1.setValueAt("              L", 0, 12);
        table1.setValueAt("              M", 0, 13);
        table1.setValueAt("              N", 0, 14);
        table1.setValueAt("              O", 0, 15);
        table1.setValueAt("              P", 0, 16);
        table1.setValueAt("              Q", 0, 17);
        table1.setValueAt("              R", 0, 18);
        table1.setValueAt("              S", 0, 19);
        table1.setValueAt("              T", 0, 20);
        table1.setValueAt("              U", 0, 21);
        table1.setValueAt("              V", 0, 22);
        table1.setValueAt("              W", 0, 23);
        table1.setValueAt("              X", 0, 24);
        table1.setValueAt("              Y", 0, 25);
        table1.setValueAt("              Z", 0, 26);
        table1.setValueAt("              AA", 0, 27);
        table1.setValueAt("              AB", 0, 28);
        table1.setValueAt("              AC", 0, 29);
        table1.setValueAt("              AD", 0, 30);
        table1.setValueAt("              AE", 0, 31);
        table1.setValueAt("              AF", 0, 32);
        table1.setValueAt("              AG", 0, 33);
        table1.setValueAt("              AH", 0, 34);
        table1.setValueAt("              AI", 0, 35);
        table1.setValueAt("              AK", 0, 36);
        table1.setValueAt("              AK", 0, 37);
        table1.setValueAt("              AL", 0, 38);
        table1.setValueAt("              AM", 0, 39);
        table1.setValueAt("              AN", 0, 40);
        table1.setValueAt("              AO", 0, 41);
        table1.setValueAt("              AP", 0, 42);
        table1.setValueAt("              AQ", 0, 43);
        table1.setValueAt("              AR", 0, 44);
        table1.setValueAt("              AT", 0, 45);
        table1.setValueAt("              AU", 0, 46);
        table1.setValueAt("              AV", 0, 47);
        table1.setValueAt("              AW", 0, 48);
        table1.setValueAt("              AX", 0, 49);


        //row numbers
        for (int j = 0; j < 50; j++) {
            table1.setValueAt("    " + rowCount, j, 0);
            rowCount += 1;
            table1.setValueAt(" ", 0, 0);

        }

        //table selection modes
        table1.setRowSelectionAllowed(true);
        table1.setCellSelectionEnabled(true);
        table1.setColumnSelectionAllowed(true);

        //MENU BAR
        //add menu bar
        setJMenuBar(mainBar);
        file.setMnemonic('w');
        //add tabs
        //mainBar.add(home);
        mainBar.add(file);
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
        graph.add(barGraph);
        graph.add(histogram);


        //action listeners
        exit.addActionListener(this);
        open.addActionListener(this);
        newFile.addActionListener(this);
        saveAs.addActionListener(this);
        save.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        histogram.addActionListener(this);
        barGraph.addActionListener(this);
        pieChart.addActionListener(this);
        lineGraph.addActionListener(this);
        doughnutC.addActionListener(this);


        //remove background from buttons
        button1.setBorder(BorderFactory.createEmptyBorder());
        button1.setContentAreaFilled(false);
        button2.setBorder(BorderFactory.createEmptyBorder());
        button2.setContentAreaFilled(false);
        button3.setBorder(BorderFactory.createEmptyBorder());
        button3.setContentAreaFilled(false);
        button4.setBorder(BorderFactory.createEmptyBorder());
        button4.setContentAreaFilled(false);
        button5.setBorder(BorderFactory.createEmptyBorder());
        button5.setContentAreaFilled(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Container con = getContentPane();

        if (source == exit)
            System.exit(0);
        else if (source == newFile) {
            BaseUI frame2 = new BaseUI();
            frame2.setSize(500, 500);
            frame2.setVisible(true);
        }
            else if(source == button1 || source == pieChart){
                pieFrame.setSize(350,350);
                pieFrame.setTitle("Pie Chart");
                pieFrame.setVisible(true);

            }

        else if(source == button2 || source == barGraph){
            barFrame.setSize(350,350);
            barFrame.setTitle("Bar Graph");
            barFrame.setVisible(true);

        }
        else if(source == button3 || source == lineGraph){
            lineFrame.setSize(350,350);
            lineFrame.setTitle("Line Graph");
            lineFrame.setVisible(true);

        }
        else if(source == button4 || source == histogram){
            histoFrame.setSize(350,350);
            histoFrame.setTitle("Histogram");
            histoFrame.setVisible(true);

        }
        else if(source == button5 || source == doughnutC){
            histoFrame.setSize(350,350);
            histoFrame.setTitle("Doughnut Chart");
            histoFrame.setVisible(true);

        }







    }

}
