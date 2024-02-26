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
        return self
    def enroll(self):
        self.is_rewards_member=True
        self.gold_card_points=200
        print(f"{self.first_name} {self.last_name} is {self.age} years old, and their breed is {self.email}")
        return self
    def spend_points(self, amount):
        self.gold_card_points -= amount
        print(f"{self.first_name} {self.last_name} is {self.age} years old, and their breed is {self.email},he spend{self.gold_card_points}")
        return self
user1= user("saif", "kouki","koukisaif2003@gmail.com",20)
user2= user("saif", "kouki","koukisaif2003@gmail.com",20)
user1.display_info().enroll().spend_points(50).display_info()
user2.enroll().spend_points(80).display_info()

