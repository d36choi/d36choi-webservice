var index = {
    // 굳이 var index 변수 속성으로 func 들을 추가해준이유는 "스코프 관리" 때문. 여러 js 겹칠위험 방지
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

    },
    save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        //    글 등록 성공시 메인페이지로 감.
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};
index.init();