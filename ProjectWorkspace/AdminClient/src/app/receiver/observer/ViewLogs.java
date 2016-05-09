
package app.receiver.observer;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.entity.AccessLog;
import app.receiver.MainUI;
import app.receiver.observable.AccessLogListener;
import app.receiver.observable.Subject;

public class ViewLogs extends MainUI implements Observer {

    public ViewLogs() {
        initComponents();
        listener = new AccessLogListener();
        listener.setIPPORT(IPPORT);
        listener.registerObserver(this);
        listener.run();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        idCheckBox = new javax.swing.JCheckBox();
        txtIdSearch = new javax.swing.JTextField();
        terminalCheckBox = new javax.swing.JCheckBox();
        txtTerminalSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View Logs");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel2.setEnabled(false);

        idCheckBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        idCheckBox.setText("ID Number");
        idCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCheckBoxActionPerformed(evt);
            }
        });

        txtIdSearch.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        terminalCheckBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        terminalCheckBox.setText("Terminal");
        terminalCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminalCheckBoxActionPerformed(evt);
            }
        });

        txtTerminalSearch.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCheckBox))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(terminalCheckBox)
                    .addComponent(txtTerminalSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCheckBox)
                    .addComponent(terminalCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTerminalSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "ID", "TimeIn", "TimeOut", "Student", "Terminal"
                }
            ));
        jTable1.setPreferredSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void terminalCheckBoxActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		display();
	}

	protected void idCheckBoxActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		display();
	}

	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox idCheckBox;
    private javax.swing.JCheckBox terminalCheckBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtTerminalSearch;
    private javax.swing.JTextField txtIdSearch;
    // End of variables declaration//GEN-END:variables
    
    private AccessLogListener listener;
    private ArrayList<AccessLog> accessLogs = new ArrayList<AccessLog>();
    private ObjectMapper om = new ObjectMapper();
    
	@Override
	public void update(HashMap result) {
		// TODO Auto-generated method stub
		if(result != null){
			String reply = (String) result.get("message");
			try {
				accessLogs = om.readValue(reply, new TypeReference<ArrayList<AccessLog>>(){});
				display();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void display(){
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setRowCount(0);
		for(AccessLog accessLog: accessLogs){
			String id = accessLog.getId().toString();
			String timeIn = accessLog.getTimeIn().toString();
			String timeOut = "";
			if(accessLog.getTimeOut() != null){
				timeOut = accessLog.getTimeOut().toString();
			}
			String student = Integer.toString(accessLog.getStudent().getIdNo());
			String terminal = accessLog.getTerminal().getRoomName() 
					+ ":" + accessLog.getTerminal().getTerminalNumber();
			if((idCheckBox.isSelected()&& student.contains(txtIdSearch.getText().trim()))
					&& (terminalCheckBox.isSelected() 
							&& terminal.contains(txtTerminalSearch.getText().trim()))){
				model.addRow(new Object[]{id, timeIn, timeOut, student, terminal});
			}
			else if(((idCheckBox.isSelected()&& student.contains(txtIdSearch.getText().trim())) 
					|| (terminalCheckBox.isSelected() && terminal.contains(txtTerminalSearch.getText().trim())))
					&& !(terminalCheckBox.isSelected() && idCheckBox.isSelected() )
					){
				model.addRow(new Object[]{id, timeIn, timeOut, student, terminal});
			}
			else if(!terminalCheckBox.isSelected() && !idCheckBox.isSelected() ){
				model.addRow(new Object[]{id, timeIn, timeOut, student, terminal});
			}
			
			
		}
	}

    //END OF NETBEANS CODE
}
