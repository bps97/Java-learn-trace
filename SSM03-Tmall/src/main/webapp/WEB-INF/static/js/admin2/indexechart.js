// 基于准备好的dom，初始化echarts图表 #4ad2ff青色
var myChart = echarts.init(document.getElementById('main'));

var option = {
  grid:{

    top:100,
    borderWidth:1,
    containLabel:true
  },
  tooltip : {
    show : true
  },
  legend : {
    data : [ '电子产品销量','生活用品销量','饮食销量' ]
  },
  xAxis : [ {
    type : 'category',
    data : [ "1月", "2月", "3月","4月","5月","6月"],
    axisPointer:{
      type:'shadow'
    }
  } ],
  yAxis : [ {
    type : 'value',
    name:'总体销量',
    mix:0,
    max:10000,
    interval: 1000,
    axisLabel: {
      formatter: '{value} 件'
    }
  },
    {
      type : 'value',
      name:'综合评价',
      mix:0,
      max:10,
      interval: 2,
      axisLabel: {
        formatter: '{value} 分'
      }
    }
  ],
  series : [ {
    "name" : "电子产品销量",
    "smooth":false,
    "type" : "bar",
    // barWidth:30,/**柱子的宽度**/
    // itemStyle:{
    //             normal:{
    //                 color:'#FF8C00'
    //                    }
    //            },/***柱子的颜色*/
    "data" : [ 1520, 1000, 5000, 2300, 8000,6320, ]/**数据**/
  },
    {
      "name" : "生活用品销量",
      "smooth":false,
      "type" : "bar",
      // barWidth:30,/**柱子的宽度**/
      // itemStyle:{
      //             normal:{
      //                 color:'pink'
      //                    }
      //            },/***柱子的颜色*/
      "data" : [1830, 1001, 8030, 6023, 2000, 4689 ]/**数据**/
    },
    {
      "name" : "饮食销量",
      "smooth":false,
      "type" : "bar",
      // barWidth:30,/**柱子的宽度**/
      // itemStyle:{
      //             normal:{
      //                 color:'pink'
      //                    }
      //            },/***柱子的颜色*/
      "data" : [ 1000, 3000, 5000, 7500, 8090,9520 ]/**数据**/
    },
    {
      "name" : "综合评价",
      "smooth":true,
      "type":'line',
      "yAxisIndex": 1,
      // barWidth:30,/**柱子的宽度**/
      // itemStyle:{
      //             normal:{
      //                 color:'pink'
      //                    }
      //            },/***柱子的颜色*/
      "data" : [ 7.5, 6.0, 8.5, 9.5, 5.5,7.0 ]/**数据**/
    }
  ]
};

// 为echarts对象加载数据
myChart.setOption(option);
