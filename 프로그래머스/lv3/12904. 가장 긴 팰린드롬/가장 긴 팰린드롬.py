def solution(s):
    answer = 0
    for i in range(len(s)+1):
        for j in range(i):
            tmp = s[j:i]
            if tmp == tmp[::-1]:
                answer = max(answer, len(tmp))
    return answer