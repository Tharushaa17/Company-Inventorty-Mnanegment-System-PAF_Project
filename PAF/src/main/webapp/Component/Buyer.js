$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
	$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide()
	
	var status = validateItemForm();
	if (status != true){
		
		$("#alertError").text(status);
		$("#alertError").show();
		
	return;
	}
	
	// If valid------------------------
	var type = ($("#hidBidSave").val() == "") ? "POST" : "PUT";
	
		$.ajax({
			
			url : "BuyerAPI",
			type : type,
			data : $("#formBuyers").serialize(),
			dataType : "text",
			complete : function(response, status)
			{
				onItemSaveComplete(response.responseText, status);
			}
		});
});

function onItemSaveComplete(response, status){
	
	if (status == "success"){
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success"){
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
			
		}
	} else if (status == "error"){	
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	
	} else{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	
}

$("#hidItemIDSave").val("");
$("#formItem")[0].reset();
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event){
	$("#hidBidSave").val($(this).closest("tr").find('#hidBidUpdate').val());
	$("#FristName").val($(this).closest("tr").find('td:eq(0)').text());
	$("#LastName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Username").val($(this).closest("tr").find('td:eq(2)').text());
	$("#MobileNu").val($(this).closest("tr").find('td:eq(3)').text());
	$("#Email").val($(this).closest("tr").find('td:eq(4)').text());
	$("#Address").val($(this).closest("tr").find('td:eq(5)').text());
	$("#Password").val($(this).closest("tr").find('td:eq(6)').text());
});


// DELETE==========================================
$(document).on("click", ".btnRemove", function(event){
	$.ajax({
		url : "BuyerAPI",
		type : "DELETE",
		data : "Bid=" + $(this).data("Bid"),
		dataType : "text",
		complete : function(response, status)
		{
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status){
	
		if (status == "success"){
			
			var resultSet = JSON.parse(response);
			
			if (resultSet.status.trim() == "success"){
				$("#alertSuccess").text("Successfully deleted.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
				
			} else if (resultSet.status.trim() == "error"){
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}
		} else if (status == "error"){
			
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		
		} else{
			
			$("#alertError").text("Unknown error while deleting..");
			$("#alertError").show();
		
		}
}

