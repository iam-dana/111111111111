import sys
input = sys.stdin.readline

arr = [1]*1000001

for i in range(3, 500000, 2):
    if arr[i]:
        for j in range(i*3, 1000001, i):
            arr[j] = 0

while 1:
    num = int(input())
    if not num:
        break

    for i in range(3, 500000, 2):
        if arr[i] and arr[num-i]:
            print(f'{num} = {i} + {num-i}')
            break
    else:
        print("Goldbach's conjecture is wrong.")
