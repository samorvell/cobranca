$('#confirmacaoExclusaoModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var codigoTitulo = button.data('codigo');
			var descricaoTitulo = button.data('descricao');

			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}
			form.attr('action', action + codigoTitulo);

			modal.find('.modal-body').html(
					'Tem certeza que deseja excluir o título <strong>'
							+ descricaoTitulo + '</strong>?');
		});

$(function() {
	$('[rel="tooltip]').tooltip();
	$('.js-currency').maskMoney({
		decimal : ',',
		thousands : '.',
		allowZero : true
	});

	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();

		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');

		var response = $.ajax({//requisção via ajax para recuperar o status
			url : urlReceber,//url que já estava no botão
			type : 'PUT' //recebido via PUT
		});
		
		
		response.done(function(e) {//função responsavel em receber o status do titulo ao atualizar pelo botão que faz a troca de pendente para o status recuperado
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']' ).html('<span class="label label-success">' + e + '</span>');
			botaoReceber.hide();
		});

		response.fail(function(e) {
			console.log(e);
			alert('Erro recebendo cobraça')

		});

	});

});























