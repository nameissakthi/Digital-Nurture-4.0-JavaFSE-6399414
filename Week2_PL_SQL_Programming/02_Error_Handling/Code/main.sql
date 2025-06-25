SET SERVEROUTPUT ON;



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
    HireDate DATE
);

CREATE TABLE ErrorLogs (
    ErrorID INT PRIMARY KEY,
    ErrorMessage VARCHAR2(255),
    ErrorDate DATE
);








INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

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

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));






-- Procedure to Apply Interest Discount to Customers Above 60 Years Old
CREATE OR REPLACE PROCEDURE ApplyInterestDiscount IS
    CURSOR cur IS
        SELECT CustomerID, DOB FROM Customers;
    
    cur_CustomerID Customers.CustomerID%TYPE;
    cur_DOB Customers.DOB%TYPE;
    currentDATE DATE := SYSDATE;
BEGIN
    FOR customer_rec IN cur LOOP
        IF MONTHS_BETWEEN(currentDATE, customer_rec.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
END ApplyInterestDiscount;
/







-- Procedure to Promote Customers to VIP Status Based on Balance
CREATE OR REPLACE PROCEDURE PromoteToVIP IS
    CURSOR cur IS
        SELECT CustomerID, Balance FROM Accounts;
    
    cur_CustomerID Accounts.CustomerID%TYPE;
    cur_Balance Accounts.Balance%TYPE;
BEGIN
    FOR account_rec IN cur LOOP
        IF account_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = account_rec.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = account_rec.CustomerID;
        END IF;
    END LOOP;
END PromoteToVIP;
/






-- Procedure to Send Loan Reminders for Loans Due Within the Next 30 Days
CREATE OR REPLACE PROCEDURE SendLoanReminders IS
    CURSOR cur IS
        SELECT CustomerID, EndDate 
        FROM Loans 
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    
    cur_CustomerID Loans.CustomerID%TYPE;
    cur_EndDate Loans.EndDate%TYPE;
BEGIN
    FOR loan_rec IN cur LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD') || ' for CustomerID: ' || loan_rec.CustomerID);
    END LOOP;
END SendLoanReminders;
/







-- Procedure to Handle Exceptions During Fund Transfers Between Accounts
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
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
                DBMS_OUTPUT.PUT_LINE('Insufficient Funds Available');
                RAISE insufficientFunds;
            END IF;
        END;

        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAccountID;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAccountID;
        DBMS_OUTPUT.PUT_LINE('Funds transferred safely..!!');
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
END SafeTransferFunds;
/







-- Procedure to Manage Errors When Updating Employee Salaries
CREATE OR REPLACE PROCEDURE UpdateSalary(
    empID IN INT,
    percentageIncrease IN DECIMAL
) IS
BEGIN
    DECLARE
        empNotFound EXCEPTION;
        PRAGMA EXCEPTION_INIT(empNotFound, -20001);

    BEGIN
        SAVEPOINT start_trans;

        UPDATE Employees 
        SET Salary = Salary + (Salary * (percentageIncrease / 100))
        WHERE EmployeeID = empID;
        DBMS_OUTPUT.PUT_LINE('Employee salary increased by ' || percentageIncrease || ' percentage');
        IF SQL%ROWCOUNT = 0 THEN
            RAISE empNotFound;
        END IF;
        
        COMMIT;
    EXCEPTION
        WHEN empNotFound THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('Employee ID does not exist: ' || empID, SYSDATE);
            DBMS_OUTPUT.PUT_LINE('Employee ID does not exist!!');
            ROLLBACK TO start_trans;
        WHEN OTHERS THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('Error updating salary for EmployeeID: ' || empID, SYSDATE);
            ROLLBACK TO start_trans;
    END;
END UpdateSalary;
/








-- Procedure to Ensure Data Integrity When Adding a New Customer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    CusID IN NUMBER,
    CusName IN VARCHAR2,
    CusDOB IN DATE,
    CusBalance IN NUMBER,
    CusLastModified IN DATE
)
IS
  Invalid_Customer_ID EXCEPTION;
  Customer_Count NUMBER;
BEGIN
  SELECT count(*) INTO Customer_Count FROM Customers WHERE CustomerID = CusID;
  
  IF Customer_Count > 0 THEN
    RAISE Invalid_Customer_ID;
  END IF;
  
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (CusID, CusName, CusDOB, CusBalance, CusLastModified);
  
  DBMS_OUTPUT.PUT_LINE('Customer registered Successfully!!');
  
EXCEPTION
  WHEN Invalid_Customer_ID THEN
    DBMS_OUTPUT.PUT_LINE('Invalid Customer ID');
END;
/











-- Call the procedures
BEGIN
    ApplyInterestDiscount;
END;
/

BEGIN
    PromoteToVIP;
END;
/

BEGIN
    SendLoanReminders;
END;
/




BEGIN
    SafeTransferFunds(1, 2, 100.00);
END;
/

BEGIN
    UpdateSalary(1, 10.00);
END;
/

BEGIN
    AddNewCustomer(CusID => 1, CusName => 'SAKTHIVEL', CusDOB => SYSDATE, CusBalance => 5000, CusLastModified => SYSDATE);
END;
/
