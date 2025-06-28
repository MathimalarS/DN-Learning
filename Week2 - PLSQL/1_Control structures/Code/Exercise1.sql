--SCENARIO 1
BEGIN
  FOR rec IN (SELECT * FROM Customers WHERE Age > 60) LOOP
    UPDATE Customers
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = rec.CustomerID;
  END LOOP;
  COMMIT;
END;
/

--SCENARIO 2
BEGIN
  FOR rec IN (SELECT * FROM Customers WHERE Balance > 10000) LOOP
    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE CustomerID = rec.CustomerID;
  END LOOP;
  COMMIT;
END;
/

--SCENARIO 3
BEGIN
  FOR rec IN (
    SELECT L.LoanID, C.Name, L.DueDate
    FROM Loans L
    JOIN Customers C ON C.CustomerID = L.CustomerID
    WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for ' || rec.Name || ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/


SELECT * FROM Customers;
SELECT * FROM Loans;
