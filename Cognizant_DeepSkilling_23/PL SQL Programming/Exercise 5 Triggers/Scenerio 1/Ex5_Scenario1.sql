USE BankDB;

DROP TRIGGER IF EXISTS UpdateCustomerLastModified;

DELIMITER //

CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    SET NEW.LastModified = NOW();
END //

DELIMITER ;
UPDATE Customers
SET Balance = 3000
WHERE CustomerID = 1;

SELECT * FROM Customers;