def solution(targets):
    answer = 1
    targets.sort(key=lambda x: x[1])
    new_targets = []
    for x, y in targets:
        new_targets.append([x*2+1, y*2-1])

    # print(new_targets)
    tmp = new_targets[0][1]

    for i in range(len(targets)):
        # print(tmp, new_targets[i][1])
        if tmp not in range(new_targets[i][0], new_targets[i][1]+1):
            answer += 1
            tmp = new_targets[i][1]

    return answer