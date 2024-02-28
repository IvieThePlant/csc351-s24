def calcRun(n):
    # when we start, we apply Insertion sort to entire array
    # Because n = length of the run

    # r is the remainder to determine if we need an extra
    # because the array length is not a power of 2
    r = 0

    # the threshold is an upper limit on the length of a run
    # so we need to reduce the run length until we get at
    # or below the threshold. Choose a power of 2.
    threshold = 32

    powers = 0
    
    while n > threshold:

        # determine if there is a remainder (at any point!)
        # if n%2==1, then r=1
        r |= n & 1

        # dividing in half
        # first time, 2 runs each of length n/2
        # at next division, 4 runs each of length n/4
        # at next division, 8 runs each of length n/8
        n >>= 1

        powers += 1
        print("Size of run",n," Number of runs:",2**powers,"+",r)

    # n is the final number of runs + 1 more if n not 2^x
    return n + r 

n = 512
print("Starting with array of size",n)
x = calcRun(n)
print("Size of each run",x)
