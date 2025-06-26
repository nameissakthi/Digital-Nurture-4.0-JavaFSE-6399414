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
    DepartmentID INT,
    HireDate DATE
);

CREATE TABLE ErrorLogs (
    ErrorID INT PRIMARY KEY,
    ErrorMessage VARCHAR2(255),
    ErrorDate DATE
);



INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1963-05-15', 'YYYY-MM-DD'), 1000, SYSDATE, 'N');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE, 'Y');

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

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, DepartmentID, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', 1, TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, DepartmentID, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', 2, TO_DATE('2017-03-20', 'YYYY-MM-DD'));






CREATE OR REPLACE PROCEDURE AddCustomer(
    p_CustomerID IN INT, 
    p_Name IN VARCHAR2, 
    p_DOB IN DATE, 
    p_Balance IN DECIMAL
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP) 
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE, 'N');
    
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) 
    VALUES (p_CustomerID, p_CustomerID, 'Savings', p_Balance, SYSDATE);
END;
/

CREATE OR REPLACE PROCEDURE UpdateCustomerDetails(
    p_CustomerID IN INT, 
    p_Name IN VARCHAR2, 
    p_DOB IN DATE
) AS
BEGIN
    UPDATE Customers
    SET Name = p_Name, DOB = p_DOB, LastModified = SYSDATE
    WHERE CustomerID = p_CustomerID;
END;
/

CREATE OR REPLACE FUNCTION GetCustomerBalance(
    p_CustomerID IN INT
) 
RETURN DECIMAL IS
    v_balance DECIMAL(10, 2);
BEGIN
    SELECT SUM(Balance) INTO v_balance
    FROM Accounts
    WHERE CustomerID = p_CustomerID;

    RETURN v_balance;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
/








CREATE OR REPLACE PROCEDURE HireEmployee(
    p_EmployeeID IN INT, 
    p_Name IN VARCHAR2, 
    p_Position IN VARCHAR2, 
    p_Salary IN DECIMAL, 
    p_Department IN VARCHAR2, 
    p_DepartmentID IN INT, 
    p_HireDate IN DATE
) AS
BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, DepartmentID, HireDate) 
    VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_DepartmentID, p_HireDate);
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeDetails(
    p_EmployeeID IN INT, 
    p_Name IN VARCHAR2, 
    p_Position IN VARCHAR2, 
    p_Salary IN DECIMAL
) AS
BEGIN
    UPDATE Employees
    SET Name = p_Name, Position = p_Position, Salary = p_Salary
    WHERE EmployeeID = p_EmployeeID;
END;
/

CREATE OR REPLACE FUNCTION CalculateAnnualSalary(
    p_EmployeeID IN INT
) 
RETURN DECIMAL IS
    v_annualSalary DECIMAL(10, 2);
BEGIN
    SELECT Salary * 12 INTO v_annualSalary
    FROM Employees
    WHERE EmployeeID = p_EmployeeID;

    RETURN v_annualSalary;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
/








CREATE OR REPLACE PROCEDURE OpenAccount(
    p_CustomerID IN INT, 
    p_AccountType IN VARCHAR2, 
    p_Balance IN DECIMAL
) AS
    v_AccountID INT;
BEGIN
    SELECT NVL(MAX(AccountID), 0) + 1 INTO v_AccountID FROM Accounts;
    
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) 
    VALUES (v_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
END;
/

CREATE OR REPLACE PROCEDURE CloseAccount(
    p_AccountID IN INT
) AS
BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_AccountID;
END;
/

CREATE OR REPLACE FUNCTION GetTotalBalance(
    p_CustomerID IN INT
) 
RETURN DECIMAL IS
    v_totalBalance DECIMAL(10, 2);
BEGIN
    SELECT SUM(Balance) INTO v_totalBalance
    FROM Accounts
    WHERE CustomerID = p_CustomerID;

    RETURN v_totalBalance;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
/









BEGIN
    AddCustomer(3, 'Sam Wilson', TO_DATE('1985-09-25', 'YYYY-MM-DD'), 1200);
    
    UpdateCustomerDetails(3, 'Samuel Wilson', TO_DATE('1985-09-25', 'YYYY-MM-DD'));
    
    DBMS_OUTPUT.PUT_LINE('Customer Balance: ' || GetCustomerBalance(3));
    
    HireEmployee(3, 'Charlie Green', 'Analyst', 50000, 'Finance', 3, TO_DATE('2020-02-10', 'YYYY-MM-DD'));
    
    UpdateEmployeeDetails(3, 'Charles Green', 'Senior Analyst', 60000);
    
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || CalculateAnnualSalary(3));
    
    OpenAccount(3, 'Savings', 1200);
    
    CloseAccount(3);
    
    DBMS_OUTPUT.PUT_LINE('Total Balance: ' || GetTotalBalance(3));
END;
/
