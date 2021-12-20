import socket
import threading
import time
from shutil import copyfile

connList = []


def worker(conn):
    while True:
        data = conn.recv(1024) # 변수 msg 은 바이트형이며, 클라이언트로 부터 받은 메세지가 저장된다. recv함수의 매개변수는 바이트 크기
        if not data:break
        if data:
            print(data.decode())
            d2=data.decode().split('/')
            d2[0]="C:\B"
            copyfile(data.decode(), '/'.join(d2))
            conn.send("성공".encode())  # 메세지를 연결된 클라이언트에게 전달
    conn.close()


def run_server(port=4000):
    host = ''
    # socket.AF_INET 은 IP4v 주소체계(socket.AF_INET6 은 IP6v), socket.SOCK_STREAM은 소켓의 타입
    # socket.AF_INET와 socket.SOCK_STREAM은 디폴트 값이므로 socket.socket() 로 코드를 작성해도 된다.
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host, port))
        s.listen()

        while True:
            conn, addr = s.accept()  # accept함수의 결과는 튜플형이며, conn은 서버 소켓에 대한 정보, addr은 클라이언트의 정보
            print("서버 소켓정보 : ", conn)
            print("연결된 클라이언트 정보 : ", addr)

            # connList.append(conn)
            th = threading.Thread(target=worker, name="[스레드 이름 {}]".format(conn), args=(conn,))
            th.start()  # 생성한 스레드를 시작한다


if __name__ == '__main__':
    run_server()