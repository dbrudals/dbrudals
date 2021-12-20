'''
Created on Jan 28, 2021

@author: ykm09
'''
import random
link=["https://www.youtube.com/watch?v=OQlC-1FV6CE", "https://www.youtube.com/watch?v=Szn0cpXUjbc", "https://www.youtube.com/watch?v=e7aesyd2pcE", 
      "https://www.youtube.com/watch?v=HC_LJHAA6LQ", "https://www.youtube.com/watch?v=8nvGJJJFKYc","https://www.youtube.com/watch?v=614oSsDS734", 
      "https://www.youtube.com/watch?v=Gy5UHK4EeM8", "https://www.youtube.com/watch?v=CsKZmUcQOzg", "https://www.youtube.com/watch?v=EmlmbleF6Ow", 
      "https://www.youtube.com/watch?v=eBBd425-zHw","https://www.youtube.com/watch?v=Vt465C65MAU", "https://www.youtube.com/watch?v=KJ_HHRJf0xg", 
      "https://www.youtube.com/watch?v=5PzTVJ_dA2o","https://www.youtube.com/watch?v=I2VoE4tPgbw", "https://www.youtube.com/watch?v=gWOgTbQKdD0",
      "https://www.youtube.com/watch?v=yfPLh_6ckzI", "https://www.youtube.com/watch?v=0Ka971Yrroo","https://www.youtube.com/watch?v=8gd_ohoPzYc",
      "https://www.youtube.com/watch?v=RSXSWpYSoYE", "https://www.youtube.com/watch?v=quoM8rX5XaE","https://www.youtube.com/watch?v=JyOtXL-0fAQ"]
title=["베르디-오페라 ‘리골레토’ 중 “여자의마음”", "슈베르트-가곡 ‘음악에’(An die Musik)", "슈베르트-가곡 ‘송어’(Die forelle)","슈베르트-피아노5중주 ‘송어’ 4악장",
       "슈베르트-가곡 ‘마왕’", "쇼팽-피아노협주곡 1번 1악장","쇼팽-즉흥환상곡", "파가니니-라캄파넬라(La Campanella)","브루흐-바이올린협주곡 1번 1악장(~02:45)",
       "헨델-오페라 ‘리날도’ 중 “울게하소서” (0:21~)", "비제-오페라 ‘카르멘’ 중 “투우사의 노래”", "비제-오페라 ‘카르멘’ 중 “하바네라”",
       "판소리 ‘흥보가’ 중 “박타는 대목” (04:26~)","판소리 ‘춘향가’ 중 “쑥대머리”","슈베르트-연가곡 ‘겨울나그네’ 중 “보리수”","뮤지컬 ‘오페라의 유령’ 중 “All I ask of you”",
       "뮤지컬 ‘지킬 앤 하이드’ 중 “지금 이 순간”","뮤지컬 ‘캣츠’ 중 “Memory”","프랑크-바이올린 소나타 A장조(0:42~)","브람스-첼로 소나타 1번", "브람스-피아노 5중주 op.34 f minor"]
  
q=list(zip(link, title))
random.shuffle(q)
  
for i in q:
    z=input(i[0]+' : ')
    print(i[1])
