import pymysql

class Database():
    def __init__(self, host, user, password, db, charset='utf8'):
        self.conn = pymysql.connect(host=host,
                               user=user,
                               password=password,
                               db=db,
                               charset=charset)

    def dbAdd(self, m):
        with self.conn.cursor() as cursor:
            sql = 'INSERT INTO movieInformation (movie_id, name, makingyear, days, genre, grade) VALUES (%s, %s, %s, %s, %s, %s)'
            cursor.execute(sql, (m.code, m.name, m.makingYear, m.days, m.genre, m.grade))
        self.conn.commit()

    def tableCheck(self, tableName):
        with self.conn.cursor() as cursor:
            check = "SHOW TABLES LIKE '{}';".format(tableName)
            cursor.execute(check)
            result = cursor.fetchall()
        self.conn.commit()
        if len(result) == 0:
            self.tableCreate()
            return True
        elif len(result) == 1:
            self.dataDel(tableName)
            return True

    def dataDel(self, tableName):
        with self.conn.cursor() as cursor:
            sql = 'DELETE FROM {};'.format(tableName)
            cursor.execute(sql)
        self.conn.commit()

    def tableCreate(self):
        with self.conn.cursor() as cursor:
            sql = '''
                    CREATE TABLE movieInformation (
                    movie_id varchar(200) NOT NULL PRIMARY KEY,
                    name varchar(200) NOT NULL,
                    makingyear varchar(55) NOT NULL,
                    days varchar(100) NOT NULL,
                    genre varchar (100) NOT NULL,
                    grade varchar (100));  '''
            sql = sql + '''ALTER TABLE movieRanking ADD CONSTRAINT movie_id
                     FOREIGN KEY(movie_id) REFERENCES movieInformation(movie_id);'''
            cursor.execute(sql)
        self.conn.commit()

    def search(self, y ,keyword):
        res = []
        with self.conn.cursor() as cursor:
            sql = 'SELECT * FROM movieInformation WHERE makingyear = %s AND name LIKE "%s";' %(y, '%'+keyword+'%')
            cursor.execute(sql)
            results = cursor.fetchall()
            for result in results:
                res.append(result)
        self.conn.commit()
        return res
    def close(self):
        self.conn.close()
