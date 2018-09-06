package guiClient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	JPanel panelBtn;
	JPanel panelTeks;
	JButton btn;
	JTextField name;
	JTextField surname;
	
	
	public HelloFrame() {
		super("Hello frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,600);
		setLayout(new BorderLayout());
		panelBtn = new JPanel();
		panelTeks = new JPanel();
		btn = new JButton("generate report");
		name = new JTextField();
		surname = new JTextField();
		
		name.setMinimumSize(new Dimension(100, 20));
		surname.setMinimumSize(new Dimension(100, 20));
		
		panelBtn.add(btn);
		panelTeks.add(name);
		panelTeks.add(surname);
		add(panelBtn, BorderLayout.SOUTH);
		add(panelTeks, BorderLayout.CENTER);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("gnerate...");
					
				
				
			}
		});
		
		setVisible(true);
	}

}
