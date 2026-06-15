--Scenario 2: The bank wants to implement a bonus scheme for employees based 
--on their performance.
--o	Question: Write a stored procedure UpdateEmployeeBonus that updates 
--the salary of employees in a given department by adding a bonus percentage 
--passed as a parameter.

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

INSERT INTO Employees
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15','YYYY-MM-DD'));

INSERT INTO Employees
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20','YYYY-MM-DD'));

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
  WHERE Department=p_department;
  COMMIT;
END;
/
EXEC UpdateEmployeeBonus('IT',10);
SELECT * FROM Employees;
