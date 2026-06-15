--Scenario 3: The bank wants to send reminders to customers whose loans are due within the 
--next 30 days.
-- o	Question: Write a PL/SQL block that fetches all loans due in the next 30 days 
--and prints a reminder message for each customer.

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Customers
VALUES (3, 'Mary Senior', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 2000, SYSDATE);

INSERT INTO Loans
VALUES (1, 1, 5000, 5, SYSDATE, SYSDATE + 40);

INSERT INTO Loans
VALUES (2, 2, 7000, 6, SYSDATE, SYSDATE + 20);

INSERT INTO Loans
VALUES (3, 3, 10000, 7, SYSDATE, SYSDATE + 10);

COMMIT;
SELECT * FROM Customers;
SELECT * FROM Loans;

SET SERVEROUTPUT ON;
BEGIN 
  FOR l IN(
    SELECT c.name,l.loanID,l.EndDate
    FROM Customers c
    JOIN Loans l
    ON c.customerID=l.customerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE+30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Remainder: Dear '||l.Name||
      ', your loan ID '||l.loanID||
      ' is due on '||l.EndDate
    );
  END LOOP;
END;
/
