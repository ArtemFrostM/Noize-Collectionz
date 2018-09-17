
<div class="row text-center">
	<div class="col-sm-9 pad-top">
		<div class="center-column">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Book title</th>
							<th>Book genre</th>
							<th>Book edition</th>
							<th>Book type</th>
							<th>Added by</th>
							<th>Table heading</th>
						</tr>
					</thead>
					<tbody id="myTable">

						<c:forEach items="${bookList}" var="book">
							<tr>
								<td>${book.id}</td>
								<td>${book.bookTitle}</td>
								<td>${book.genre}</td>
								<td>${book.edition}</td>
								<td>${book.bookType}</td>
								<td>${book.user.firstName}</td>
								<td>Table cell</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="col-md-12 text-center">
				<ul class="pagination pagination-lg pager" id="myPager"></ul>
			</div>
		</div>
	</div>
${requestScope['javax.servlet.forward.servlet_path']}
</div>
