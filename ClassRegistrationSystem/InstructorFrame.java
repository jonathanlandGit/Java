
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JButton;

/**
 *@author Jonathan Land
 *6/21/2017
 * 
 * This class is a GUI for an Instructor. It includes buttons with actions for
 * printing course reports, showing how many Student's are enrolled, and a
 * cancel action.
 *
 */
public class InstructorFrame extends JFrame 
{	//two linked lists to hold data for frame and 
	//for retrieving data in staff and student frame
	private LinkedList<String> ll = new LinkedList<>();
	private LinkedList<String> ll1 = new LinkedList<>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					InstructorFrame  frame = new InstructorFrame();
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
	 * Constructor for InstructorFrame
	 */
	public InstructorFrame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// method to call in order to load the instructor list
		loadInstructorList();
		// method call to load the class list in the frame
		loadClassList();

		// button for printing courses
		JButton btn_printCourseReports = new JButton("Print Course Reports");
		btn_printCourseReports.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				{
					JFrame frame = new JFrame();
					frame.setSize(900, 400);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);

					// button for going to previous screen, not exiting the
					// program
					JButton btn_logout = new JButton("Previous");
					btn_logout.setBounds(360, 300, 100, 29);
					frame.getContentPane().add(btn_logout);

					// array to hold data for jtable later on
					Object[] columns = { "Course ID", "Course Name", "Course Time" };
					DefaultTableModel model = new DefaultTableModel(columns, 0);

					// do away with frame after clicked
					btn_logout.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							frame.dispose();
						}

					});

					String line;
					
					// loop through linked list and add rows with separators
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

					// create jtable to hold data inside frame
					JTable table = new JTable(model);

					// create a table model and set a Column Identifiers to this
					// model
					// model.setColumnIdentifiers(columns);

					// set the model to the table
					table.setModel(model);

					// Change A JTable Background Color, Font Size, Font Color,
					// Row
					// Height
					table.setBackground(Color.LIGHT_GRAY);
					table.setForeground(Color.black);
					Font font = new Font("", 1, 22);
					table.setFont(font);
					table.setRowHeight(30);

					// create JScrollPane
					JScrollPane pane = new JScrollPane(table);
					pane.setBounds(0, 0, 880, 200);

					frame.getContentPane().setLayout(null);

					frame.getContentPane().add(pane);

				}
			}
		});

		btn_printCourseReports.setBounds(34, 48, 175, 66);
		contentPane.add(btn_printCourseReports);

		// Student's enrolled button with bounds.
		JButton btn_studentsEnrolled = new JButton("Student's Enrolled");
		btn_studentsEnrolled.setBounds(238, 48, 175, 66);
		contentPane.add(btn_studentsEnrolled);

		btn_studentsEnrolled.addActionListener(new ActionListener() 
		{
			//retrives data from
			public void actionPerformed(ActionEvent e) 
			{
				{
					JFrame frame = new JFrame();
					frame.setSize(900, 400);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					//button to return to previous
					JButton btn_logout = new JButton("Previous");
					btn_logout.setBounds(360, 300, 100, 29);
					frame.getContentPane().add(btn_logout);
					//array to hold data contnet for colums in jtable
					Object[] columns = { "Course ID", "Students Enrolled" };
					DefaultTableModel model = new DefaultTableModel(columns, 0);

					btn_logout.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							frame.dispose();
						}

					});

					String line;
					try 
					{
						//we have to loop through the linked list 
						//and get the row with the proper spacing 
						for (int i = 0; i < ll1.size(); i++) 
						{
							model.addRow(ll1.get(i).split(","));
						}
					}
					//give error if can't be completed
					catch (Exception e1) 
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
					//create jtable to hold data
					JTable table = new JTable(model);

					// create a table model and set a Column Identifiers to this
					// model
					// model.setColumnIdentifiers(columns);

					// set the model to the table
					table.setModel(model);

					// modify jTable Background Color, Font Size, Font Color, Row, Height
					table.setBackground(Color.LIGHT_GRAY);
					table.setForeground(Color.black);
					Font font = new Font("", 1, 22);
					table.setFont(font);
					table.setRowHeight(30);

					// create JScrollPane
					JScrollPane pane = new JScrollPane(table);
					pane.setBounds(0, 0, 880, 200);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().add(pane);
				}
			}
		});

		//create jbutton to cancel the instructor frame 
		//this button does takes user to login screen
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setBounds(166, 187, 117, 29);
		contentPane.add(btn_cancel);

		btn_cancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LoginFrame login = new LoginFrame();
				login.frame.setVisible(true);
				dispose();
			}
		});
	}
	
	//method to read from text.txt file
	public void loadInstructorList() 
	{

		try {
			String line;
			BufferedReader reader;
			File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Text.txt");

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
	
	//method to read clases for instructor from instructor.txt file
	public void loadClassList() 
	{

		try 
		{
			String line;
			BufferedReader reader;
			File file = new File("C:\\Users\\samsng\\Desktop\\folder\\Instructor.txt");

			if (!file.exists()) 
			{
				return;
			}

			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) 
			{
				ll1.add(line);
			}
			reader.close();
		}

		catch (IOException e1) 
		{
			JOptionPane.showMessageDialog(null, "Error");
			e1.printStackTrace();
		}
	}

}
