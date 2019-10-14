# This problem was asked by Airbnb.

# You are given a huge list of airline ticket prices between different cities around the world on a given day. These are all direct flights. Each element in the list has the format `(source_city, destination, price)`.

# Consider a user who is willing to take up to `k` connections from their origin city `A` to their destination `B`. Find the cheapest fare possible for this journey and print the itinerary for that journey.

# For example, our traveler wants to go from JFK to LAX with up to 3 connections, and our input flights are as follows:

# ```
# [
#     ('JFK', 'ATL', 150),
#     ('ATL', 'SFO', 400),
#     ('ORD', 'LAX', 200),
#     ('LAX', 'DFW', 80),
#     ('JFK', 'HKG', 800),
#     ('ATL', 'ORD', 90),
#     ('JFK', 'LAX', 500),
# ]
# ```

# Due to some improbably low flight prices, the cheapest itinerary would be JFK -> ATL -> ORD -> LAX, costing $440.


import sys


def get_city_map(flights):
    city_map = dict()
    for src, dst, fare in flights:
        if dst not in city_map:
            city_map[dst] = list()
        city_map[dst].append((src, fare))

    return city_map


def get_cheapest_fare(src, tgt, max_stops, city_map, total=0, stops=0):
    if stops > max_stops:
        return sys.maxsize

    if src == tgt:
        return total

    new_tgt_fares = city_map[tgt]
    possibilities = list()
    for new_tgt, fare in new_tgt_fares:
        poss = get_cheapest_fare(
            src, new_tgt, max_stops, city_map, total + fare, stops + 1)
        possibilities.append(poss)

    return min(possibilities)


# Tests
flights = [
    ('JFK', 'ATL', 150),
    ('ATL', 'SFO', 400),
    ('ORD', 'LAX', 200),
    ('LAX', 'DFW', 80),
    ('JFK', 'HKG', 800),
    ('ATL', 'ORD', 90),
    ('JFK', 'LAX', 500),
]
city_map = get_city_map(flights)
assert get_cheapest_fare("JFK", "LAX", 3, city_map) == 440
assert get_cheapest_fare("JFK", "LAX", 0, city_map) == sys.maxsize
