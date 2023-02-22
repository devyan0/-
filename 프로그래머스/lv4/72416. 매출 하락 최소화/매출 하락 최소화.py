from collections import defaultdict
def solution(sales, links):
    d = defaultdict(list)
    for a, b in links:
        d[a].append(b)

    def dfs(node):
        if not d[node]:
            return sales[node-1], 0     # select, ignore

        child_in = []
        child_out = []
        for child in d[node]:
            ci, co = dfs(child)
            child_in.append(ci)
            child_out.append(co)

        # select the node, not any of children
        select_node = sales[node-1] + sum(child_out)

        # ignore the node, select an optimal children
        ignore_node = float('inf')
        for ci, co in zip(child_in, child_out):
            ignore_node = min(ignore_node, ci + sum(child_out) - co)

        # return select_node, ignore_node
        return select_node, min(ignore_node, select_node)

    ceo_in, ceo_out = dfs(1)
    return min(ceo_in, ceo_out)