class BankAccount:
    def __init__(self, int_rate, balance): 
        self.int_rate=int_rate
        self.balance=balance
    def deposit(self, amount):
        self.balance+=amount
        print(f"Balance:{self.balance}")
    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance -= amount
        else:self.balance-=5
        print(f"Balance:{self.balance}")
    def display_account_info(self):
        print(f"Balance:{self.balance}")
    def yield_interest(self):
        self.balance += self.balance * self.int_rate
        print(f"Balance:{self.balance}")
savings_account=BankAccount(0.01,100)
savings_account.deposit(50)
savings_account.withdraw(50)
savings_account.display_account_info()
savings_account.yield_interest()

