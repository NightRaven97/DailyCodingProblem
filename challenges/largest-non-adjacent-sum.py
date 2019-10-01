# 
# 
# This problem was asked by Airbnb.
# 
# Given a list of integers, 
# write a function that 
# returns the largest sum of non-adjacent numbers.
# Numbers can be 0 or negative.

# For example, 
# [2, 4, 6, 2, 5] should return 13, 
# since we pick 2, 6, and 5. 
# [5, 1, 1, 5] should return 10, 
# since we pick 5 and 5.
# 
# 

import math

def maximumNonAdjacentSum(array):
    
    if (len(array) == 1):
        return array[0]
    
    if (len(array) == 2):
        return max(array[0] , array[1])
    
    DP = [0]*len(array)
    DP[0] = array[0]
    DP[1] = max(array[0] , array[1])
    
    for i in range(2,len(array)):
    	
        DP[i] = max( array[i] , array[i] + DP[i-2] , DP[i-1])
        print(DP)

    return DP[len(array) - 1]

# Outputs 
maximumNonAdjacentSum([2])
# 2

maximumNonAdjacentSum([2,3])
# 3

print(maximumNonAdjacentSum([2,4,6,2,5]))
# [2, 4, 8, 0, 0]
# [2, 4, 8, 8, 0]
# [2, 4, 8, 8, 13]
# 13

print(maximumNonAdjacentSum([5,1,1,5]))
# [5, 5, 6, 0]
# [5, 5, 6, 10]
# 10
