$(function() {
	$(".loadbooks").click(function(event) {
		$.ajax({
            url : 'loadbooks/'+$(event.target).attr("id"),
            contentType: 'application/json', 
            dataType: 'json',
            success : function(response) {
            	var personId = $(event.target).attr("id");
            	var $element = $('#borrowedBooks'+personId); 
                if(response !=''){
                	$element.html("");
                    $.each(response, function(index,item) {
                    	$element.append('<b>'+item.title + '</b> ' +item.author +' <i>' +item.isbn + '</i>');
                    	if (index+1 < response.length){
                    		$element.append("<br/>");
                    	}
                  });
               }else{
            	   $element.html('<font color="red">no books</font>');
               }
            }
        });
		event.preventDefault();
	});
});

