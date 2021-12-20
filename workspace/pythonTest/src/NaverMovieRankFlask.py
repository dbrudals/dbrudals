from flask import Flask, render_template
from bs4 import BeautifulSoup
import requests

app = Flask(__name__)

@app.route('/')
def hello():
    return '<h1>영화순위가 보고싶은 날짜를 입력하세요 /YYYYMMDD</h1>'

@app.route('/<int:date>', methods = ['GET'])
def ranking(date):
    movieranking=list()
    response = requests.get('https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=cnt&tg=0&date=%s' % date)
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')
    ranking = 1
    for tag in soup.select('div[class=tit3] a'):
        rank = dict()
        rank['rank'] = ranking
        rank['name'] = tag.text
        rank['link'] = "https://movie.naver.com"+tag.get('href')
        ranking = ranking + 1
        movieranking.append(rank)
    return render_template('movie_rank.html', values=movieranking)

if __name__ == '__main__':
    app.run(host="0.0.0.0", port="40031")