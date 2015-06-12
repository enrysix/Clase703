package dao.servicios.aumentar.salario;

import java.util.List;

import codegeneration.Employees;

public class EmployeesDAO extends SuperClassDAO{
	
	public EmployeesDAO () {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Employees> getListEmployees() {
	
		List<Employees> list_employees = null;
		
		try {
			
			list_employees = this.getSession().createSQLQuery(InstruccionesSQL.CONSULTAR_TODOS).addEntity(Employees.class).list();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list_employees;
	}
}
