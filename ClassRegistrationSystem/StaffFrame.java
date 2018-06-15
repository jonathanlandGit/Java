import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Jonathan Land 
 * 6/20/2017
 * 
 * This class is a JFrame for the staff user.
 *
 */

public class StaffFrame extends JFrame 
{
	/**
	 * The constructor for the StaffFrame that uses a table model. 
	 */
	public StaffFrame() 
	{
		//set columns in jtable with the following content to keep track of data
		Object[] columns = { "Course Id", "Course Name", "Course Time", "Capacity" };
		DefaultTableModel model = new DefaultTableModel(columns, 0);

		String line;
		/*
		 * create buffered reader and file in order to write to file
		 * and then read file back to table
		 */
		BufferedReader reader;
		
		try 
		{
			File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Text.txt");
			reader = new BufferedReader(new FileReader(file));
			/*
			 * keep on reading the file while there is somethng to read
			 * parse the line correctly due to formatting issues in 
			 * printing table to text file
			 */
			while ((line = reader.readLine()) != null) 
			{
				model.addRow(line.split(","));
			}
			//close the reader
			reader.close();
		} 
		
		//if there's a problem with the file or reading the file
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
		
		/*
		 * Create Jtable in order to hold course registration data
		 */
		JTable table = new JTable(model);

		// create a table model and set a Column Identifiers to this model
		//model.setColumnIdentifiers(columns);
	
		// set the model to the table
		table.setModel(model);

		// Change A JTable Background Color, Font Size, Font Color, Row Height
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setRowHeight(30);

        // create JTextFields
        JTextField courseId = new JTextField();        
        JTextField courseName = new JTextField();
        JTextField courseTime = new JTextField();
        JTextField seatsAvailable = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
        courseId.setBounds(114, 212, 150, 25);
        courseName.setBounds(114, 249, 150, 25);
        courseTime.setBounds(114, 286, 150, 25);
        seatsAvailable.setBounds(114, 321, 150, 25);
        
        btnAdd.setBounds(294, 218, 100, 25);
        btnUpdate.setBounds(294, 249, 100, 25);
        btnDelete.setBounds(294, 274, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        getContentPane().setLayout(null);
        
        getContentPane().add(pane);
        
        // add JTextFields to the jframe
        getContentPane().add(courseId);
        getContentPane().add(courseName);
        getContentPane().add(courseTime);
        getContentPane().add(seatsAvailable);
    
        // add JButtons to the jframe
        getContentPane().add(btnAdd);
        getContentPane().add(btnDelete);
        getContentPane().add(btnUpdate);
        
        //add neeeded jlabels to the frame
        JLabel lblCourseId = new JLabel("Course ID");
        lblCourseId.setBounds(22, 218, 72, 16);
        getContentPane().add(lblCourseId);
        
        JLabel lblNewLabel = new JLabel("Course Name");
        lblNewLabel.setBounds(22, 255, 84, 16);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Course Time");
        lblNewLabel_1.setBounds(22, 289, 84, 16);
       getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Capacity");
        lblNewLabel_2.setBounds(22, 326, 100, 16);
       getContentPane().add(lblNewLabel_2);
       
       JButton btnNewButton = new JButton("Save");
       
       //when save button is clicked, this content goes to text file
       //to be read and written to 
       btnNewButton.addActionListener(new ActionListener() 
       {	
    	   public void actionPerformed(ActionEvent e) 
    	   {
    		   try
    		   {
                   //the file path
                  File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Text.txt");

                  //if the file not exist create one
                  if(!file.exists())
                  {
                      file.createNewFile();
                  }
                  
                  FileWriter fw = new FileWriter(file.getAbsoluteFile());
                  BufferedWriter bw = new BufferedWriter(fw);
                  
                  //loop for jtable rows
                  for(int i = 0; i < table.getRowCount(); i++)
                  {
                      //loop for jtable column
                      for(int j = 0; j < table.getColumnCount(); j++)
                      {
                          bw.write(table.getModel().getValueAt(i, j) + "");
                          
                          if (j < table.getColumnCount()-1)
                          {
                        	  bw.write(",");  
                          }
                      }
                      //break line at the begin 
                      //break line at the end 
                      bw.write("\n");
                  }
                  //close BufferedWriter
                  bw.close();
                  //close FileWriter 
                  fw.close();
                  JOptionPane.showMessageDialog(null, "Data Exported");
                  
                  //we have to have another text file for instructor, since they 
                  //access data differently than student
                  File file1 = new File("C:\\Users\\samsng\\Desktop\\folder\\Instructor.txt");
                  
                  //if the file not exist create one
                  if(!file1.exists())
                  {
                      file1.createNewFile();
                  }
                  
                  FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
                  BufferedWriter bw1 = new BufferedWriter(fw1);
                  
                  //loop for jtable rows in order to return the value when method
                  //is called
                  for(int i = 0; i < table.getRowCount(); i++)
                  {
                     bw1.write(table.getModel().getValueAt(i, 0)+ "," + (i+7));
                     
                      bw1.write("\n");
                  }
                  //close BufferedWriter
                  bw1.close();
                  //close FileWriter 
                  fw1.close();
                  }
    		   
    		   		catch(Exception ex)
    		   		{
                      ex.printStackTrace();
    		   		}	    
       		}
       });
       
       btnNewButton.setBounds(294, 298, 100, 25);
       getContentPane().add(btnNewButton);
       
       //need button to return to main menu for other options
       JButton btnSave = new JButton("Logout");
       btnSave.setBounds(294, 321, 100, 29);
       getContentPane().add(btnSave);
		
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	//in this case, logout take user back to login frame
				 LoginFrame login = new LoginFrame();
		            login.frame.setVisible(true);
				
	                dispose();
	            }
		});
        
        // create an array of objects to set the row data
        Object[] row = new Object[4];
        
        // button add row
        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
             
                row[0] = courseId.getText();
                row[1] = courseName.getText();
                row[2] = courseTime.getText();
                row[3] = seatsAvailable.getText();
                
                // add row to the model
                model.addRow(row);
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                
                else
                {
                    System.out.println("Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter()
        {
        
        @Override
        public void mouseClicked(MouseEvent e)
        {
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            courseId.setText(model.getValueAt(i, 0).toString());
            courseName.setText(model.getValueAt(i, 1).toString());
            courseTime.setText(model.getValueAt(i, 2).toString());
            seatsAvailable.setText(model.getValueAt(i, 3).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(courseId.getText(), i, 0);
                   model.setValueAt(courseName.getText(), i, 1);
                   model.setValueAt(courseTime.getText(), i, 2);
                   model.setValueAt(seatsAvailable.getText(), i, 3);
                }
                
                else
                {
                    System.out.println("Update Error");
                }
            }
        });
        
        setSize(900,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}