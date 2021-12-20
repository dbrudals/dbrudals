'''
Created on 2021. 5. 22.

@author: ykm09
'''
import random
class B:
    def check(self, a):
        d=dict()
        for i in range(1, 6):
            d[i]=a.count(i)
        return d
a=[]
for i in range(10):
    a.append(random.randint(1, 5))
b=B()
d=list(b.check(a).values())
print(max(d)/min(d))
