import requests
from bs4 import BeautifulSoup
from flask import Flask, render_template

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

# 0AFbuL2vD3w%2BmPYxv7wngHxV15sYkff8KFECgmkncga%2FlYSFookF8j870zhAqNxb4e7yZ99r0xH%2BgDE7M7wf8A%3D%3D

# 노선번호 목록조회
'http://openapi.gbis.go.kr/ws/rest/busrouteservice?serviceKey=0AFbuL2vD3w%2BmPYxv7wngHxV15sYkff8KFECgmkncga%2FlYSFookF8j870zhAqNxb4e7yZ99r0xH%2BgDE7M7wf8A%3D%3D&keyword=8'
# 경유정류소 목록조회
'http://openapi.gbis.go.kr/ws/rest/busrouteservice/station?serviceKey=gFPEKeUFchor6ufSmF7rcQdqX07%2FzujLylBDhPciPIFFNGcI6GF4gXbuj%2BA6VYJc0dUETinOu9HQ7ewyXuLqWA%3D%3D&routeId=234000070'
#지역별노선번호 목록조회
'http://openapi.gbis.go.kr/ws/rest/busrouteservice/area?serviceKey=gFPEKeUFchor6ufSmF7rcQdqX07%2FzujLylBDhPciPIFFNGcI6GF4gXbuj%2BA6VYJc0dUETinOu9HQ7ewyXuLqWA%3D%3D&areaId=26&keyword=11'

'http://openapi.gbis.go.kr/ws/rest/buslocationservice?serviceKey=1234567890&routeId=233000031'

@app.route('/')
def intro():
    return '<h1>환영함</h1>'

@app.route('/<number>')
def home(number):
    h = requests.get('http://openapi.gbis.go.kr/ws/rest/busrouteservice?serviceKey=0AFbuL2vD3w%2BmPYxv7wngHxV15sYkff8KFECgmkncga%2FlYSFookF8j870zhAqNxb4e7yZ99r0xH%2BgDE7M7wf8A%3D%3D&keyword={}'.format(number))
    hdata = BeautifulSoup(h.text, "html.parser")
    li = list()
    for data in hdata.select('busroutelist'):
        di=dict()
        di["zn"]=data.regionname.text
        di["number"]=data.routename.text
        di["routeid"]=data.routeid.text
        li.append(di)
    return render_template('b_routehome.html', values=li, title=number)

@app.route('/route/<code>')
def route(code):
    a=requests.get('http://openapi.gbis.go.kr/ws/rest/busrouteservice/station?serviceKey=0AFbuL2vD3w%2BmPYxv7wngHxV15sYkff8KFECgmkncga%2FlYSFookF8j870zhAqNxb4e7yZ99r0xH%2BgDE7M7wf8A%3D%3D&routeId={}'.format(code))
    adata = BeautifulSoup(a.text, "html.parser")
    b=requests.get('http://openapi.gbis.go.kr/ws/rest/buslocationservice?serviceKey=0AFbuL2vD3w%2BmPYxv7wngHxV15sYkff8KFECgmkncga%2FlYSFookF8j870zhAqNxb4e7yZ99r0xH%2BgDE7M7wf8A%3D%3D&routeId={}'.format(code))
    bdata = BeautifulSoup(b.text, "html.parser")

    li1=list()
    li2=list()
    for dat in adata.select('busroutestationlist'):
        di=dict()
        bus=''
        for rou in bdata.select('buslocationlist'):
            if dat.stationid.text == rou.stationid.text:
                bus=rou.plateno.text
                break
        di['r']=bus
        if dat.turnyn.text == 'Y':
            di['station'] = dat.stationname.text
            di['name']='Y'
        else:
            di['station'] = dat.stationname.text
            di['name']=''
        di['stationid']=dat.stationid.text
        li1.append(di)
    for i in range(len(li1)):
        if li1[i]['name']=='Y':
            li2=li1[i:]
            li1=li1[:i+1]
            break
    return render_template('b_route.html', values1=li1, values2=li2, buscode = code, start=li2[0]['station'], stat=li1[0]['station'])

@app.route('/station/<stationid>')
def stationTiem(stationid):
    s=requests.get('''http://openapi.gbis.go.kr/ws/rest/busarrivalservice/station?serviceKey=0AFbuL2vD3w+mPYxv7wngHxV15sYkff8KFECgmkncga/lYSFookF8j870zhAqNxb4e7yZ99r0xH+gDE7M7wf8A==&stationId={}'''.format(stationid))
    sdata= BeautifulSoup(s.text, "html.parser")
    dic = dict()
    for statd in sdata.select("busarrivallist"):
        dic['no1']=statd.plateno1.text
        dic['no2']=statd.plateno2.text
        dic['time1']=statd.predicttime1.text
        dic['time2']=statd.predicttime2.text
    return render_template('b_stationbus.html', value=dic, stationid=stationid)

if __name__ == "__main__":
    app.run(host="127.0.0.1", port="8080")
