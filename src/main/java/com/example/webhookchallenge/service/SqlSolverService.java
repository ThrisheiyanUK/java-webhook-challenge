package com.example.webhookchallenge.service;

import org.springframework.stereotype.Service;

@Service
public class SqlSolverService {
    
    /**
     * Solves the SQL problem for Question 1 (Odd registration numbers)
     * TODO: Replace this with the actual SQL solution from Question 1
     * 
     * This is a placeholder - you need to update this with the actual SQL query
     * from the Question 1 PDF that you have access to.
     */
    public String solveQuestion1() {
        // PLACEHOLDER SQL QUERY - REPLACE WITH ACTUAL SOLUTION FROM QUESTION 1
        String sqlQuery = "SELECT " +
            "emp_id, " +
            "emp_name, " +
            "department, " +
            "salary " +
            "FROM employees " +
            "WHERE salary > (" +
            "SELECT AVG(salary) " +
            "FROM employees" +
            ") " +
            "ORDER BY salary DESC";
        
        System.out.println("Solving SQL Question 1...");
        System.out.println("Generated SQL Query: " + sqlQuery);
        
        return sqlQuery.trim();
    }
    
    /**
     * This method can be updated with the actual question content
     * once you have access to the Question 1 PDF
     */
    public String getActualSolution() {
        // TODO: Implement the actual SQL solution based on Question 1 requirements
        return solveQuestion1();
    }
}
