package conversor.igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 48));
		lblNewLabel.setBounds(358, 11, 244, 60);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 77, 916, 398);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMoneda = new JButton("Moneda");
		btnMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConversorMoneda pantalla = new ConversorMoneda();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				
			}
		});
		btnMoneda.setFont(new Font("Sylfaen", Font.PLAIN, 26));
		btnMoneda.setBounds(345, 63, 214, 83);
		panel.add(btnMoneda);
		
		JButton btnConversorDeTemperatura = new JButton("Temperatura");
		btnConversorDeTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConversorTemperatura pantalla = new ConversorTemperatura();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
			}
		});
		btnConversorDeTemperatura.setFont(new Font("Sylfaen", Font.PLAIN, 26));
		btnConversorDeTemperatura.setBounds(345, 157, 214, 83);
		panel.add(btnConversorDeTemperatura);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Sylfaen", Font.PLAIN, 26));
		btnSalir.setBounds(345, 251, 214, 83);
		panel.add(btnSalir);
	}
}
