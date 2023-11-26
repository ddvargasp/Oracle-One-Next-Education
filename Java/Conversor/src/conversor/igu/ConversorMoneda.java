package conversor.igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversor.logica.Colones;

import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversorMoneda extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesde;
	private JTextField txtHacia;

	public static boolean validarNumeros(String datos) {
		
		return datos.matches("[1, 9]");
		}

	/**
	 * Create the frame.
	 */
	public ConversorMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de Moneda");
		lblNewLabel.setBounds(243, 15, 461, 58);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 84, 917, 412);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cmbDesde = new JComboBox();
		cmbDesde.setModel(new DefaultComboBoxModel(new String[] {"Colones"}));
		cmbDesde.setBounds(54, 47, 145, 46);
		panel.add(cmbDesde);
		
		JComboBox cmbHacia = new JComboBox();
		cmbHacia.setModel(new DefaultComboBoxModel(new String[] {"Dolar", "Euros", "Libras Esterlinas", "Yen Japones", "Won Surcoreano"}));
		cmbHacia.setBounds(54, 210, 145, 46);
		panel.add(cmbHacia);
		
		txtDesde = new JTextField();
		txtDesde.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				int key = e.getKeyChar();
				
				boolean numeros = key >= 48 && key <= 57;
				
				if(!numeros) {
					e.consume();
				}				
			}
		});
		txtDesde.setColumns(10);
		txtDesde.setBounds(438, 47, 435, 46);
		panel.add(txtDesde);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Desde = (String)cmbDesde.getSelectedItem();
				String Hacia = (String)cmbHacia.getSelectedItem();
				
				if(Desde.equals("Colones") && (Hacia.equals("Dolar"))) {
					
					double colon = Double.parseDouble(txtDesde.getText());
					double dolar = (double) (colon * 0.0019);
					txtHacia.setText(String.valueOf(dolar));
				}
				
				if(Desde.equals("Colones") && (Hacia.equals("Euros"))) {
					
					double colon = Double.parseDouble(txtDesde.getText());
					double euro = (double) (colon * 0.0017);
					txtHacia.setText(String.valueOf(euro));
				}
				
				if(Desde.equals("Colones") && (Hacia.equals("Libras Esterlinas"))) {
					
					double colon = Double.parseDouble(txtDesde.getText());
					double libraEst = (double) (colon * 0.0015);
					txtHacia.setText(String.valueOf(libraEst));
				}
				
				if(Desde.equals("Colones") && (Hacia.equals("Yen Japones"))) {
					
					double colon = Double.parseDouble(txtDesde.getText());
					double yen = (double) (colon * 0.24);
					txtHacia.setText(String.valueOf(yen));
				}
				
				if(Desde.equals("Colones") && (Hacia.equals("Won Surcoreano"))) {
					
					double colon = Double.parseDouble(txtDesde.getText());
					double won = (double) (colon * 2.37);
					txtHacia.setText(String.valueOf(won));
				}	
				
				//validacion
				if (!validarNumeros(txtDesde.getText().trim())) {
					JOptionPane.showMessageDialog(rootPane, "Por favor ingresar solo numeros sin espacios");
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Conversion realizada con exito");
				}
			}
			
			public boolean validarNumeros(String numero) {
				return numero.matches("[0-9]*");
			}
		});
		btnConvertir.setBounds(438, 129, 145, 46);
		panel.add(btnConvertir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDesde.setText("");
				txtHacia.setText("");
			}
		});
		btnLimpiar.setBounds(683, 129, 145, 46);
		panel.add(btnLimpiar);
		
		txtHacia = new JTextField();
		txtHacia.setColumns(10);
		txtHacia.setBounds(438, 210, 435, 46);
		panel.add(txtHacia);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(728, 304, 145, 46);
		panel.add(btnSalir);
	}
}
