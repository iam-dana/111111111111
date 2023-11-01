import heapq

def solution(n, works):
    if n > sum(works):
        return 0
    
    works = [-x for x in works]
    heapq.heapify(works)

    
    for _ in range(n):
        i = heapq.heappop(works)
        i += 1
        heapq.heappush(works, i)
        
        
    return sum([x*x for x in works])