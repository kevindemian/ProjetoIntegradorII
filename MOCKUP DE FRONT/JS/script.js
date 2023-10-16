$(document).ready(function () {
  $('#field_pesquisa').hide();
  $('#fld_EntradaProduto').hide();
  $('#fld_SaidaProduto').hide();

  $('#botao_pesquisar').click(function () {
    $('#field_pesquisa').toggle();
  });

  $('#btn_CadastrarEntrada').click(function () {
    $('#fld_EntradaProduto').toggle();
  });

  $('#btn_CadastrarSaida').click(function () {
    $('#fld_SaidaProduto').toggle();
  });
});

/*VALIDAÇÕES-------------------------------------------------------------*/

function validaData() {
  let dataDeEntrada = document.getElementById('dataEntrada').value;
  let data = new Date(dataDeEntrada);
  let hoje = new Date();

  if (data.getTime() > hoje.getTime()) {
    alert('A data informada não pode ser posterior ao dia de hoje');
    $('#dataEntrada').val('');
  }

  let inputZ = document.getElementById('inQtdEntrada');
  inputZ.oninvalid = function (event) {
    event.target.setCustomValidity(
      'A quantidade de produtos deve ser de, no mínimo, 1'
    );
  };

  let inputA = document.getElementById('inPrecoEntrada');
  inputA.oninvalid = function (event) {
    event.target.setCustomValidity(
      'O preço informado deve ter o formato XX,XX e ser maior que 0'
    );
  };
}
