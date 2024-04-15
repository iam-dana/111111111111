import sys
input = sys.stdin.readline

N = int(input())
building = []
ans = 0

for _ in range(N):
    x, y = map(int, input().split())
    if not building and y:
        building.append(y)
    elif building and building[-1] < y:
        building.append(y)
    elif building and building[-1] > y:
        while building:
            if building[-1] > y:
                building.pop()
                ans += 1
            else:
                break
        if y and y not in building:
            building.append(y)

print(ans+len(building))
