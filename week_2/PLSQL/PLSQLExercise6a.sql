DECLARE
  CURSOR txn_cursor IS
    SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
    ORDER BY c.CustomerID;

  v_customer_id Customers.CustomerID%TYPE;
  v_name Customers.Name%TYPE;
  v_date Transactions.TransactionDate%TYPE;
  v_amount Transactions.Amount%TYPE;
  v_type Transactions.TransactionType%TYPE;
BEGIN
  OPEN txn_cursor;
  LOOP
    FETCH txn_cursor INTO v_customer_id, v_name, v_date, v_amount, v_type;
    EXIT WHEN txn_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' | Date: ' || v_date ||
                         ' | Type: ' || v_type || ' | Amount: ' || v_amount);
  END LOOP;
  CLOSE txn_cursor;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error generating statements: ' || SQLERRM);
END;
/
