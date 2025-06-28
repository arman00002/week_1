SET SERVEROUTPUT ON;

BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID ||
                             ' for ' || loan_rec.Name ||
                             ' is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/
