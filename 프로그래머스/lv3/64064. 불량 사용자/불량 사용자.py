from copy import deepcopy

def solution(user_id, banned_id):
    pick = []
    for id in banned_id:
        idx = []
        pick_ele = []
        for i in range(len(id)):  # 별 위치 인덱스 저장
            if id[i] == "*":
                idx.append(i)
        for user in user_id:  # 유저에서 탐색
            if len(user) == len(id):  # 길이가 같을 때
                tmp = list(user)
                for i in idx:
                    tmp[i] = "*"
                if tmp == list(id):  # 불량 사용자일 수 있을 때
                    pick_ele.append(user)
        pick.append(pick_ele)
    # print(pick)
    ans = []


    def dfs(v):
        if v == len(pick)-1:
            if len(arr) == len(banned_id):
                tmp = deepcopy(arr)
                tmp.sort()
                # print(tmp)
                if tmp not in ans:
                    ans.append(tmp)
            return

        for i in pick[v+1]:
            if i not in arr:
                arr.append(i)
                dfs(v+1)
                arr.pop()

    for i in pick[0]:
        arr = [i]
        dfs(0)
        
    # print(ans)
    return len(ans)


