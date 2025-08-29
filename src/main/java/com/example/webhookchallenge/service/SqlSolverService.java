package com.example.webhookchallenge.service;

import org.springframework.stereotype.Service;

@Service
public class SqlSolverService {
    
    /**
     * Solves the SQL problem for Question 1 (Odd registration numbers)
     * 
     * Finds the highest salary credited to an employee, excluding transactions 
     * made on the 1st day of any month, along with employee details.
     * 
     * @return SQL query string for Question 1 solution
     */
    public String solveQuestion1() {
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
