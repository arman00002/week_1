CREATE OR REPLACE PROCEDURE TransferFunds (
    senderAccountID   IN NUMBER,
    receiverAccountID IN NUMBER,
    amountToTransfer  IN NUMBER
) AS
    senderBalance NUMBER;
BEGIN
    SELECT Balance INTO senderBalance
    FROM Accounts
    WHERE AccountID = senderAccountID
    FOR UPDATE;

    IF senderBalance < amountToTransfer THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - amountToTransfer,
        LastModified = SYSDATE
    WHERE AccountID = senderAccountID;

    UPDATE Accounts
    SET Balance = Balance + amountToTransfer,
        LastModified = SYSDATE
    WHERE AccountID = receiverAccountID;

    COMMIT;
END;
/
