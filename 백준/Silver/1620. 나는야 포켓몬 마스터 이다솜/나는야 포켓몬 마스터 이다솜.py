
N, M = map(int, input().split())

pokemon1 = dict()
pokemon2 = dict()
for i in range(1, N+1):
    p = input()
    pokemon1[i] = p
    pokemon2[p] = i

for _ in range(M):
    a = input()
    if a.isdigit():
        print(pokemon1[int(a)])
    else:
        print(pokemon2[a])
