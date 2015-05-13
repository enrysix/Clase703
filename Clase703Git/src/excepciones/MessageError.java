package excepciones;

import javax.swing.JOptionPane;

public class MessageError extends Exception{

	public MessageError() {
		
		JOptionPane.showMessageDialog(null, "No se puede introducir este último registro, el array esta completo");
		System.out.println("No se puede introducir este último registro, el array esta completo");
	}
}
