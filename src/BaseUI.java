import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JList.*;

public class BaseUI extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private Container con;
    private int rowCount = 1;
    private JTable table1 = new JTable(50, 50);
    JTableHeader header = table1.getTableHeader();
    private Color myColor = new Color(0,84,161);

    private TableModel model = new DefaultTableModel(50,1)
    {
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
    private JTable table2 = new JTable(model);

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
    private JMenuItem Retrieve = new JMenuItem("Retrieve");
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




    //Constructor
    public BaseUI() {
        super("Data Visualization App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = getContentPane();
        setLayout(new BorderLayout());
        con.add(scrollPane);
        panel.add(toolBar);

        //toolbar layout and look
        add(toolBar, BorderLayout.NORTH);
        toolBar.setBackground(myColor);
        toolBar.setFloatable(false);
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
        panel.setLayout(new BorderLayout());
        panel.add(header, BorderLayout.NORTH);
        header.setBackground(myColor);
        panel.add(table2, BorderLayout.WEST);
        table2.setBackground(myColor);
        panel.add(table1, BorderLayout.CENTER);
        table1.setForeground(myColor);
        table1.setSelectionBackground(myColor);



         //column header
        table1.getColumnModel().getColumn(0).setHeaderValue(" ");
        table1.getColumnModel().getColumn(1).setHeaderValue(" A");
        table1.getColumnModel().getColumn(2).setHeaderValue(" B");
        table1.getColumnModel().getColumn(3).setHeaderValue(" C");
        table1.getColumnModel().getColumn(4).setHeaderValue(" D");
        table1.getColumnModel().getColumn(5).setHeaderValue(" E");
        table1.getColumnModel().getColumn(6).setHeaderValue(" F");
        table1.getColumnModel().getColumn(7).setHeaderValue(" G");
        table1.getColumnModel().getColumn(8).setHeaderValue(" H");
        table1.getColumnModel().getColumn(9).setHeaderValue(" I");
        table1.getColumnModel().getColumn(10).setHeaderValue(" J");
        table1.getColumnModel().getColumn(11).setHeaderValue(" K");
        table1.getColumnModel().getColumn(12).setHeaderValue(" L");
        table1.getColumnModel().getColumn(13).setHeaderValue(" M");
        table1.getColumnModel().getColumn(14).setHeaderValue(" N");
        table1.getColumnModel().getColumn(15).setHeaderValue(" O");
        table1.getColumnModel().getColumn(16).setHeaderValue(" P");
        table1.getColumnModel().getColumn(17).setHeaderValue(" Q");
        table1.getColumnModel().getColumn(18).setHeaderValue(" R");
        table1.getColumnModel().getColumn(19).setHeaderValue(" S");
        table1.getColumnModel().getColumn(20).setHeaderValue(" T");
        table1.getColumnModel().getColumn(21).setHeaderValue(" U");
        table1.getColumnModel().getColumn(22).setHeaderValue(" V");
        table1.getColumnModel().getColumn(23).setHeaderValue(" W");
        table1.getColumnModel().getColumn(24).setHeaderValue(" X");
        table1.getColumnModel().getColumn(25).setHeaderValue(" Y");
        table1.getColumnModel().getColumn(26).setHeaderValue(" Z");
        table1.getColumnModel().getColumn(27).setHeaderValue(" AA");
        table1.getColumnModel().getColumn(28).setHeaderValue(" AB");
        table1.getColumnModel().getColumn(29).setHeaderValue(" AC");
        table1.getColumnModel().getColumn(30).setHeaderValue(" AD");
        table1.getColumnModel().getColumn(31).setHeaderValue(" AE");
        table1.getColumnModel().getColumn(32).setHeaderValue(" AF");
        table1.getColumnModel().getColumn(33).setHeaderValue(" AG");
        table1.getColumnModel().getColumn(34).setHeaderValue(" AH");
        table1.getColumnModel().getColumn(35).setHeaderValue(" AI");
        table1.getColumnModel().getColumn(36).setHeaderValue(" AJ");
        table1.getColumnModel().getColumn(37).setHeaderValue(" AK");
        table1.getColumnModel().getColumn(38).setHeaderValue(" AL");
        table1.getColumnModel().getColumn(39).setHeaderValue(" AM");
        table1.getColumnModel().getColumn(40).setHeaderValue(" AO");
        table1.getColumnModel().getColumn(41).setHeaderValue(" AP");
        table1.getColumnModel().getColumn(42).setHeaderValue(" AQ");
        table1.getColumnModel().getColumn(43).setHeaderValue(" AR");
        table1.getColumnModel().getColumn(44).setHeaderValue(" AS");
        table1.getColumnModel().getColumn(45).setHeaderValue(" AT");
        table1.getColumnModel().getColumn(46).setHeaderValue(" AU");
        table1.getColumnModel().getColumn(47).setHeaderValue(" AV");
        table1.getColumnModel().getColumn(48).setHeaderValue(" AW");
        table1.getColumnModel().getColumn(49).setHeaderValue(" AX");


        //row header
        for (int j = 0; j < 50; j++) {
            table2.setValueAt("       " + rowCount, j, 0);
            rowCount += 1;

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
        file.add(Retrieve);
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



        //declaring of variables holding values to be stored into database
        String[][] inputs1 = new String[2][2];
        // String[][] inputs2 = new String[2][2];
        String[][] outputs1 = new String[2][2];
        String[][] outputs2 = new String[2][2];

        String url = "jdbc:mysql://localhost:3306/java_group";
        String uname= "root";
        String pword = "";
        String user[] = new String[2];
        //action listeners
        //save listeners
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{


                    if(user[0]==null) {

                        // INSERTING INTO DATABASE
                        outer:
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 2; j++) {
                                inputs1[i][j] = (String) table1.getModel().getValueAt(i , j );
                                inputs1[i][j + 1] = (String) table1.getModel().getValueAt(i , j + 1);
                                System.out.println( inputs1[i][j] +":"+inputs1[i][j + 1]);

                                if (inputs1[i][j] == null || inputs1[i][j + 1] == null) {


                                    JOptionPane.showMessageDialog(table1, "The input is null");
                                    break outer;
                                } else {
                                    System.out.println(inputs1[i][j]);
                                    System.out.println(inputs1[i][j + 1]);
                                    user[i] = JOptionPane.showInputDialog(null, "Input your name");
                                    String query = "insert into user_input(f_input,s_input,user) values(?,?,?)";
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection(url, uname, pword);
                                    PreparedStatement st = con.prepareStatement(query);
                                    st.setString(1, inputs1[i][j]);
                                    st.setString(2, inputs1[i][j + 1]);
                                    st.setString(3, user[i]);
                                    int count = st.executeUpdate();


                                    st.close();
                                    con.close();
                                }
                                break;

                            }
                            if (i > 0) {
                                JOptionPane.showMessageDialog(table1, "The Input is saved");

                            }

                        }
                        for (int i = 0; i < inputs1.length; i++) {
                            System.out.println(user[i]);
                            for (int j = 0; j < inputs1.length; i++) {
                                System.out.println(inputs1[i][j] + " : " + inputs1[i][j + 1]);


                                break;
                            }
                        }
                        String newuser = user[0];

                        //Retrieving the data from the database
                        for (int i = 0; i < 2; i++) {
                            String query = "select * from user_input where user=('" + newuser + "')";
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(url, uname, pword);
                            Statement st = con.createStatement();

                            ResultSet rs = st.executeQuery(query);

                            for (int j = 0; i < 2; i++) {
                                first:
                                while (rs.next()) {
                                    outputs1[i][j] = rs.getString("f_input");
                                    outputs1[i][j + 1] = rs.getString("s_input");

                                    break first;
                                }

                            }


                        }


                        for (int i = 0; i < outputs1.length; i++) {
                            System.out.println(user[i]);
                            for (int j = 0; j < outputs1.length; i++) {
                                System.out.println(outputs1[i][j] + " : " + outputs1[i][j + 1]);


                                break;
                            }
                        }

                    }else{
                        for(int i=0;i<outputs2.length;i++) {

                            for(int j=0;j<outputs2.length;j++) {
                                String name = user[0];
                                System.out.println(name);
                                String query = "UPDATE user_input set f_input='?', s_input='?' WHERE user ='?'";
                                Class.forName("com.mysql.jdbc.Driver");

                                Connection con = DriverManager.getConnection(url, uname, pword);


                                PreparedStatement st = con.prepareStatement(query);
                                st.setString(1,  outputs2[i][j]);
                                st.setString(2, outputs2[i][j]);
                                st.setString(3, name);
                                int count = st.executeUpdate();
                            }

                        }
                    }

                }catch (Exception a){
                    a.printStackTrace();
                    System.out.println("Error in values insertion");


                }



            }
        });

        Retrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = JOptionPane.showInputDialog(null,"Enter your username");
                    for(int i=0;i<2;i++){
                        String query= "select * from user_input where user=('"+ name +"')";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url,uname,pword);
                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(query);


                        for(int j=0;i<2;i++){
                            first: while (rs.next()){
                                outputs2[i][j]= rs.getString("f_input");
                                outputs2[i][j+1]= rs.getString("s_input");

                                table1.setValueAt(outputs2[i][j],i,j);
                                table1.setValueAt(outputs2[i][j+1],i,j+1);

                                break first;


                            }

                        }

//                        for(int j=0;j<2;j++){
//
//
////                            table1.setValueAt(outputs1[i][j],i+1,j+1);
////                            table1.setValueAt(outputs1[i][j+1],i+1,j+2);
//
//
//                            break;
//                        }
                        st.close();
                        con.close();

                    }


                    user[0]=name;

                }catch (Exception a){
                    a.printStackTrace();
                    System.out.println("Error in values insertion");

                }
            }
        });
        exit.addActionListener(this);
        open.addActionListener(this);
        newFile.addActionListener(this);
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


        //tool tips
        button1.setToolTipText("Pie Chart");
        button2.setToolTipText("Bar Graph");
        button3.setToolTipText("Line Graph");
        button4.setToolTipText("Histogram");
        button5.setToolTipText("Doughnut Chart");

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
