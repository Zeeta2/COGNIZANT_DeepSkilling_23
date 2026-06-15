--Scenario 2: The bank wants to implement a bonus scheme for employees based 
--on their performance.
--o	Question: Write a stored procedure UpdateEmployeeBonus that updates 
--the salary of employees in a given department by adding a bonus percentage 
--passed as a parameter.

CREATE TABLE Employees (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER
);
INSERT INTO Employees VALUES (101,'John','IT',50000);
INSERT INTO Employees VALUES (102,'David','IT',60000);
INSERT INTO Employees VALUES (103,'Mary','HR',45000);
COMMIT;

SELECT * FROM Employees;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus IN NUMBER
)
IS 
BEGIN
  UPDATE Employees
  SET salary=salary+(salary*p_bonus/100)
  WHERE department=p_department;
  COMMIT;
END;
/
EXEC UpdateEmployeeBonus('IT',10);
SELECT * FROM Employees;