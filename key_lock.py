def positional_set(value):
    return set(str(k) + str(i) for i, k in enumerate(value))


filter_list = [f"{i:03}" for i in range(1000)]

hints = {"291": (1, 1), "245": (1, 0), "463": (2, 0), "578": (0, 0), "569": (1, 0)}

for (k, v) in hints.items():
    filter_list = list(filter(
        lambda hint: len(set(k).intersection(set(hint))) == v[0] and
                     len(set(positional_set(k)).intersection(set(positional_set(hint)))) == v[1], filter_list
    ))

print(filter_list)