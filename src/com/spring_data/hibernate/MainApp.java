package com.spring_data.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.spring_data.hibernate.model.Car;
import com.spring_data.hibernate.model.Client;
import com.spring_data.hibernate.model.Color;
import com.spring_data.hibernate.model.Data;
import com.spring_data.hibernate.model.Info;
import com.spring_data.hibernate.model.Person;
import com.spring_data.hibernate.model.Student;

public class MainApp {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
		       .configure("hibernate.cfg.xml")
		       .addAnnotatedClass(Car.class)
		       .addAnnotatedClass(Color.class)
		       .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
	
		int id = 3;
		try {
			session.beginTransaction();
			Car c = session.get(Car.class, id);
			
			c.setName("New Car");
			c.getColors().get(0).setName("black");
			//OR session.update(c);
			
			// if you need delete you need remove from cascade CascadeType.Remove and write the other function in every class not from 1 class 
		
			session.getTransaction().commit();
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}finally {
			session.close();
		}
	
	
		
	
	}

}

            /*session.close();
			System.out.println(c.getName());
			for(Color c1 : c.getColors()) {
				System.out.println(c1.getName());
			}*/


/*
Car c1 = new Car("car1");
Car c2 = new Car("car2");
Car c3 = new Car("car3");

Color co1 = new Color("red");
Color co2 = new Color("blue");
Color co3 = new Color("yellow");

c1.getColors().add(co1);
c1.getColors().add(co2);
c1.getColors().add(co3);

c2.getColors().add(co1);
c2.getColors().add(co2);
c2.getColors().add(co3);

c3.getColors().add(co1);
c3.getColors().add(co2);
c3.getColors().add(co3);

session.save(c1);
session.save(c2);
session.save(c3);
*/
   


/*int id=3;
Student student =new Student();
student = session.get(Student.class,id);

student.setName("sammy");

student.getInfos().get(0).setPhone("012");
student.getInfos().get(1).setPhone("011");


session.update(student);
*/

/*
Info i1 = new Info();
i1.setPhone("01247946285");
Info i2 = new Info();
i2.setPhone("01050770321");

student.getInfos().add(0, i1);
student.getInfos().add(1, i2);


i1.setStudent(student);
i2.setStudent(student);
*/

/*
System.out.println(student.getName());

for(Info i :student.getInfos()) {
	System.out.println(i.getPhone());
}
*/



/*
Student student =new Student();
student.setName("Ahmed");

Info info1 = new Info();
Info info2 = new Info();

info1.setPhone("01055335452");

info2.setPhone("01256337492");


student.getInfos().add(info1);
student .getInfos().add(info2);

info1.setStudent(student);
info2.setStudent(student);
*/

//session.save(student);			

/*
 * Person p = new Person(); p.setName("loay eslam");
 * 
 * Data data = new Data(); data.setAge("21");
 * 
 * p.setData(data); session.save(p);
 */

/*
Person p = new Person();
p.setId(1);

Person res = session.get(Person.class,p.getId());

System.out.println("name: "+res.getName());
System.out.println("Age: "+res.getData().getAge());

//session.delete(res);//delete function 

res.setName("Karim");
res.getData().setAge("22");
*/




  /*
   * 
   * 
   * 	Data d = new Data();
			d.setId(1);
			
			Data res = session.get(Data.class,d.getId());
			
			System.out.println("Name: "+res.getAge());
			System.out.println("Age: "+res.getPerson().getName());
			
			session.delete(res);*/
/*
 
 * Criteria c = session.createCriteria(Client.class);
			
			//c.setProjection(Projections.min("id"));
			//c.setProjection(Projections.max("id"));
			//c.setProjection(Projections.avg("id"));
			//c.setProjection(Projections.sum("id"));
			//c.setProjection(Projections.count("address"));
			c.setProjection(Projections.countDistinct("address"));
			
			List<Client> clients = c.list();
			System.out.println("sum: "+clients.get(0));
			
			for(int i=0;i<clients.size();i++) {
				
				System.out.println(clients.get(i).getFullName()+" "+clients.get(i).getAge());
				
				}
				
				
			System.out.println(c.getFullName()+" "+c.getAddress());
 * 
 * 
 * */

