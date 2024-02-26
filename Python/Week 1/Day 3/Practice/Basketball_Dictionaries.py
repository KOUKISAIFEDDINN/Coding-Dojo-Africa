class Player:
    def __init__(self, name, age, position, team):
        self.name = name
        self.age = age
        self.position = position
        self.team = team
    def display_info(self):
        print(f"{self.name} is{self.age} years old his postion is {self.position} and he played in {self.team}")
        return self
kevin=Player("Kevin Durant",34,"small forward","Brooklyn")
jason=Player("jasin Durant",44,"defend","Brooklyn")
kyrie = ("Kyrie Irving",32,"Point Guard", "Brooklyn Nets")

new_team=[]
new_team.append(kevin)
new_team.append(jason)
for team in new_team:
    team.display_info()


