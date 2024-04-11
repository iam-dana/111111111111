import sys

input = sys.stdin.readline
data = dict()

N, M = map(int, input().split())
for _ in range(N):
    word = input().strip()
    if len(word) < M:
        continue
    if word not in data:
        data[word] = [1, len(word), word]  # 나온 횟수, 길이, 영단어
    else:
        data[word][0] += 1

data = sorted(data.items(), key=lambda x: (-x[1][0], -x[1][1], x[1][2]))

for d in data:
    print(d[0])