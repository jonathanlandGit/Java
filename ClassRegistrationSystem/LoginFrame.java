
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/*
 * @ author Jonathan Land
 * 6/21/2017
 * 
 * This is the main login frame that oll other frames refer to, specifically
 * student, staff, and instructor. 
 * 
 */
public class LoginFrame 
{
	JFrame frame;
	private JTextField Username;
	private JPasswordField passwordField;
	private boolean succeeded;

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
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				}

				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		//frame to display login info and title
		frame = new JFrame("OurSystem Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		//user name label with specified height and width
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(70, 77, 75, 16);
		frame.getContentPane().add(lblNewLabel);

		//password label with specified height and width
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 131, 75, 16);
		frame.getContentPane().add(lblPassword);

		//username textfiled to hold entry of user data 
		//with specified height and width
		Username = new JTextField();
		Username.setBounds(151, 71, 154, 28);
		frame.getContentPane().add(Username);
		Username.setColumns(10);

		//button to capture action when clicked
		JButton btnLogin = new JButton("Login");
		
		//when the button is clicked three different frames are activated or in play
		//each with its own user name and password.
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String uname = Username.getText();
				String psd = passwordField.getText();
				
				//student user name and password 
				if (uname.equals("student") && psd.equals("1234")) 
				{
					JOptionPane.showMessageDialog(frame, "Welcome " + uname + ", you are successfully logged in.");
					StudentFrame studentframe = new StudentFrame();
					studentframe.setTitle("Student");
					studentframe.setVisible(true);
					studentframe.setLocationRelativeTo(null);
					succeeded = true;
					frame.dispose();
					
				//instructor user name and password
				} 
				
				else if (uname.equals("instructor") && psd.equals("1234")) 
				{
					JOptionPane.showMessageDialog(frame, "Welcome " + uname + ", you are successfully logged in.");
					InstructorFrame instructorframe = new InstructorFrame();
					instructorframe.setTitle("Instructor");
					instructorframe.setVisible(true);
					instructorframe.setLocationRelativeTo(null);
					succeeded = true;
					frame.dispose();
					
				//staff user name and password
				} 
				
				else if (uname.equals("staff") && psd.equals("1234")) 
				{
					JOptionPane.showMessageDialog(frame, "Welcome " + uname + ", you are successfully logged in.");
					StaffFrame staffframe = new StaffFrame();
					staffframe.setTitle("Staff");
					staffframe.setVisible(true);
					staffframe.setLocationRelativeTo(null);
					succeeded = true;
					frame.dispose();
				
				//if incorrect user name and password don't let user passed login screen
				} 
				
				else 
				{
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
					Username.setText("");
					passwordField.setText("");
					succeeded = false;
				}
			}

		});
		
		btnLogin.setBounds(78, 189, 117, 29);
		frame.getContentPane().add(btnLogin);

		//cancel button completely closes the system
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});

		btnCancel.setBounds(258, 189, 117, 29);
		frame.getContentPane().add(btnCancel);

		passwordField = new JPasswordField();
		passwordField.setBounds(151, 125, 154, 28);
		frame.getContentPane().add(passwordField);
	}
}
