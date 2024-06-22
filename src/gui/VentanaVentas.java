package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import clases.ArregloVentas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVentas extends JFrame {
	
	ArregloVentas v = new ArregloVentas();
	
	 public void imprimirVentas() {
		 txts.setText(""); // Limpiar el JTextArea antes de imprimir
	     txts.append("\n");   
		 for (int i = 0; i < v.tamaño(); i++) {
	            txts.append(" " + v.obtener(i) + "\n");
	        }
	    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtposrem;
	private JTextField txtvalorrem;
	private JTextField txtEliminar;
	private JTextField txtvalorinc;
	private JTextField txtAdicionar;
	private JTextField txtposinc;
	private JTextArea txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentas frame = new VentanaVentas();
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
	public VentanaVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVentaMaxima = new JButton("Venta Máxima");
		btnVentaMaxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			txts.append("\n");
			txts.append(" Venta Máxima: " + v.ventaMaximo() + "\n");
				
			}
		});
		btnVentaMaxima.setFont(new Font("Arial", Font.PLAIN, 11));
		btnVentaMaxima.setBounds(21, 55, 130, 21);
		contentPane.add(btnVentaMaxima);
		
		JButton btnVentaMinima = new JButton("Venta Mínima");
		btnVentaMinima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			txts.append(" Venta Mínima: " + v.ventaMinimo() + "\n");	
				
			}
		});
		btnVentaMinima.setFont(new Font("Arial", Font.PLAIN, 11));
		btnVentaMinima.setBounds(21, 86, 130, 21);
		contentPane.add(btnVentaMinima);
		
		JButton btnTotalVentas = new JButton("Total Ventas");
		btnTotalVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			txts.append(" Total Ventas: " + v.totalVentas() + "\n");
				
			}
		});
		btnTotalVentas.setFont(new Font("Arial", Font.PLAIN, 11));
		btnTotalVentas.setBounds(21, 117, 130, 21);
		contentPane.add(btnTotalVentas);
		
		JButton btnReemplazoVentas = new JButton("Reemplazar Venta");
		btnReemplazoVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int pos = Integer.parseInt(txtposrem.getText());
                double valor = Double.parseDouble(txtvalorrem.getText());
                v.reemplazoVentas(pos, valor);
                txts.append(" Nueva Venta : " + pos + valor + "\n");
				imprimirVentas();
				txtposrem.setText("");
				txtposrem.requestFocus();
			}
		});
		btnReemplazoVentas.setFont(new Font("Arial", Font.PLAIN, 11));
		btnReemplazoVentas.setBounds(21, 459, 130, 21);
		contentPane.add(btnReemplazoVentas);
		
		JButton btnEliminarVenta = new JButton("Eliminar Venta");
		btnEliminarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double valor = Double.parseDouble(txtEliminar.getText());
                v.eliminarVenta(valor);
                txts.append(" Venta eliminada: " + valor + "\n");
                imprimirVentas();
                txtEliminar.setText("");
                txtEliminar.requestFocus();
				
			}
		});
		btnEliminarVenta.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEliminarVenta.setBounds(21, 256, 130, 21);
		contentPane.add(btnEliminarVenta);
		
		JButton btnIncrementarVenta = new JButton("Incrementar Venta");
		btnIncrementarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int pos = Integer.parseInt(txtposinc.getText());
            double valor = Double.parseDouble(txtvalorinc.getText());
            v.incrementarVenta(pos, valor);
            txts.append(" Venta incrementada en posición " + pos + " con valor " + valor + "\n");
            imprimirVentas();	
            txtposinc.setText("");
            txtposinc.requestFocus();
				
			}
		});
		btnIncrementarVenta.setFont(new Font("Arial", Font.PLAIN, 11));
		btnIncrementarVenta.setBounds(21, 359, 130, 21);
		contentPane.add(btnIncrementarVenta);
		
		JButton btnVenta = new JButton("Adicionar Venta");
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                    double valor = Double.parseDouble(txtAdicionar.getText());
                    v.buscarAdicionarVenta(valor);
                    txts.append(" Venta adicionada: " + valor + "\n");
                    imprimirVentas();		
                    txtAdicionar.setText("");
                    txtAdicionar.requestFocus();
			}
		});
		btnVenta.setFont(new Font("Arial", Font.PLAIN, 11));
		btnVenta.setBounds(21, 188, 130, 21);
		contentPane.add(btnVenta);
		
		JButton btnGenerarVentas = new JButton("Generar Ventas");
		btnGenerarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				v.generarVentas();
                txts.append(" Ventas generadas aleatoriamente.\n");
                imprimirVentas();	
				
			}
		});
		btnGenerarVentas.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGenerarVentas.setBounds(21, 504, 130, 21);
		contentPane.add(btnGenerarVentas);
		
		txtposrem = new JTextField();
		txtposrem.setHorizontalAlignment(SwingConstants.CENTER);
		txtposrem.setFont(new Font("Arial", Font.PLAIN, 11));
		txtposrem.setBounds(21, 401, 96, 19);
		contentPane.add(txtposrem);
		txtposrem.setColumns(10);
		
		txtvalorrem = new JTextField();
		txtvalorrem.setHorizontalAlignment(SwingConstants.CENTER);
		txtvalorrem.setFont(new Font("Arial", Font.PLAIN, 11));
		txtvalorrem.setBounds(21, 430, 96, 19);
		contentPane.add(txtvalorrem);
		txtvalorrem.setColumns(10);
		
		txtEliminar = new JTextField();
		txtEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		txtEliminar.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEliminar.setBounds(21, 227, 96, 19);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		
		txtvalorinc = new JTextField();
		txtvalorinc.setHorizontalAlignment(SwingConstants.CENTER);
		txtvalorinc.setFont(new Font("Arial", Font.PLAIN, 11));
		txtvalorinc.setBounds(21, 330, 96, 19);
		contentPane.add(txtvalorinc);
		txtvalorinc.setColumns(10);
		
		txtAdicionar = new JTextField();
		txtAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionar.setFont(new Font("Arial", Font.PLAIN, 11));
		txtAdicionar.setBounds(21, 159, 96, 19);
		contentPane.add(txtAdicionar);
		txtAdicionar.setColumns(10);
		
		txtposinc = new JTextField();
		txtposinc.setHorizontalAlignment(SwingConstants.CENTER);
		txtposinc.setFont(new Font("Arial", Font.PLAIN, 11));
		txtposinc.setColumns(10);
		txtposinc.setBounds(21, 301, 96, 19);
		contentPane.add(txtposinc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(161, 18, 370, 507);
		contentPane.add(scrollPane);
		
		txts = new JTextArea();
		scrollPane.setViewportView(txts);
		txts.setFont(new Font("Consolas", Font.BOLD, 14));
		
		JButton btnMostrarVentas = new JButton("Mostrar Ventas");
		btnMostrarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				imprimirVentas();
				
			}
		});
		btnMostrarVentas.setFont(new Font("Arial", Font.PLAIN, 11));
		btnMostrarVentas.setBounds(21, 20, 130, 21);
		contentPane.add(btnMostrarVentas);
	}
}