DECLARE
  CURSOR account_cursor IS
    SELECT AccountID, Balance FROM Accounts;

  v_account_id Accounts.AccountID%TYPE;
  v_balance Accounts.Balance%TYPE;
  annual_fee CONSTANT NUMBER := 100;
BEGIN
  OPEN account_cursor;
  LOOP
    FETCH account_cursor INTO v_account_id, v_balance;
    EXIT WHEN account_cursor%NOTFOUND;

    IF v_balance >= annual_fee THEN
      UPDATE Accounts
      SET Balance = Balance - annual_fee,
          LastModified = SYSDATE
      WHERE AccountID = v_account_id;
    ELSE
      DBMS_OUTPUT.PUT_LINE('Account ' || v_account_id || ' has insufficient balance for annual fee.');
    END IF;
  END LOOP;
  CLOSE account_cursor;
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error applying annual fee: ' || SQLERRM);
    ROLLBACK;
END;
/
