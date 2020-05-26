var containId=[];
containId.push("大学生论文检测系统PMLC-专科、本科毕业论文定稿");
containId.push("学术不端文献检测系统5.3-硕士、博士毕业论文定稿");
containId.push("科技期刊文献检测系统AMLC-期刊杂志投稿、职称评审");
containId.push("大分解论文检测系统-专、本、硕、博毕业论文初稿");
containId.push("小分解论文检测系统-专、本、硕、博毕业论文初稿");
containId.push("大学生毕业设计管理系统-特定高校专本定稿");
containId.push("课程作业管理系统-本、专、硕、博课程作业");
function getData(index) {
    var containerName=containId[index];
    var containerId="container"+index;
    $.ajax({
        url:"getAllByName",
        type:"get",
        async:false,
        data:{
            name:containerName
        },
        success:function(result){
            draw(containerId,containerName,result);
        }
    })
}
function init() {
    $(".container").each(function (index) {
        getData(index)
    })
}
jQuery(function($) {
    init()
});
//画图
function draw(containerId,containerName,data) {
    var xData=[];
    var yData=[];
    for (var i = 0; i <data.length ; i++) {
        xData.push(data[i].spidertime.substr(0,data[i].spidertime.indexOf(".")));
        yData.push(data[i].price)
    }
    var dom = document.getElementById(containerId);
    var myChart = echarts.init(dom);
    var app = {};
    var option = null;
    option = {
        title: {
            text: containerName
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: xData,
            axisLabel: {
                show: true,
                interval:0,
                rotate:20,
                textStyle: {
                    color: '#fe2aff',
                }
            },
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: yData,
            type: 'line'
        }]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}