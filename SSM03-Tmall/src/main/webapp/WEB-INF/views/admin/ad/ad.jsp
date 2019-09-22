<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>

<rapid:override name="head_content">
    <style>
        .hide {
            display: none;
        }

        .c1 {
            background-color: white;
            position: fixed;
            top: 38%;
            left: 50%;
            z-index: 3;
            width: 420px;
            height: auto;
            margin-left: -200px;
            opacity: 1.0;
            overflow-y: auto;
            cursor: pointer;
        }

        #theme-popover-mask {
            z-index: 10000000;
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            filter: alpha(opacity=50);
            display: none;
        }
    </style>
</rapid:override>

<rapid:override name="main_content">
    <div class="container">


        <div class="panel panel-default">
            <div class="panel-heading text-right">
                <a href="/admin/ad/add" class="btn btn-success">添加</a>
            </div>
        </div>
        <!-- panel-heading -->
        <c:forEach items="${ads}" var="ad">

            <div class="col-sm-6 col-md-4">
                <div class="thumbnail" id="ad-${ad.id}">
                    <img src="${ad.link}" alt="${ad.text}">
                    <h3>${ad.text}</h3>

                    <div class="caption text-right">
                        <p>
                            <a href="javascript:Show()" class="btn btn-primary btn-alter" role="button" value="${ad.id} ">修改</a>
                            <button onclick="delAd(this)" class="btn btn-default" role="button" value="${ad.id}" >删除</button>
                        </p>
                    </div>
                </div>
            </div>


        </c:forEach>
    </div>


    <div class="panel panel-default">
        <div id="theme-popover-mask">
            <div id="alter" class="c1 hide" style="top:170px">
                <div class="panel panel-default" style="margin: 0">
                    <div class="panel-footer">
                        <i class="fa fa-times fa-lg" style="float:right;margin:6px" onclick="Hide()"></i>
                        <div class="main" style="margin-top: 0px">
                            <form id="form-ad">
                                <input type="hidden" name="id" id="id">
                                <div class="form-group">
                                    <label for="text">标题</label>
                                    <input type="text" class="form-control" id="text" name="text" placeholder="Title" autofocus>
                                </div>
                                <div class="form-group">
                                    <label for="link">链接</label>
                                    <input type="text" class="form-control" id="link" name="link" placeholder="Link">
                                </div>
<%--                                <div class="form-group">--%>
<%--                                    <label for="image" class="col-md-2 control-label">图片</label>--%>
<%--                                    <input type="file" id="image" name="image">--%>
<%--                                </div>--%>
                                <a type="submit" class="btn btn-success btn-block" href="javascript:alterAd()" >修改</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</rapid:override>

<rapid:override name="script_content">
    <script>
        var showMask = function () {
            document.getElementById('theme-popover-mask').style.display = 'block'
        }
        var hideMask = function () {
            document.getElementById('theme-popover-mask').style.display = 'none'
        }

        function Show() {
            showMask()
            document.getElementById('alter').classList.remove('hide');
        }
        function Hide() {
            hideMask()
            document.getElementById('alter').classList.add('hide');
        }

        
        $(document).ready(function () {
            $text = $('#text');
            $link = $('#link');


            $("a.btn-alter").click(function () {
                var adId = $(this).attr('value');
                $('#id').attr('value',adId)
                $.ajax({
                    data:{"adId":adId},
                    datatype:'json',
                    method:'get',
                    url:'/admin/ad/ad.do',
                    success:function (resp) {
                        $text.attr('value',resp['text']);
                        $link.attr('value',resp['link']);
                    }
                })
                
            })
        })

        var alterAd = function () {
            $.ajax({
                data:$('#form-ad').serialize(),
                datatype:'json',
                url:'/admin/ad/edit.do',
                method:'get',
                success:function (resp) {

                    $container = $('#ad-'+resp['id']);

                    $img = $container.children('img');
                    $a = $container.children('div').children().children("a:first");
                    console.log()

                    $h3 = $container.children('h3');
                    $img.attr('src',resp['link']);
                    $img.attr('alt',resp['text']);
                    $h3.text(resp['text']);
                    $a.attr('value',resp['id']);
                }
            })
        }

        var delAd  = function (obj) {
            console.log($(obj).attr('class'));
            $.ajax({
                data:{'id':$(obj).attr('value')},
                datatype:'json',
                url:'/admin/ad/del.do',
                method:'get',
                success:function (resp) {
                    // console.log(resp);
                    window.location.reload();
                }
            })
        }
    </script>

</rapid:override>
<%@ include file="../base.jsp" %>



