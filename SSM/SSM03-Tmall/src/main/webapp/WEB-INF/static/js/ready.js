

$(document).ready(function () {



    //alert(window.innerWidth);
    var box=document.getElementById('box');
    var imagesUI=document.getElementById('imagesUI');
    var btnUI=document.getElementById('btnUI');
    var imgs=imagesUI.getElementsByTagName('li');
    var btn=btnUI.getElementsByTagName('li');
    var i=index=0; //中间量，统一声明；
    var play=null;
    // console.log(box,imgs,imgs,btn);//获取正确

    autoPlay();//马上调用，我试过用window.onload调用这个方法，但是调用之后影响到了其他方法，使用autoPlay所以只能这样调用了

    //div的鼠标移入移出事件
    box.onmouseover=function(){
        clearInterval(play);
    };
    box.onmouseout=function(){
        autoPlay();
    };
    //切换按钮功能
    for(i=0;i<btn.length;i++){
        btn[i].index=i;
        btn[i].onmouseover=function(){
            show(this.index);
            clearInterval(play);
        }
    }








    //自动轮播方法
    function autoPlay(){
        play=setInterval(function(){ //定时器处理
            index++;
            index>=imgs.length&&(index=0);
            show(index);
        },3000)
    }

    //图片切换方法
    function show(a) {
        for (i = 0; i < btn.length; i++) {
            btn[i].className = ''; //显示当前设置按钮。
            btn[a].className = 'current';
        }
        for (i = 0; i < imgs.length; i++) { //把图片的效果设置和按钮相同
            imgs[i].style.opacity = 0;
            imgs[a].style.opacity = 1;
        }
    }
    //切换按钮功能
    for (i = 0; i < btn.length; i++) {
        btn[i].index = i;
        btn[i].onmouseover = function() {
            show(this.index);
            clearInterval(play);
        }
    }








})