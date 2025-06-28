CREATE OR REPLACE FUNCTION HasSufficientBalance(
  p_accountId NUMBER,
  p_amount NUMBER
) RETURN BOOLEAN IS
  acc_balance NUMBER;
BEGIN
  SELECT Balance INTO acc_balance FROM Accounts WHERE AccountID = p_accountId;
  RETURN acc_balance >= p_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/
