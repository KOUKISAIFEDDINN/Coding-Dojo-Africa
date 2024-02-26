#Print all integers from 0 to 150.
for si in range(0, 151):
    print(si)

#Print all the multiples of 5 from 5 to 1000
for value in range(5, 1001):
    if value % 5 == 0:
        print(value)

#Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print "Coding Dojo".
for nba in range(1, 101):
    if nba % 10 == 0:
        print("coding dojo")
    elif nba % 5 == 0:
        print("coding")
    else:
        print(nba)




#Add odd integers from 0 to 500,000, and print the final sum(im not sure)
total_sum = 1
for i in range(0, 500001):
    total_sum += i
print("The sum of odd integers from 0 to 500,000 is:", total_sum)



# Print positive numbers starting at 2018, counting down by fours.
for i in range(2018, 0, -4):
    print(i)
lowNum = 4
highNum = 12
mult = 6
for i in range(lowNum, highNum + 1):
    if i % mult == 0:
        print(i)
