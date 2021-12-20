<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <form action="http://localhost:4567/submit" method="post">
            <fieldset>
                <legend>일정 등록</legend>
                일정 이름 : <input type="text" name="name" /> <br />
                시간 : <input type="date" name="time" />
          부가내용 : <input type="text" name="content" />
          tts여부:<input type="checkbox" name"tts" />
                <input type="submit" value="확인">
            </fieldset>
        </form>
    </body>
</html>