package app.receiver.observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import app.receiver.JsonUtil;
import app.receiver.Login;
import app.receiver.MainUI;
import app.receiver.observable.CreateTerminal;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Kiela Agustin
 * @author April Guevara
 */
public class Setup extends MainUI implements Observer {    
    public Setup() {
    	setLocationRelativeTo(null);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblIp = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblSetup = new java.awt.Label();
        lblTerminals = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        panelTitle = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        panel4 = new java.awt.Panel();
        txtPort = new javax.swing.JTextField();
        txtIp = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();      
        tableScroll = new javax.swing.JScrollPane();        
        // @added [May-08-16]
        model = new DefaultTableModel( null, columnNames );
        terminalList = new JTable( model );

        label3.setText("label3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(null);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 0, 40));
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblSetup.setBackground(new java.awt.Color(255, 255, 255));
        lblSetup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSetup.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        lblSetup.setText("Set-up");
        jPanel2.add(lblSetup, java.awt.BorderLayout.CENTER);
        lblSetup.getAccessibleContext().setAccessibleName("lblSetup");

        getContentPane().add(jPanel2);

        panelTitle.setBackground(new java.awt.Color(255, 255, 255));
        panelTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 20, 40));
        panelTitle.setMinimumSize(new java.awt.Dimension(440, 250));
        panelTitle.setLayout(new java.awt.GridBagLayout());

