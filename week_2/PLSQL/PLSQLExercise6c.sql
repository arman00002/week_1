DECLARE
  CURSOR loan_cursor IS
    SELECT LoanID, InterestRate FROM Loans;

  v_loan_id Loans.LoanID%TYPE;
  v_interest Loans.InterestRate%TYPE;
  rate_increment CONSTANT NUMBER := 0.5;
BEGIN
  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO v_loan_id, v_interest;
    EXIT WHEN loan_cursor%NOTFOUND;

    UPDATE Loans
    SET InterestRate = v_interest + rate_increment
    WHERE LoanID = v_loan_id;
  END LOOP;
  CLOSE loan_cursor;
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error updating interest rates: ' || SQLERRM);
    ROLLBACK;
END;
/
