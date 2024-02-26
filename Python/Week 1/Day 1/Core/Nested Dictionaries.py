x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]
x = [[5, 2, 3], [10, 8, 9]]
x[1][0] = 15  
students[0]['last_name'] = 'Bryant'
sports_directory['soccer'][0] = 'Andres'
z[0]['y'] = 30 


#2
def iterateDictionary(list):
    for dictionary in list:
        for key, value in dictionary.items():
            print(f"{key} - {value}", end=", ")
        
students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'},
    {'first_name': 'Mark', 'last_name': 'Guillen'},
    {'first_name': 'KB', 'last_name': 'Tonel'}
]
iterateDictionary(students)

#3
def iterateDictionary2(key_name, some_list):
    for i in some_list:
        print(i[key_name])
print("First names:")
iterateDictionary2('first_name', students)
print("Last names:")
iterateDictionary2('last_name', students)

#4(im not sure)
def printInfo(some_dict):
    for key, value in some_dict.items():
        print(f"{len(value)},{key}")
        for item in value:
            print(item)
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
printInfo(dojo)