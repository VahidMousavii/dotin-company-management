<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
    var i = 0;

    function addReceiverPerson() {
        document.getElementById("receivers").innerHTML += createReceiverSelectHtmlCode();
        return null;
    }

    function createReceiverSelectHtmlCode() {

        i++;
        var htmlCode = '<div id=persons' + i + '>' +
            '<select name="receiverPersons[' + i + '].ID">\n' +
            '            <c:forEach items="${receiverPersons}" var="receiverPerson">\n' +
            '            <option value="${receiverPerson.ID}">${receiverPerson.personName}</option>\n' +
            '            </c:forEach>\n' +
            '            </select><img src="/assets/image/email/remove.png" onclick="remove(' + i + ')">' +
            '           <br/> </div>';
        return htmlCode;
    }

    function remove(receiverPersonId) {
        document.getElementById("persons" + receiverPersonId).remove();
        i--;
    }

    function check() {
        var subject = document.getElementById("subject").value;
        if (subject == '') {
            alert('فیلد عنوان نمیتواند خالی باشد');
            return false;
        }
        var emailContent = document.getElementById("emailContent").value;
        if (emailContent == '') {
            alert('متن ایمیل نمیتواند خالی باشد')
            return false;
        }

    }
</script>
<html>
<head>
    <title>ایمیل</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/assets/css/menu/menu.css">
    <script src="//code.jquery.com/jquery.min.js"></script>
    <script src="/assets/js/calendar/calendar.js"></script>
    <style>
        .center {
            margin: auto;
            width: 50%;
            border: 3px solid green;
            padding: 10px;
        }

        .pcenter {
            margin: auto;
            width: 50%;
        }

        .tdlable {
            text-align: right
        }
    </style>
</head>
<body>
<div class="topnav">
    <a href="/person/findAll.do?active=1" > <img src="/assets/image/home.png" width="32" height="32">صفحه اصلی </a>
    <a href="/person/savePage.do"><img src="/assets/image/profile.jpg" width="32" height="32"> ایجاد کاربر</a>
    <a href="/offRequest/offRequest.do?ID=${senderPerson.ID}"><img src="/assets/image/offRequest.jpg" width="32" height="32">مرخصی</a>
    <a href="/person/update.do?ID=${senderPerson.ID}"><img src="/assets/image/updatePerson.png" width="32" height="32">بروز رسانی</a>
    <a href="#" class="active"> <img src="/assets/image/email/email.png" width="32" height="32">ارسال ایمیل</a>
    <a href="/email/showInbox.do?ID=${senderPerson.ID}&active=true"> <img src="/assets/image/inbox.png" width="32" height="32">صندوق دریافت</a>
    <a href="/email/showSentBox.do?ID=${senderPerson.ID}&active=true"><img src="/assets/image/outbox.png" width="32" height="32"> صندوق ارسال</a>
</div>
<div class="center">
<form action="/email/saveEmail.do" method="post" enctype="multipart/form-data" onsubmit="return check();">
    <table class="table-responsive">
        <tr>
            <td>
                <label for="subject">عنوان</label>
            </td>
            <td>
                <input type="text" id="subject" name="emailSubject" align="right"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="emailContent"> متن</label>
            </td>
            <td>
                <label for="emailContent"></label>

                <textarea id="emailContent" name="emailContent" rows="5" cols="50"></textarea>
            </td>

        </tr>
        <tr>
            <td>

                <input type="hidden" name="senderPerson.ID" value="${senderPerson.ID}">
            </td>
        </tr>
        <tr>
            <td>
                <p>گیرنده</p>
            </td>
            <td>
                <input type="button" onclick="addReceiverPerson()" value="افزودن گیرنده"/>
            </td>
        </tr>
        <tr>
            <td width="200px">
                <select name="receiverPersons[0].ID">
                    <c:forEach items="${receiverPersons}" var="receiverPerson">
                        <option value="${receiverPerson.ID}">${receiverPerson.personName}</option>
                    </c:forEach>
                </select>
                <div id="receivers">

                </div>
            </td>
        </tr>
        <tr>
            <td>
                <label for="file">فایل</label>
            </td>
            <td>
                <input id="file" type="file" name="multipartFileEmailAttachFile"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="ارسال ایمیل"/>
            </td>
            <td>
                <p>صندوق دریافت</p>
                <a href="/email/showInbox.do?ID=${senderPerson.ID}&active=true">Inbox</a>
            </td>
            <td>
                <p>صندوق ارسال</p>
                <a href="/email/showSentBox.do?ID=${senderPerson.ID}&active=true">SentBox</a>
    </table>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</form>
</div>
</body>
</html>
