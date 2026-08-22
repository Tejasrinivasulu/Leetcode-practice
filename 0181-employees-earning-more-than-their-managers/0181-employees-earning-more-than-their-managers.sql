# Write your MySQL query statement below
SELECT t1.name as Employee
FROM Employee t1 
WHERE t1.salary > (SELECT t2.salary FROM Employee t2 WHERE t2.id = t1.managerId);