from collections import defaultdict
import sys
sys.setrecursionlimit(int(1e9))

def solution(a, edges):
    d, move = defaultdict(lambda: []), 0

    for n1, n2 in edges:
        d[n1].append(n2)
        d[n2].append(n1)
    
    def post(node, parent):
        nonlocal move
        
        if not d[node] or d[node] == parent:
            move += abs(a[node])
            return a[node]
        
        acc = a[node]
        for child in d[node]:
            if child == parent: continue
            acc += post(child, node)
        
        move += abs(acc)
        return acc
    
    return -1 if post(0, -1) else move
    
    