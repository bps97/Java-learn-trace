

var getsome = function () {
    var preName = "";
    var categoryGroupName = "";
    var url = "loadSubCategory.do";
    categoryGroupName = obj.children.item(0).children.item(0).children.item(1).innerHTML;
    if(categoryGroupName != preName){
        var data = {'categoryGroup':categoryGroupName};
        $.post(url, data, function (responseDate, status, xhr) {
            console.log(responseDate.toString());
        })
    }
    preName = categoryGroupName;
}