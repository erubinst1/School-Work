# The class can be used to compute probabilities 
# e.g., p(h=5), probability of getting five heads when flipping a coin 10 times 
import random

class FlipCoin(object):
    """A class for coin flipping experiments"""
    def __init__(self, n):
        """n: number of flips"""
        self.n = n
        
    def outcomeSpace(self):
        """
        return the size of outcome space
        if self.n == 1, the function returns 2
        if self.n == 2, the function returns 4
        and so on
        """
        return 2**self.n

    def simulateOne(self):
        """
        a function that returns a simulation result as a list
        for example, if self.n = 2, the results can be any of 
        ["head", "tail"], ["tail", "head"], ["head", "head"], ["tail", "tail"]
        """
        return [ random.choice( ["head", "tail"] ) for _ in range(self.n) ]
        
    def simulation2Head(self):
        """
        a function that returns the number of heads in one experiment 
        (i.e. flipping a coin self.n times); for example, if self.n = 2, 
        the result can be either 0 (for 0 heads), 1, or 2
        """
        return sum(1 for _ in range(self.n) if random.choice(["head", "tail"]) == "head")

    def simulation2Prob(self, m = 1000):
        """
        estimate the probabilities of have 0, 1, ..., self.n heads, respectively, by simulation;
        m is the number of experiments
        the funtion returns [p(h=0), p(h=1), ... p(h=n)], 
        the probabilities of having 0 head, 1 head, ..self.n heads, as a list
        since this is a simulation, results may vary among different runs
        """
        counts = [0] * (self.n + 1)
        for _ in range(m):
            heads = self.simulation2Head()
            counts[heads] += 1
        return [c / m for c in counts]

    def count2Prob(self):
        """
        A function that computes the exact probabilities of having 0 h, 1 h, ...
        """
        counts = self.countHeads4All(self.n)
        tot = sum(counts)
        prob = [i / tot for i in counts] 
        return prob

    def countHeads4All(self, n):
        """
        A function that counts the number of outcomes with 0, 1, ..., self.n heads
        after flipping n (the input) coins using recursion; 
        cuntHeads4All() is needed by count2Prob() to compute the exact probabilities.
        output: number of outcomes with 0, 1, ..., n heads, respectively, in a list
        """
        if n == 0:
            return [1]
        prev = self.countHeads4All(n-1)
        res = [0] * (n + 1)
        for i in range(len(prev)):
            res[i] += prev[i]
            res[i+1] += prev[i]
        return res

if __name__ == "__main__":
    n, h = 3, 1 #flip 3 coins & get 1 head
    
    fp = FlipCoin(n)
    s = fp.outcomeSpace() # s = 8
    print("Outcome space size:", s)

    c = fp.countHeads4All(n) # c = [1, 3, 3, 1]
    print("Counts of heads:", c)
    
    p1_a = fp.count2Prob()
    print("Exact probabilities:", p1_a)
    p1 = p1_a[h] #p1 = 0.375
    print(f"Exact probability of {h} head(s):", p1)

    p2_a = fp.simulation2Prob()
    print("Simulated probabilities:", p2_a)
    p2 = p2_a[h] #p2 should be close to 0.375
    print(f"Simulated probability of {h} head(s):", p2)