--Scenario 1: The bank needs to process monthly interest for all savings accounts.
--Question: Write a stored procedure ProcessMonthlyInterest that calculates
-- and updates the balance of all savings accounts by applying an interest rate 
--of 1% to the current balance.

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers
VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts
VALUES (2, 2, 'Checking', 1500, SYSDATE);

COMMIT;

SELECT * FROM Accounts;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
UPDATE Accounts
SET Balance=Balance+(Balance*0.01),LastModified=SYSDATE
    WHERE AccountType='Savings';
COMMIT;
END;
/
EXEC ProcessMonthlyInterest;
SELECT * FROM Accounts;
