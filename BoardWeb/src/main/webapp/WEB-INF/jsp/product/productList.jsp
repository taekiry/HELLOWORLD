<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
    <h3>product/productList.jsp</h3>

    <div id="show">
        <table class="table">
            <tr>
                <th>글번호</th>
                <td><input type="text" id="bno" class="form-control"></td>
            </tr>
            <tr>
                <th>글내용</th>
                <td><input type="text" id="reply" class="form-control"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button id="addReply" class="btn btn-primary">등록</button>
                </td>
            </tr>
        </table>
        <table class="table">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>댓글내용</th>
                    <th>작성자</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
    <script>
        const logId = "${logId}"    //js에서는 달러 중괄호로 가져오지못해서 jsp처럼 쓰려면 script안에 넣어서 변수
    </script>
    <script src="js/service.js"></script>
    <script src="js/ajax2.js"></script>