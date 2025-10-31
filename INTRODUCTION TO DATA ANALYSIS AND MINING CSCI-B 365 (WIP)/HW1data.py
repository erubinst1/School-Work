# Place your imports here
import numpy as np
import pandas as pd
import random 

class MiniData(object):
    """a class for basic data operation"""
    def toyList(self, n):
        """
        return a python list of n numbers in this pattern: 1, 2, 4, 7, 11, 16, ...\
        """
        patternList = []
        nextNum = 1
        for i in range(0, n):
            if(i == 0):
                patternList.append(nextNum)
            else:
                patternList.append(patternList[i-1]+nextNum)
                nextNum += 1
            
        
        return patternList

    def toyVector(self):
        """
        create a vector containing the following numbers: (1,4,5,7,9,10) 
        and return it as a numpy array
        """
        return np.array([1, 4, 5, 7, 9, 10])

    def toyMatrix(self, n, m):
        """
        generate a toy matrix of n by m integers in the range of [0, 100] and return the matrix as a numpy array of nxm.
        use random module to generate the integers randomly 
        """ 
        matrix = [[random.randint(0, 100) for i in range(m)] for j in range(n)]
    
        return np.array(matrix)

    def toyDataframe(self):
        """
        create a toy dataset and represent it using Pandas dataframe, return the dataframe
        it contains 10 people (objects) with three attributes, 'Refund', 'Marital Status' and 'Taxable Income'
        again using random to generate values for these attributes, 
            'Refund' can be 'Yes' or 'No', 
            'Marital Status' can be 'Married', 'Single', or 'Divorced'
            'Taxable Income' is an integer in the range of [50, 500] (50 represents 50k etc)
        """ 
        refunds = [random.choice(['Yes', 'No']) for i in range(10)]
        marital_status = [random.choice(['Married', 'Single', 'Divorced']) for j in range(10)]
        taxable_income = [random.randint(50, 500) for k in range(10)]

        data = {
            'Refund': refunds,
            'Marital Status': marital_status,
            'Taxable Income': taxable_income
        }

        return pd.DataFrame(data)

class Ritz(object):
    def __init__(self):
        self.better = 1.5

    def majority(self, nums):
        """
        the input nums is a list containing the speedup numbers; 
        if more than half of the numbers in nums are equal to or greater than self.better
        the algorithm is considered to be faster so this function returns 'faster', otherwise 'no improvement'
        """
        count = sum(1 for n in nums if n >= self.better)
        if count > len(nums) / 2:
            return 'faster'
        else:
            return 'no improvement'
    
    def meanBased(self, nums, mean="arithmetic"):
        """
        this function implements a different approach for evaluating the speedups. 
        if the mean of the speedups is equal to or great than self.better, 
        the function returns 'faster', otherwise, 'no improvement'
        mean can be either 'arithmetic' or 'geometric', which specifies the approach for computing the mean
        """
        if mean == "arithmetic":
            avg = sum(nums) / len(nums)
        elif mean == "geometric":
            product = 1
            for n in nums:
                product *= n
            avg = product ** (1 / len(nums))
        return "faster" if avg >= self.better else "no improvement"

if __name__ == '__main__':
    md = MiniData()
    #print(md.toyDataframe())

    t = Ritz()
    nums = [2.0, 0.5, 1.0, 2.0, 100]
    #print(t.majority(nums)) #faster
    #print(t.meanBased(nums)) #faster
    #print(t.meanBased(nums, mean="geometric")) #faster

    #toyList
    print("toyList \n")
    print(md.toyList(0))
    print(md.toyList(6))
    print("\n")

    #toyVector
    print("toyVector \n")
    print(md.toyVector())
    print("\n")

    #toyMatrix
    print("toyMatrix \n")
    print(md.toyMatrix(2,2))
    print(md.toyMatrix(5,5))
    print("\n")

    #toyDataframe
    print("toyDataframe \n")
    print(md.toyDataframe())
    print("\n")

    #majority
    print("majority \n")
    r = Ritz()
    print(r.majority([1.2, 1.6, 1.8, 1.1, 2.0]))  
    # Output: faster  (3 out of 5 are >= 1.5)

    print(r.majority([1.0, 1.2, 1.3, 1.4, 1.1]))  
    # Output: no improvement  (0 out of 5 are >= 1.5)
    print("\n")

    #Meanbased
    print("meanbased \n")
    r = Ritz()
    print(r.meanBased([1.2, 1.6, 1.8], mean="arithmetic"))
    # Output: faster  (arithmetic mean ≈ 1.53)

    print(r.meanBased([1.2, 1.6, 1.8], mean="geometric"))
    # Output: faster  (geometric mean ≈ 1.52)

    print(r.meanBased([1.0, 1.2, 1.3], mean="arithmetic"))
    # Output: no improvement

    print("\n")
