class user:
    def __init__(self,first_name,last_name,email,age) :
        self.first_name=first_name
        self.last_name=last_name
        self.email=email
        self.age=age
        self.is_rewards_member = False
        self.gold_card_points = 0
    def display_info(self):
        print(f"{self.first_name} {self.last_name} is {self.age} years old, and the email is {self.email}")
    def enroll(self):
        self.is_rewards_member=True
        self.gold_card_points=200
        print(f"{self.first_name} {self.last_name} is {self.age} years old, and their breed is {self.email}")
    def spend_points(self, amount):
        self.gold_card_points -= amount
        print(f"{self.first_name} {self.last_name} is {self.age} years old, and their breed is {self.email},he spend{self.gold_card_points}")
first_user= user("saif", "kouki","koukisaif2003@gmail.com",20)
second_user= user("saif", "kouki","koukisaif2003@gmail.com",20)
first_user.display_info()
print('='*44)
first_user.enroll()
print('='*44)
first_user.spend_points(150)
print('='*44)
second_user.display_info()
print('='*44)
second_user.enroll()
print('='*44)
second_user.spend_points(120)
print('='*44)
