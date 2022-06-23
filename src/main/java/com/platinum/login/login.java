package com.platinum.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.hash;
import modelo.persona;
import modelo.sqlPersona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtRut;
	private JPasswordField txtPassword;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField textField_2;
	private JTextField txtTelefono;
	private JPasswordField textConfirmarPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("rut");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 59, 16);
		contentPane.add(lblNewLabel);
		
		txtRut = new JTextField();
		txtRut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRut.setBounds(154, 9, 163, 19);
		contentPane.add(txtRut);
		txtRut.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 78, 71, 13);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(154, 75, 163, 19);
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sqlPersona modSql = new sqlPersona();
				persona mod = new persona();
				
				String pass = new String(txtPassword.getPassword()); 
				String passCon = new String(textConfirmarPassword.getPassword()); 
				
				if(pass.equals(passCon)) {
					
					String nuevoPass = hash.sha1(pass);
					
					mod.setRut(txtRut.getText());
					mod.setNombre(txtNombre.getText());
					mod.setApellido(txtApellido.getText());
					mod.setPassword(txtPassword.getText());
					mod.setTelefono(txtTelefono.getText());
					
					if(modSql.Ingresar(mod)) {
						
							
						JOptionPane.showMessageDialog(null, "registro guardado");
						
					}else {
					
						JOptionPane.showMessageDialog(null, "error al  guardar");
					}
				}	else {
						
						JOptionPane.showMessageDialog(null, "las contraseña no coinciden");
						
					}
				}
				
		}	
			);
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setBounds(174, 204, 130, 21);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 36, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(154, 38, 163, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 129, 68, 18);
		contentPane.add(lblNewLabel_3);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(154, 131, 163, 19);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 163, 79, 13);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 160, 150, 0);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setBounds(154, 160, 163, 19);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel txtConfirmarPassword = new JLabel("confirmar password");
		txtConfirmarPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtConfirmarPassword.setBounds(10, 98, 123, 26);
		contentPane.add(txtConfirmarPassword);
		
		textConfirmarPassword = new JPasswordField();
		textConfirmarPassword.setBounds(154, 102, 163, 19);
		contentPane.add(textConfirmarPassword);
	}
}
