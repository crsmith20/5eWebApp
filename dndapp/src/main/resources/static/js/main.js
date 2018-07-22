$(document).ready(function() {

	// Changes the Plus to a Minus (and vice-a-versa) when expanding table rows
	$('.collapse').on('shown.bs.collapse', function() {

		var rowId = '#icon' + this.id;

		$(rowId).removeClass("glyphicon-plus").addClass("glyphicon-minus");
	}).on('hidden.bs.collapse', function() {
		var rowId = '#icon' + this.id;
		$(rowId).removeClass("glyphicon-minus").addClass("glyphicon-plus");
	});
});