-- Enable server output
SET SERVEROUTPUT ON;



-- Create tables
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance INT,
    LastModified DATE,
    IsVIP CHAR(1)
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR2(20),
    Balance INT,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount INT,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount INT,
    InterestRate INT,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary INT,
    Department VARCHAR2(50),
    DepartmentID INT,
    HireDate DATE
);




-- Create ErrorLogs table for logging errors
CREATE TABLE ErrorLogs (
    ErrorID INT PRIMARY KEY,
    ErrorMessage VARCHAR2(255),
    ErrorDate DATE
);






INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'Jane', TO_DATE('1963-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jhon Doe', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 5, SYSDATE, SYSDATE + 25);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));







-- SCENARIO - 1
-- Procedure to Process Monthly Interest for All Savings Accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_rows_updated NUMBER;
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';

    v_rows_updated := SQL%ROWCOUNT;

    DBMS_OUTPUT.PUT_LINE('Number of accounts updated: ' || v_rows_updated);
END ProcessMonthlyInterest;
/






-- SCENARIO -2 
-- Procedure to Update Employee Bonus Based on Performance
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    departmentID IN INT,
    bonusPercentage IN DECIMAL
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonusPercentage / 100))
    WHERE DepartmentID = departmentID;
END UpdateEmployeeBonus;
/







-- SCENARIO - 3
-- Procedure to Transfer Funds Between Accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAccountID IN INT,
    toAccountID IN INT,
    amount IN DECIMAL
) IS
BEGIN
    DECLARE
        insufficientFunds EXCEPTION;
        PRAGMA EXCEPTION_INIT(insufficientFunds, -20001);

    BEGIN
        SAVEPOINT start_trans;

        DECLARE
            from_balance INT;
        BEGIN
            SELECT Balance INTO from_balance
            FROM Accounts
            WHERE AccountID = fromAccountID;
            
            IF from_balance < amount THEN
                RAISE insufficientFunds;
            END IF;
        END;

        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAccountID;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAccountID;

        COMMIT;
    EXCEPTION
        WHEN insufficientFunds THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('Insufficient funds for transfer from AccountID: ' || fromAccountID, SYSDATE);
            ROLLBACK TO start_trans;
        WHEN OTHERS THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('SQL Error during transfer from AccountID: ' || fromAccountID || ' to AccountID: ' || toAccountID, SYSDATE);
            ROLLBACK TO start_trans;
    END;
END TransferFunds;
/










-- Example calls for the procedures
BEGIN
    ProcessMonthlyInterest;
END;
/

BEGIN
    UpdateEmployeeBonus(1, 10.00);
END;
/

BEGIN
    TransferFunds(1, 2, 100.00);
END;
/
