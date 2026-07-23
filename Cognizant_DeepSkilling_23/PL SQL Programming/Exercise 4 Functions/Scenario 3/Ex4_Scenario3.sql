USE BankDB;

SELECT DATABASE();
DROP FUNCTION IF EXISTS HasSufficientBalance;
DELIMITER //

CREATE FUNCTION HasSufficientBalance(
    p_AccountID INT,
    p_Amount DECIMAL(10,2)
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE v_Balance DECIMAL(10,2);

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
END //

DELIMITER ;
SELECT HasSufficientBalance(1,500);


SELECT HasSufficientBalance(2,500);