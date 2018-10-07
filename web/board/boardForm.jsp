<%--
  Created by IntelliJ IDEA.
  User: winetree
  Date: 07/10/2018
  Time: 4:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="wine.tree.board.dto.Board_Dto" %>
<%@ page import="java.util.List" %>
<jsp:include page="../comm/header.jsp"/>
<%

	List<Board_Dto> lists = (List<Board_Dto>) request.getAttribute("lists");

%>
<div class="container">
	<div class="grid-item-col-12">
		<table>
			<thead>
			<tr>
				<td>seq</td>
				<td>id</td>
				<td>writer</td>
				<td>title</td>
				<td>content</td>
				<td>ref</td>
				<td>step</td>
				<td>depth</td>
				<td>readcount</td>
				<td>regdate</td>
				<td>delflag</td>
			</tr>
			</thead>

			<% for (int i = 0; i < lists.size(); i++) { %>
			<tbody>
			<tr>
				<td><%=lists.get(i).getSeq()%>
				</td>
				<td><%=lists.get(i).getId()%>
				</td>
				<td><%=lists.get(i).getWriter()%>
				</td>
				<td><%=lists.get(i).getTitle()%>
				</td>
				<td><%=lists.get(i).getContent()%>
				</td>
				<td><%=lists.get(i).getRef()%>
				</td>
				<td><%=lists.get(i).getStep()%>
				</td>
				<td><%=lists.get(i).getDepth()%>
				</td>
				<td><%=lists.get(i).getReadCount()%>
				</td>
				<td><%=lists.get(i).getRegdate()%>
				</td>
				<td><%=lists.get(i).getDelflag()%>
				</td>
			</tr>
			</tbody>
			<% } %>

		</table>

	</div>
</div>

<form action="boardCtrl.jsp">
	<input type="hidden" name="command" value="newContent">
	<input type="submit" value="새 글 작성">
</form>


<jsp:include page="../comm/footer.jsp"/>