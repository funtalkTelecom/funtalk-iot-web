
$(document).ready(function(){
    var year = new Date().getFullYear();
    var month = ("0" + (new Date().getMonth() + 1)).slice(-2);
    var stat_month = year  + month;
    $("#indb_date").val( stat_month );
});



(function(){

    new TipBox({type:'load', str:"初始化信息...", setTime:1000,
		callBack:function(){
            getSettle();
	}});

}());


function getSettle() {

    var indbdate = document.getElementById("indb_date").value;

    $.ajax({
        type: "POST",
        url:  "../reportAction!unicomSettleByMonth.action",
        data: { statmonth:indbdate, workno: sessionStorage.workno },
        dataType : "json",
        success: function( json ){

            console.log("-------->"+json);
            ul = JSON.parse( json.unicomSettleStr );
            $("#i_settletable tbody").html("");
            for(var i in ul){

                $("#i_settletable tbody").append("<tr>"+
                    "<td align=\"center\">"+ul[i].statmonth+"</td>"+
                    "<td>"+ul[i].yuyin+"</td>"+
                    "<td>"+ul[i].yuyin_tax+"</td>"+
                    "<td>"+ul[i].liuliang+"</td>"+
                    "<td>"+ul[i].liuliang_tax+"</td>"+
                    "<td>"+ul[i].duanxin+"</td>"+
                    "<td>"+ul[i].duanxin_tax+"</td>"+
                    "<td>"+ul[i].caixin+"</td>"+
                    "<td>"+ul[i].caixin_tax+"</td>"+
                    "<td>"+ul[i].laixian+"</td>"+
                    "<td>"+ul[i].laixian_tax+"</td>"+
                    "<td>"+ul[i].qita+"</td>"+
                    "<td>"+ul[i].qita_tax+"</td>"+
                    "<td>"+ul[i].total+"</td>"+
                    "</tr>"  );
            }

            console.log("---page---"+json.page+"------allpages-----"+json.allPage);
            
            $('.pagination').jqPagination({
                link_string :  '/?page={page_number}',
                current_page: json.page,
                max_page :  json.allPage,
                page_string : '当前第{current_page}页,共{max_page}页',
                paged : function( page ) {

                    var indbdate = document.getElementById("indb_date").value;

                    $.ajax({
                        type: "POST",
                        url:  "../acctAction!acctInfoByCustname.action",
                        data: { statmonth:indbdate, workno: sessionStorage.workno,page : page },
                        dataType : "json",
                        success: function( json ){

                            console.log("-------->"+json);
                            ul = JSON.parse( json.unicomSettleStr );
                            $("#i_settletable tbody").html("");
                            for(var i in ul){

                            $("#i_settletable tbody").append("<tr>"+
                                "<td align=\"center\">"+ul[i].statmonth+"</td>"+
                                "<td>"+ul[i].yuyin+"</td>"+
                                "<td>"+ul[i].yuyin_tax+"</td>"+
                                "<td>"+ul[i].liuliang+"</td>"+
                                "<td>"+ul[i].liuliang_tax+"</td>"+
                                "<td>"+ul[i].duanxin+"</td>"+
                                "<td>"+ul[i].duanxin_tax+"</td>"+
                                "<td>"+ul[i].caixin+"</td>"+
                                "<td>"+ul[i].caixin_tax+"</td>"+
                                "<td>"+ul[i].laixian+"</td>"+
                                "<td>"+ul[i].laixian_tax+"</td>"+
                                "<td>"+ul[i].qita+"</td>"+
                                "<td>"+ul[i].qita_tax+"</td>"+
                                "<td>"+ul[i].total+"</td>"+
                                "</tr>"  );
                        }
                        },
                        error: function(json){
                            return false;
                        }
                    });
                }
            });
        },
        error: function(json){
            return false;
        }
    });

}


function showAcctsByPage(allpage,currentpage){

    $('.pagination').jqPagination({
        link_string :  '/?page={page_number}',
        current_page: currentpage,
        max_page :  allpage,
        page_string : '当前第{current_page}页,共{max_page}页',
        paged : function( page ) {

            console.log("------page----->"+page);
            $.ajax({
                type: "POST",
                url:  "../acctAction!acctInfoByCustname.action",
                data: { custname:custname, workno: sessionStorage.workno },
                dataType : "json",
                success: function( json ){


                    console.log("-------->"+json);
                    ul = JSON.parse( json.acctLists );
                    $("#i_settletable tbody").html("");
                    for(var i in ul){
                        var custname = escape(ul[i].custname);

                        $("#i_settletable tbody").append("<tr>"+
                            "<td align=\"center\">"+ul[i].custname+"</td>"+
                            "<td>"+ul[i].acctid+"</td>"+
                            "<td>"+ul[i].depositname+"</td>"+
                            "<td>"+ul[i].limitmoney+"</td>"+
                            "<td>"+ul[i].availmoney+"</td>"+
                            "<td>"+ul[i].createdate+"</td>"+
                            "</tr>"  );
                    }
                },
                error: function(json){
                    return false;
                }
            });
        }
    });
}

