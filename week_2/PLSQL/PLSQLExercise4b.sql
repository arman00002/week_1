CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  loanAmount NUMBER,
  annualInterestRate NUMBER,
  durationYears NUMBER
) RETURN NUMBER IS
  monthlyRate NUMBER := annualInterestRate / 12 / 100;
  months NUMBER := durationYears * 12;
  emi NUMBER;
BEGIN
  IF monthlyRate = 0 THEN
    emi := loanAmount / months;
  ELSE
    emi := loanAmount * monthlyRate * POWER(1 + monthlyRate, months) /
           (POWER(1 + monthlyRate, months) - 1);
  END IF;
  RETURN ROUND(emi, 2);
END;
/
