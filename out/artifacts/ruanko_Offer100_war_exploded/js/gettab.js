function getdata(){
	//gettab();
	paging();
}

/*function gettab() {
		var vtable = document.getElementById("group_one");
		//这里可以从数据库里读，或者……，我先在这写死了，假设数据如下
		var dataFromDb = new Array('Smith','John','7/12/1978','2');		
		//var len = dataFromDb.length;
		for ( var i = 0; i < 30; i++) { //插入行数
			var vtd = [];
			var vtr = vtable.insertRow(i);// insertRow插入行
			vtr.style.align = "center";
			
			for ( var k = 0; k < 4; k++) {  //4是因为有四列
				vtd[k] = vtr.insertCell(k);// insertCell插入列
				vtd[k].style.textAlign ="center";  //这里要用textAlign而非align
				vtd[k].innerHTML = dataFromDb[k];
			}
		}
}*/

function paging() {
	page = new Page(20, 'table1', 'group_one'); //3为每页显示几条
}