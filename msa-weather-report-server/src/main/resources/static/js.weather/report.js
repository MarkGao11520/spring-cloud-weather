/**
 * report页面下拉框事件
 * auther:waylau.com
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		var url = '/report/cityId/'+ cityId;
		console.log(url);
		window.location.href = url;
	})
});