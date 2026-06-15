--Scenario 1: The bank needs to process monthly interest for all savings accounts.
--Question: Write a stored procedure ProcessMonthlyInterest that calculates
-- and updates the balance of all savings accounts by applying an interest rate 
--of 1% to the current balance.

CREATE TABLE SavingsAccounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    balance NUMBER
);
INSERT INTO SavingsAccounts VALUES (101,'John',10000);
INSERT INTO SavingsAccounts VALUES (102,'David',20000);
INSERT INTO SavingsAccounts VALUES (103,'Mary',15000);
COMMIT;

SELECT * FROM SavingsAccounts;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
UPDATE SavingsAccounts
SET balance=balance+(balance*0.01);
COMMIT;
END;
/
EXEC ProcessMonthlyInterest;
SELECT * FROM SavingsAccounts;
EXEC ProcessMonthlyInterest;
SELECT * FROM SavingsAccounts;