package app.receiver;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDayChooser;
import java.awt.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class ReservationUI extends MainUI {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ReservationUI frame = new ReservationUI();
					//frame.setVisible(true);
					new ReservationUI().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservationUI() {
		setTitle("Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtStudentId = new JTextField();
		txtStudentId.setBackground(new Color(245, 245, 245));
		txtStudentId.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtStudentId.setBounds(34, 51, 215, 29);
		contentPane.add(txtStudentId);
		txtStudentId.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setBounds(10, 23, 265, 29);
		contentPane.add(lblStudentId);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(245, 245, 245));
		dateChooser.setBounds(34, 131, 215, 29);
		contentPane.add(dateChooser);
		
		
		/**
		 * For time:
		 * JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
			JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
			timeSpinner.setEditor(timeEditor);
			timeSpinner.setValue(new Date());
		 */
		
		List listTerminal = new List();
		listTerminal.setBackground(new Color(245, 245, 245));
		listTerminal.setBounds(34, 283, 215, 102);
		contentPane.add(listTerminal);
		
		startHour = new JSpinner();
		startHour.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		startHour.setModel(new SpinnerNumberModel(8, 8, 17, 1));
		startHour.setBounds(34, 201, 35, 20);
		contentPane.add(startHour);
		
		startMin = new JSpinner();
		startMin.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		startMin.setModel(new SpinnerNumberModel(0, 0, 59, 15));
		startMin.setBounds(85, 201, 35, 20);
		contentPane.add(startMin);
		
		JLabel lblDate = new JLabel("Date and Time");
		lblDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(10, 91, 265, 29);
		contentPane.add(lblDate);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartTime.setBounds(10, 171, 133, 29);
		contentPane.add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTime.setBounds(142, 171, 133, 29);
		contentPane.add(lblEndTime);
		
		endMin = new JSpinner();
		endMin.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		endMin.setBounds(214, 201, 35, 20);
		contentPane.add(endMin);
		
		endHour = new JSpinner();
		endHour.setModel(new SpinnerNumberModel(8, 8, 17, 1));
		endHour.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		endHour.setBounds(163, 201, 35, 20);
		contentPane.add(endHour);
		
		JLabel lblTerminal = new JLabel("Terminal");
		lblTerminal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminal.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTerminal.setBounds(10, 248, 265, 29);
		contentPane.add(lblTerminal);
		JButton btnReserve = new JButton("Reserve");
		btnReserve.setBackground(Color.WHITE);
		btnReserve.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnReserve.setBounds(69, 408, 158, 29);
		 btnReserve.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnReservePerformed(evt);
	            }
	        });
		contentPane.add(btnReserve);
	}
	private void btnReservePerformed(java.awt.event.ActionEvent evt) {
		String studentID = txtStudentId.getText().trim();
		String starthour = startHour.getValue().toString();
		String startmin = startMin.getValue().toString();
		String endmin = endMin.getValue().toString();
		String endhour = endMin.getValue().toString();
		String date = "";
		try{
			 date = dateChooser.getDate().toString(); 
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
				//((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

				//dateChooser.getDateFormatString();
		
		System.out.println(studentID);
		System.out.println(starthour);
		System.out.println(startmin);
		System.out.println(endmin);
		System.out.println(endhour);
		//System.out.println(date);
		
		HashMap map;
		if( studentID.equals( "" ) || starthour.equals( "" ) || startmin.equals( "" ) || 
				endmin.equals( "" ) || endhour.equals( "" ) || date.equals( "" )){
    		// if empty -> show error
    		JOptionPane.showMessageDialog( this, "Incomplete fields. Please fill up all fields nigger.", "Input Error", JOptionPane.INFORMATION_MESSAGE );
    	}
    	else {
    		
    	
    		try {
    			// make HashMap
    			HashMap<String, Object> mapSend = new HashMap<String, Object>();
    			
    			// put the necessary info in the HashMap
    			mapSend.put("date", date);
    			
    			
    			// "send" the HashMap
    			map = doCommand( "/Reservation", mapSend );
    			String outputText = ( ( String ) map.get( "message" ) );
    			
    			if( outputText.equals("-1") ) {

    				JOptionPane.showMessageDialog( this, 
    						"ERROR (OUTPUT TEXT = -1)", "ID Not Found", JOptionPane.ERROR_MESSAGE );
    			}
    			//else if( outputText.contains( "Database error Bean object must not be null" ) ) {}
    			else {

    			}
    		} catch (NumberFormatException e) {
    			e.printStackTrace();
    		} catch (Exception e) { 
    			e.printStackTrace();
    		}
    		
    	}
		
	}
	private JPanel contentPane;
	private JTextField txtStudentId;
	private JSpinner startHour;
	private JSpinner startMin;
	private JSpinner endMin; 
	private JSpinner endHour;
	private JDateChooser dateChooser;
	
}
