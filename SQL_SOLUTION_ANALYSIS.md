# SQL Solution Analysis - Question 1

## Problem Statement
Find the highest salary that was credited to an employee, but only for transactions that were **not made on the 1st day of any month**. Along with the salary, extract employee data like name (combined first+last), age and department.

## Database Schema
- **DEPARTMENT**: DEPARTMENT_ID (PK), DEPARTMENT_NAME
- **EMPLOYEE**: EMP_ID (PK), FIRST_NAME, LAST_NAME, DOB, GENDER, DEPARTMENT (FK)
- **PAYMENTS**: PAYMENT_ID (PK), EMP_ID (FK), AMOUNT, PAYMENT_TIME

## SQL Solution
```sql
SELECT 
    p.AMOUNT as SALARY, 
    CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) as NAME, 
    FLOOR(DATEDIFF(CURDATE(), e.DOB) / 365.25) as AGE, 
    d.DEPARTMENT_NAME 
FROM PAYMENTS p 
JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID 
JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID 
WHERE DAY(p.PAYMENT_TIME) != 1 
ORDER BY p.AMOUNT DESC 
LIMIT 1;
```

## Solution Breakdown

### 1. **Filter Condition**
`WHERE DAY(p.PAYMENT_TIME) != 1`
- Excludes payments made on 1st day of any month
- Excludes payment IDs: 1, 3, 6 (all made on 2025-01-01)

### 2. **Joins Required**
- `PAYMENTS p` ← `EMPLOYEE e` (via EMP_ID)
- `EMPLOYEE e` ← `DEPARTMENT d` (via DEPARTMENT foreign key)

### 3. **Required Output Columns**
- **SALARY**: `p.AMOUNT as SALARY`
- **NAME**: `CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) as NAME` 
- **AGE**: `FLOOR(DATEDIFF(CURDATE(), e.DOB) / 365.25) as AGE`
- **DEPARTMENT_NAME**: `d.DEPARTMENT_NAME`

### 4. **Highest Salary Selection**
- `ORDER BY p.AMOUNT DESC LIMIT 1`
- Gets the single highest amount from filtered results

## Expected Result
Looking at the data, payments NOT made on 1st day:
- Payment ID 16: Emily Brown, 74998.00, Sales (2025-03-02) ← **HIGHEST**
- Payment ID 13: Sarah Johnson, 72984.00, Finance (2025-03-05)
- Payment ID 9: Emily Brown, 71876.00, Sales (2025-02-01)
- ... and others

**Expected Output:**
- SALARY: 74998.00
- NAME: Emily Brown  
- AGE: 32 (born 1992-11-30)
- DEPARTMENT_NAME: Sales
