# Place your imports here

class FibException(Exception):
    """A class to throw if you come across incorrect syntax or other issues"""

    def __init__(self, value):
        self.value = value

    def __str__(self):
        return repr(self.value)


class Fib(object):
    """
    a class for Fibonacci sequences.
    """

    def generate(self, n):
        """returning a Fibonacci sequence of given length n, starting with 0"""
        fibSeq = []
        x = 0
        y = 1

        for i in range(n):
            if i == 0:
                fibSeq.append(x)
            elif i == 1:
                fibSeq.append(y)
            else:
                z = x+y
                fibSeq.append(z)
                x = y
                y = z
        return fibSeq


    def isFib(self, nums):
        """
        return if a given list nums contains fibonacci sequence or not
        this function return true or false
        """
        fibSeq = []
        x = nums[0]
        y = nums[1]

        for i in range(len(nums)):
            if x != nums[i]:
                return False
            z = x + y
            x = y
            y = z
        return True

if __name__ == '__main__':
    myfib = Fib()

    #test cases
    #generate
    print(myfib.generate(3))
    print(myfib.generate(10))

    #isFib
    print(myfib.isFib([1,2,3]))
    print(myfib.isFib([1,1,2,2,6]))