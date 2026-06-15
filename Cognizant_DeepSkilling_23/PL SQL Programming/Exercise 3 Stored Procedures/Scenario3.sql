--Scenario 3: Customers should be able to transfer funds between their accounts.
--o Question: Write a stored procedure TransferFunds that transfers a specified amount 
--from one account to another, checking that the source account has sufficient balance 
--before making the transfer.

CREATE TABLE Accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    balance NUMBER
);
INSERT INTO Accounts VALUES(101,'John',10000);
INSERT INTO Accounts VALUES(102,'David',5000);
INSERT INTO Accounts VALUES(103,'Mary',15000);
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
  WHERE account_id=p_source_acc;
  IF v_bal>=p_amount THEN
    UPDATE Accounts
    SET balance=balance-p_amount
    WHERE account_id=p_source_acc;

    UPDATE Accounts
    SET balance=balance+p_amount
    WHERE account_id=P_target_acc;
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
