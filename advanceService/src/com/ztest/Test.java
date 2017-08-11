package com.ztest;

public class Test {
	//1.1 {"cmd":"login","params": {"userName": "137280409@qq.com","passWord": "123456"}}
	//1.1.1{"cmd":"authLogin","params": {"userName": "jbcjbdsjbcjkbdsc","nikeName": "昵称","userIcon":"http://…xxxx.png"}}
	
	//1.2 {"cmd":"register","params": { "userName": "124984469@qq.com","passWord": "123456","authCode":"961737"}}
	//1.4 {"cmd":"requestAuthCode","params": {"userName": "124984469@qq.com",}}
	//1.3 {"cmd":"findPassword","params": {"userName": "137280409@qq.com","authCode": "959962"}}
	//1.5 {"cmd":"changePassword","params":{"newPassword":"1234567","userName":"137280409@qq.com"} }
	//1.6 {"cmd":"editUserInfo", "params": {"userName": "18539902139","nickName":"ZhangSan","studio":"星光工作室"}}
	//	  {"cmd":"editUserInfo", "params": {"userName":"18539902139","nickName":"test1","userIcon":"http://116.255.239.201:8080/mschool/image/1.jpg"}}
	//    {"cmd":"editUserInfo", "params": {"userName": "18039970898","nickName":"ZhangSan","studio":"星光工作室","shi":"郑州市","sheng":"河南省","xian":"管城区","school":"初级中学","nickName":"小妞妞","grade":"初一","email":"email@163.com","score":"95","sex":"1","klass":"一班","thirdName":"牛儿"}}
	
	//6.1 {"cmd":"editUserIcon", "params": {"userName":"18039970898","userIcon":"http://116.255.239.201:8080/mschool/image/1.jpg"}}
	//2.1 {"cmd":"getTalkList","type":"1","userName":"137280409@qq.com","pageSize":"20","nowPage":"1"}
	//2.2 {"cmd":"searchTalkList","type":"0","userName":"","searchText":"美术"}
	//2.2.1{"cmd": "sendMessageTalk","talkMessage":"hello world","talkID":"1","userName":"137280409@qq.com"}
	//2.2.2{"cmd": "sendVoiceTalk","talkMessage":"hello world","talkID":"1","userName":"137280409@qq.com"}
	//2.2.3{"cmd": "talkUP","talkID":"1","userName":"137280409@qq.com","upType":"1"}
	//2.2.4{"cmd": "saveFavourite","talkID":"1","userName":"137280409@qq.com","favouriteType":"1"}
	//2.2.4{"cmd": "getTalkDetail","talkID":"1","userName":"137280409@qq.com"}
	//2.2.4{"cmd": "sendTalkToTalk","talkTalkID":"1","userName":"137280409@qq.com","receiveTalkUserName":"137280409@qq.com","talkMessage":"hello world",}
	//2.2.5{"cmd": "getMyTalk","userName":"137280409@qq.com"}
	//2.3{"cmd": "sendTalkAction","talkContent":"23sdada","userName":"137280409@qq.com","talkImage":"","talkType":"1"}

	//3.1{"cmd": "getShopMainData",}
	//3.2 {"cmd": "getRecommodityList","categoryID":"","pageSize":"20","nowPage":"1" }
	//3.3{"cmd": "searchRecommodityList","search":"测试"}
	//3.4{"cmd": "getRecommodityInfo","commodityID":"67","userName":""}
	//3.5{"cmd": "saveFavourite","commodityID":"1","commodityTypeID":"1","userName":"137280409@qq.com","stateType":"0"}
	//3.6{"cmd": "saveBuyCar","commodityID":"1","userName":"137280409@qq.com","commodityNum":"2","commodityTypeID":"1"}
	//4{"cmd": "getMyOrder","userName":"137280409@qq.com"}
	//4.1{"cmd": "talkCommodity","userName":"137280409@qq.com","commodityID" :"12","talkContent" :"这个商品不错","talkImage":"","rateScore":"2"}
	//4.2	{"cmd": "deleteOrder","userName":"","orderID" :"201508171136",}
	//5{"cmd": "getShopCar","userName":"137280409@qq.com" ,}
	//5.1 {"cmd": "sendCommodities","userName":"137280409@qq.com","addressInfoID":"1","commodityList":[{"commodityID":"1","commodityNum":"1","sumMoney":"100","leaveMessage":"这个记得发邮政小包","commodityTypeID":1}]}
	//5.2{"cmd": "editShopCar","userName":"137280409@qq.com","commodityID" :"24" ,"commodityNum":"12"}
	
	
	//6{"cmd":"getCommodityFavouriteList","userName":"137280409@qq.com"}

	//7.1{"cmd": "addAdress","userName":"137280409@qq.com","name":"zhangsan","phone":"15939031234","adress":"河南省郑州市中州大道货站街","postcode":"456676","isDefault":"1"}
	//7.2{"cmd": "getAdress","userName":"137280409@qq.com" }
	//7.3{"cmd": "deleteAdress","userName":"137280409@qq.com","adressID":"A9sjNjLx3Fbjj7Qt"}
	//7.4{"cmd": "editAdress","adressID":"YUBjmyLxw1K7OQ98","userName":"137280409@qq.com","name":"李四","phone":"111","adress":"河111","postcode":"456676","isDefault":"1"}
	
	//8{"cmd": "getNews","userName":"137280409@qq.com"}
	//8.0.1{"cmd":"getSchool","userName":"137280409@qq.com","searchText":"xxx"}
	//8.1{"cmd":"saveRSSschool","userName":"137280409@qq.com","schoolID":"1","rssType":"1"}
	//8.2{"cmd": "getSchoolDetail","schoolID":"1"}
	//8.3{"cmd": "getSelfScore","studentID":"23",}
	//8.4{"cmd": "getMyRSSschool","userName":"137280409@qq.com"}
	//9.2{"cmd": "getMyAlbum","userName":"137280409@qq.com",}
	//9.3{"cmd": "sendMyIdea","userName":"137280409@qq.com","ideaContent":"hhh"}	
	//9.4{"cmd": "aboutUs",}
	//10{"cmd":"report","type":"1","message":"举报内容","ID":"234","userName":"137280409@qq.com"}
	//11{"cmd":"addFriend","userName":"137280409@qq.com","addedUserName":"124984469@qq.com"}
	//11.1{"cmd": "requestFriendList","userName":"137280409@qq.com" }
//11.1.1{"cmd": "deleteRequest","userName":"137280409@qq.com","requestID":"2"}
//11.2{"cmd": "manageRequest","requestID":"2","userName":"137280409@qq.com","requestType":"1"}
//11.3{"cmd":"searchFriend","searchText":"137280",}
	//11.4{"cmd": "deleteFriend","userName": "137280409@qq.com","delUserName":"18039970898",}
//11.5{"cmd": "friendTalkList","userName": "137280409@qq.com","friendUserName":"137280409@qq.com" }
//12{"cmd": "myTalk_talk","userName": "137280409@qq.com"}
	//{"cmd":"getImageDefault","videoType":"0","nowPageSize":"1","everyPageSize":"20","userName":"183539902137"}
}
