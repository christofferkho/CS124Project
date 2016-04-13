/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.receiver;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Francisco
 */
//@Component classes will be compiled and run automatically if they are autowired
@Component
public class LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LoginUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldId = new javax.swing.JTextField();
        textFieldTerminal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldLocation = new javax.swing.JTextField();
        buttonLogin = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        out = new javax.swing.JTextArea();
        
        buttonLogin.setEnabled(true);
		buttonLogout.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Number:");

        textFieldId.setText("");

        textFieldTerminal.setEditable(false);
        textFieldTerminal.setText("24");

        jLabel3.setText("Terminal:");

        jLabel4.setText("Location:");

        textFieldLocation.setEditable(false);
        textFieldLocation.setText("CTC 101");
        textFieldLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLocationActionPerformed(evt);
            }
        });

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonLogout.setText("Logout");
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        out.setColumns(20);
        out.setRows(5);
        jScrollPane1.setViewportView(out);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogout)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldTerminal)
                            .addComponent(textFieldLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonLogin)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(textFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogout)
                    .addComponent(buttonLogin))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLocationActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
    	HashMap map;
    	try {
			String idNo = textFieldId.getText();
			thisId = idNo;
			String terminal = textFieldTerminal.getText();
			String location = textFieldLocation.getText();
			if (idNo.equals("") || terminal.equals("") || location.equals("")){
				out.setText("Please input an ID number.");
			}
			else{
				map = doCommand("/login", idNo, terminal, location, "", 1);
				String outputText = (String) map.get("message");
				timeIn = outputText;
				timeIn = timeIn.substring(0, timeIn.length() - 1);
				String errorText = outputText;
				errorText = errorText.substring(0, 14);
				if(!errorText.equals("access denied.")){
					out.setText("Logged in, " + outputText);
					buttonLogin.setEnabled(false);
					buttonLogout.setEnabled(true);
				}
				else{
					out.setText(outputText);
				}
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // TODO add your handling code here:
    	HashMap map;
    	try {
			map = doCommand("/logout", thisId, "", "", timeIn, 2);
			String outputText = (String) map.get("message");
			out.setText("Logged out, " + outputText);
			buttonLogin.setEnabled(true);
			buttonLogout.setEnabled(false);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_buttonLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea out;
    private javax.swing.JTextField textFieldId;
    private javax.swing.JTextField textFieldLocation;
    private javax.swing.JTextField textFieldTerminal;
    // End of variables declaration//GEN-END:variables
    
    //---------END OF NETBEANS CODE------------
    
    private String timeIn;
    private String thisId;
    
    private static HashMap doCommand(String action, String idNo, String terminal, String location, String timeIn, int state) throws Exception
	{
		String url1 = "http://localhost:8080/"+action;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		switch (state){
		case 1 :
			map.put(URLHandler.IDNO, idNo);
			map.put(URLHandler.TERMINAL, terminal);
			map.put(URLHandler.LOCATION, location);
			break;
		case 2 :
			map.put(URLHandler.IDNO, idNo);
			map.put(URLHandler.TIMEIN, timeIn);
			break;
		}
		
		
		// CONVERT JAVA DATA TO JSON
		ObjectMapper mapper = new ObjectMapper();
		String json1 = mapper.writeValueAsString(map);
		
		
		// SEND TO SERVICE
		String reply = NetUtil.postJsonDataToUrl(url1, json1);
		//System.out.println("REPLY = "+reply);
		
		try
		{
			// CONVERT REPLY JSON STRING TO A JAVA OBJECT 
			HashMap replyMap = (HashMap) mapper.readValue(reply, HashMap.class);
			return replyMap;	
		}
		catch(Exception e)
		{
			//System.out.println(reply);
			HashMap replyMap = new HashMap();
			replyMap.put("message", reply);
			return replyMap;	
			
		}
	}
    
    @PostConstruct
	public void tada()
	{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
	}
	
	@Override
	@Value("${app.name}")
	public void setTitle(String s)
	{
		super.setTitle(s);
	}
}
