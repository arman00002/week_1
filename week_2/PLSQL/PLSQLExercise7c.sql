CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_acc_id NUMBER);
  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_acc_id, p_cust_id, p_type, p_balance, SYSDATE);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Account ID already exists.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Failed to open account: ' || SQLERRM);
  END;

  PROCEDURE CloseAccount(p_acc_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_acc_id;
    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No account found to close.');
    END IF;
  END;

  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT NVL(SUM(Balance), 0)
    INTO v_total
    FROM Accounts
    WHERE CustomerID = p_cust_id;
    RETURN v_total;
  END;

END AccountOperations;
/
