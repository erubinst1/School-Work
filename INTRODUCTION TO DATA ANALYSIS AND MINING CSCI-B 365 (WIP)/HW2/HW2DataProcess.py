import math

class DataProcessor(object):
    """
    a class for basic data operations & processing
    in the following functions, x and y are python lists representing data objects
    """
    def summary(self, x):
        """
        input: x, a python list
        output/return: a tuple of three numbers: mean, median, variance (using ddof = 1)
        for median, you will use a slow algorithm that first sorts the input list; 
        if the number of numbers in x is odd, the median is the middle one in the sorted list; 
        otherwise, the median is an average of the middle two numbers.
        """
        mean = sum(x) / len(x)
        
        x.sort()
        if len(x) % 2 == 0:
            mid = len(x) // 2
            median = (x[mid - 1] + x[mid]) / 2
        else:
            median = x[len(x) // 2]
        
        squaredDiffs = [(n - mean) ** 2 for n in x]
        variance = sum(squaredDiffs) / (len(x) - 1)

        return (mean, median, variance)

    def dot(self, x, y):
        """
        input: python lists x and y
        output/return: dot product of x and y 
        """
        acc = 0
        for i in range (len(x)):
            acc += x[i] * y[i]
        return acc

    def cov(self, x, y):
        """
        input: python lists x and y
        output/return: covariance between x and y 
        use ddof = 1
        """
        meanX = sum(x) / len(x)
        meanY = sum(y) / len(y)

        cov = sum((x[i] - meanX) * (y[i] - meanY) for i in range(len(x))) / (len(x) - 1)
        return cov

    def corr(self, x, y):
        """
        input: python lists x and y
        output/return: the Pearson correlation coefficient between x and y
        use cov() and summary() to complete this function
        """ 
        import math
        if len(x) != len(y) or len(x) < 2:
            return float('nan')  # or raise ValueError

        # use copies so summary() doesn't mutate the originals
        var_x = self.summary(x[:])[2]
        var_y = self.summary(y[:])[2]

        sx = math.sqrt(var_x)
        sy = math.sqrt(var_y)
        if sx == 0 or sy == 0:
            return float('nan')

        return self.cov(x, y) / (sx * sy)

    def SMC(self, x, y):
        """
        input: python lists x and y of 0 and 1s (representing binary vectors)
        output/return: simple match score
        """
        matches = sum(1 for i in range(len(x)) if x[i] == y[i])
        return matches / len(x)

    def Jaccard(self, x, y):
        """
        input: python lists x and y of 0 and 1s (representing binary vectors)
        output/return: Jaccard similarity 
        """
        intersection = sum(1 for i in range(len(x)) if x[i] == 1 and y[i] == 1)
        union = sum(1 for i in range(len(x)) if x[i] == 1 or y[i] == 1)

        if union == 0:
            return 0.0
    
        return intersection / union

    def Cosine(self, x, y):
        """
        input: python lists x and y of floats
        output/return: Cosine between x and y
        """
        dot = self.dot(x, y)
        normX = math.sqrt(sum(n * n for n in x))
        normY = math.sqrt(sum(m * m for m in y))
        if normX == 0 or normY == 0:
            return 0.0
        
        return dot / (normX * normY)

    def Euclidean(self, x, y):
        """
        input: python lists x and y of floats
        output/return: Euclidean distance between x and y
        """
        return math.sqrt(sum((n - m) ** 2 for n, m in zip(x, y)))

if __name__ == '__main__':
    dp = DataProcessor()

    # Example 1: Summary stats
    data = [1, 2, 3, 4, 5]
    print("Summary:", dp.summary(data))
    # -> (mean=3.0, median=3, variance=2.5)

    # Example 2: Dot product
    print("Dot:", dp.dot([1, 2, 3], [4, 5, 6]))
    # -> 32

    # Example 3: Covariance
    print("Covariance:", dp.cov([2, 4, 6], [1, 3, 5]))
    # -> 4.0

    # Example 4: Correlation
    print("Correlation:", dp.corr([2, 4, 6], [1, 3, 5]))
    # -> 1.0 (perfect positive)

    # Example 5: Simple Match Coefficient
    bx1 = [1, 1, 0, 0, 1]
    by1 = [1, 0, 0, 0, 1]
    print("SMC:", dp.SMC(bx1, by1))
    # -> 0.8

    # Example 6: Jaccard similarity
    print("Jaccard:", dp.Jaccard(bx1, by1))
    # -> 0.666...

    # Example 7: Cosine similarity
    print("Cosine:", dp.Cosine([1.0, 2.0, 3.0], [4.0, 5.0, 6.0]))
    # -> ~0.9746

    # Example 8: Euclidean distance
    print("Euclidean:", dp.Euclidean([1.0, 2.0, 3.0], [4.0, 5.0, 6.0]))
    # -> ~5.196