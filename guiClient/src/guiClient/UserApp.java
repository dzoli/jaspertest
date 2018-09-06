package guiClient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;

public class UserApp {

	private JFrame frame;
	private JTextField name;
	private JTextField surname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserApp window = new UserApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		name = new JTextField();
		name.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(10, 54, 86, 20);
		frame.getContentPane().add(surname);
		surname.setColumns(10);
		
		JButton btnGenerate = new JButton("generate");
		btnGenerate.setBounds(10, 137, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		btnGenerate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("generate...");
				
				try {
					InputStream inputStream = UserApp.class.getResourceAsStream("../reports/report1.jrxml");
				
					JasperReport report = JasperCompileManager.compileReport(inputStream);
					JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanArrayDataSource(new User[] {new User(name.getText(), surname.getText())}));
					JasperViewer.viewReport(print,false);					
					
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
