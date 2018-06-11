/**
 * Created by lfs on 16/7/28.
 */
var testin = {
	init : function() {
		this.param = this.request();
		this.key = $('body').attr('key');
		this.url = location.pathname;
		this.getVersion();
	},
	get_project : function(){
		if (!testin.project) {
			$.post('/get-projects', {'key' : this.key, 'url' : this.url}, function(data){
				if (data.code != 0) {
					return;
				}
				
				testin.project = data.data;

				$('#nav_project_ul').html(testin.project.project_list_html);

			});
		} else {
			$('#project_ul').html(testin.project.project_list_html);
		}
		
	},
	request : function() {
		var url = location.search; //获取url中"?"符后的字串
		var theRequest = new Object(); 

		if (url.indexOf("?") != -1) { 
			var str = url.substr(1); 
			strs = str.split("&"); 

			for(var i = 0; i < strs.length; i ++) { 
				theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
			} 
		} 
		
		return theRequest; 
	},
	getRemind: function(data, callback){
		$.post("/system-upgrade-remind", data, function(s){
			if (s.code){
				return;
			}

			if (typeof callback == 'function')
				return eval(callback)(s);
		}, 'json');
	},
	getVersion: function(){
		var _this = this;

		var serveName = '_BUGOUT_VERSION';
		var serveCk = $.cookie(serveName);

		var localName = '_LOCAL_VERSION';
		var localCk = $.cookie(localName);

		//如果服务端没有生成，则跳出
		if (typeof serveCk == 'undefined' || !serveCk.length){
			return;
		}

		//解析服务端生成的COOKIE
		var serveVers = JSON.parse(serveCk);

		//定义默认数据
		var localVers = {
			id: serveVers.id,
			version_id: 0,
		};
		if (typeof localCk != 'undefined' && localCk.length){
			localVers = JSON.parse(localCk);
		}

		//如果本地版本大于等于服务器版本，则跳出
		if (localVers.version_id >= serveVers.version_id){
			return false;
		}

		_this.getRemind(serveVers, function(s){

			//如果数据为空
			if (typeof s.data == 'undefined'){
				return;
			}

			//定义弹窗模板
			var tpl = '';
				tpl += "<div class=\'modal fade testin-modal\' tabindex=\'-1\' role=\'dialog\' aria-labelledby=\'myModalLabel\' aria-hidden=\'true\' style=\'display: none;\'>";
				tpl += "    <div class=\'modal-dialog\'>";
				tpl += "        <div class=\'modal-content\'>";
				tpl += "            <div class=\'modal-header\'>";
				tpl += "                <button type=\'button\' class=\'close\' data-dismiss=\'modal\' aria-hidden=\'true\'>";
				tpl += "                    ×";
				tpl += "                </button>";
				tpl += "                <h4 class=\'modal-title\' id=\'myModalLabel\'>";
				tpl += "                    提示";
				tpl += "                </h4>";
				tpl += "            </div>";
				tpl += "            <div class=\'modal-body\' style=\"padding:10px!important;\"></div>";
				tpl += "            <div class=\'modal-footer\'>";
				tpl += "                <button type=\'button\' class=\'btn btn-default hidden pagination-prev\'>上一步</button>";
				tpl += "                <button type=\'button\' class=\'btn testin-btn-primary hidden pagination-next\'>下一步</button>";
				tpl += "                <button type=\'button\' class=\'btn testin-btn-primary i-see\' data-dismiss=\'modal\'>我知道了</button>";
				tpl += "            </div>";
				tpl += "        </div>";
				tpl += "    </div>";
				tpl += "</div>";

			var $testinModal = $(tpl);

			var key = 0;
			//定义body渲染方法
			var renderBody = function(){
				$testinModal.find('.pagination-next').addClass('hidden');
				$testinModal.find('.i-see').addClass('hidden');
				$testinModal.find('.pagination-prev').addClass('hidden')

				if (s.data.content.length > 1){

					if (key < s.data.content.length-1){
						$testinModal.find('.pagination-next').removeClass('hidden');
						if (key > 0){
							$testinModal.find('.pagination-prev').removeClass('hidden')
						}
					}else{
						$testinModal.find('.pagination-prev').removeClass('hidden');
						$testinModal.find('.i-see').removeClass('hidden');
					}

				}else{
					$testinModal.find('.i-see').removeClass('hidden');
				}

				$testinModal.find('.modal-title').html(s.data.title);
				$testinModal.find('.modal-body').html('<pre style="border:0;background:none;line-height:22px;">'+s.data.content[key]+'</pre>');
			};

			//默认渲染
			renderBody();

			//显示提示弹窗
			$testinModal.prependTo('body').modal('show');

			//设置过期时间为1年
			$.cookie(localName, serveCk, { expires: 365 });

			//当点击上一步时
			$testinModal.find('.pagination-next').on('click', function(){
				if (key + 1 < s.data.content.length){
					key++;
				}

				//重新渲染
				renderBody();
			});

			//当点击下一步时
			$testinModal.find('.pagination-prev').on('click', function(){
				if (key - 1 >= 0){
					key--;
				}

				//重新渲染
				renderBody();
			});
		});
	},
	param : null,
	project : null,
	key : null,
	url : null
};

var tips = {
	init : function(){
		var info = '';
		var info_class = 'info';
		
		if ('error' == info_class) {
			tips.error(info);
		} else if('success' == info_class) {
			tips.success(info);
		} else if('warn' == info_class) {
			tips.warn(info);
		} else {
			tips.info(info);
		}
	},
	error : function(info){
		$('.ebms-tip').addClass('ebms-failed-tip').html('<i class=\"iconfont\">&#xe64d;</i>'+info);
	},
	success : function(info){
		$('.ebms-tip').addClass('ebms-success-tip').html('<i class=\"iconfont\">&#xe60f;</i>'+info);
	},
	info : function (info) {
		$('.ebms-tip').html(info);
	},
	warn : function(info) {
		$('.ebms-tip').addClass('ebms-warning-tip').html('<i class=\"iconfont\">&#xe619;</i>'+info);
	}
};


var upload_Url = 'http://fs.testin.cn/form.upload';

$(document).ready(function(){
	testin.init();
	
	if (!testin.project) {
		if ($('#nav_project_type').length > 0) {
			testin.get_project();
		}
	}


	//复制key
	var clipboard = new Clipboard('.testin_copy_key');
	clipboard.on('success', function(e) {
		$('.ebms-success-tip').tip('复制成功');
	});
	clipboard.on('error', function(e) {
		$('.ebms-success-tip').tip('复制失败');
	});

	
});
