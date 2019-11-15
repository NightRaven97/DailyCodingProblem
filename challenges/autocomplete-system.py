#!/usr/bin/python
""" #11
Purpose: This problem was asked by Twitter.
    Implement an autocomplete system. That is, given a query string s
    and a set of all possible query strings, return all strings in the
    set that have s as a prefix.
Example: Given the query string de and the set of strings [dog, deer, deal],
    return [deer, deal]
Hint: Try pre-processing the dictionary into a more efficient data structure
    to speed up queries

"""


def time_taken(func):
    def __inner(*args, **kwargs):
        import time
        start_time = time.perf_counter_ns()
        _result = func(*args, **kwargs)
        print(f'Execution time :{func.__name__} is {time.perf_counter_ns() - start_time :5} ns')
        return _result

    return __inner


@time_taken
def auto_complete_1(word_dict, query_string):
    """

    :param word_dict:
    :param query_string:
    :return:
    """
    matched_words = []
    for each_word in word_dict:
        if each_word.startswith(query_string):
            matched_words.append(each_word)
    return matched_words


@time_taken
def auto_complete_2(word_dict, query_string):
    """

    :param word_dict:
    :param query_string:
    :return:
    """
    return [each_word for each_word in word_dict if each_word.startswith(query_string)]


suggestions = []


class Node:
    def __init__(self, val):
        self.val = val
        self.children = []

    def add(self, remaining, word):
        exists = False

        for child in self.children:
            if remaining[0] == child.val:
                exists = True
                if len(remaining) > 1:
                    child.add(remaining[1:], word)
                else:
                    child.children.append(Node(word))

        if not exists:
            newNode = Node(remaining[0])
            self.children.append(newNode)
            if len(remaining) > 1:
                newNode.add(remaining[1:], word)
            else:
                newNode.children.append(Node(word))

    def find_suggestions(self):
        if self.children:
            for child in self.children:
                child.find_suggestions()
        else:
            suggestions.append(self.val)

    def find(self, query):
        if query == "":
            self.find_suggestions()
            return

        for child in self.children:
            if query[0] == child.val:
                return child.find(query[1:])

        return None


@time_taken
def auto_complete_3(word_dict, query_string):
    root = Node("root")
    for query in word_dict:
        root.add(query.lower(), query.lower())

    root.find(query_string)

    return suggestions


if __name__ == '__main__':
    assert auto_complete_1(word_dict=['dog', 'deer', 'deal'], query_string='de') == ['deer', 'deal']
    assert auto_complete_2(word_dict=['dog', 'deer', 'deal'], query_string='de') == ['deer', 'deal']
    assert auto_complete_3(word_dict=['dog', 'deer', 'deal'], query_string='de') == ['deer', 'deal']
