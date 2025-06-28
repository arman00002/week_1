CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  current_balance NUMBER;
BEGIN
  SELECT Balance INTO current_balance FROM Accounts WHERE AccountID = :NEW.AccountID;

  IF UPPER(:NEW.TransactionType) = 'WITHDRAWAL' THEN
    IF :NEW.Amount > current_balance THEN
      RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds current balance.');
    END IF;
  ELSIF UPPER(:NEW.TransactionType) = 'DEPOSIT' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
  ELSE
    RAISE_APPLICATION_ERROR(-20003, 'Invalid transaction type.');
  END IF;
END;
/
