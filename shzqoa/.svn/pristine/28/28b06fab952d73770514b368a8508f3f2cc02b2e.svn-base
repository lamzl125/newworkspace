var testData={};
testData.getHolidayItem=function(){
	var holidayItem=[];
	holidayItem.push({year:'2017',month:"1",workday:'19'});
	holidayItem.push({year:'2017',month:"2",workday:'19'});
	holidayItem.push({year:'2017',month:"3",workday:'23'});
	holidayItem.push({year:'2017',month:"4",workday:'19'});
	holidayItem.push({year:'2017',month:"5",workday:'21'});
	holidayItem.push({year:'2017',month:"6",workday:'22'});
	holidayItem.push({year:'2017',month:"7",workday:'21'});
	holidayItem.push({year:'2017',month:"8",workday:'23'});
	holidayItem.push({year:'2017',month:"9",workday:'22'});
	holidayItem.push({year:'2017',month:"10",workday:'17'});
	holidayItem.push({year:'2017',month:"11",workday:'22'});
	holidayItem.push({year:'2017',month:"12",workday:'21'});
	return holidayItem;
}
jQuery(function($) {
	var holidayItems = testData.getHolidayItem();
});

function getHoliday(year, month) {
	var holidayItems = testData.getHolidayItem();
	var count = 0;
	for(var j = 0; j < holidayItems.length; j++) {
		if(parseInt(holidayItems[j].year) == year && parseInt(holidayItems[j].month)==month) {
			count = holidayItems[j].workday;
		}
	}
	return count;
}