        lblIp.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblIp.setText("IP Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTitle.add(lblIp, gridBagConstraints);

        lblPort.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblPort.setText("Port No.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTitle.add(lblPort, gridBagConstraints);

        txtPort.setBackground(new java.awt.Color(228, 228, 228));
        txtPort.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        txtPort.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPort.setMaximumSize(null);
        txtPort.setMinimumSize(new java.awt.Dimension(90, 35));
        txtPort.setPreferredSize(new java.awt.Dimension(110, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTitle.add(txtPort, gridBagConstraints);

        txtIp.setBackground(new java.awt.Color(228, 228, 228));
        txtIp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        txtIp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtIp.setMaximumSize(null);
        txtIp.setMinimumSize(new java.awt.Dimension(175, 35));
        txtIp.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
        panelTitle.add(txtIp, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));

        btnConnect.setText(">");
        btnConnect.setMargin(new java.awt.Insets(10, 14, 10, 14));
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnConnect)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnConnect)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        panelTitle.add(jPanel4, gridBagConstraints);

        getContentPane().add(panelTitle);

        panel4.setMaximumSize(null);
        panel4.setMinimumSize(new java.awt.Dimension(450, 0));
        panel4.setName(""); // NOI18N
        panel4.setPreferredSize(new java.awt.Dimension(450, 150));

        lblTerminals.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblTerminals.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTerminals.setText("PC Terminals");
        lblTerminals.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));

        terminalList.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        terminalList.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        terminalList.setMaximumSize(new java.awt.Dimension(365, 120));
        terminalList.setMinimumSize(new java.awt.Dimension(53, 90));
        terminalList.setPreferredSize(new java.awt.Dimension(365, 120));
        terminalList.setSelectionBackground(new java.awt.Color(153, 153, 153));
        terminalList.setEnabled( false );        
        
        tableScroll.setViewportView(terminalList);
        tableScroll.setEnabled( false );        

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTerminals)
                .addGap(171, 171, 171))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(lblTerminals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 40, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(160, 95));
        jPanel3.setLayout(new java.awt.BorderLayout());

        btnContinue.setBackground(new java.awt.Color(255, 255, 255));
        btnContinue.setLabel("Continue");
        btnContinue.setMargin(new java.awt.Insets(2, 20, 2, 20));
        btnContinue.setMaximumSize(null);
        btnContinue.setMinimumSize(null);
        btnContinue.setPreferredSize(new java.awt.Dimension(87, 35));
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        btnContinue.setEnabled( false );
        jPanel3.add(btnContinue, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {
    	// store the IP and port in variables for the meantime
		String ip = txtIp.getText().trim();
		String port = txtPort.getText().trim();
		
		// check if the variables aren't empty
		// show an error message if empty
		if( ip.equals( "" ) || port.equals( "" ) ) {
			JOptionPane.showMessageDialog( this, "Please fill in all necessary fields.", "Not Enough Input", JOptionPane.INFORMATION_MESSAGE );
		}
		else {			
	    	HashMap map;
	    	try {
	    		setIPPORT(ip + ":" + port);
	    		// make the HashMap
	    		HashMap<String, Object> mapSend = new HashMap<String, Object>();
	    		
    			// "send" the HashMap
        		// note: it's OK if the HashMap is empty
    			map = doCommand( "/connect", mapSend );
    			String outputText = ( ( String ) map.get( "message" ) ).trim();
    			
    			// check if connected
    			if( outputText.equals( "1" ) ) {
    				CreateTerminal createTerminal = new CreateTerminal();
    				createTerminal.setVisible(true);
    				createTerminal.registerObserver(this);
    				getListJson(mapSend);
    				
    				// enable the disabled components
    				terminalList.setEnabled( true );
    				btnContinue.setEnabled( true );
    				tableScroll.setEnabled( true );
    			}
    			else {
    				// if it won't connect for some reason, output a message prompting the user to try again
    				JOptionPane.showMessageDialog( this, "Unable to connect. Please try another ip or port.", "Connection Notice", JOptionPane.INFORMATION_MESSAGE );
    			}
    		} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) { 
				e.printStackTrace();
			}
	    }
    }   

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {
    	if( terminalList.getSelectedRow() == -1 ) {
    		// no terminal is selected -> show error
    		JOptionPane.showMessageDialog( this, "Please select a terminal from the list.", "Empty Selection", JOptionPane.INFORMATION_MESSAGE );
    	}
    	else if( terminalList.getSelectedRowCount() > 1 ) {
    		// user selects more than one terminal -> show error
    		// if there is a way to limit row selection to just one, then switch to that one
    		// for the meantime, we have this error checking method
    		JOptionPane.showMessageDialog( this, "Please select only one terminal from the list.", "Selection Notice", JOptionPane.INFORMATION_MESSAGE );
    	}
    	else {
    		// get the id, terminal# and the room name
    		int id = ( Integer ) terminalList.getValueAt( terminalList.getSelectedRow(), 0 );
    		int terminalNo = ( Integer ) terminalList.getValueAt( terminalList.getSelectedRow(), 1 );
        	String roomName = ( String ) terminalList.getValueAt( terminalList.getSelectedRow(), 2 );
        	
        	// pass it to the constructor of the log-in screen
        	Login login = new Login( id, terminalNo, roomName );
        	// make it visible
        	login.setVisible( true );
        	// make this screen visible
        	this.setVisible( false );
    	}
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setup().setVisible(true);
            }
        });
    }

    // Variables declaration //GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnContinue;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane tableScroll;
    private java.awt.Label label3;
    private javax.swing.JLabel lblIp;
    private javax.swing.JLabel lblPort;
    private java.awt.Label lblSetup;
    private javax.swing.JLabel lblTerminals;
    private java.awt.Panel panel4;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtPort;
    // @added [May-08-16]
    private javax.swing.JTable terminalList;
    private javax.swing.table.DefaultTableModel model;
    private final String columnNames[] = { "ID", "Terminal No.", "Room Name" };
    // End of variables declaration //GEN-END:variables
    
	@Override
	public void update(HashMap result) {
		// TODO Auto-generated method stub
		getListJson(result);
	}
	
	private void getListJson(HashMap mapSend){
		HashMap map;
		try {
			map = doCommand( "/viewTerminals", mapSend );
			// get output text in JSON format
			String outputText = ( String ) map.get( "message" );    				
			// split the JSON string and store in an array
			String[] tList = outputText.split( "}," );   
			
			
			// fix the entries
			// because the split removed the "}" of each string
			for( int i = 0; i < tList.length; i++ ) {
				if( i == 0 ) {
					// for the first entry, remove the first character
					tList[i] = ( tList[i] ).substring( 1 );
				}
				else if( i == ( tList.length - 1 ) ){
					// for the last entry, remove the last 2 characters (I think)
					tList[i] = ( tList[i] ).substring( 0, ( tList[0] ).length() );
				}
				// add the bracket at the end
				tList[i] += "}";
			}
			
			// populate the JTable using populateTable()
			ArrayList<HashMap> maps = new ArrayList<HashMap>();
			JsonUtil JSONtransformer = new JsonUtil();    				
			for( String s : tList ) {
				maps.add( ( HashMap<String, Object> ) JSONtransformer.fromJsonToObject( s, HashMap.class ) );
			}    				
			populateTable( maps );
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void populateTable( ArrayList<HashMap> maps ) {
        model.setRowCount( maps.size() );
        for ( int row = 0; row < maps.size() ; row++ ) {
            model.setValueAt( ( maps.get( row ) ).get( "id" ), row, 0 );
        	model.setValueAt( ( maps.get( row ) ).get( "terminalNumber" ), row, 1 );
        	model.setValueAt( ( maps.get( row ) ).get( "roomName" ), row, 2 );
        }        
    }
}