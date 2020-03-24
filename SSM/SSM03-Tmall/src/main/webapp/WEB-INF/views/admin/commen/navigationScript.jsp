<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/19
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(document).ready(function()
    {
        $('.panel-default').on('mouseover',function(){
            $(this).children("div.panel-collapse").removeClass('collapse')
            $(this).children("div.panel-collapse").addClass('collapse in')
        })
        $('.panel-default').on('mouseout',function(){
            $(this).children("div.panel-collapse").removeClass('collapse in')
            $(this).children("div.panel-collapse").addClass('collapse')
            // console.log( $(this).parent().children("div.panel-body"))
        })
    });
    $(function(){
        $("#xxx_nav li").on("mouseover",function(){
            $('#xxx_nav li').removeClass('active')
            $(this).addClass('active')
        })
    })
</script>