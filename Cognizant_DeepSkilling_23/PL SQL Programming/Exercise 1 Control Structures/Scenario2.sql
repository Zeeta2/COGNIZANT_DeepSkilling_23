--Scenario 2: A customer can be promoted to VIP status based on their balance.
-- o	Question: Write a PL/SQL block that iterates through all customers and sets
--a flag IsVIP to TRUE for those with a balance over $10,000.


CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(5)
);

INSERT INTO Customers
VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

INSERT INTO Customers
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'), 12000, SYSDATE, 'FALSE');

INSERT INTO Customers
VALUES (3, 'Mary Senior', TO_DATE('1950-01-01','YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');

COMMIT;

--BEFORE
SELECT CustomerID ,Name,Balance,IsVIP FROM Customers;
BEGIN
  FOR c IN(
    SELECT CustomerID,Balance
    FROM Customers
  )
  LOOP
    IF c.balance>10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID=c.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/
SELECT CustomerID ,Name,Balance,IsVIP FROM Customers;
