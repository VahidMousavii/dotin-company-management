<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${isSent == true}">
        <title>SENT BOX</title>
    </c:if>
    <c:if test="${isSent == false}">
        <title>INBOX</title>
    </c:if>
</head>

<body>

    <table>
        <c:forEach items="${receivedEmails}" var="recEmail">
            <tr>
                <td>
                    <label for ="emailsubject">عنوان ایمیل</label>
                    <input type="text" id="emailsubject" disabled value="${recEmail.emailSubject}">
                </td>
                <td>
                    <label for ="senderPerson">ارسال کننده</label>
                    <input type="text" id="senderPerson" disabled value="${recEmail.senderPerson.personName}">
                </td>
            </tr>
            <tr>
                <td>
                <textarea id="receivedEmailContent"  name="emailContent" rows="5" cols="50">
                        ${recEmail.emailContent}
                </textarea>
                </td>
            </tr>
        </c:forEach>
    </table>

<c:if test="${isSent==true}">
    <table>
        <c:forEach items="${person.sentEmails}" var="sentEmail">
            <tr>
                <td>
                    <label for ="sentEmailSubject">عنوان</label>
                    <input type="text" id="sentEmailSubject" disabled value="${sentEmail.emailSubject}">
                </td>
                <td>
                    <c:forEach items="${sentEmail.receiverPersons}" var="recPer">
                        <label for ="receiverPerson">دریافت کننده:</label>
                        <input type="text" id="receiverPerson" disabled value="${recPer.personName}">

                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                <textarea id="sentEmailContent" name="emailContent" rows="5" cols="50">
                        ${sentEmail.emailContent}
                </textarea>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
