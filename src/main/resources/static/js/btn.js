$('#exampleModal').on('shown.bs.modal', function (event) {
	 var button = $(event.relatedTarget);
	 
	 var codigoTitulo = button.data('codigo');
	 var descricaoTitulo = button.data('descricao');
	 
	 var modal = $(this);
	 var form = modal.find('form');
	 var action = form.data('url-base');
	 if(!action.endsWith('/')){
		 action+= '/';
	 }
	 form.attr('action', action + codigoTitulo)
});
$('#exampleModal2').on('shown.bs.modal', function (event) {
	 var button = $(event.relatedTarget);
	 
	 var codigoEvento = button.data('codigo');
	 var descricaoEvento = button.data('descricao');
	 
	 var modal = $(this);
	 var form = modal.find('form');
	 var action = form.data('url-base');
	 if(!action.endsWith('/')){
		 action+= '/';
	 }
	 form.attr('action', action + codigoEvento)
});