const main = {
    init: () => {
        let _this = this;
        $('#btn-save').on('click', () => {
            //_this.save();
            main.save();
        });
    },
    save: () => {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
        }
        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(() => {
            alert('success');
            location.reload();
        }).fail((error) => {
            alert('Error: ' + error);
        })
    }
};

main.init();