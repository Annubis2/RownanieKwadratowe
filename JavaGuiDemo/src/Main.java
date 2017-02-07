import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class WindBuilder {

	private JFrame frame;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldDelta;
	private JTextField textFieldC;
	private JTextField textFieldX1;
	private JTextField textFieldX2;
	private JLabel lblX1;
	private JLabel lblX2;
	private JLabel lblTypDelty;
	private JLabel lblNewLabel;
	private JLabel lblRownaniePoz1;
	private JLabel lblRownaniePoz2;
	private JLabel lblDelta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindBuilder window = new WindBuilder();
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
	public WindBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(25, 56, 58, 53);
		frame.getContentPane().add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.setColumns(10);
		textFieldB.setBounds(131, 56, 47, 53);
		frame.getContentPane().add(textFieldB);
		
		JButton btnAdd = new JButton("OBLICZ R\u00D3WNANIE");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a, b, c ;
				float delta;
				float x1, x2;
				try {
					
					a = Integer.parseInt(textFieldA.getText()) ;
					b = Integer.parseInt(textFieldB.getText()) ;
					c = Integer.parseInt(textFieldC.getText()) ;
					
					delta= (b*b)-4*a*c ; 
							
					
						
						textFieldDelta.setText(Double.toString(delta) ) ;
					
				if (delta>0){
				
				lblDelta.setVisible(true);
				textFieldDelta.setVisible(true);
				lblTypDelty.setVisible(true);
				lblTypDelty.setText("Delta jest >0, równanie ma dwa rozwi¹zania:");
				
				x1= (float) ((-b - Math.sqrt(delta) ) / a*2);
				x2= (float) ((-b + Math.sqrt(delta) ) / a*2);
				
				lblX1.setVisible(true);
				lblX2.setVisible(true);
				textFieldX1.setVisible(true);
				textFieldX2.setVisible(true);
				
					textFieldX1.setText(Float.toString(x1));
					textFieldX2.setText(Float.toString(x2));
				}
					else {
						if (delta==0) {
					
					
					lblDelta.setVisible(true);
					textFieldDelta.setVisible(true);	
					lblX1.setVisible(true);
					textFieldX1.setVisible(true);
					lblTypDelty.setVisible(true);
					
					lblTypDelty.setText("Delta jest równa 0, równanie ma jedno rozwi¹zanie:");	
					
					x1=(float) ( -b / (2*a) );
					lblX1.setText("x0=");
					textFieldX1.setText(Float.toString(x1));
						}			
				
						else{
							lblTypDelty.setVisible(true);
							lblTypDelty.setText("Delta jest mniejsza od 0, brak rozwi¹zania w zbiorze liczb rzeczywistych!");	
							
						}
				}
						
				
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "wprowadŸ poprawn¹ wartoœæ");
					 
				}
				
			}
		});
		btnAdd.setBounds(25, 120, 245, 63);
		frame.getContentPane().add(btnAdd);
		
		textFieldDelta = new JTextField();
		textFieldDelta.setText(" ");
		textFieldDelta.setBounds(102, 194, 168, 58);
		textFieldDelta.setVisible(false);
		frame.getContentPane().add(textFieldDelta);
		textFieldDelta.setColumns(10);
		
		lblDelta = new JLabel("Delta:");
		lblDelta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDelta.setBounds(30, 209, 127, 25);
		lblDelta.setVisible(false);
		frame.getContentPane().add(lblDelta);
		
		textFieldC = new JTextField();
		textFieldC.setColumns(10);
		textFieldC.setBounds(226, 56, 47, 53);
		frame.getContentPane().add(textFieldC);
		
		textFieldX1 = new JTextField();
		textFieldX1.setText(" ");
		textFieldX1.setColumns(10);
		textFieldX1.setBounds(100, 311, 168, 58);
		textFieldX1.setVisible(false);
		frame.getContentPane().add(textFieldX1);
		
		textFieldX2 = new JTextField();
		textFieldX2.setText(" ");
		textFieldX2.setColumns(10);
		textFieldX2.setBounds(100, 381, 168, 58);
		textFieldX2.setVisible(false);
		frame.getContentPane().add(textFieldX2);
		
		lblX1 = new JLabel("x1:");
		lblX1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX1.setBounds(30, 326, 127, 25);
		lblX1.setVisible(false);
		frame.getContentPane().add(lblX1);
		
		lblX2 = new JLabel("x2:");
		lblX2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX2.setBounds(30, 396, 127, 25);
		lblX2.setVisible(false);
		frame.getContentPane().add(lblX2);
		
		lblTypDelty = new JLabel("TypDelty");
		lblTypDelty.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTypDelty.setAutoscrolls(true);
		lblTypDelty.setBounds(25, 259, 371, 41);
		lblTypDelty.setVisible(false);
		frame.getContentPane().add(lblTypDelty);
		
		lblNewLabel = new JLabel("Program oblicza r\u00F3wnanie kwadratowe\r\nax2+bx+c");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 334, 34);
		frame.getContentPane().add(lblNewLabel);
		
		lblRownaniePoz1 = new JLabel("x2  +");
		lblRownaniePoz1.setBounds(93, 75, 46, 14);
		frame.getContentPane().add(lblRownaniePoz1);
		
		lblRownaniePoz2 = new JLabel("x   +");
		lblRownaniePoz2.setBounds(187, 75, 46, 14);
		frame.getContentPane().add(lblRownaniePoz2);
	}
}
