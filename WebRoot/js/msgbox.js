/**
 * 提示框动态效果 by Yaofeng Ruan
 */

// 获取提示框元素
var msgbox = document.getElementById("msgbox");
// 显示提示框
msgbox.style.opacity = 1;
msgbox.style.transform = "scale(1)";

// 隐藏提示框的方法
function hideMsgbox() {
	msgbox.style.opacity = 0;
	msgbox.style.transform = "scale(0.5)";
}

// 延时自动关闭提示框
setTimeout(hideMsgbox, 2000);
// 单击关闭提示框
msgbox.addEventListener('click', hideMsgbox);
