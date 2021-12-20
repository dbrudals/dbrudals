'''
Created on Jan 28, 2021

@author: ykm09
'''
import random
gerund=["avoid","consider","delay","deny","dislike","enjoy","escape","finish","give up","imagine","keep","mind","postpone","practice","put off","stop","suggest"]
to=["agree","choose","decide","expect","fail","hope","plan","promise","refuse","want","wish","would like"]
no=["begin","continue","hate","like","love","prefer","start"]
r=["be busy -ing","be used[accustomed]to -ing","be worth -ing","cannot help -ing  =cannot (help) but +동사원형","feel like -ing","There is no -ing  =It is impossible to~","have difficulty[trouble](in) -ing","It is no use[good] -ing","keep[stop/prevent/prohibit] A from -ing","look forward to -ing","on[upon] -ing  =as soon as+주어+동사", "spend[waste]+시간/돈+ -ing", "be used to+동사원형","used to+동사원형"]
b=["~하느라 바쁘다","~하는 데 익숙하다","~할 가치가 있다","~할 수밖에 없다","~하고 싶다","~할 수 없다","~하는 데 어려움을 겪다","~해 봐야 소용없다","A가 ~하는 것을 막다","~하기를 고대하다","~하자마자","~하느라 시간/돈을 쓰다[낭비하다]","~하는 데 사용되다","~하곤 했다"]
x=list()

c=list()
for i in gerund:
    c.append((i, "ing"))
for i in to:
    c.append((i, "to"))
for i in no:
    c.append((i, "no"))
random.shuffle(c)
  
  
for i in c:
    a=input(i[0]+':')
    if a != i[1]:
        x.append(i)
        print(i[1]+"란다 이놈아^^")

# q=list(zip(r, b))
# random.shuffle(q)
#  
# for i in q:
#     z=input(i[0]+':')
#     if z != i[1]:
#         print(i[1]+' 이거란다 얘야^^')
#         x.append(i)
if x:
    print(x)
else:
    print("다맞았어!!")