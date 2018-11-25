package Employee;

import java.util.*;
public class Employee {

    String name;
    String post;
    int salary;
    public Employee(String n,String p,int s)
    {
        name=n;
        post=p;
        salary=s;
    }
    public String getName(){return name;}
    public String getPost(){return post;}
    public int getSalary(){return salary;}
    public String toString()
    {
        return ""+name+" "+post+" "+ salary;
    }


    public static void main(String[] args) {
        LinkedList<Employee> sv = new LinkedList<Employee>();
        LinkedList<Employee> sv1 = new LinkedList<Employee>();
        sv.add(new Employee("Employer0","Post0",100));
        sv.add(new Employee("Employer0","Post11",100));
        sv.add(new Employee("Employer1","Post1",50));
        sv.add(new Employee("Employer2","Post2",60));
        sv.add(new Employee("Employer3","Post11",20));
        sv.add(new Employee("Employer4","Post4",10));
        sv.add(new Employee("Employer5","Post5",120));
        sv.add(new Employee("Employer6","Post11",35));
        sv.add(new Employee("Employer7","Post7",12));
        sv.add(new Employee("Employer8","Post8",90));
        sv.add(new Employee("Employer9","Post11",80));

		/*for (Employee e : sv )
			{
				if (e.getPost().equals("Post11"))
		     {
		    		 sv1.addFirst(e);
		       System.out.println(e + "777");
		}

			}*/  Iterator <Employee> it =  sv.iterator();
        while (it.hasNext())
        {
            Employee e = it.next();
            if (e.getPost().equals("Post11"))
            {sv1.add(e);
                it.remove();
            }
        }
        it = sv.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\n");

        Iterator<Employee>    it1 = sv1.iterator();
        while (it1.hasNext())
            System.out.println(it1.next());
    }


}

