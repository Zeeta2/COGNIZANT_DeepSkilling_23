CREATE TABLE Customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(50)
);

CREATE TABLE Loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

INSERT INTO Customers VALUES (1,'John');
INSERT INTO Customers VALUES (2,'David');
INSERT INTO Customers VALUES (3,'Mary');

INSERT INTO Loans VALUES (101,1,SYSDATE+40);
INSERT INTO Loans VALUES (102,2,SYSDATE+20);
INSERT INTO Loans VALUES (103,3,SYSDATE+10);
SELECT * FROM Customers;
SELECT * FROM Loans;
COMMIT;

SET SERVEROUTPUT ON;
BEGIN 
  FOR l IN(
    SELECT c.name,l.loan_id,l.due_date
    FROM Customers c
    JOIN Loans l
    ON c.customer_id=l.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE+30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Remainder: Dear '||l.name||
      ', your loan ID '||l.loan_id||
      ' is due on '||l.due_date
    );
  END LOOP;
END;
/