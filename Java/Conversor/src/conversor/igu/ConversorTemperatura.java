package conversor.igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesde;
	private JTextField txtHacia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
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
	public ConversorTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 898, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de Temperatura");
		lblNewLabel.setBounds(164, 11, 566, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		
		JComboBox cmbDesde = new JComboBox();
		cmbDesde.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin", "Rankine"}));
		cmbDesde.setBounds(69, 157, 145, 46);
		contentPane.add(cmbDesde);
		
		JComboBox cmbHacia = new JComboBox();
		cmbHacia.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin", "Rankine"}));
		cmbHacia.setBounds(69, 320, 145, 46);
		contentPane.add(cmbHacia);
		
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
		txtDesde.setBounds(453, 157, 435, 46);
		contentPane.add(txtDesde);
		txtDesde.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Desde = (String)cmbDesde.getSelectedItem();
				String Hacia = (String)cmbHacia.getSelectedItem();
				
				//Celsius Conversion
				//Celsius to Fahrenheit
				if(Desde.equals("Celsius") && (Hacia.equals("Fahrenheit") ) ) {
					
					double celsius = Double.parseDouble(txtDesde.getText());
					
					double fahrenheit = (double) (celsius * 1.8  +  32);
					
					txtHacia.setText(String.valueOf(fahrenheit));
				}
				
				//Celsius to Kelvin
				if(Desde.equals("Celsius") && (Hacia.equals("Kelvin") ) ) {
					
					double celsius = Double.parseDouble(txtDesde.getText());
					
					double kelvin = (double) (celsius + 273.15);
					
					txtHacia.setText(String.valueOf(kelvin));
				}
				
				//Celsius to Rankine
				if(Desde.equals("Celsius") && (Hacia.equals("Rankine") ) ) {
					
					double celsius = Double.parseDouble(txtDesde.getText());
					
					double Rankine = (double) (celsius * 1.8  + 491.67);
					
					txtHacia.setText(String.valueOf(Rankine));
				}
				
				//Celsius to Celsius
				if(Desde.equals("Celsius") && (Hacia.equals("Celsius") ) ) {
					
					double celsius = Double.parseDouble(txtDesde.getText());
					
					txtHacia.setText(String.valueOf(celsius));
				}
				
				//Fahrenheit Conversion
				//Fahrenheit to Celsius
				if(Desde.equals("Fahrenheit") && (Hacia.equals("Celsius") ) ) {
					
					double fahrenheit = Double.parseDouble(txtDesde.getText());
					
					double celsius = (double) ((fahrenheit - 32) * 5/9);
					
					txtHacia.setText(String.valueOf(celsius));
				}
				
				//Fahrenheit to Kelvin
				if(Desde.equals("Fahrenheit") && (Hacia.equals("Kelvin") ) ) {
					
					double fahrenheit = Double.parseDouble(txtDesde.getText());
					
					double kelvin = (double) ((fahrenheit + 459.67) * 5/9);
					
					txtHacia.setText(String.valueOf(kelvin));
				}
				
				//Fahrenheit to Rankine
				if(Desde.equals("Fahrenheit") && (Hacia.equals("Rankine") ) ) {
					
					double fahrenheit = Double.parseDouble(txtDesde.getText());
					
					double Rankine = (double) (fahrenheit + 459.67);
					
					txtHacia.setText(String.valueOf(Rankine));
				}
				
				//Fahrenheit to Fahrenheit
				if(Desde.equals("Fahrenheit") && (Hacia.equals("Fahrenheit") ) ) {
					
					double fahrenheit = Double.parseDouble(txtDesde.getText());
					
					txtHacia.setText(String.valueOf(fahrenheit));
				}
				
				//Kelvin Conversion
				//Kelvin to Celsius
				if(Desde.equals("Kelvin") && (Hacia.equals("Fahrenheit") ) ) {
					
					double kelvin = Double.parseDouble(txtDesde.getText());
					
					double celsius = (double) (kelvin - 273.15);
					
					txtHacia.setText(String.valueOf(celsius));
				}
				
				//Kelvin to Fahrenheit
				if(Desde.equals("Kelvin") && (Hacia.equals("Fahrenheit") ) ) {
					
					double kelvin = Double.parseDouble(txtDesde.getText());
					
					double fahrenheit = (double) (((kelvin - 273.15)* 9/5) + 32);
					
					txtHacia.setText(String.valueOf(fahrenheit));
				}
				
				//Kelvin to Rankine
				if(Desde.equals("Kelvin") && (Hacia.equals("Rankine") ) ) {
					
					double kelvin = Double.parseDouble(txtDesde.getText());
					
					double rankine = (double) (kelvin * 1.8);
					
					txtHacia.setText(String.valueOf(rankine));
				}
				
				//Kelvin to Kelvin
				if(Desde.equals("Kelvin") && (Hacia.equals("Kelvin") ) ) {
					
					double kelvin = Double.parseDouble(txtDesde.getText());
					
					txtHacia.setText(String.valueOf(kelvin));
				}
				
				//Rankine Conversion
				//Rankine to Celsius
				if(Desde.equals("Rankine") && (Hacia.equals("Celsius") ) ) {
					
					double rankine = Double.parseDouble(txtDesde.getText());
					
					double celsius = (double) ((rankine - 491.67)* 5/9);
					
					txtHacia.setText(String.valueOf(celsius));
				}
				
				//Rankine to Fahrenheit
				if(Desde.equals("Rankine") && (Hacia.equals("Fahrenheit") ) ) {
					
					double rankine = Double.parseDouble(txtDesde.getText());
					
					double fahreheit = (double) (rankine - 459.67);
					
					txtHacia.setText(String.valueOf(fahreheit));
				}
				
				//Rankine to Kelvin
				if(Desde.equals("Rankine") && (Hacia.equals("Kelvin") ) ) {
					
					double rankine = Double.parseDouble(txtDesde.getText());
					
					double kelvin = (double) (rankine / 1.8);
					
					txtHacia.setText(String.valueOf(kelvin));
				}
				
				//Rankine to Rankine
				if(Desde.equals("Rankine") && (Hacia.equals("Rankine") ) ) {
					
					double rankine = Double.parseDouble(txtDesde.getText());					
		
					txtHacia.setText(String.valueOf(rankine));
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
		btnConvertir.setBounds(453, 239, 145, 46);
		contentPane.add(btnConvertir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDesde.setText("");
				txtHacia.setText("");
			}
		});
		btnLimpiar.setBounds(698, 239, 145, 46);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setBounds(743, 414, 145, 46);
		contentPane.add(btnSalir);
		
		txtHacia = new JTextField();
		txtHacia.setColumns(10);
		txtHacia.setBounds(453, 320, 435, 46);
		contentPane.add(txtHacia);
	}
}
