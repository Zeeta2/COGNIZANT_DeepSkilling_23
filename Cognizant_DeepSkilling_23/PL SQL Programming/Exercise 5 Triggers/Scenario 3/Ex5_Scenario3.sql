USE BankDB;

DROP TRIGGER IF EXISTS CheckTransactionRules;

DELIMITER //

CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    DECLARE v_Balance DECIMAL(10,2);

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = NEW.AccountID;

    IF NEW.TransactionType = 'Withdrawal' AND NEW.Amount > v_Balance THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient Balance';
    END IF;

    IF NEW.TransactionType = 'Deposit' AND NEW.Amount <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Deposit Amount Must Be Greater Than Zero';
    END IF;
END //

DELIMITER ;

INSERT INTO Transactions
VALUES (4,1,NOW(),500,'Deposit');

SELECT * FROM Transactions;


INSERT INTO Transactions
VALUES (5,1,NOW(),10000,'Withdrawal');


INSERT INTO Transactions
VALUES (6,1,NOW(),-100,'Deposit');