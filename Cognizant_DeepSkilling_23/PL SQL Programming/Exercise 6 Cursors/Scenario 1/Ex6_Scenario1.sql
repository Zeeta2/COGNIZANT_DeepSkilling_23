USE BankDB;

DROP PROCEDURE IF EXISTS GenerateMonthlyStatements;

DELIMITER //

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_Name VARCHAR(100);
    DECLARE v_TransactionID INT;
    DECLARE v_Amount DECIMAL(10,2);
    DECLARE v_TransactionType VARCHAR(10);

    DECLARE cur CURSOR FOR
        SELECT c.Name,
               t.TransactionID,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE MONTH(t.TransactionDate) = MONTH(CURDATE())
          AND YEAR(t.TransactionDate) = YEAR(CURDATE());

    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;

    OPEN cur;

    read_loop: LOOP

        FETCH cur
        INTO v_Name,
             v_TransactionID,
             v_Amount,
             v_TransactionType;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT(
            'Customer: ', v_Name,
            ', Transaction ID: ', v_TransactionID,
            ', Amount: ', v_Amount,
            ', Type: ', v_TransactionType
        ) AS MonthlyStatement;

    END LOOP;

    CLOSE cur;

END //

DELIMITER ;


CALL GenerateMonthlyStatements();