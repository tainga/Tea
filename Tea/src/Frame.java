import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Leaves tea;
	private JLabel btnLbl;
	private JButton btn;
	private Color winter = new Color(246,246,246);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		
		ImageIcon icon = new ImageIcon(getClass().getResource("teacup.png"));
		setIconImage(icon.getImage());
		Font topFont = new Font("Candara", Font.PLAIN, 14);
		Font btnFont = new Font("Candara", Font.BOLD, 14);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 180);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(winter);
		
		JLabel lbl = new JLabel("Would you like a cup of tea?");
		lbl.setFont(topFont);
		contentPane.add(lbl, BorderLayout.NORTH);
	
		JPanel centerPanel = new JPanel();
		
		btn = new JButton();
		btnLbl = new JLabel("<html><div style='text-align: center;'>Start</div></html>");
		btnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		btnLbl.setFont(btnFont);
		btn.add(btnLbl);
		btn.setBackground(new Color(226,227,217));
		btn.setBorder(new LineBorder(new Color(166,169,138)));
		btn.setRolloverEnabled(false);
	   
		btn.setPreferredSize(new Dimension(150, 50));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		centerPanel.add(rigidArea);
		centerPanel.setBackground(winter);
		centerPanel.add(btn);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		tea = new Leaves();
		btn.addActionListener(new StartListener());

	}

	class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tea.run();
		    btnLbl.setText("<html><div style='text-align: center;'>Finish</div></html>");
		    btn.removeActionListener(this);
		    btn.addActionListener(new FinishListener());
		}
	};
	
	class FinishListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tea.stop();
			btnLbl.setText("<html><div style='text-align: center;'>Start</div></html>");
			btn.removeActionListener(this);
			btn.addActionListener(new StartListener());
		}
	};
}
