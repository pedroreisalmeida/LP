/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.server.mgr;

import ual.lp.caller.utils.Config;
import ual.lp.server.objects.Department;
import ual.lp.server.objects.Employee;
import ual.lp.server.objects.Ticket;

/**
 *
 * @author Pedro
 */
public class MainTest {

    public static void main(String[] args) {
        Config config = new Config();
        Employee employee;
        Manager mgr = new Manager();
//        System.out.println(mgr.getEmployee(new Employee(1, "teste", "teste")).getName());
//        mgr.insertEmployee(new Employee(1, "Pedro Tomas", "Ceu"));
//        mgr.getEmployee(new Employee(5,"Pedro Tomas", "Ceu"));
//        System.out.println(mgr.getTickets());
        Ticket t = new Ticket();
//        t.setIdTicket(2);
//        mgr.createTicket(4, 1);
        employee = config.getEmployee();

        mgr.verifyEmployee(employee);

//        mgr.closeTicket(t);
//        System.out.println(mgr.getEmployee(new Employee(3, "teste", "teste")).getName());
//        ApplicationContext context = new ClassPathXmlApplicationContext("ual/lp/spring/bean.xml");
//        EmployeeDAO empDAO = (EmployeeDAO) context.getBean("employeeDAO");
//        
////        Manager mgr = new Manager();
//        Employee emp = new Employee();
//        emp.setName("Divanio Silva");
//        emp.setDepartment("Financeiro");
//        empDAO.insert(emp);
    }
}
