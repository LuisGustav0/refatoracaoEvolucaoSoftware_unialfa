$('#confirmacaoExclusaoModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);

    var id = button.data('id');
    var empresa = button.data('empresa');

    var modal = $(this);
    var form = modal.find('form');
    var action = form.data('url-base');

    if (action &&!action.endsWith('/')) {
        action += '/';
    }

    form.attr('action', action + id);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir oa nota fiscal empresa: <strong>' + empresa + '</strong>?');
});
