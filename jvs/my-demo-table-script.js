$(document).ready(function() {

    $(".jqueryDataTable").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sAjaxSource": "./StudentDataServlet",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "name" },
            { "mData": "mark" }
            
        ]
    } ); 
} );

