import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.text.NumberFormat;

public class EventHandlers extends BaseUI {
    public EventHandlers(){
        super();

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
                                System.out.println(outputs1.length);

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
                    System.out.println(inputs1.length);

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
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Deleted");
            }
        });





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


    }


}
