$(document).ready(function() {
	$(".delete_btn").click(function(e) {
		if (!window.confirm('本当に削除してよろしいですか？')) {
			e.preventDefault();  // キャンセルなら送信を止める
		}
	});

});