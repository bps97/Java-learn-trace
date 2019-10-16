<head>

</head>
<body>
<h2>Hello World!</h2>
<div id="progressBar" style='height: 20px;border:2px solid green'>
    <div id="bar" style="height: 100%; background:#33dd33;width:0%"> </div>
</div>
<form>
    <input type="file" id="files" multiple/>
    <br/>
    <output id="selectFiles"></output>
    <input id="uploadButton" type="button" value="Upload"/>
</form>

<hr>




<div id="debug" style="height: 100px; border: 2px solid green;overflow:auto" ></div>

</body>
<script>
    var totalFileLength, totalUploaded, fileCount, filesUploaded;
    // 上传文件总长度 已上传的字节数 要上传的文件数量 已上传的文件数量
    function debug(s){
        var debug = document.getElementById("debug");
        if (debug) {
            debug.innerHTML = debug.innerHTML + '<br/>' + s;
        }
    }

    function onUploadComplete(e) {
        totalUploaded += document.getElementById('files').files[filesUploaded].size;
        filesUploaded++;

        debug('complete' + filesUploaded + "of" + fileCount);
        debug('totalUploaded:' + totalUploaded);

        if (filesUploaded < fileCount){
            uploadNext();
        } else{
            var bar =  document.getElementById('bar');
            bar.style.width = '100%';
            bar.innerHTML = '100% complete';
            alert('Finished uploading files(s)');
        }

    }
    function onFileSelect(e) {
        var files = e.target.files; //FileList Object
        console.log(files);
        var output = [];
        fileCount = files.length;
        totalFileLength = 0;
        for(var i=0; i<fileCount; ++i){
            var file = files[i];
            output.push(file.name,'(',file.size,'bytes,',file.lastModifiedDate.toLocaleDateString(),')');
            output.push("<br/>");
            debug('add' + file.size);
            totalFileLength += file.size;
        }
        document.getElementById('selectedFiles').innerHTML =  output.join('');
        debug('totalFileLength:'+totalFileLength);
    }
    function onUploadProgress(e) { //更新进度条
        if(e.lengthComputable){
            var percentComplete = parseInt((e.loaded + totalUploaded) * 100) / totalFileLength;
            var bar = document.getElementById('bar');
            bar.style.width = percentComplete + '%';
            bar.innerHTML = percentComplete + ' %complete';
        }else{
            debug('unable to compute');
        }

    }
    function onUploadFailed(e) {
        alert("Error uploading file");
    }

    function uploadNext() {
        var xhr = new XMLHttpRequest();
        var fd = new FormData();
        var file = document.getElementById('files').files[filesUploaded];
        fd.append("multipartFile", file);
        xhr.upload.addEventListener("progress", onUploadProgress, false);
        xhr.upload.addEventListener("load", onUploadComplete, false);
        xhr.upload.addEventListener("error", onUploadFailed, false);
        xhr.open(method='POST' ,  url="file-upload");
        debug('uploading'+file.name);
        xhr.send(fd);

    }
    function startUpload() {
        totalUploaded = filesUploaded = 0;
        uploadNext();

    }
    window.onload = function () { //窗口加载完毕后...
        document.getElementById('files').addEventListener(
            'change', onFileSelect, false);//change事件
        document.getElementById('uploadButton').addEventListener(
            'click', startUpload, false); //click事件

    }
</script>
</html>