/*
 *  // c.setFirstResult(0);
			 // c.setMaxResults(9);
		    //c.add(Restrictions.in("id",ids));
		     // c.add(Restrictions.isNotNull("address"));
		     // c.add(Restrictions.isEmpty("address"));
			//c.add(Restrictions.eq("fullName", "loay"));
			//c.add(Restrictions.like("fullName", "s",MatchMode.START));
			//c.add(Restrictions.like("fullName", "s",MatchMode.ANYWHERE));
		    Criterion c1 = Restrictions.eq("address", "alex");
			Criterion c2 = Restrictions.eq("fullName", "loay");
			LogicalExpression or = Restrictions.or(c1,c2);
			c.add(or);
			
 * 
 * 
 * */

/*
 * Query q1=session.createQuery("select Max(id) from Client");
			Query q2=session.createQuery("select Min(id) from Client");
			Query q3=session.createQuery("select Sum(id) from Client");
			Query q4=session.createQuery("select Avg(id) from Client");
			Query q5=session.createQuery("select Count(address) from Client");
			Query q6=session.createQuery("select Count(distinct address) from Client");
			
			
			System.out.println("Max: "+q1.list().get(0));
			System.out.println("Min: "+q2.list().get(0));
			System.out.println("Sum: "+q3.list().get(0));
			System.out.println("Avg: "+q4.list().get(0));
			System.out.println("Count: "+q5.list().get(0));
			System.out.println("Count unq: "+q6.list().get(0));
 * 
 * 
 * */

/*
 *     write query to insert it 
 * Query q = session.createQuery("from Client where id =?5 or fullName =?5");
					//q.setFirstResult(0);
					//q.setMaxResults(4);
					
					q.setInteger(5, id);
					q.setString(5,"eyad");
			
 * 
 * 
 * 
 * Query q = session.createQuery("from Client where id =:v1 or fullName =:v2");
					//q.setFirstResult(0);
					//q.setMaxResults(4);
					
					q.setInteger("v1", id);
					q.setString("v2","eyad");
 * 
 *   session.createQuery("update Client set age=19 where id =6").executeUpdate();
 *   
 *   
 *     bit maniplation AND / OR  
 *                     ("from Client c where"
							+ " c.fullName = 'mohammed'"
							+"OR c.address='alex'")
					.list();
 * 
 * 
 * Delete from dataBase
 * 	Client c = new Client();
			c.setId(id);
			session.delete(c);
			
			session.getTransaction().commit();
 * 
 * 
 * UPDATE with hibernate 
 * Client client = session.get(Client.class, id);
			client.setFullName("maged");
			client.setAge(23);
			client.setAddress("alex");
			Client c = new Client("Yasser",20,"cairo");
			c.setId((long)1);
			session.update(c);
 * 
 * */

/*
 * INSERT into hibernate 
 * 	Client client1 =new Client("loay eslam",21,"loayeslam91@gmail.com");
		//client1.setId((long)1);
		
		Client client2 =new Client("loay eslam",21,"loayeslam91@gmail.com");
		//client2.setId((long)2);
		
		Client client3 =new Client("loay eslam",21,"loayeslam91@gmail.com");
		//client3.setId((long)3);
 * 
 * 
 * */

/*
 *
 *    JDBC without hibernate 
 * String url="jdbc:mysql://localhost:3306/employee?useSSL=false"; String
 * username="root"; String password="root";
 * 
 * try { Connection connection = DriverManager.getConnection(url, username,
 * password); System.out.println("Connected"); System.out.println(connection);
 * 
 * }catch(Exception e) { System.out.println(e.toString()) ;
 * 
 * }
 */