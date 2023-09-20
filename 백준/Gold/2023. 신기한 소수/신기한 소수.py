def isPrime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True


def make(num):
    if len(num) == N:
        if isPrime(int(num)):
            print(num)
        return

    if not isPrime(int(num)):
        return

    for i in range(10):
        make(num+str(i))


N = int(input())


arr1 = [2, 3, 5, 7]


for a in arr1:
    num = str(a)
    make(num)