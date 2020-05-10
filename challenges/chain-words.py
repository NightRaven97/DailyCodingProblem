words = eval(input())
length = len(words)  # number of words
chain = [words[0]]  # appending first word
words = words[1:]  # slicing out the first word from words
for i in range(0, length - 1):
    for word in words:  # each word in the list
        break_flag = False  # used to check whether to break the loop or not
        if word[0] == chain[-1][-1]:  # chain forming condition
            for temp_word in words:  # each word in the list
                # checks if the list contains word for further chain formation
                if len(words) != 1 and word[-1] == temp_word[0]:
                    chain.append(word)  # appending the word
                    words.remove(word)  # removing the word to avoid repeated check
                    break_flag = True  # if word added then no use of further iterations
                    break
                elif len(words) == 1: chain.append(word)  # in case only one word is left
        if break_flag: break  # if word already added stop further iterations
# checks whether the chain formed is correct or not
if len(chain) == length and chain[0][0] == chain[-1][-1]: print(chain)
else: print("Sorry. The words cannot be chained to form a circle")
