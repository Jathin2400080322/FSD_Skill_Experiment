package com.klu.main;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Product;

public class ProductApp {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        // 1. Sort by cost (Ascending)
        Query<Product> q1 = s.createQuery("FROM Product ORDER BY pcost", Product.class);
        List<Product> ascList = q1.getResultList();
        System.out.println("Ascending by cost:");
        ascList.forEach(System.out::println);

        // 2. Sort by cost (Descending)
        Query<Product> q2 = s.createQuery("FROM Product ORDER BY pcost DESC", Product.class);
        List<Product> descList = q2.getResultList();
        System.out.println("\nDescending by cost:");
        descList.forEach(System.out::println);

        // 3. Sort by quantity
        Query<Product> q3 = s.createQuery("FROM Product ORDER BY quantity DESC", Product.class);
        List<Product> qtyList = q3.getResultList();
        System.out.println("\nSorted by quantity:");
        qtyList.forEach(System.out::println);

        // 4. Pagination (first 3 products)
        Query<Product> q4 = s.createQuery("FROM Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        List<Product> pageList = q4.getResultList();
        System.out.println("\nPagination (first 3 products):");
        pageList.forEach(System.out::println);

        // 5. Aggregate - Total count
        Query<Long> q5 = s.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
        Long totalProducts = q5.uniqueResult();
        System.out.println("\nTotal Products: " + totalProducts);

        // 6. Aggregate - Count where quantity > 0
        Query<Long> q6 = s.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0", Long.class);
        Long availableProducts = q6.uniqueResult();
        System.out.println("Products with quantity > 0: " + availableProducts);

        // 7. Aggregate - Min and Max price
        Query<Object[]> q7 = s.createQuery(
                "SELECT MIN(p.pcost), MAX(p.pcost) FROM Product p", Object[].class);
        Object[] minMax = q7.uniqueResult();
        System.out.println("Minimum Cost: " + minMax[0]);
        System.out.println("Maximum Cost: " + minMax[1]);

        // 8. GROUP BY pname
        Query<Object[]> q8 = s.createQuery(
                "SELECT p.pname, COUNT(p) FROM Product p GROUP BY p.pname",
                Object[].class);

        List<Object[]> groupList = q8.getResultList();
        System.out.println("\nGroup By Product Name:");
        for (Object[] row : groupList) {
            System.out.println("Name: " + row[0] + " Count: " + row[1]);
        }

        // 9. WHERE clause (price range)
        Query<Product> q9 = s.createQuery(
                "FROM Product p WHERE p.pcost BETWEEN 100 AND 500",
                Product.class);

        List<Product> rangeList = q9.getResultList();
        System.out.println("\nProducts between 100 and 500:");
        rangeList.forEach(System.out::println);

        // 10. LIKE - names starting with A
        Query<Product> q10 = s.createQuery(
                "FROM Product p WHERE p.pname LIKE 'A%'", Product.class);

        System.out.println("\nNames starting with A:");
        q10.getResultList().forEach(System.out::println);

        // 11. LIKE - names ending with e
        Query<Product> q11 = s.createQuery(
                "FROM Product p WHERE p.pname LIKE '%e'", Product.class);

        System.out.println("\nNames ending with e:");
        q11.getResultList().forEach(System.out::println);

        // 12. LIKE - names containing 'pro'
        Query<Product> q12 = s.createQuery(
                "FROM Product p WHERE p.pname LIKE '%pro%'", Product.class);

        System.out.println("\nNames containing 'pro':");
        q12.getResultList().forEach(System.out::println);

        // 13. LIKE - names with exactly 5 characters
        Query<Product> q13 = s.createQuery(
                "FROM Product p WHERE p.pname LIKE '_____'", Product.class);

        System.out.println("\nNames with exactly 5 characters:");
        q13.getResultList().forEach(System.out::println);

        s.close();
        sf.close();
    }
}