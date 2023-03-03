def solution(sequence):
    seq1 = [x if i%2 else -x for i, x in enumerate(sequence)]
    seq2 = [-x if i%2 else x for i, x in enumerate(sequence)]
    # print(seq1)
    # print(seq2)
    def kadane(seq):
        max_, acc = 0, 0
        for n in seq:
            if 0 < acc + n: acc += n
            else: acc = 0
            max_ = max(max_, acc)
        return max_
    
    return max(map(kadane, [seq1, seq2]))