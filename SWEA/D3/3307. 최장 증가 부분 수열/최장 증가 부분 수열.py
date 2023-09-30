import bisect

T = int(input())

for t in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    lis = []

    for i in range(len(arr)):
        if i == 0:
            lis.append(arr[i])
            continue

        if arr[i] > lis[len(lis)-1]:
            lis.append(arr[i])
            continue

        idx = bisect.bisect_left(lis, arr[i])
        lis[idx] = arr[i]

    print(f'#{t} {len(lis)}')