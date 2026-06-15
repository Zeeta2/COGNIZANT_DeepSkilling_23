--Scenario 3: Customers should be able to transfer funds between their accounts.
--o Question: Write a stored procedure TransferFunds that transfers a specified amount 
--from one account to another, checking that the source account has sufficient balance 
--before making the transfer.

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
VALUES (101, 1, 'Savings', 10000, SYSDATE);

INSERT INTO Accounts
VALUES (102, 2, 'Savings', 5000, SYSDATE);

COMMIT;

SELECT * FROM Accounts;
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_source_acc IN NUMBER,
  P_target_acc IN NUMBER,
  p_amount IN NUMBER
)
IS 
v_bal NUMBER;
BEGIN
  SELECT balance
  INTO v_bal
  FROM Accounts
  WHERE AccountID=p_source_acc;
  IF v_bal>=p_amount THEN
    UPDATE Accounts
    SET Balance=Balance-p_amount
    WHERE AccountID=p_source_acc;

    UPDATE Accounts
    SET Balance=Balance+p_amount
    WHERE AccountID=P_target_acc;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer Successful');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
  END IF;
END;
/
SET SERVEROUTPUT ON;
EXEC TransferFunds(101,102,2000);
SELECT * FROM Accounts;
EXEC TransferFunds(101,102,9000);
SELECT * FROM Accounts;
