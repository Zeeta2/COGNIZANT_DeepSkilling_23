USE BankDB;

DELIMITER //

CREATE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount DECIMAL(10,2),
    p_InterestRate DECIMAL(5,2),
    p_Years INT
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE v_Installment DECIMAL(10,2);

    SET v_Installment =
    (p_LoanAmount + (p_LoanAmount * p_InterestRate * p_Years / 100))
    / (p_Years * 12);

    RETURN v_Installment;
END //

DELIMITER ;
SELECT LoanID,
       LoanAmount,
       InterestRate,
       CalculateMonthlyInstallment(LoanAmount, InterestRate, 5) AS MonthlyInstallment
FROM Loans;