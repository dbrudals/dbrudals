import socket
import threading

connList = []


def worker(conn):
    while True:
        data = conn.recv(1024)
        if not data: break
        # print(data.decode())
        for b in connList:
            b.send(data)
    conn.close()


def run_server(port=4000):
    host = ''
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host, port))
        s.listen()

        while True:
            conn, addr = s.accept()
            print("서버 소켓정보 : ", conn)
            print("연결된 클라이언트 정보 : ", addr)

            connList.append(conn)
            th = threading.Thread(target=worker, name="[스레드 이름 {}]".format(conn), args=(conn,))
            th.start()


if __name__ == '__main__':
    run_server()