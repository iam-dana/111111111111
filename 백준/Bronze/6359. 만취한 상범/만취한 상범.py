import sys
input = sys.stdin.readline

T = int(input())

def check():
    for i in range(1, n+1):
        for j in range(i, n+1, i):
            student[j] = abs(student[j]-1)

for _ in range(T):
     n = int(input())
     student = [1]*(n+1)
     check()
     
     print(student.count(0))

