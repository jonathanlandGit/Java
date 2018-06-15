
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/*
 * @author Jonathan Land 
 * 6/21/2017
 * 
 * This is the student frame where classes are added, removed, updated and saved
 * in the system.
 * 
 *  The staff frame is closely linked with the student frame.
 *  When it is updated, the classes load to the student frame in order
 *  to be added.
 */

public class StudentFrame extends JFrame 
{
	private JPanel contentPane;
	private JTextField CourseName_search;
	private final Color INACTIVE_COLOUR = Color.LIGHT_GRAY;
	private final Color ACTIVE_COLOUR = Color.BLACK;
	private LinkedList<String> ll = new LinkedList<>();

	/**
	 * Start the application.
	 */
	public static void main(String[] args) 
	{	
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}

				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the StudentFrame.
	 */
	public StudentFrame() 
	{
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setName("Student");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//load the current student schedule from file
		loadStudentList();

		//view schedule button
		JButton btnViewSchedule = new JButton("View Schedule");
		btnViewSchedule.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				//when view schedule is chosen show other buttons previous and print schedule
				JFrame frame = new JFrame();
				frame.setSize(900, 400);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

				JButton btn_logout = new JButton("Previous");
				btn_logout.setBounds(360, 300, 100, 29);
				frame.getContentPane().add(btn_logout);
				
				JButton btn_printSchedule = new JButton("Print Schedule");
				btn_printSchedule.setBounds(335, 215, 150, 29);
				frame.getContentPane().add(btn_printSchedule);
				
				//when print schedule is clicked, the printschedule method is called
				//at the end of the code of this page
				btn_printSchedule.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						printSchedule();
					}

				});

				//when remove course is clicked, the course is deleted from frame
				JButton btnDeleteCourses = new JButton("Remove Course");
				btnDeleteCourses.setBounds(320, 260, 180, 29);
				frame.getContentPane().add(btnDeleteCourses);

				btn_logout.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						frame.dispose();
					}

				});

				//array to hold data
				Object[] columns = { "Course ID", "Course Name", "Course Time" };
				DefaultTableModel model = new DefaultTableModel(columns, 0);

				String line;
				BufferedReader reader;
				
				//we have to loop through the linked list and modify it correctly
				try 
				{
					for (int i = 0; i < ll.size(); i++)
					{	
						model.addRow(ll.get(i).split(","));
					}
				}

				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Error");
				}

				JTable table = new JTable(model);

				// create a table model and set a Column Identifiers to this
				// model
				// model.setColumnIdentifiers(columns);

				// set the model to the table
				table.setModel(model);

				table.setBackground(Color.LIGHT_GRAY);
				table.setForeground(Color.black);
				Font font = new Font("", 1, 22);
				table.setFont(font);
				table.setRowHeight(30);

				JScrollPane pane = new JScrollPane(table);
				pane.setBounds(0, 0, 880, 200);

				frame.getContentPane().setLayout(null);

				frame.getContentPane().add(pane);

				btnDeleteCourses.addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						int i = table.getSelectedRow();
						if (i >= 0) 
						{
							// remove a row from jtable
							String s = table.getModel().getValueAt(i, 0) + "," + table.getModel().getValueAt(i, 1) + "," + table.getModel().getValueAt(i, 2);
							
							model.removeRow(i);
							//also remove from Linked list
							ll.remove(s);
							saveStudentList();							
						} 
						
						else 
						{
							System.out.println("Delete Error");
						}
					}
				});
			}
		});
		btnViewSchedule.setBounds(239, 59, 175, 66);
		contentPane.add(btnViewSchedule);
		
		//when available courses button is clicked a few options open up
		//such as previous, add course, and search courses
		JButton btnAvailableCourses = new JButton("Available Courses");
		btnAvailableCourses.setBounds(32, 59, 175, 66);
		btnAvailableCourses.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frame = new JFrame();
				frame.setSize(900, 400);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				//get content on previous screen
				JButton btn_previous = new JButton("Previous");
				btn_previous.setBounds(340, 320, 180, 29);
				frame.getContentPane().add(btn_previous);

				btn_previous.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {

						frame.dispose();
					}

				});

				//add course button
				JButton btn_addCourse = new JButton("Add Course");
				btn_addCourse.setBounds(245, 250, 180, 29);
				frame.getContentPane().add(btn_addCourse);

				//course ID label
				JLabel lblCourseID = new JLabel("Course ID");
				lblCourseID.setBounds(290, 218, 72, 16);
				frame.getContentPane().add(lblCourseID);

				//course id textfiled in order to enter data
				CourseName_search = new JTextField("Enter Course ID");
				CourseName_search.setForeground(INACTIVE_COLOUR);
				CourseName_search.setBounds(360, 212, 150, 25);
				frame.getContentPane().add(CourseName_search);
				CourseName_search.setColumns(10);

				CourseName_search.addFocusListener(new FocusListener() 
				{
					public void focusGained(FocusEvent e) 
					{
						CourseName_search.setText("");
						CourseName_search.setForeground(ACTIVE_COLOUR);
					}

					public void focusLost(FocusEvent e) 
					{

					}
				});

				//button to search for courses
				JButton btn_searchCourses = new JButton("Search Courses");
				btn_searchCourses.setBounds(430, 250, 180, 29);
				frame.getContentPane().add(btn_searchCourses);

				btn_searchCourses.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{

						frame.dispose();
					}

				});
				
				//array to load needed column information
				Object[] columns = { "Course ID", "Course Name", "Time", "Seats Available" };
				DefaultTableModel model = new DefaultTableModel(columns, 0);

				String line;
				BufferedReader reader;
				try 
				{
					//read from text file while there is something to read
					File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Text.txt");
					reader = new BufferedReader(new FileReader(file));
					while ((line = reader.readLine()) != null) {
						model.addRow(line.split(","));
					}
					//close it
					reader.close();
				}
				
				//catch since opening file and may not be there
				catch (IOException e1) 
				{
					JOptionPane.showMessageDialog(null, "Error");
					e1.printStackTrace();
				}
				//create jtable
				JTable table = new JTable(model);

				// create a table model and set a Column Identifiers to this model
				// model.setColumnIdentifiers(columns);

				// set the model to the table
				table.setModel(model);

				// Change a JTable Background Color, Font Size, Font Color, Row, Height
				table.setBackground(Color.LIGHT_GRAY);
				table.setForeground(Color.black);
				Font font = new Font("", 1, 22);
				table.setFont(font);
				table.setRowHeight(30);
				
				btn_addCourse.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						try 
						{
							int position = 0;
							boolean found = false;
							String s = null;
							//add to an array of classes we're taking
							String value = CourseName_search.getText();
							for (int i = 0; i < table.getRowCount(); i++)
							{
								System.out.println("'"+ value + "'"+ "   "+ "'"+ table.getModel().getValueAt(i, 0)+"'");
								if (value.equals(table.getModel().getValueAt(i, 0)))
								{
									position = i;
									s = table.getModel().getValueAt(i, 0) + "," + table.getModel().getValueAt(i, 1) + "," + table.getModel().getValueAt(i, 2);
									found = true;
								}
							}
							
							if (!found)
							{
								JOptionPane.showMessageDialog(frame, "Course " + value + " not found in catalog");
								return;
							}
							
							ll.add(s);
							saveStudentList();								
						} 
						
						catch (Exception ex) 
						{
							ex.printStackTrace();
						}
					}

				});

				JScrollPane pane = new JScrollPane(table);
				pane.setBounds(0, 0, 880, 200);

				frame.getContentPane().setLayout(null);

				frame.getContentPane().add(pane);

			}
		});
		contentPane.add(btnAvailableCourses);

		JButton btnCancel = new JButton("Logout");
		btnCancel.setBounds(159, 198, 117, 29);
		contentPane.add(btnCancel);

		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LoginFrame login = new LoginFrame();
				login.frame.setVisible(true);
				dispose();
			}

		});
	}
	
	/*
	 * @param method to load student schedule
	 * Since array is altered,have save the file
	 */
	public void saveStudentList()
	{
		try
		   {
            //the file path
           File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Student.txt");

           //if the file not exist create one
           if(!file.exists())
           {
               file.createNewFile();
           }
           
           FileWriter fw = new FileWriter(file.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);
           
           //go thruogh linked list
           for (int i = 0; i < ll.size(); i++)
           {
               bw.write(ll.get(i) + "\n");
               
              
           }
           
           bw.close();
                     
           }
		
		catch(Exception ex)
		{
			ex.printStackTrace();
        }    
	
	}
	
	/*
	 * @param method to load student schedule
	 */
	public void loadStudentList()
	{
		
		try 
		{
			String line;
			BufferedReader reader;
			File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Student.txt");
			
			if (!file.exists())
			{
				return;
			}
			
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) 
			{
				
				ll.add(line);
			}
			reader.close();
		}

		catch (IOException e1) 
		{
			JOptionPane.showMessageDialog(null, "Error");
			e1.printStackTrace();
		}
	}
	
	/*
	 * @param method to print the schedule
	 */
	public void printSchedule()
	{
		System.out.println("Student Schedule");
		System.out.println("Course ID"+ "\t"+ "Course Name" + "\t" + "Time");

		for (int i = 0; i < ll.size(); i++)
		{
			String s= ll.get(i);
			String[] anArr = s.split(",");
			
			for (String a: anArr)
			{
				System.out.print(a + "\t");
			}
			
			System.out.print("\n");
		}
	}
}
