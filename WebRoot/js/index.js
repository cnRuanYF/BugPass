/**
 * Created by lfs on 16/8/4.
 */
/**
 * 未完待续
 **/
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
                $('a.save-btn').click();    
            }
        }
    };

    var extension = 'jpeg、jpg、png';
    var $file_thumb = $('#portrait-select-div');
    var $portraits = $('#select-portrait-icon');
    var limit = 1024*1024*2;
    var old_img = '';
    var fileId = '';

    var uploader = WebUploader.create({
        auto: true,
        chunkRetry:3,
        // swf文件路径
        swf: '/lib/webuploader/Uploader.swf',

        // 文件接收服务端。
        server: service,

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id : '.file-upload',
            multiple: false
        },
        compress: {
            
            width: 60,

            // height: 60,

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
            width: 60,
            // height: 60,
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

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        fileVal: 'uploadFile',
        threads: 1
    });

    uploader.on('uploadBeforeSend', function (block, data, headers) {

        fileId = data.id;

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
        //存储老数据
        old_img = $file_thumb.html();

    });

    uploader.on( 'fileQueued', function( file ) {
        if (extension.indexOf(file.ext.toLocaleLowerCase()) == -1) {
            $('.ebms-warning-tip').tip('请上传jpeg、jpg、png格式的文件');
            uploader.stop(true);
            uploader.removeFile(file);
            return false;
        }

        if (file.size > limit) {
            $('.ebms-warning-tip').tip('文件超出大小限制');

            uploader.stop(true);
            uploader.removeFile(file);
            return false;
        }

        //解除绑定
        unbindClick($('.save-btn'));

        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $('.ebms-warning-tip').tip('上传失败,图片格式错误或图片破损,请重试!');
                return;
            }

            $file_thumb.html('<img alt="" src="' + src + '" />').show();

        });
    });

    uploader.on( 'uploadProgress', function( file, percentage ) {
        $file_thumb.html('<div class="loding-mask"><img class="lodings" src="/images/test-loading.gif"/></div>');
    });

    /**
     * 成功上传
     */
    uploader.on( 'uploadSuccess', function( file , obj) {

        if(0 == obj.code){

            var src = obj.data.fileinfo.fileUrl;
            $file_thumb.html('<span class="add-portrait-title">头像</span><img width="50px" alt="" src="' + src + '" />'+'上传小于2MB的PNG、JPG文件 或 选择一个testin头像');
            $('#portrait').val(src);
            $('#select-portrait-icon').toggle();
            $('.ebms-success-tip').tip('头像设置成功，点击保存生效。');

            //清除数据
            uploader.removeFile(file);
        }

        //追加绑定
        bindClick($('.save-btn'));
    });

    /**
     * 上传出错
     */
    uploader.on( 'uploadError', function( file ) {
        $file_thumb.html(old_img);
        $portraits.toggle();

        //追加绑定
        bindClick($('.save-btn'));

        //提示错误
        $('.ebms-failed-tip').tip('头像上传失败，请稍后重试');
    });

    //选择
    $('#portrait-select-div').click(function(event){
        event.stopPropagation();
        $('select.testin-select-open').testinSelect('hide');
        $portraits.toggle('show');
    })

    $('#enterprisemanagemodel-verifycode').blur(function () {
        if ('' == $(this).val()) {
            $(this).parent().next().text('请输入您收到的语音验证码');
        } else {
            $(this).parent().next().text('');
        }
    });

    //保存
    bindClick($('.save-btn'));

    //选择默认图标
    $('.default-staff-portrait-icon').click(function(){
        var default_src = $(this).attr('src');
        $file_thumb.html('<span class="add-portrait-title">头像</span><img alt="" src="' + default_src + '" />'+'上传小于2MB的PNG、JPG文件 或 选择一个testin头像');
        $('#portrait').val(default_src);
        $('#select-portrait-icon').toggle();
        $('.ebms-success-tip').tip('头像设置成功，点击保存生效。');
    });

    $(document).on('click',function(){
        $portraits.hide();
    });
    $('.file-upload').on('click',function (e) {
       e.stopPropagation();
    });

    $('#enterprisemanagemodel-staff_phone').blur(function () {
        var change_phone = $(this).val();
        if (change_phone != staff_phone) {
            $('.div-verify').css('display', 'block');
        } else {
            $('.div-verify').css('display', 'none');
        }
    });

    T_Countdown.setOpt({
        c: '重新获取(-TT-)s',
        e: '#get-phone',
        countType: 'D',
        beginCallback: 'checkPhone()'
    });

});

/*绑定事件*/
function bindClick(obj) {
    obj.unbind('click');
    obj.click(function(){
        if (1 == $('input[name=needVerify]').val() && '' == $('#enterprisemanagemodel-verifycode').val()) {
            $('#enterprisemanagemodel-verifycode').parent().next().text('请输入您收到的语音验证码');
            return false;
        }
        $('#user-info-form').submit();
    });

}
/*解绑事件*/
function unbindClick(obj) {
    obj.unbind('click');
    obj.click(function () {
       $('.ebms-warning-tip').tip('头像上传中，请稍后');
    });
}


/*检查电话信息*/
function checkPhone() {
    var inputObj = $('input[data-key="getVerifyCode"]');
    var phone = inputObj.val();
    var rule = /^(1[3|4|5|8|7][0-9])\d{8}$/;

    if (phone != 'undefined' && phone != '' && rule.test(phone)) {
        inputObj.blur();
        $.ajax({
            url: "/site/get-verify-code",
            type: 'POST',
            dataType: 'json',
            data: {
                phone: phone
            },
            success: function (data) {
                if (0 == data.code) {
                    $('.ebms-success-tip').tip(data.message);
                } else if (2 == data.code) {
                    $('.ebms-warning-tip').tip(data.message);
                    T_Countdown.stop(T_Countdown.i);
                } else {
                    inputObj.blur();
                    T_Countdown.stop(T_Countdown.i);
                    $('.ebms-failed-tip').tip(data.message);
                }
            },
            error: function () {
                // Notification.error({info: '验证码下发失败，请重试或联系客服协助解决'});
            }
        });

    } else {
        inputObj.blur();
        return false;
    }
}