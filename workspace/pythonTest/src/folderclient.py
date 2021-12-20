import socket
import threading
import os
import time
import glob

def search(dirname):
    filenames = os.listdir(dirname)
    files=list()
    for filename in filenames:
        full_filename = os.path.join(dirname, filename)
        files.append(full_filename)
    return files

def worker(conn):
    while True:
        data = conn.recv(1024)
        print(data.decode())
    conn.close()

def Diff(li1, li2):
    return (list(list(set(li1)-set(li2)) + list(set(li2)-set(li1))))

def run():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect(('localhost', 4000))
        print("클라이언트 소켓정보 : ", s)
        th = threading.Thread(target=worker, name="[스레드 이름 {}]".format(s), args=(s,))
        th.start()  # 생성한 스레드를 시작한다

        path = "C:\A"
        old_list=[path+'/'+i for i in os.listdir(path)]
        while True:
            new_list=[path+"/"+i for i in os.listdir(path)]
            # print(file_list)
            if Diff(new_list, old_list):
                for item in Diff(new_list, old_list):
                    s.send(item.encode())
                    os.remove(item)
                    new_list.remove(item)
            old_list = new_list

if __name__ == '__main__':
    run()