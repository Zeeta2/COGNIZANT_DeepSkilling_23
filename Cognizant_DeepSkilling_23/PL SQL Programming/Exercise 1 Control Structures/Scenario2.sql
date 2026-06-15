--Scenario 2: A customer can be promoted to VIP status based on their balance.
-- o	Question: Write a PL/SQL block that iterates through all customers and sets
--a flag IsVIP to TRUE for those with a balance over $10,000.

CREATE TABLE Customers(
  Customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(50),
  balance NUMBER,
  IsVIP VARCHAR2(5)
);
INSERT INTO Customers VALUES(1,'John',8000,'FALSE');
INSERT INTO Customers VALUES(2,'Mary',12000,'FALSE');
INSERT INTO Customers VALUES(3,'David',15000,'FALSE');

--BEFORE
SELECT * FROM Customers;
BEGIN
  FOR c IN(
    SELECT Customer_id,balance
    FROM Customers
  )
  LOOP
    IF c.balance>10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE Customer_id=c.Customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/
SELECT * FROM Customers;
