--Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
--Question: Write a PL/SQL block that loops through all customers, checks their age, 
--and if they are above 60, apply a 1% discount to their current loan interest rates.

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
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans
VALUES (2, 2, 7000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 48));

INSERT INTO Loans
VALUES (3, 3, 10000, 7, SYSDATE, ADD_MONTHS(SYSDATE, 36));

COMMIT;
SELECT * FROM Loans;
BEGIN 
  FOR c IN (
    SELECT customerID,Name,DOB
    FROM Customers
    )
  LOOP
    IF MONTHS_BETWEEN(SYSDATE,c.DOB)/12 > 60 THEN
      UPDATE Loans
      SET InterestRate=InterestRate-1
      WHERE CustomerID=c.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/
--TABLE AFTER CHANGE
SELECT * FROM Loans;

