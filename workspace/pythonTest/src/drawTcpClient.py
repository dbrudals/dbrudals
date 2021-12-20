from PyQt5.QtWidgets import QMainWindow, QApplication
from PyQt5.QtCore import Qt
from PyQt5.QtGui import QPainter
import sys
import socket
import threading


class Main(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setMouseTracking(True)

        self.setWindowTitle('mouse2')
        self.resize(900, 600)
        self.all=list()
        self.clicked = 0
        self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.s.connect(('127.0.0.1', 4000))
        self.run()
        self.show()

    def mousePressEvent(self, e):  # e ; QMouseEvent
        if e.buttons() & Qt.LeftButton:
            self.clicked = 1
            self.s.send('c'.encode())

    def mouseReleaseEvent(self, e):  # e ; QMouseEvent
        # print('BUTTON RELEASE')
        self.clicked = 0
    #         self.mouseButtonKind(e.buttons())

    def mouseMoveEvent(self, e):  # e ; QMouseEvent
        self.send(e.x(), e.y())
        # if self.clicked:
        #     self.repaint()

    def paintEvent(self, event):
        if len(self.all) > 0:
            q = QPainter(self)
            for b in self.all:
                for c in range(len(b) - 1):
                    q.drawLine(b[c][0], b[c][1], b[c + 1][0], b[c + 1][1])

    def send(self, x, y):
        d='%d_%d_%s'%(x, y, self.clicked)
        self.s.send(d.encode())

    def run(self):
        th = threading.Thread(target=self.worker, name="[스레드 이름{}]".format(self.s), args=(self.s,))
        th.start() 

    def worker(self, conn):
        while True:
            data = conn.recv(1024)
            data = data.decode()
            if data == 'c':
                self.all.append(list())
            if data[-1] == '1':
                data=data.split('_')
                # print(data)
                self.all[-1].append((int(data[0]), int(data[1])))
                self.repaint()
        conn.close()
        window.socket.close()
        # sys.exit(App.exec())


App = QApplication(sys.argv)
window = Main()
sys.exit(App.exec())

