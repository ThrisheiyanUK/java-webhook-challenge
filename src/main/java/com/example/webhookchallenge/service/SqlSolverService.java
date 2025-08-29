package com.example.webhookchallenge.service;

import org.springframework.stereotype.Service;

@Service
public class SqlSolverService {
    
    /**
     * Solves the SQL problem for Question 1 (Odd registration numbers)
     * 
     * Problem: Find the highest salary that was credited to an employee, but only for 
     * transactions that were not made on the 1st day of any month. Along with the salary, 
     * extract employee data like name (combined first+last), age and department.
     * 
     * Tables: DEPARTMENT, EMPLOYEE, PAYMENTS
     */
    public String solveQuestion1() {
        // SQL SOLUTION FOR QUESTION 1: Find highest salary not credited on 1st day of month
        // with employee name, age, and department details
        String sqlQuery = "SELECT " +
            "p.AMOUNT as SALARY, " +
            "CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) as NAME, " +
            "FLOOR(DATEDIFF(CURDATE(), e.DOB) / 365.25) as AGE, " +
            "d.DEPARTMENT_NAME " +
            "FROM PAYMENTS p " +
            "JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID " +
            "JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID " +
            "WHERE DAY(p.PAYMENT_TIME) != 1 " +
            "ORDER BY p.AMOUNT DESC " +
            "LIMIT 1";
        
        System.out.println("Solving SQL Question 1...");
        System.out.println("Generated SQL Query: " + sqlQuery);
        
        return sqlQuery.trim();
    }
    
    /**
     * Returns the SQL solution for the actual Question 1 problem
     * Expected result: The highest salary (74998.00) for Emily Brown from Sales department
     */
    public String getActualSolution() {
        return solveQuestion1();
    }
}
