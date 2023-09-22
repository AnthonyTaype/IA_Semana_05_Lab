package semana05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Mochila extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblCantidad;
	private JComboBox<String> cboModelo;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mochila frame = new Mochila();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Mochila() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 65, 14);
		contentPane.add(lblModelo);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 65, 14);
		contentPane.add(lblCantidad);

		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Sherman", "Faguo", "Aldo", "Suburban"}));
		cboModelo.setBounds(85, 8, 100, 20);
		contentPane.add(cboModelo);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(85, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int cant,choco;
		double pre,impC,impD,impP;
		String modelo;
		cant = Integer.parseInt(txtCantidad.getText());
		modelo = cboModelo.getSelectedItem().toString();
		//calculando precio
		if(modelo == "Sherman"){pre=149.9;}
		else if(modelo == "Faguo"){pre=89.9;}
		else if(modelo == "Aldo"){pre=119.9;}
		else{pre=174.9;}
		
		impC = pre*cant;
		
		//Calculando el importe de descuento
		if(cant<5){impD=impC*0.05;}
		else if(cant>=5&&cant<10){impD=impC*0.07;}
		else if(cant>=10&&cant<20){impD=impC*0.09;}
		else{impD=impC*0.11;}
		
		impP = impC-impD;
		
		//Calculando los chocolates
		if(impP<200){choco=1*cant;}
		else if(impP>=200&&impP<500){choco=2*cant;}
		else if(impP>=500&&impP<700){choco=8;}
		else{choco=10;}
		
		txtS.setText("SISTEMA DE MOCHILA \n\n");
		imprimir("Importe compra     : " + decimalFormat(impC));
		imprimir("Importe descuento  : " + decimalFormat(impD));
		imprimir("Importe pagar      : " + decimalFormat(impP));
		imprimir("Chocolates         : " + choco);
	}
	
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
	
		
		
		





		



		
		
		
		
				
		
		
		
		
		
		
		
		



