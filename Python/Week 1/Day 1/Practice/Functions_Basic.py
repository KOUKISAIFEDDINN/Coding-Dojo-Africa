#1
def countdown(n):
    return list(range(n,0,-1))
print(countdown(9)) 

#2
def value(num):
    print(num[0])
    return num[1]
result = value([1, 9])
print(result)

#3
def listnum(num):
    return num[0] + len(num)
result = listnum([1, 2, 3, 4, 5])
print(result)  

#4 
def first_greater(lst):
    if len(lst) < 2:
        return False
    
    second_value = lst[1]
    pass
#5