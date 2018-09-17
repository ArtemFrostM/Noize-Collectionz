<%@ include file="/WEB-INF/taglib.jsp"%>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div align="center">
				<img src="data:image/png;base64, ${artistPic} " width="200px"
					alt="" class="img-circle img-responsive">

			<a href="artist/list"><h2 class="text-center">All list</h2> </a>	
			</div>

			<div class="text-center"></div>

		</div>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div align="center">
				<img src="data:image/png;base64, ${top30} " width="200px"
					>

			<a href="artist/top_list"><h2 class="text-center">TOP popular</h2> </a>	
			</div>

			<div class="text-center"></div>

		</div>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div align="center">
				<img src="data:image/png;base64, ${genre} " width="200px"
					alt="" class="img-circle img-responsive">

			<a href="/artists_genres"><h2 class="text-center">Genres</h2> </a>	
			</div>

			<div class="text-center"></div>

		</div>
	</div>
</div>