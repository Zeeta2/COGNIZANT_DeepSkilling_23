CREATE TABLE Customers(
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER
);

CREATE TABLE Loans(
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);
INSERT INTO Customers VALUES (1, 'John', 45);
INSERT INTO Customers VALUES (2, 'David', 65);
INSERT INTO Customers VALUES (3, 'Mary', 70);

INSERT INTO Loans VALUES (101, 1, 10);
INSERT INTO Loans VALUES (102, 2, 10);
INSERT INTO Loans VALUES (103, 3, 12);
--TABLE BEFORE CHANGE
SELECT * FROM Loans;
--SCENARIO 1
COMMIT;
BEGIN 
  FOR c IN (
    SELECT customer_id,name,age
    FROM Customers
    )
  LOOP
    IF c.age > 60 THEN
      UPDATE Loans
      SET interest_rate=interest_rate-1
      WHERE customer_id=c.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/
--TABLE AFTER CHANGE
SELECT * FROM Loans;