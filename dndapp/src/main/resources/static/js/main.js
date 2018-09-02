$(document).ready(function() {

	// Changes the Plus to a Minus (and vice-a-versa) when expanding table rows
	$('.collapse').on('shown.bs.collapse', function() {

		var rowId = '#icon' + this.id;

		$(rowId).removeClass("glyphicon-plus").addClass("glyphicon-minus");
	}).on('hidden.bs.collapse', function() {
		var rowId = '#icon' + this.id;
		$(rowId).removeClass("glyphicon-minus").addClass("glyphicon-plus");
	});
	
	$('#d20roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d20').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d20Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#d12roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d12').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d12Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#d10roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d10').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d10Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#d100roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d100').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d100Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#d8roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d8').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d8Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#d6roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d6').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d6Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#d4roll').click(function() {

        $.ajax({
            url: "roll",
            type: "POST",
            data: $('#d4').serialize(),
            dataType: "html",
            success: function( data ) {
            	//Replace existing result with data returned from query
                $('#d4Result').html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                window.location.href = "";
            }
        });
    });
	
	$('#rollAllOnce').click(function() {
		$('#d20roll').trigger('click');
		$('#d12roll').trigger('click');
		$('#d10roll').trigger('click');
		$('#d100roll').trigger('click');
		$('#d8roll').trigger('click');
		$('#d6roll').trigger('click');
		$('#d4roll').trigger('click');
    });
});

