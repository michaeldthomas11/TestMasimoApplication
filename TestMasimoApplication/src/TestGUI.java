import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Color;


public class TestGUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8322544745829768011L;
	private JFrame frame;
	private JButton btnCalculate;
	private JScrollPane scrollPane;
	private JTextField textField_1;
	private JButton btnBrowse;
	private JFileChooser fc;
	private JTextArea label;
	private final JLabel label_1 = new JLabel("Value c:");
	private final JTextField textField_2 = new JTextField();
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JLabel lblValueN;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI window = new TestGUI();
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
	public TestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.NORTH);
		
		splitPane_1 = new JSplitPane();
		splitPane.setLeftComponent(splitPane_1);
		splitPane_1.setLeftComponent(label_1);
		textField_2.setMinimumSize(new Dimension(170, 20));
		splitPane_1.setRightComponent(textField_2);
		textField_2.setToolTipText("Type an integer.");
		textField_2.setText("0");
		
		splitPane_2 = new JSplitPane();
		splitPane.setRightComponent(splitPane_2);
		
		lblValueN = new JLabel("Value N:");
		splitPane_2.setLeftComponent(lblValueN);
		
		textField = new JTextField();
		textField.setToolTipText("Type an integer.");
		textField.setText("0");
		splitPane_2.setRightComponent(textField);
		
		//Create a file chooser
        fc = new JFileChooser();
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(this);
		frame.getContentPane().add(btnCalculate, BorderLayout.EAST);
		
		label = new JTextArea();
		label.setBackground(Color.LIGHT_GRAY);
		
		scrollPane = new JScrollPane(label);
		scrollPane.setPreferredSize(new Dimension(190, 190));
		frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);
		scrollPane.setViewportView(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(24);
		frame.getContentPane().add(textField_1, BorderLayout.WEST);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(this);
		frame.getContentPane().add(btnBrowse, BorderLayout.CENTER);
		frame.setResizable(false);
	}
	
	/**
	 * Listen for any actions performed on the frame.
	 */
	public void actionPerformed(ActionEvent e) {
		 
        //Handle open button action.
        if (e.getSource() == btnBrowse) {
        	int returnVal = fc.showOpenDialog(TestGUI.this);
        	if (returnVal == JFileChooser.APPROVE_OPTION) {
        		File currentFile = fc.getSelectedFile();
                textField_1.setText(currentFile.getAbsolutePath());
        	}
        } else if (e.getSource() == btnCalculate) {
            label.setText(MatrixCalculator.CalculateMatrix(textField.getText(), textField_2.getText(), textField_1.getText()));
        }
    }


}
