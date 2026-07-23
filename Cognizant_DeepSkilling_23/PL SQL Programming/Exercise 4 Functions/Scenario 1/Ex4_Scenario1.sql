USE BankDB;

DELIMITER //

CREATE FUNCTION CalculateAge(
    p_DOB DATE
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE v_age INT;

    SET v_age = TIMESTAMPDIFF(YEAR, p_DOB, CURDATE());

    RETURN v_age;
END //

DELIMITER ;
SELECT Name,
       DOB,
       CalculateAge(DOB) AS Age
FROM Customers;