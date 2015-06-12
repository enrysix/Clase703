package dao.servicios.aumentar.salario;

public class MainServicios {

	public static void main(String[] args) {
		
		boolean bn = false;
		ClassServices sc = new ClassServices();
		
		bn = sc.aumentarSalario20();
		
		System.out.println(bn);
	}
}
