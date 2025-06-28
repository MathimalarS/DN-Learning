CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20), 
    Balance NUMBER(10, 2)
);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (201, 1, 'Savings', 10000);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (202, 2, 'Savings', 15000);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (203, 3, 'Current', 8000);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance) VALUES (204, 1, 'Savings', 5000);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DepartmentID NUMBER,
    Salary NUMBER(10, 2)
);

INSERT INTO Employees (EmployeeID, Name, DepartmentID, Salary) VALUES (101, 'Arun Kumar', 10, 40000);
INSERT INTO Employees (EmployeeID, Name, DepartmentID, Salary) VALUES (102, 'Beena Nair', 10, 45000);
INSERT INTO Employees (EmployeeID, Name, DepartmentID, Salary) VALUES (103, 'Charles D', 20, 50000);
INSERT INTO Employees (EmployeeID, Name, DepartmentID, Salary) VALUES (104, 'Divya R', 20, 55000);

--Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error while processing interest: ' || SQLERRM);
END;
/

--Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_DepartmentID IN NUMBER,
  p_BonusPercent IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_BonusPercent / 100)
  WHERE DepartmentID = p_DepartmentID;

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Bonus applied to employees in department ' || p_DepartmentID);
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error updating bonus: ' || SQLERRM);
END;
/


--Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_FromAccountID IN NUMBER,
  p_ToAccountID IN NUMBER,
  p_Amount IN NUMBER
) IS
  v_FromBalance NUMBER;
BEGIN
  IF p_Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
  END IF;

  SELECT Balance INTO v_FromBalance
  FROM Accounts
  WHERE AccountID = p_FromAccountID;

  IF v_FromBalance < p_Amount THEN
    RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance in source account.');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_Amount
  WHERE AccountID = p_FromAccountID;

  UPDATE Accounts
  SET Balance = Balance + p_Amount
  WHERE AccountID = p_ToAccountID;

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END;
/

EXEC ProcessMonthlyInterest;

BEGIN
  UpdateEmployeeBonus(10, 10);
END;
/

BEGIN
  TransferFunds(201, 204, 2000);
END;
/


