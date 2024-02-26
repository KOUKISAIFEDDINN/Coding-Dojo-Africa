class Ninja:
    def __init__(self,first_name , last_name , treats , pet_food , pet) :
        self.first_name=first_name
        self.last_name =last_name 
        self.treats=treats
        self.pet_food=pet_food
        self.pet=pet
    def walk(self ):
        self.pet.play()
    def feed(self):
        self.pet.eat()
    def bathe(self):
        self.pet.noise()

class Pet:
    def __init__(self,name,type,tricks):
        self.namee=name
        self.type=type
        self.tricks=tricks
        self.health=20
        self.energy=0
    def sleep(self):
        self.energy+=25
        print(f"THE ENERGY IS{self.energy}")
    def eat(self):
        self.energy+=5
        self.health+=10
    def play(self):
        self.health+=5
    def noise(self):
        print(self.tricks)
ninja1=Pet("div","edd","eeee")
