package dao.servicios.aumentar.salario;

import java.math.BigDecimal;
//import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import codegeneration.Employees;

public class ClassServices {
	
	private EmployeesDAO empleadoDAO;
//	private int newsalary = 0;
//	private static final double porcentaje = 1.20;

	public ClassServices () {
		
		empleadoDAO = new EmployeesDAO();
	}
	
	public boolean aumentarSalario20 () {
		
		boolean aumentado = false;
		Session session = null;
		Transaction transaction = null;
		List<Employees> list_employees = null;
		
		try {
			session = SessionManager.getNewSession();
			transaction = session.beginTransaction();
			empleadoDAO.setSession(session);
			
			list_employees = empleadoDAO.getListEmployees();
			
			//LO COMENTANTADO ES IGUAL A NUESTRO MÉTODO PRIVADO refreshSalaryEmployees
//			Iterator<Employees> it = list_employees.iterator();
//			Employees employeed;
//			BigDecimal bg = null;

			
//			while (it.hasNext()) {
//				
//				employeed = it.next();
//				newsalary = (int)(employeed.getSalary().doubleValue() * porcentaje);
//
//				bg = new BigDecimal(newsalary);
//    			
//    			employeed.setSalary(bg);
////    			session.update(employeed);
//    			System.out.println(employeed.toString());
//    		}
			
			refreshSalaryEmployees(list_employees);
    		transaction.commit();
    		aumentado = true;
			
		} catch (Exception e) {
			
			transaction.rollback();
			aumentado = false;
			e.printStackTrace();
		} finally {
			SessionManager.closeSession(session);
		}

		return aumentado;
		
	}
	
	private void refreshSalaryEmployees (List<Employees> list) {
	
		for (Employees e: list) {
			
			e.setSalary(e.getSalary().multiply(new BigDecimal(1.2)));
		}
	}
}
