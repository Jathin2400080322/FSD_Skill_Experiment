import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Product;

public class ProductApp {
	 public static void main(String[] args) {
	        // Step 1: Configure Hibernate
	       
	        SessionFactory sf = new Configuration().configure().buildSessionFactory();

	        // ---------- INSERT MULTIPLE PRODUCTS ----------
	        Session s = sf.openSession();
	        Product p1 = new Product("Laptop", "intel i5", 55000.0, 10);
	        

	        s.persist(p1);
	        //like wise insert all records

	        Transaction tx = s.beginTransaction();
	        tx.commit();
	        s.close();

	        // RETRIEVE PRODUCT BY ID
	        
	        s = sf.openSession();
	        Product product = s.find(Product.class, 1); // Example ID
	        System.out.println("Retrieved Product: " + product.getName() + ", Price: " + product.getPrice());
	        s.close();

	        //UPDATE PRICE OR QUANTITY
	        s = sf.openSession();
	        Product prodToUpdate = s.find(Product.class, 1);
	        if (prodToUpdate != null) {
	            prodToUpdate.setPrice(58000.0);   // update price
	            prodToUpdate.setQuantity(12);     // update quantity
	            s.merge(prodToUpdate);

	            tx = s.beginTransaction();
	            tx.commit();
	        }
	        s.close();

	        // DELETE PRODUCT 
	        s = sf.openSession();
	        Product prodToDelete = s.find(Product.class, 3);
	        if (prodToDelete != null) {
	            s.remove(prodToDelete);

	            tx = s.beginTransaction();
	            tx.commit();
	        }
	        s.close();

	        sf.close();
	    }

}
