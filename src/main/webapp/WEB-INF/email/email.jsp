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
</script>
<html>
<head>
    <title>SEND EMAIL PAGE</title>
</head>
<body>
<form action="/email/saveEmail.do" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <td>
                <label for="subject">عنوان</label>
            </td>
            <td>
                <input type="text" id="subject" name="emailSubject"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="emailContent"> متن</label>
            </td>
            <td>
                <label for="emailContent"></label>

                <textarea id="emailContent" name="emailContent" rows="5" cols="50">

                </textarea>
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
                <input type="button" onclick="addReceiverPerson()" value="add receiver"/>
                <br/>
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
                <input id="file" type="file" name="emailAttachment"/>
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
</form>

</body>
</html>
