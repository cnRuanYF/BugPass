/**
 * Created by lfs on 16/8/11.
 */
$(document).ready(function () {
    document.onkeydown = function(evt){
        var evt = window.event ? window.event : evt;
        if (evt.keyCode == 13) {
            evt.preventDefault();

            if ($('.testin-modal').length && $('.testin-modal').is(':visible')){
                $('.testin-modal').each(function(){
                    if ($(this).is(':visible')){
                        $(this).find('button.testin-btn-primary').click();
                    }
                });
            }else{
                $('input[type="submit"]').click();
            }
        }
    };


    var extension = 'jpeg、jpg、png';
    var limit = 1024*1024*2;
    var fileId = '';
    //上传
    var uploader = WebUploader.create({
        // 文件接收服务端。
        server: upload_Url,
        pick: {
            id: '.Project-icon',
            multiple: false
        },
        swf: '/lib/webuploader/Uploader.swf',
        //接收的类型
        accept: {
            title: 'Images',
            // extensions: 'jpg,jpeg,png',
            mimeTypes: 'image/!*'
        },
        compress: {
            
            width: 72,
            // height: 72,

            // 图片质量，只有type为`image/jpeg`的时候才有效。
            quality: 90,

            // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
            allowMagnify: false,

            // 是否允许裁剪。
            crop: false,

            // 是否保留头部meta信息。
            preserveHeaders: true,

            // 如果发现压缩后文件大小比原来还大，则使用原来图片
            // 此属性可能会影响图片自动纠正功能
            noCompressIfLarger: false,

            // 单位字节，如果图片大小小于此值，不会采用压缩。
            compressSize: 0
        },
        thumb: {
            width: 72,
            // height: 72,
            // 图片质量，只有type为`image/jpeg`的时候才有效。
            quality: 70,
            // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
            allowMagnify: true,
            // 是否允许裁剪。
            crop: false,
            // 为空的话则保留原有图片格式。
            // 否则强制转换成指定的类型。
            type: 'image/jpeg'
        },
        fileVal: 'uploadFile',
        //fileNumLimit: 1,
        //threads: 1,
        //fileSizeLimit: 2048000,
        //fileSingleSizeLimit: 2048000,
        auto: true,
        duplicate: true
    });

    uploader.on('uploadBeforeSend', function (block, data, headers) {

        var opt_data = {
            uid: '60',
            op: "Ctfile.upload",
            tag: "testinPortal",
            suffix: ''
        };
        delete data.id;
        delete data.name;
        delete data.type;
        delete data.lastModifiedDate;
        delete data.size;
        delete data.chunks;
        delete data.chunk;
        $.extend(data, {
            'UPLOAD-JSON': JSON.stringify(opt_data)
        });
    });

    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
        fileId = file.id;

        if (extension.indexOf(file.ext.toLocaleLowerCase()) == -1) {
            $('.ebms-failed-tip').tip('请上传jpeg、jpg、png格式的文件');
            uploader.stop(true);
            uploader.removeFile(file);
            return false;
        }

        if (file.size > limit) {
            $('.ebms-failed-tip').tip('文件超出大小限制');
            uploader.stop(true);
            uploader.removeFile(file);
            return false;
        }


        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $('.ebms-warning-tip').tip('上传失败,图片格式错误或图片破损,请重试!');
                return;
            }

            $('#app_logo').attr('src', src);
        });
    });

    /*上传过程中*/
    uploader.on('uploadProgress', function () {
        //$file_thumb.html('<img class="lodings" src="/images/test-loading.gif"/>');
    });

    /*成功*/
    uploader.on('uploadSuccess', function (file, obj) {

        if (0 == obj.code) {
            var src = obj.data.fileinfo.fileUrl;
            $('#app_logo').attr('src', src);
            $('.icon_path').val(src).blur();
            $('.ebms-success-tip').tip('图标上传成功,保存后生效');
        }
    });

    /*失败*/
    uploader.on('uploadError', function (file, obj) {

        $('.icon_path').val('').blur();
        //提示
        $('.ebms-failed-tip').tip('图标上传失败，请稍后重试');
    });


    /*选择转让人*/
    $('.transfer-project .project-select-out .dropdown').click(function(){
        var $dropdown_text = $(this).find('.dropdown-text'),
            $hidden = $(this).find('input:hidden');

        $(this).find('.dropdown-menu').each(function(){
            $(this).on('click','li',function(){
                var cho_value = $(this).attr('data-id');
                $hidden.val(cho_value);
                $dropdown_text.html($(this).html());
                $(this).siblings('.selected').removeClass('selected').end().addClass('selected');
            });
        });
    });


    /*删除项目*/
    $('#confirmDel').click(function(){
        var project_key = $('#del-project').attr('data-key');
        if(''!=project_key){
            $.ajax({
                url: '/projects/del-project',
                type: 'POST',
                data: {key: project_key},
                dataType: 'json',
                success: function (rep) {
                    if (0 == rep.code) {
                        $('.ebms-success-tip').tip('解散项目成功');
                        window.location.href='/bug';
                    }else{
                        if ('' != rep.message) {
                            $('.ebms-failed-tip').tip(rep.message);
                        } else {
                            $('.ebms-failed-tip').tip('解散项目失败，请刷新页面重试');
                        }
                    }
                },
                error: function () {
                    $('.ebms-failed-tip').tip('解散项目失败，请刷新页面重试');
                }
            });
        }
    });

    /*转让项目*/
    $('#confirmTransfer').click(function(){
        var project_key = $('#transfer-project').attr('data-key');
        var user_id = $('.transfer-project .project-select-out .dropdown').find('input:hidden').val();
        var $model = $(this).parent('modal');
        if (user_id == '') {
            $('.ebms-warning-tip').tip('请选择转让人');
            return false;
        }
        if ('' != project_key) {
            $.ajax({
                url: '/projects/transfer-project',
                type: 'POST',
                data: {key: project_key,user_id:user_id},
                dataType: 'json',
                success: function (rep) {
                    $model.modal('hide');
                    if (0 == rep.code) {
                        $('.ebms-success-tip').tip('转让项目成功');
                        window.location.reload();
                    }else{
                        if ('' != rep.message) {
                            $('.ebms-failed-tip').tip(rep.message);
                        } else {
                            $('.ebms-failed-tip').tip('转让项目失败，请刷新页面重试');
                        }
                    }
                },
                error: function () {
                    $('.ebms-failed-tip').tip('转让项目失败，请刷新页面重试');
                }
            });
        }
    });

});